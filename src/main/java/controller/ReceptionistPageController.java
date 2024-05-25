package controller;

import app.Navigator;
import app.SessionManager;
import database.DatabaseUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Appointment;
import model.Patient;
import model.User;
import model.dto.ChangePasswordDto;
import model.dto.RecDto.AppointmentDto;
import model.dto.RecDto.PatientDto;

import model.dto.StaffDto.DoctorDto;
import model.filter.DoctorFilter;
import model.filter.PatientFilter;
import repository.Staff.DepartmentRepository;
import repository.Staff.DoctorRepository;
import repository.Staff.NurseRepository;
import service.Alerts;
import service.ChartService;
import service.CountStaffService;
import service.Rec.AppointmentService;
import service.Rec.PatientService;
//import service.Rec.ReceptionistService;
import service.Rec.ReceptionistServicee;
import service.Staff.AdminService;
import service.Staff.DoctorService;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class ReceptionistPageController implements Initializable {
    @FXML
    private Button account_btn;

    @FXML
    private Button logout_btn;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Button patients_btn;

    @FXML
    private Button appointments_btn;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private AnchorPane patients_form;

    @FXML
    private TableView<Patient> patients_tableView;

    @FXML
    private TableColumn<?, ?> patients_col_patientID;

    @FXML
    private TableColumn<?, ?> patients_col_name;

    @FXML
    private TableColumn<?, ?> patients_col_lastname;


    @FXML
    private TableColumn<?, ?> patients_col_department;

    @FXML
    private TableColumn<?, ?> patients_col_doctor;

    @FXML
    private TableColumn<?, ?> patients_col_nurse;

    @FXML
    private TableColumn<?, ?> patients_col_phonenumber;

    @FXML
    private TableColumn<?, ?> patients_col_email;

    @FXML
    private TableColumn<?, ?> patients_col_address;

    @FXML
    private TableColumn<?, ?> patients_col_payment;

    @FXML
    private Button add_patient_btn;

    @FXML
    private AnchorPane profile_form;

    @FXML
    private TextField recID;

    @FXML
    private TextField recUsername;

    @FXML
    private TextField recEmail;


    @FXML
    private RadioButton radioMale;

    @FXML
    private RadioButton radioFemale;

    @FXML
    private Button import_btn;
    @FXML
    private Button update_btn;

    @FXML
    private AnchorPane register_patient_form;

    @FXML
    private TextField patFirstName;

    @FXML
    private TextField patLastName;

    @FXML
    private DatePicker patBirthdate;

    @FXML
    private TextField patPhone;

    @FXML
    private TextField patEmail;

    @FXML
    private PasswordField patPassword;

    @FXML
    private TextField patAddress;

    @FXML
    private ComboBox<String> patDep;

    @FXML
    private ComboBox<String> patDoctor;

    @FXML
    private ComboBox<String> patNurse;

    @FXML
    private DatePicker patDate;

    @FXML
    private TextField patPayment;

    @FXML
    private Button register_patient_btn;


    @FXML
    private AnchorPane appointments_form;

    @FXML
    private TextField appID;

    @FXML
    private TextField appName;

    @FXML
    private TextField appLastName;

    @FXML
    private RadioButton appMale;

    @FXML
    private RadioButton appFemale;

    @FXML
    private TextField appDesc;

    @FXML
    private ComboBox<String> appDep;

    @FXML
    private ComboBox<String> appDoc;

    @FXML
    private ComboBox<String> appNurse;

    @FXML
    private TextField appPhone;

    @FXML
    private TextField appAddress;

    @FXML
    private DatePicker appDate;

    @FXML
    private TextField appHour;

    @FXML
    private TableView<Appointment> app_tableView;

    @FXML
    private TableColumn<?, ?> app_col_appID;

    @FXML
    private TableColumn<?, ?> app_col_name;

    @FXML
    private TableColumn<?, ?> app_col_department;

    @FXML
    private TableColumn<?, ?> app_col_doctor;

    @FXML
    private TableColumn<?, ?> app_col_nurse;

    @FXML
    private TableColumn<?, ?> app_col_phone;

    @FXML
    private TableColumn<?, ?> app_col_address;

    @FXML
    private TableColumn<?, ?> app_col_date;

    @FXML
    private TableColumn<?, ?> app_col_hour;


    @FXML
    private Button addApp_btn;

    @FXML
    private Label ad;

    @FXML
    private Label pd;


    @FXML
    private Label appointments;


    @FXML
    private Label patients;


    @FXML
    private AnchorPane contentPane;
    @FXML
    private Label personalinformation;
    @FXML
    private Label firstname;

    @FXML
    private Label lastname;

    @FXML
    private Label birthdate;

    @FXML
    private Label phone;

    @FXML
    private Label email;

    @FXML
    private Label address;

    @FXML
    private Label patientapp;
    @FXML
    private Label department;

    @FXML
    private Label doctor;

    @FXML
    private Label nurse;

    @FXML
    private Label datee;

    @FXML
    private Label payment;

    @FXML
    private Label Projectitle;

    @FXML
    private Label appo;

    @FXML
    private Label fn;

    @FXML
    private Label ln;

    @FXML
    private Label ge;


    @FXML
    private Label de;

    @FXML
    private Label dep;

    @FXML
    private Label doc;
    @FXML
    private Label nur;
    @FXML
    private Label phnum;
    @FXML
    private Label aadd;
    @FXML
    private Label datte;
    @FXML
    private Label hourr;
    @FXML
    private Label app_number;
    @FXML
    private Label patients_number;

    @FXML
    private AreaChart<String, Number> dashboad_chart_PD;

    @FXML
    private AreaChart<String, Number> dashboad_chart_AD;
    @FXML
    private TextField filterPatName;

    @FXML
    private TextField filterPatSubname;

    @FXML
    private TextField ChangePwdEmail;

    @FXML
    private AnchorPane account_form;

    @FXML
    private Label cNewPwd;

    @FXML
    private Label chCPwd;

    @FXML
    private Label chConfPwd;

    @FXML
    private Label chEmail;

    @FXML
    private Button changePasswordbtn;

    @FXML
    private PasswordField confirmNewPassword;

    @FXML
    private PasswordField currentPassword;

    @FXML
    private Label infoAddress;

    @FXML
    private Label infoEmail;

    @FXML
    private Label infoFirstName;

    @FXML
    private Label infoLastName;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblFirstName;

    @FXML
    private Label lblID;

    @FXML
    private Label lblLastName;

    @FXML
    private PasswordField newPassword;

    @FXML
    private Label upAddress;

    @FXML
    private Label upEmail;

    @FXML
    private Label upFirstName;

    @FXML
    private Label upLastName;

    @FXML
    private TextField updateAddress;

    @FXML
    private TextField updateEmail;

    @FXML
    private TextField updateFirstName;

    @FXML
    private TextField updateID;

    @FXML
    private TextField updateLastName;

    @FXML
    private Label yourInfo;

    User loggedReceptionist;


    @FXML
    public void registerPatient(ActionEvent event) {
        Date birthdate = Date.valueOf(this.patBirthdate.getValue());
        Date date = Date.valueOf(this.patDate.getValue());

        PatientDto patient = new PatientDto(this.patFirstName.getText(), this.patLastName.getText(), birthdate, this.patPhone.getText(), this.patEmail.getText(), this.patAddress.getText(), (String) this.patDep.getValue(), (String) this.patDoctor.getValue(), (String) this.patNurse.getValue(), date, this.patPayment.getText());
        boolean patientCreated = PatientService.createPatient(patient);
        if (patientCreated) {
            Navigator.navigate(event, Navigator.ReceptionistPage);
        }
    }

    @FXML
    public void registerAppointment(ActionEvent event) {

        Date date = Date.valueOf(this.appDate.getValue());

        AppointmentDto appointment = new AppointmentDto(this.appID.getText(), this.appName.getText(), this.appLastName.getText(), this.appDesc.getText(), (String) this.appDep.getValue(), (String) this.appDoc.getValue(), (String) this.appNurse.getValue(), this.appPhone.getText(), this.appAddress.getText(), date, this.appHour.getText());
        boolean appointmentCreated = AppointmentService.createAppointment(appointment);
        if (appointmentCreated) {
            Navigator.navigate(event, Navigator.ReceptionistPage);
        }
    }

    @FXML
    void switchForm(ActionEvent event) {
        if (event.getSource() == dashboard_btn) showForm(dashboard_form);
        else if (event.getSource() == patients_btn) showForm(patients_form);
        else if (event.getSource() == account_btn) showForm(account_form);
        else if (event.getSource() == add_patient_btn) showForm(register_patient_form);
        else if (event.getSource() == appointments_btn) showForm(appointments_form);
    }

    private void showForm(AnchorPane form) {
        dashboard_form.setVisible(form == dashboard_form);
        patients_form.setVisible(form == patients_form);
        account_form.setVisible(form == account_form);
        register_patient_form.setVisible(form == register_patient_form);
        appointments_form.setVisible(form == appointments_form);

    }

    public ObservableList<Patient> getPatients() {
        ObservableList<Patient> listPatients = FXCollections.observableArrayList();
        String query = "select * from patients";
        Connection con = DatabaseUtil.getConnection();
        try {
            PreparedStatement prepare = con.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                Patient patData = new Patient(result.getInt("patient_id"), result.getString("patient_firstName"), result.getString("patient_lastName"), result.getString("patient_department"), result.getString("patient_doctor"), result.getString("patient_nurse"), result.getString("patient_phone"), result.getString("patient_email"), result.getString("patient_address"), result.getString("patient_payment"));
                listPatients.add(patData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPatients;
    }


    public ObservableList<Appointment> getAppointments() {
        ObservableList<Appointment> listAppointments = FXCollections.observableArrayList();
        String query = "select * from appointments";
        Connection con = DatabaseUtil.getConnection();
        try {
            PreparedStatement prepare = con.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                Appointment appointmentData = new Appointment(result.getString("appointment_id"), result.getString("appointment_firstName"), result.getString("appointment_department"), result.getString("appointment_doctor"), result.getString("appointment_nurse"), result.getString("appointment_phone"), result.getString("appointment_address"), result.getDate("appointment_date"), result.getString("appointment_hour"));
                listAppointments.add(appointmentData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAppointments;
    }

    public void patientDisplayData() {
        patients_col_patientID.setCellValueFactory(new PropertyValueFactory<>("id"));
        patients_col_name.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        patients_col_lastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        patients_col_department.setCellValueFactory(new PropertyValueFactory<>("department"));
        patients_col_doctor.setCellValueFactory(new PropertyValueFactory<>("doctor"));
        patients_col_nurse.setCellValueFactory(new PropertyValueFactory<>("nurse"));
        patients_col_phonenumber.setCellValueFactory(new PropertyValueFactory<>("phone"));
        patients_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        patients_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        patients_col_payment.setCellValueFactory(new PropertyValueFactory<>("payment"));
        patients_tableView.setItems(getPatients());
    }


    public void appointmentDisplayData() {
        app_col_appID.setCellValueFactory(new PropertyValueFactory<>("id"));
        app_col_name.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        app_col_department.setCellValueFactory(new PropertyValueFactory<>("department"));
        app_col_doctor.setCellValueFactory(new PropertyValueFactory<>("doctor"));
        app_col_nurse.setCellValueFactory(new PropertyValueFactory<>("nurse"));
        app_col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        app_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        app_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        app_col_hour.setCellValueFactory(new PropertyValueFactory<>("hour"));
        app_tableView.setItems(getAppointments());

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dashboard_form.setVisible(true);
        patients_form.setVisible(false);
        account_form.setVisible(false);
        register_patient_form.setVisible(false);
        appointments_form.setVisible(false);
        patientDisplayData();
        appointmentDisplayData();
        this.staff_count();
        loadDepartmentNames();
        loadDoctorNames();
        loadNurseNames();
        ChartService.patientAreaChart(dashboad_chart_PD);
        ChartService.appointmentAreaChart(dashboad_chart_AD);


        //Navigating with Enter through Patients TextFields
        // dashboard_btn.setOnAction(event -> patients_btn.requestFocus());
        // patients_btn.setOnAction(event -> add_patient_btn.requestFocus());
        // add_patient_btn.setOnAction(event -> patFirstName.requestFocus());
        patFirstName.setOnAction(event -> patLastName.requestFocus());
        patLastName.setOnAction(event -> patBirthdate.requestFocus());
        patBirthdate.setOnAction(event -> patPhone.requestFocus());
        patPhone.setOnAction(event -> patEmail.requestFocus());
        patEmail.setOnAction(event -> patAddress.requestFocus());
        patAddress.setOnAction(event -> patDep.requestFocus());
        patDep.setOnAction(event -> patDoctor.requestFocus());
        patDoctor.setOnAction(event -> patNurse.requestFocus());
        patNurse.setOnAction(event -> patDate.requestFocus());
        patDate.setOnAction(event -> patPayment.requestFocus());
        patPayment.setOnAction(event -> register_patient_btn.requestFocus());
        register_patient_btn.setOnAction(event -> {
            registerPatient(event);
            event.consume();

        });
        //Navigating with Enter through Appointments TextFields
       /* appID.setOnAction(event -> appName.requestFocus());
        appName.setOnAction(event ->appLastName.requestFocus());
        appLastName.setOnAction(event -> appMale.requestFocus());
        appMale.setOnAction(event -> appFemale.requestFocus());
        appFemale.setOnAction(event -> appDesc.requestFocus());
        appDesc.setOnAction(event ->  appDep.requestFocus());
        appDep.setOnAction(event -> appDoc.requestFocus());
        appDoc.setOnAction(event -> appNurse.requestFocus());
        appNurse.setOnAction(event -> appPhone.requestFocus());
        appPhone.setOnAction(event -> appAddress.requestFocus());
        appAddress.setOnAction(event -> appDate.requestFocus());
        appDate.setOnAction(event -> appHour.requestFocus());
        appHour.setOnAction(event -> addApp_btn.requestFocus());
        addApp_btn.setOnAction(event -> {
            registerAppointment(event);
            event.consume();

        });

        */

        Navigator.loadContent(contentPane, "ReceptionistPage.fxml");
        this.translate();
        setRecInfo();
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
        Locale locale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle("translations.content", locale);
        //   this.Projectitle.setText(rb.getString("Hospital Management System"));
        this.dashboard_btn.setText(rb.getString("Dashboard"));
        this.patients_btn.setText(rb.getString("Patients"));
        this.appointments_btn.setText(rb.getString("Appointments"));
        this.add_patient_btn.setText(rb.getString("Add New Patient"));
        this.register_patient_btn.setText(rb.getString("Add"));
        this.account_btn.setText(rb.getString("Account"));
        this.logout_btn.setText(rb.getString("Logout"));
        this.ad.setText(rb.getString("Appointments Data"));
        this.pd.setText(rb.getString("Patients Data"));
        this.appointments.setText(rb.getString("Appointments"));
        this.patients.setText(rb.getString("Patients"));
        this.patients_col_patientID.setText(rb.getString("Patient ID"));
        this.patients_col_name.setText(rb.getString("Name"));
        this.patients_col_department.setText(rb.getString("Department"));
        this.patients_col_doctor.setText(rb.getString("Doctor"));
        this.patients_col_nurse.setText(rb.getString("Nurse"));
        this.patients_col_phonenumber.setText(rb.getString("Phone Number"));
        this.patients_col_email.setText(rb.getString("Email"));
        this.patients_col_address.setText(rb.getString("Address"));
        this.patients_col_payment.setText(rb.getString("Payment"));
        this.personalinformation.setText(rb.getString("Personal Information"));
        this.firstname.setText(rb.getString("First Name"));
        this.lastname.setText(rb.getString("Last Name"));
        this.birthdate.setText(rb.getString("Birthdate"));
        this.phone.setText(rb.getString("Phone"));
        this.address.setText(rb.getString("Address"));
        this.patientapp.setText(rb.getString("Patient Appointment"));
        this.department.setText(rb.getString("Department"));
        this.doctor.setText(rb.getString("Doctor"));
        this.nurse.setText(rb.getString("Nurse"));
        this.datee.setText(rb.getString("Date"));
        this.payment.setText(rb.getString("Payment"));
        this.app_col_appID.setText(rb.getString("Appointment ID"));
        this.app_col_name.setText(rb.getString("First Name"));
        this.app_col_department.setText(rb.getString("Department"));
        this.app_col_doctor.setText(rb.getString("Doctor"));
        this.app_col_nurse.setText(rb.getString("Nurse"));
        this.app_col_phone.setText(rb.getString("Phone Number"));
        this.app_col_address.setText(rb.getString("Address"));
        this.app_col_date.setText(rb.getString("Date"));
        this.app_col_hour.setText(rb.getString("Hour"));
        this.appo.setText(rb.getString("Appointment ID"));
        this.fn.setText(rb.getString("First Name"));
        this.ln.setText(rb.getString("Last Name"));
        this.ge.setText(rb.getString("Gender"));
        this.appMale.setText(rb.getString("Male"));
        this.appFemale.setText(rb.getString("Female"));
        this.de.setText(rb.getString("Description"));
        this.dep.setText(rb.getString("Department"));
        this.doc.setText(rb.getString("Doctor"));
        this.nur.setText(rb.getString("Nurse"));
        this.phnum.setText(rb.getString("Phone Number"));
        this.aadd.setText(rb.getString("Address"));
        this.datte.setText(rb.getString("Date"));
        this.hourr.setText(rb.getString("Hour"));
        this.addApp_btn.setText(rb.getString("Add"));
        this.patients_col_lastname.setText(rb.getString("Subname"));
        this.infoFirstName.setText(rb.getString("First Name"));
        this.infoLastName.setText(rb.getString("Last Name"));
        this.infoEmail.setText(rb.getString("Email"));
        this.infoAddress.setText(rb.getString("Address"));
        this.upEmail.setText(rb.getString("Email"));
        this.upAddress.setText(rb.getString("Address"));
        this.upFirstName.setText(rb.getString("First Name"));
        this.upLastName.setText(rb.getString("Last Name"));
        this.chConfPwd.setText(rb.getString("Confirm Password"));
        this.chEmail.setText(rb.getString("Email"));
        this.chCPwd.setText(rb.getString("Current Password"));
        this.cNewPwd.setText(rb.getString("New Password"));

    }

    public void staff_count() {

        CountStaffService.countStaff(app_number, CountStaffService.countPatients);
        CountStaffService.countStaff(patients_number, CountStaffService.countAppointments);
    }

    private void loadDepartmentNames() {
        List<String> departmentNames = DepartmentRepository.getAllDepartmentNames();
        ObservableList<String> observableList = FXCollections.observableArrayList(departmentNames);
        patDep.setItems(observableList);
        appDep.setItems(observableList);
    }

    private void loadDoctorNames() {
        List<String> doctorNames = DoctorRepository.getAllDoctorsNames();
        ObservableList<String> observableList = FXCollections.observableArrayList(doctorNames);
        patDoctor.setItems(observableList);
        appDoc.setItems(observableList);
    }

    private void loadNurseNames() {
        List<String> nurseNames = NurseRepository.getAllNursesNames();
        ObservableList<String> observableList = FXCollections.observableArrayList(nurseNames);
        patNurse.setItems(observableList);
        appNurse.setItems(observableList);
    }

    @FXML
    void handlePatientFilter(ActionEvent event) {
        String firstName = filterPatName.getText();
        String lastName = filterPatSubname.getText();
        PatientFilter filter = new PatientFilter(firstName, lastName);
        List<Patient> filteredPatients = PatientService.filter(filter);
        updatePatientTable(filteredPatients);
    }

    public void updatePatientTable(List<Patient> patients) {
        ObservableList<Patient> listPatients = FXCollections.observableArrayList(patients);
        patients_tableView.setItems(listPatients);
    }

    public void logout(ActionEvent event) {
        SessionManager.clearSession();
        Navigator.navigate(event, Navigator.LoginPage);
    }

    @FXML
    void changePassword(ActionEvent event) {
        String currentPassword = this.currentPassword.getText();
        String newPassword = this.newPassword.getText();
        String confirmNewPassword = this.confirmNewPassword.getText();
        if (currentPassword.isBlank() || ChangePwdEmail.getText().isEmpty() || newPassword.isBlank() || confirmNewPassword.isEmpty())
            Alerts.errorMessage("Please fill all the fields before proceeding.");
        else if (!newPassword.equals(confirmNewPassword)) {
            Alerts.errorMessage("Passwords do not match.");
        } else {
            ChangePasswordDto change = new ChangePasswordDto(this.ChangePwdEmail.getText(), this.currentPassword.getText(), this.newPassword.getText(), this.confirmNewPassword.getText());
            boolean changed = AdminService.changePassword(change);
            if (changed) {
                Alerts.successMessage("Password was successfully changed.");
            } else {
                Alerts.errorMessage("Password was not changed");
            }
        }
    }


    public void updateAccount(ActionEvent event) {
        String firstName = updateFirstName.getText();
        String lastName = updateLastName.getText();
        String email = updateEmail.getText();
        String address = updateAddress.getText();

        if (firstName.isBlank() || lastName.isBlank() || email.isBlank() || address.isBlank()) {
            Alerts.errorMessage("Please fill all the fields before proceeding.");
        } else {
            loggedReceptionist.setFirstName(firstName);
            loggedReceptionist.setLastName(lastName);
            loggedReceptionist.setEmail(email);
            loggedReceptionist.setAddress(address);


            boolean updated = ReceptionistServicee.updateReceptionistDetails(loggedReceptionist);
            if (updated) {
                Alerts.successMessage("Account details were successfully updated.");
                setRecInfo(); // Refresh the displayed info
            } else {
                Alerts.errorMessage("Failed to update account details.");
            }


        }
    }

    public void setRecInfo() {
        loggedReceptionist = SessionManager.getCurrentUser();
        if (loggedReceptionist != null) {
            lblID.setText(loggedReceptionist.getId());
            lblFirstName.setText(loggedReceptionist.getFirstName());
            lblLastName.setText(loggedReceptionist.getLastName());
            lblEmail.setText(loggedReceptionist.getEmail());
            lblAddress.setText(loggedReceptionist.getAddress());

            updateID.setText(loggedReceptionist.getId());
            updateFirstName.setText(loggedReceptionist.getFirstName());
            updateLastName.setText(loggedReceptionist.getLastName());
            updateEmail.setText(loggedReceptionist.getEmail());
            updateAddress.setText(loggedReceptionist.getAddress());
        }
    }


}
