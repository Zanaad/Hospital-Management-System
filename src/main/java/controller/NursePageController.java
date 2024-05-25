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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.*;
import model.dto.RecDto.PatientDto;
import model.dto.ReportDto.*;
import service.Rec.PatientService;
import service.Report.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;
import java.util.ResourceBundle;

public class NursePageController implements Initializable {


    @FXML
    private Button Logout_btn;

    @FXML
    private Label Project_title;

    @FXML
    private Label SQDateBi;

    @FXML
    private Label SQDateDe;

    @FXML
    private Label SQDateOp;

    @FXML
    private Label SQDateOt;

    @FXML
    private Label SQDescriptionBi;

    @FXML
    private Label SQDescriptionDe;

    @FXML
    private Label SQDescriptionOp;

    @FXML
    private Label SQDescriptionOt;

    @FXML
    private Label SQDoctorOp;

    @FXML
    private Label SQDonorAge;

    @FXML
    private Label SQDonorPatient;

    @FXML
    private Label SQNewbornBi;

    @FXML
    private Label SQPatientBi;

    @FXML
    private Label SQPatientDe;

    @FXML
    private Label SQPatientOP;

    @FXML
    private Label SQPatientOt;

    @FXML
    private Label SQTimeBi;

    @FXML
    private Label SQTimeDe;

    @FXML
    private Label SQTimeOp;

    @FXML
    private Label SQTimeOt;

    @FXML
    private Button account_btn;

    @FXML
    private Button addOperation_btn;

    @FXML
    private Button add_birth_btn;

    @FXML
    private Button add_death_btn;

    @FXML
    private Button add_donor_btn;

    @FXML
    private Button add_other_btn;

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
    private TableView<?> bed_table;

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
    private TableColumn<?, ?> blood_col_donorPatient;

    @FXML
    private TableColumn<?, ?> blood_col_gender;

    @FXML
    private TableColumn<?, ?> blood_col_lastDonationDate;

    @FXML
    private TableView<BloodDonors> blood_table;

    @FXML
    private Label chart1;

    @FXML
    private Label chart2;

    @FXML
    private ComboBox<String> chooseDonorBloodGroup;

    @FXML
    private ComboBox<String> chooseDonorGender;

    @FXML
    private AnchorPane contentPane;

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
    private TableView<Deaths> death_table;

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
    private Label id1;

    @FXML
    private Label id2;

    @FXML
    private Label id3;

    @FXML
    private AnchorPane main_form;

    @FXML
    private TableView<Operation> operation_table;

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
    private TextField patAddress;

    @FXML
    private DatePicker patBirthdate;

    @FXML
    private DatePicker patDate;

    @FXML
    private ComboBox<?> patDep;

    @FXML
    private ComboBox<?> patDoctor;

    @FXML
    private TextField patEmail;

    @FXML
    private TextField patFirstName;

    @FXML
    private TextField patLastName;

    @FXML
    private ComboBox<?> patNurse;

    @FXML
    private TextField patPayment;

    @FXML
    private TextField patPhone;

    @FXML
    private Button patients_btn;

    @FXML
    private TableColumn<?, ?> patients_col_address;

    @FXML
    private TableColumn<?, ?> patients_col_department;

    @FXML
    private TableColumn<?, ?> patients_col_doctor;

    @FXML
    private TableColumn<?, ?> patients_col_email;

    @FXML
    private TableColumn<?, ?> patients_col_name;

    @FXML
    private TableColumn<?, ?> patients_col_nurse;

    @FXML
    private TableColumn<?, ?> patients_col_patientID;

    @FXML
    private TableColumn<?, ?> patients_col_payment;

    @FXML
    private TableColumn<?, ?> patients_col_phonenumber;

    @FXML
    private AnchorPane patients_form;

    @FXML
    private TableView<Patient> patients_tableView;

    @FXML
    private Button register_patient_btn;

    @FXML
    private AnchorPane register_patient_form;

    @FXML
    private Tab report1op;

    @FXML
    private Tab report2Op;

    @FXML
    private Tab report3Op;

    @FXML
    private Tab report4Op;

    @FXML
    private Button report_btn;

    @FXML
    private AnchorPane report_form;

    @FXML
    private Label titulliReports;

    @FXML
    private DatePicker txtBirthDate;

    @FXML
    private TextField txtBirthDescription;

