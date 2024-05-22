package controller;

import app.Navigator;
import database.DatabaseUtil;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.dto.ReportDto.*;
import model.dto.StaffDto.NurseDto;
import model.dto.StaffDto.ReceptionistDto;
import service.DBConnection;
import service.Report.birthService;
import service.Report.deathService;
import service.Report.donorService;
import service.Report.operationService;
import service.Report.otherService;
import service.Staff.ReceptionistService;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class NursePageController implements Initializable {

    @FXML
    private Button account_btn;

    @FXML
    private Button addOperation_btn;

    @FXML
    private Button add_birth_btn;

    @FXML
    private Button add_death_btn;

    @FXML
    private Button add_other_btn;

    @FXML
    private Button add_patient_btn;

    @FXML
    private AnchorPane add_reportBirth;

    @FXML
    private AnchorPane add_reportDeath;

    @FXML
    private AnchorPane add_reportOperation;

    @FXML
    private AnchorPane add_reportOther;

    @FXML
    private Button bedWards_btn;

    @FXML
    private AnchorPane bedWards_form;

    @FXML
    private TableColumn<?, ?> bed_col_bedID;

    @FXML
    private TableColumn<?, ?> bed_col_bedNumber;

    @FXML
    private TableColumn<?, ?> bed_col_patient;

    @FXML
    private TableColumn<?, ?> bed_col_type;

    @FXML
    private TableView<BirthsDto> birth_table;

    @FXML
    private TableColumn<?, ?> births_col_birthID;

    @FXML
    private TableColumn<?, ?> births_col_date;

    @FXML
    private TableColumn<?, ?> births_col_description;

    @FXML
    private TableColumn<?, ?> births_col_newBorn;

    @FXML
    private TableColumn<?, ?> births_col_patient;

    @FXML
    private TableColumn<?, ?> births_col_time;

    @FXML
    private Button bloodBank_btn;

    @FXML
    private AnchorPane bloodBank_form;

    @FXML
    private TableColumn<?, ?> blood_col_age;

    @FXML
    private TableColumn<?, ?> blood_col_bloodGroup;

    @FXML
    private TableColumn<?, ?> blood_col_donorID;

    @FXML
    private TableColumn<?, ?> blood_col_gender;

    @FXML
    private TableColumn<?, ?> blood_col_lastDonationDate;

    @FXML
    private TableView<OperationDto> operation_table;

    @FXML
    private TableView<DeathsDto> death_table;

    @FXML
    private BarChart<?, ?> dashboad_chart_BD;

    @FXML
    private AreaChart<?, ?> dashboad_chart_PD;

    @FXML
    private Label dashboard_beds;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Label dashboard_donors;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Label dashboard_patients;

    @FXML
    private Label date_time;

    @FXML
    private TableColumn<?, ?> deaths_col_date;

    @FXML
    private TableColumn<?, ?> deaths_col_deathID;

    @FXML
    private TableColumn<?, ?> deaths_col_description;

    @FXML
    private TableColumn<?, ?> deaths_col_patient;

    @FXML
    private TableColumn<?, ?> deaths_col_time;

    @FXML
    private AnchorPane doctor_table;

    @FXML
    private TableView<?> doctors_tableView;

    @FXML
    private AnchorPane main_form;

    @FXML
    private TableColumn<?, ?> operations_col_date;

    @FXML
    private TableColumn<?, ?> operations_col_description;

    @FXML
    private TableColumn<?, ?> operations_col_doctor;

    @FXML
    private TableColumn<?, ?> operations_col_operationID;

    @FXML
    private TableColumn<?, ?> operations_col_patient;

    @FXML
    private TableColumn<?, ?> operations_col_time;

    @FXML
    private TableView<OthersDto> other_table;

    @FXML
    private TableColumn<?, ?> others_col_date;

    @FXML
    private TableColumn<?, ?> others_col_description;

    @FXML
    private TableColumn<?, ?> others_col_otherID;

    @FXML
    private TableColumn<?, ?> others_col_patient;

    @FXML
    private TableColumn<?, ?> others_col_time;

    @FXML
    private TableColumn<?, ?> patient_col_action;

    @FXML
    private TableColumn<?, ?> patient_col_address;

    @FXML
    private TableColumn<?, ?> patient_col_department;

    @FXML
    private TableColumn<?, ?> patient_col_email;

    @FXML
    private TableColumn<?, ?> patient_col_name;

    @FXML
    private TableColumn<?, ?> patient_col_patientID;

    @FXML
    private TableColumn<?, ?> patient_col_phone;

    @FXML
    private TableColumn<?, ?> patient_col_specialization;

    @FXML
    private TableColumn<?, ?> patient_col_status;

    @FXML
    private Button patients_btn;

    @FXML
    private AnchorPane patients_form;

    @FXML
    private ComboBox<?> reportCase_comboBox;

    @FXML
    private Button report_btn;

    @FXML
    private AnchorPane report_form;

    @FXML
    private DatePicker txtBirthDate;

    @FXML
    private TextField txtBirthDescription;

    @FXML
    private TextField txtBirthNewBorn;

    @FXML
    private TextField txtBirthPatient;

    @FXML
    private TextField txtBirthTime;

    @FXML
    private DatePicker txtDeathDate;

    @FXML
    private TextField txtDeathDescription;

    @FXML
    private TextField txtDeathPatient;

    @FXML
    private TextField txtDeathTime;

    @FXML
    private DatePicker txtOperationDate;

    @FXML
    private TextField txtOperationDescription;

    @FXML
    private TextField txtOperationDoctor;

    @FXML
    private TextField txtOperationPatient;

    @FXML
    private TextField txtOperationTime;

    @FXML
    private DatePicker txtOtherDate;

    @FXML
    private TextField txtOtherID;

    @FXML
    private TextField txtOtherDescription;

    @FXML
    private TextField txtOtherPatient;

    @FXML
    private TextField txtOtherTime;

    @FXML
    private TextField txtDonorAge;

    @FXML
    private TextField txtDonorBlood;

    @FXML
    private DatePicker txtDonorDate;

    @FXML
    private Button add_donor_btn;

    @FXML
    private ComboBox<String> chooseDonorBloodGroup;

    @FXML
    private ComboBox<String> chooseDonorGender;

    @FXML
    private TextField txtDeathID;

    @FXML
    private TextField txtBirthID;

    @FXML
    private TextField txtOperationID;


    Connection conn=null;


    ResultSet rs=null;

    PreparedStatement pst=null;



    //change the forms depending on what the user chooses-----------------------------------------------------------

    @FXML
    void switchForm(ActionEvent event) {

        if (event.getSource() == dashboard_btn) {
            dashboard_form.setVisible(true);
            patients_form.setVisible(false);
            report_form.setVisible(false);
            bedWards_form.setVisible(false);
            bloodBank_form.setVisible(false);
        } else if (event.getSource() == patients_btn) {
            dashboard_form.setVisible(false);
            patients_form.setVisible(true);
            report_form.setVisible(false);
            bedWards_form.setVisible(false);
            bloodBank_form.setVisible(false);
        } else if (event.getSource() == report_btn) {
            dashboard_form.setVisible(false);
            patients_form.setVisible(false);
            report_form.setVisible(true);
            bedWards_form.setVisible(false);
            bloodBank_form.setVisible(false);
        } else if (event.getSource() == bedWards_btn) {
            dashboard_form.setVisible(false);
            patients_form.setVisible(false);
            report_form.setVisible(false);
            bedWards_form.setVisible(true);
            bloodBank_form.setVisible(false);
        } else if (event.getSource() == bloodBank_btn) {
            dashboard_form.setVisible(false);
            patients_form.setVisible(false);
            report_form.setVisible(false);
            bedWards_form.setVisible(false);
            bloodBank_form.setVisible(true);
        }
    }


    //database tools--------------------------------------------------------------------------------------------------

    @FXML
    void registerOperation(ActionEvent event) {
        conn= DBConnection.getConnection();
        String sql="insert into births (operationID, opDescription, opPatient, opDoctor, opDate, opTime) values (? , ? , ? , ? , ?, ?)";
        try{
            pst=conn.prepareStatement(sql);
            Date operationDate = Date.valueOf(this.txtOperationDate.getValue());
            pst.setInt(1, Integer.parseInt(txtOperationID.getText()));
            pst.setString(2,txtOperationDescription.getText());
            pst.setString(3,txtOperationPatient.getText());
            pst.setString(4,txtOperationDoctor.getText());
            pst.setDate(4, operationDate);
            pst.setString(5,txtOperationTime.getText());

            pst.execute();
            pst.close();
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }
    @FXML
    void registerBirth(ActionEvent event) {
        conn = DBConnection.getConnection();
        String sql = "insert into births (birthID, birth_description, birth_patient, birth_newborn, birth_date, birth_time) values (?, ?, ?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(sql);
            Date birthDate = Date.valueOf(this.txtBirthDate.getValue());
            pst.setInt(1, Integer.parseInt(txtBirthID.getText()));
            pst.setString(2, txtBirthDescription.getText());
            pst.setString(3, txtBirthPatient.getText());
            pst.setString(4, txtBirthNewBorn.getText());
            pst.setDate(5, birthDate);
            pst.setString(6, txtBirthTime.getText());

            pst.execute();
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void registerDeath(ActionEvent event) {
        conn= DBConnection.getConnection();
        String sql="insert into deaths (deathID, death_description, death_patient, death_date, death_time) values (? , ? , ? , ? , ?)";
        try{
            pst=conn.prepareStatement(sql);
            Date deathDate = Date.valueOf(this.txtDeathDate.getValue());
            pst.setInt(1, Integer.parseInt(txtDeathID.getText()));
            pst.setString(2,txtDeathDescription.getText());
            pst.setDate(4, deathDate);
            pst.setString(5,txtDeathTime.getText());

            pst.execute();
            pst.close();
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }


    @FXML
    void registerOther(ActionEvent event) {
        conn= DBConnection.getConnection();
        String sql="insert into others (other_ID, other_description, other_patient, other_date, other_time) values (? , ? , ? , ? , ?)";
        try{
            pst=conn.prepareStatement(sql);
            Date otherDate = Date.valueOf(this.txtOtherDate.getValue());
            pst.setInt(1, Integer.parseInt(txtOtherID.getText()));
            pst.setString(2,txtOtherDescription.getText());
            pst.setString(3,txtOtherPatient.getText());
            pst.setDate(4,otherDate);
            pst.setString(5,txtOtherTime.getText());

            pst.execute();
            pst.close();
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }


    @FXML
    void registerDonor(ActionEvent event) {
        String donorAge = txtDonorAge.getText();
        String bloodGroup = chooseDonorBloodGroup.getValue();
        String gender = chooseDonorGender.getValue();
        Date lastDonationDate = Date.valueOf(txtDonorDate.getValue());


        DonorDto donor = new DonorDto(bloodGroup, donorAge, gender, lastDonationDate);

        boolean donorCreated = donorService.createDonor(donor);

        if (donorCreated) {
            Navigator.navigate(event, Navigator.NursePage);
        }
    }



    //display data at the tables---------------------------------------------------------------------------------------

    public ObservableList<OperationDto> getOperations() {
        ObservableList<OperationDto> listOperation = FXCollections.observableArrayList();
        String query = "select * from operations";
        Connection con = DatabaseUtil.getConnection();
        try {
            PreparedStatement prepare = con.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                OperationDto operationData = new OperationDto(result.getInt("operationID"), result.getString("opDescription"), result.getString("opPatient"), result.getString("opDoctor"), result.getDate("opDate"), result.getString("opTime"));
                listOperation.add(operationData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOperation;
    }



    public void operationDisplayData() {
        operations_col_operationID.setCellValueFactory(new PropertyValueFactory<>("operationID"));
        operations_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        operations_col_patient.setCellValueFactory(new PropertyValueFactory<>("patient"));
        operations_col_doctor.setCellValueFactory(new PropertyValueFactory<>("doctor"));
        operations_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        operations_col_time.setCellValueFactory(new PropertyValueFactory<>("time"));
        operation_table.setItems(getOperations());
    }

    public ObservableList<BirthsDto> getBirths() {
        ObservableList<BirthsDto> listBirths = FXCollections.observableArrayList();
        String query = "SELECT * FROM births";
        Connection con = DatabaseUtil.getConnection();
        try {
            PreparedStatement prepare = con.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                BirthsDto birthData = new BirthsDto(
                        result.getInt("birthID"),
                        result.getString("birth_description"),
                        result.getString("birth_patient"),
                        result.getString("birth_newborn"),
                        result.getDate("birth_date"),
                        result.getString("birth_time")
                );
                listBirths.add(birthData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBirths;
    }




    public void birthDisplayData() {
        births_col_birthID.setCellValueFactory(new PropertyValueFactory<>("birthID"));
        births_col_description.setCellValueFactory(new PropertyValueFactory<>("birth_description"));
        births_col_patient.setCellValueFactory(new PropertyValueFactory<>("birth_patient"));
        births_col_newBorn.setCellValueFactory(new PropertyValueFactory<>("birth_newborn"));
        births_col_date.setCellValueFactory(new PropertyValueFactory<>("birth_date"));
        births_col_time.setCellValueFactory(new PropertyValueFactory<>("birth_time"));

        birth_table.setItems(getBirths());
    }


    public ObservableList<DeathsDto> getDeaths() {
        ObservableList<DeathsDto> listDeaths = FXCollections.observableArrayList();
        String query = "SELECT * FROM deaths";
        Connection con = DatabaseUtil.getConnection();
        try {
            PreparedStatement prepare = con.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                DeathsDto deathData = new DeathsDto(
                        result.getInt("deathID"),
                        result.getString("death_description"),
                        result.getString("death_patient"),
                        result.getDate("death_date"),
                        result.getString("death_time")
                );
                listDeaths.add(deathData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDeaths;
    }


    public void deathDisplayData() {
        deaths_col_deathID.setCellValueFactory(new PropertyValueFactory<>("deathID"));
        deaths_col_description.setCellValueFactory(new PropertyValueFactory<>("deathDescription"));
        deaths_col_patient.setCellValueFactory(new PropertyValueFactory<>("deathPatient"));
        deaths_col_date.setCellValueFactory(new PropertyValueFactory<>("deathDate"));
        deaths_col_time.setCellValueFactory(new PropertyValueFactory<>("deathTime"));

        death_table.setItems(getDeaths());
    }

    public ObservableList<OthersDto> getOthers() {
        ObservableList<OthersDto> listOthers = FXCollections.observableArrayList();
        String query = "SELECT * FROM others";
        Connection con = DatabaseUtil.getConnection();
        try {
            PreparedStatement prepare = con.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                OthersDto otherData = new OthersDto(
                        result.getInt("otherID"),
                        result.getString("other_description"),
                        result.getString("other_patient"),
                        result.getDate("other_date"),
                        result.getString("other_time")
                );
                listOthers.add(otherData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOthers;
    }

    public void otherDisplayData(){
        others_col_otherID.setCellValueFactory(new PropertyValueFactory<>("otherID"));
        others_col_description.setCellValueFactory(new PropertyValueFactory<>("otherDescription"));
        others_col_patient.setCellValueFactory(new PropertyValueFactory<>("otherPatient"));
        others_col_date.setCellValueFactory(new PropertyValueFactory<>("otherDate"));
        others_col_time.setCellValueFactory(new PropertyValueFactory<>("otherTime"));

        other_table.setItems(getOthers());
    }

    public void initialize(URL location, ResourceBundle resources) {
        // Initialize tables
        operationDisplayData();
        birthDisplayData();
        deathDisplayData();
        otherDisplayData();

        // Initialize blood group ComboBox
        ObservableList<String> bloodGroupOptions = FXCollections.observableArrayList(
                "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"
        );
        chooseDonorBloodGroup.setItems(bloodGroupOptions);

        // Initialize gender ComboBox
        ObservableList<String> genderOptions = FXCollections.observableArrayList(
                "Male", "Female", "Other"
        );
        chooseDonorGender.setItems(genderOptions);

        // Handle selection changes
        chooseDonorBloodGroup.setOnAction(event -> handleBloodGroupSelection());
        chooseDonorGender.setOnAction(event -> handleGenderSelection());
    }

    // Method to handle blood group selection
    private void handleBloodGroupSelection() {
        String selectedBloodGroup = chooseDonorBloodGroup.getValue();

    }

    // Method to handle gender selection
    private void handleGenderSelection() {
        String selectedGender = chooseDonorGender.getValue();

    }

}




