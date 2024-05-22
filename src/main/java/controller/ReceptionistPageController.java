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
import model.dto.DepartmentDto;
import model.dto.RecDto.AppointmentDto;
import model.dto.RecDto.PatientDto;
import model.dto.StaffDto.DoctorDto;
import model.dto.StaffDto.NurseDto;
import model.dto.StaffDto.ReceptionistDto;

import service.DepartmentService;
import service.Rec.AppointmentService;
import service.Rec.PatientService;
import service.Staff.DoctorService;
import service.Staff.NurseService;
import service.Staff.ReceptionistService;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ReceptionistPageController
{
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
    private TableView<?> patients_tableView;

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
    private RadioButton appMale ;

    @FXML
    private RadioButton appFemale ;

    @FXML
    private TextField appDesc;

    @FXML
    private ComboBox<?> appDep;

    @FXML
    private ComboBox<?> appDoctor;

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
    private TableView<?> app_tableView;

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
    public void registerPatient(ActionEvent event) {

        Date birthdate = Date.valueOf(this.patBirthdate.getValue());
        Date date = Date.valueOf(this.patDate.getValue());

        PatientDto patient = new PatientDto(this.patFirstName.getText(), this.patLastName.getText(), birthdate, this.patPhone.getText(), this.patEmail.getText(), this.patAddress.getText(), (String) this.patDep.getValue(),(String) this.patDoctor.getValue(),(String) this.patNurse.getValue(),date, this.patPayment.getText());
        boolean patientCreated = PatientService.createPatient(patient);
        if (patientCreated) {
            Navigator.navigate(event, Navigator.ReceptionistPage);
        }
    }

    @FXML
    public void registerAppointment(ActionEvent event) {

        Date date = Date.valueOf(this.patDate.getValue());

        AppointmentDto appointment = new AppointmentDto(this.appID.getText(),this.appName.getText(), this.appLastName.getText(),this.appDesc.getText(),(String) this.appDep.getValue(),(String) this.appDoctor.getValue(),(String) this.appNurse.getValue() ,this.appPhone.getText(),this.appAddress.getText(), date, this.appHour.getText());
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



}
