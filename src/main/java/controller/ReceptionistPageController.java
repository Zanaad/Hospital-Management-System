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
import javafx.scene.layout.AnchorPane;
import model.Appointment;
import model.Patient;
import model.dto.RecDto.AppointmentDto;
import model.dto.RecDto.PatientDto;

import service.Rec.AppointmentService;
import service.Rec.PatientService;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    private BarChart<?, ?> dashboad_chart_AD;

    @FXML
    private AreaChart<?, ?> dashboad_chart_PD;

    @FXML
    private AnchorPane patients_form;

    @FXML
    private TableView<Patient> patients_tableView;

    @FXML
    private TableColumn<?, ?> patients_col_patientID;

    @FXML
    private TableColumn<?, ?> patients_col_name;

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
    private ComboBox<?> patDep;

    @FXML
    private ComboBox<?> patDoctor;

    @FXML
    private ComboBox<?> patNurse;

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
    private ComboBox<?> appDep;

    @FXML
    private ComboBox<?> appDoc;

    @FXML
    private ComboBox<?> appNurse;

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
        else if (event.getSource() == account_btn) showForm(profile_form);
        else if (event.getSource() == add_patient_btn) showForm(register_patient_form);
        else if (event.getSource() == appointments_btn) showForm(appointments_form);
    }

    private void showForm(AnchorPane form) {
        dashboard_form.setVisible(form == dashboard_form);
        patients_form.setVisible(form == patients_form);
        profile_form.setVisible(form == profile_form);
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
                Patient patData = new Patient(result.getInt("patient_id"),result.getString("patient_firstName"),result.getString("patient_department"), result.getString("patient_doctor"), result.getString("patient_nurse"), result.getString("patient_phone"), result.getString("patient_email"), result.getString("patient_address"), result.getString("patient_payment"));
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
                Appointment appointmentData = new Appointment(result.getString("appointment_id"), result.getString("appointment_firstName"),result.getString("appointment_department"), result.getString("appointment_doctor"), result.getString("appointment_nurse"), result.getString("appointment_phone"), result.getString("appointment_address"), result.getDate("appointment_date"), result.getString("appointment_hour"));
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
        patientDisplayData();
        appointmentDisplayData();
        Navigator.loadContent(contentPane, "ReceptionistPage.fxml");
        this.translate();
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
        this.dashboard_btn.setText(rb.getString("Dashboard"));
        this.patients_btn.setText(rb.getString("Patients"));
        this.appointments_btn.setText(rb.getString("Appointments"));
        this.add_patient_btn.setText(rb.getString("Add New Patients"));
        this.register_patient_btn.setText(rb.getString("Add"));
        this.account_btn.setText(rb.getString("Account"));
        this.logout_btn.setText(rb.getString("Logout"));
        this.ad.setText(rb.getString("Appointments Data"));
        this.pd.setText(rb.getString("Patients Data"));
        this.appointments.setText(rb.getString("Appointments"));
        this.patients.setText(rb.getString("Patients"));

    }
}