    @FXML
    private TextField txtBirthID;

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
    private TextField txtDeathID;

    @FXML
    private TextField txtDeathPatient;

    @FXML
    private TextField txtDeathTime;

    @FXML
    private TextField txtDonorAge;

    @FXML
    private DatePicker txtDonorDate;

    @FXML
    private TextField txtDonorPatient;

    @FXML
    private DatePicker txtOperationDate;

    @FXML
    private TextField txtOperationDescription;

    @FXML
    private TextField txtOperationDoctor;

    @FXML
    private TextField txtOperationID;

    @FXML
    private TextField txtOperationPatient;

    @FXML
    private TextField txtOperationTime;

    @FXML
    private DatePicker txtOtherDate;

    @FXML
    private TextField txtOtherDescription;

    @FXML
    private TextField txtOtherID;

    @FXML
    private TextField txtOtherPatient;

    @FXML
    private TextField txtOtherTime;

    @FXML
    private TableColumn<?, ?> blood_col_donor_id;

    @FXML
    private Tab titulli_AddDonors;

    @FXML
    private Tab titulli_DonorsList;

    @FXML
    private Label titulli_Donors;


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
    public void registerPatient(ActionEvent event) {

        Date birthdate = Date.valueOf(this.patBirthdate.getValue());
        Date date = Date.valueOf(this.patDate.getValue());

        PatientDto patient = new PatientDto(this.patFirstName.getText(), this.patLastName.getText(), birthdate, this.patPhone.getText(), this.patEmail.getText(), this.patAddress.getText(), (String) this.patDep.getValue(), (String) this.patDoctor.getValue(), (String) this.patNurse.getValue(), date, this.patPayment.getText());
        boolean patientCreated = PatientService.createPatient(patient);
        if (patientCreated) {
            Navigator.navigate(event, Navigator.NursePage);
        }

    }
    @FXML
    void registerDonor(ActionEvent event) {
        Date donationDate = Date.valueOf(this.txtDonorDate.getValue());

        DonorDto donor = new DonorDto(this.txtDonorPatient.getText(),
                (String) this.chooseDonorBloodGroup.getValue(),
                Integer.parseInt(this.txtDonorAge.getText()),
                (String) this.chooseDonorGender.getValue(),
                donationDate);
        boolean donorCreated = donorService.createDonor(donor);
        if (donorCreated)
        {
            Navigator.navigate(event, Navigator.NursePage);
        }
    }







//display data at the tables----------------------------------------------------------------------------------------------------------------------------------------------------------

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
                        result.getString("other_ID"),
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


//display Patient
    public ObservableList<Patient> getPatients() {
        ObservableList<Patient> listPatients = FXCollections.observableArrayList();
        String query = "select * from patients";
        Connection con = DatabaseUtil.getConnection();
        try {
            PreparedStatement prepare = con.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                Patient patData = new Patient(result.getInt("patient_id"),result.getString("patient_firstName"),result.getString("patient_lastName"),result.getString("patient_department"), result.getString("patient_doctor"), result.getString("patient_nurse"), result.getString("patient_phone"), result.getString("patient_email"), result.getString("patient_address"), result.getString("patient_payment"));
                listPatients.add(patData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPatients;
    }
    public void patientDisplayData() {
        patients_col_patientID.setCellValueFactory(new PropertyValueFactory<>("id"));
        patients_col_name.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        patients_col_department.setCellValueFactory(new PropertyValueFactory<>("department"));
        patients_col_doctor.setCellValueFactory(new PropertyValueFactory<>("doctor"));
        patients_col_nurse.setCellValueFactory(new PropertyValueFactory<>("nurse"));
        patients_col_phonenumber.setCellValueFactory(new PropertyValueFactory<>("phone"));
        patients_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        patients_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        patients_col_payment.setCellValueFactory(new PropertyValueFactory<>("payment"));
        patients_tableView.setItems(getPatients());

    }

//display Donors

    public ObservableList<BloodDonors> getDonors() {
        ObservableList<BloodDonors> listDonors = FXCollections.observableArrayList();
        String query = "SELECT * FROM donors";
        Connection con = DatabaseUtil.getConnection();
        try {
            PreparedStatement prepare = con.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                BloodDonors donorData = new BloodDonors(
                        result.getInt("donor_ID"),
                        result.getString("donor_patient"),
                        result.getString("donor_bloodGroup"),
                        result.getInt("donor_age"),
                        result.getString("donor_gender"),
                        result.getDate("donor_lastDonation")
                );
                listDonors.add(donorData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDonors;
    }
    public void donorDisplayData(){
        blood_col_donor_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        blood_col_donorPatient.setCellValueFactory(new PropertyValueFactory<>("patient"));
        blood_col_bloodGroup.setCellValueFactory(new PropertyValueFactory<>("bloodGroup"));
        blood_col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        blood_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        blood_col_lastDonationDate.setCellValueFactory(new PropertyValueFactory<>("lastDonationDate"));

        blood_table.setItems(getDonors());
    }




    public void initialize(URL location, ResourceBundle resources) {
        // Initialize tables
        operationDisplayData();
        birthDisplayData();
        deathDisplayData();
        otherDisplayData();
        patientDisplayData();
        donorDisplayData();
// Event Handler for navigating through TextFields with Enter--------------------------------------------------------------------------------------------------------------


//Navigating with Enter through Operation TextFields
        txtOperationID.setOnAction(event -> txtOperationDescription.requestFocus());
        txtOperationDescription.setOnAction(event -> txtOperationPatient.requestFocus());
        txtOperationPatient.setOnAction(event -> txtOperationDoctor.requestFocus());
        txtOperationDoctor.setOnAction(event -> txtOperationDate.requestFocus());
        txtOperationDate.setOnAction(event -> txtOperationTime.requestFocus());
        txtOperationTime.setOnAction(event -> {
            registerOperation(event);
            event.consume();

        });

//Navigating with Enter through Births TextFields
        txtBirthID.setOnAction(event -> txtBirthDescription.requestFocus());
        txtBirthDescription.setOnAction(event -> txtBirthPatient.requestFocus());
        txtBirthPatient.setOnAction(event -> txtBirthNewBorn.requestFocus());
        txtBirthNewBorn.setOnAction(event -> txtBirthDate.requestFocus());
        txtBirthDate.setOnAction(event -> txtBirthTime.requestFocus());
        txtBirthTime.setOnAction(event -> {
            registerBirth(event);
            event.consume();

        });

//Navigating with Enter through Deaths TextFields
        txtDeathID.setOnAction(event -> txtDeathDescription.requestFocus());
        txtDeathDescription.setOnAction(event -> txtDeathPatient.requestFocus());
        txtDeathPatient.setOnAction(event -> txtDeathDate.requestFocus());
        txtDeathDate.setOnAction(event -> txtDeathTime.requestFocus());
        txtDeathTime.setOnAction(event -> {
            registerDeath(event);
            event.consume();

        });

//Navigating with Enter through Other TextFields
        txtOtherID.setOnAction(event -> txtOtherDescription.requestFocus());
        txtOtherDescription.setOnAction(event -> txtOtherPatient.requestFocus());
        txtOtherPatient.setOnAction(event -> txtOtherDate.requestFocus());
        txtOtherDate.setOnAction(event -> txtOtherTime.requestFocus());
        txtOtherTime.setOnAction(event -> {
            registerOther(event);
            event.consume();

        });

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

        Navigator.loadContent(contentPane, "NursePage.fxml");
        this.translate();
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


    @FXML
    public void handleLanguage() {
        Locale defaultLocale = Locale.getDefault();
        if (defaultLocale.getLanguage().equals("en")) {
            Locale.setDefault(new Locale("sq"));
        } else {
            Locale.setDefault(Locale.ENGLISH);
        }
        this.translate();
    }



    public void translate() {
        try {
            Locale locale = Locale.getDefault();
            ResourceBundle rb = ResourceBundle.getBundle("translations.content", locale);
            this.dashboard_btn.setText(rb.getString("Dashboard"));
            this.report_btn.setText(rb.getString("Report"));
            this.patients_btn.setText(rb.getString("Patients"));
            this.bloodBank_btn.setText(rb.getString("Blood Donation"));
            this.bedWards_btn.setText(rb.getString("Bed Status"));
            this.chart1.setText(rb.getString("Blood Donation"));
            this.chart2.setText(rb.getString("Patients Data"));
            this.id1.setText(rb.getString("Patients"));
            this.id2.setText(rb.getString("Blood Donors"));
            this.id3.setText(rb.getString("Beds Available"));
            this.SQDescriptionOp.setText(rb.getString("Description"));
            this.SQDoctorOp.setText(rb.getString("Doctor"));
            this.SQPatientOP.setText(rb.getString("Patient"));
            this.report1op.setText(rb.getString("Operations"));
            this.report2Op.setText(rb.getString("Deaths"));
            this.report3Op.setText(rb.getString("Births"));
            this.report4Op.setText(rb.getString("Other"));
            this.titulliReports.setText(rb.getString("Report Incident Case "));
            this.operations_col_operationID.setText(rb.getString("OperationID"));
            this.operations_col_description.setText(rb.getString("Description"));
            this.operations_col_patient.setText(rb.getString("Patient"));
            this.operations_col_doctor.setText(rb.getString("Doctor"));
            this.operations_col_date.setText(rb.getString("Date"));
            this.operations_col_time.setText(rb.getString("Time"));
            this.deaths_col_deathID.setText(rb.getString("DeathID"));
            this.deaths_col_description.setText(rb.getString("Description"));
            this.deaths_col_patient.setText(rb.getString("Patient"));
            this.deaths_col_date.setText(rb.getString("Date"));
            this.deaths_col_time.setText(rb.getString("Time"));
            this.births_col_birthID.setText(rb.getString("BirthID"));
            this.births_col_description.setText(rb.getString("Description"));
            this.births_col_patient.setText(rb.getString("Patient"));
            this.births_col_newBorn.setText(rb.getString("New Born's name"));
            this.births_col_date.setText(rb.getString("Date"));
            this.births_col_time.setText(rb.getString("Time"));
            this.others_col_otherID.setText(rb.getString("OtherID"));
            this.others_col_description.setText(rb.getString("Description"));
            this.others_col_patient.setText(rb.getString("Patient"));
            this.others_col_date.setText(rb.getString("Date"));
            this.others_col_time.setText(rb.getString("Time"));
            this.SQDescriptionOp.setText(rb.getString("Description"));
            this.SQPatientOP.setText(rb.getString("Patient"));
            this.SQDoctorOp.setText(rb.getString("Doctor"));
            this.SQDateOp.setText(rb.getString("Date"));
            this.SQTimeOp.setText(rb.getString("Time"));
            this.Logout_btn.setText(rb.getString("LogOut"));
            this.account_btn.setText(rb.getString("Account"));
            this.Project_title.setText(rb.getString("Hospital Management System"));
            this.addOperation_btn.setText(rb.getString("Add Operation"));
            this.add_death_btn.setText(rb.getString("Add Death"));
            this.SQDescriptionDe.setText(rb.getString("Description"));
            this.SQPatientDe.setText(rb.getString("Patient"));
            this.SQDateDe.setText(rb.getString("Date"));
            this.SQTimeDe.setText(rb.getString("Time"));
            this.SQDescriptionBi.setText(rb.getString("Description"));
            this.SQPatientBi.setText(rb.getString("Patient"));
            this.SQNewbornBi.setText(rb.getString("New Born's name"));
            this.SQDateBi.setText(rb.getString("Date"));
            this.SQTimeBi.setText(rb.getString("Time"));
            this.SQDescriptionOt.setText(rb.getString("Description"));
            this.SQPatientOt.setText(rb.getString("Patient"));
            this.SQDateOt.setText(rb.getString("Date"));
            this.SQTimeOt.setText(rb.getString("Time"));
            this.add_other_btn.setText(rb.getString("Add Other"));
            this.add_death_btn.setText(rb.getString("Add Death"));
            this.add_birth_btn.setText(rb.getString("Add Birth"));
            this.titulli_DonorsList.setText(rb.getString("Blood Donors List"));
            this.titulli_AddDonors.setText(rb.getString("Add Blood Donor"));
            this.SQDonorAge.setText(rb.getString("Age"));
            this.chooseDonorGender.setPromptText(rb.getString("Gender..."));
            this.txtDonorDate.setPromptText(rb.getString("Last Donation Date..."));
            this.add_donor_btn.setText(rb.getString("Add Donor"));
            this.chooseDonorBloodGroup.setPromptText(rb.getString("Blood Group..."));
            this.titulli_Donors.setText(rb.getString("Blood Bank"));
            this.blood_col_bloodGroup.setText(rb.getString("Blood Group"));
            this.blood_col_lastDonationDate.setText("Last Donation Date");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
