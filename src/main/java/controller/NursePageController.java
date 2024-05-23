package controller;

import app.Navigator;
import database.DatabaseUtil;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Births;
import model.Deaths;
import model.Operation;
import model.Others;
import model.dto.RecDto.PatientDto;
import model.dto.ReportDto.*;
import service.Rec.PatientService;
import service.Report.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    private TableView<Births> birth_table;

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
    private TableView<Operation> operation_table;

    @FXML
    private TableView<Deaths> death_table;

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
    private TableView<Others> other_table;

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
        Date operationDate = Date.valueOf(this.txtOperationDate.getValue());

        OperationDto operation = new OperationDto (this.txtOperationID.getText(), this.txtOperationDescription.getText(), this.txtOperationPatient.getText(),this.txtOperationDoctor.getText(), operationDate, this.txtOperationTime.getText());
        boolean operationCreated = operationService.createOperation(operation);
        if (operationCreated) {
            Navigator.navigate(event, Navigator.NursePage);
        }
    }


    @FXML
    void registerBirth(ActionEvent event) {
        Date birthDate = Date.valueOf(this.txtBirthDate.getValue());

        BirthsDto birth = new BirthsDto (this.txtBirthID.getText(), this.txtBirthDescription.getText(), this.txtBirthPatient.getText(),this.txtBirthNewBorn.getText(), birthDate, this.txtBirthTime.getText());
        boolean birthCreated = birthService.createBirth(birth);
        if (birthCreated) {
            Navigator.navigate(event, Navigator.NursePage);
        }
    }


    @FXML
    void registerDeath(ActionEvent event) {
        Date deathDate = Date.valueOf(this.txtDeathDate.getValue());

        DeathsDto deaths = new DeathsDto(this.txtDeathID.getText(), this.txtDeathDescription.getText(), this.txtDeathPatient.getText(), deathDate, this.txtDeathTime.getText());
        boolean deathCreated = deathService.createDeath(deaths);
        if (deathCreated) {
            Navigator.navigate(event, Navigator.NursePage);
        }
    }


    @FXML
    void registerOther(ActionEvent event) {
        Date otherdate = Date.valueOf(this.txtOtherDate.getValue());

        OthersDto others = new OthersDto(this.txtOtherID.getText(), this.txtOtherDescription.getText(), this.txtOtherPatient.getText(), otherdate, this.txtOtherTime.getText());
        boolean otherCreated = otherService.createOther(others);
        if (otherCreated) {
            Navigator.navigate(event, Navigator.NursePage);
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

//display Operations
    public ObservableList<Operation> getOperations() {
        ObservableList<Operation> listOperation = FXCollections.observableArrayList();
        String query = "SELECT * FROM operations";
        Connection con = DatabaseUtil.getConnection();
        try {
            PreparedStatement prepare = con.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                Operation operationData = new Operation(
                        result.getString("operationID"),
                        result.getString("opDescription"),
                        result.getString("opPatient"),
                        result.getString("opDoctor"),
                        result.getDate("opDate"),
                        result.getString("opTime")
                );
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



//display Births
    public ObservableList<Births> getBirths() {
        ObservableList<Births> listBirths = FXCollections.observableArrayList();
        String query = "SELECT * FROM births";
        Connection con = DatabaseUtil.getConnection();
        try {
            PreparedStatement prepare = con.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                Births birthData = new Births(
                        result.getString("birthID"),
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
        births_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        births_col_patient.setCellValueFactory(new PropertyValueFactory<>("patient"));
        births_col_newBorn.setCellValueFactory(new PropertyValueFactory<>("newborn"));
        births_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        births_col_time.setCellValueFactory(new PropertyValueFactory<>("time"));

        birth_table.setItems(getBirths());
    }

//display Deaths
    public ObservableList<Deaths> getDeaths() {
        ObservableList<Deaths> listDeaths = FXCollections.observableArrayList();
        String query = "SELECT * FROM deaths";
        Connection con = DatabaseUtil.getConnection();
        try {
            PreparedStatement prepare = con.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                Deaths deathData = new Deaths(
                        result.getString("deathID"),
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
        deaths_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        deaths_col_patient.setCellValueFactory(new PropertyValueFactory<>("patient"));
        deaths_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        deaths_col_time.setCellValueFactory(new PropertyValueFactory<>("time"));

        death_table.setItems(getDeaths());
    }


//display Others

    public ObservableList<Others> getOthers() {
        ObservableList<Others> listOthers = FXCollections.observableArrayList();
        String query = "SELECT * FROM others";
        Connection con = DatabaseUtil.getConnection();
        try {
            PreparedStatement prepare = con.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                Others otherData = new Others(
                        result.getString("otherID"),
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
        others_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        others_col_patient.setCellValueFactory(new PropertyValueFactory<>("patient"));
        others_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        others_col_time.setCellValueFactory(new PropertyValueFactory<>("time"));

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
    @FXML
    void handleRegjistro(MouseEvent event) {

        Navigator.navigate(event, Navigator.NursePage);
    }





}
