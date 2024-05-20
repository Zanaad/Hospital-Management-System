package controller;

import app.Navigator;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.dto.ReportDto.BirthsDto;
import model.dto.ReportDto.OperationDto;
import model.dto.StaffDto.ReceptionistDto;
import service.Report.birthService;
import service.Report.operationService;
import service.Staff.ReceptionistService;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class NursePageController {

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
    private TextField txtOtherDescription;

    @FXML
    private TextField txtOtherPatient;

    @FXML
    private TextField txtOtherTime;

    //change the forms depending what the user chooses-----------------------------------------------------------

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


        OperationDto report = new OperationDto(this.txtOperationDescription.getText(), this.txtOperationPatient.getText(),this.txtOperationDoctor.getText(), operationDate, this.txtOperationTime.getText());
        boolean reportCreated = operationService.createOperation(report);
        if (reportCreated) {
            Navigator.navigate(event, Navigator.NursePage);
        }
    }

    @FXML
    void registerBirth(ActionEvent event) {
        Date birthsDate = Date.valueOf(this.txtBirthDate.getValue());


        BirthsDto report = new BirthsDto(this.txtBirthDescription.getText(), this.txtBirthPatient.getText(),this.txtBirthNewBorn.getText(), birthsDate, this.txtBirthTime.getText());
        boolean reportCreated = birthService.createBirth(report);
        if (reportCreated) {
            Navigator.navigate(event, Navigator.NursePage);
        }

    }

    @FXML
    void registerDeath(ActionEvent event) {

    }



    @FXML
    void registerOther(ActionEvent event) {

    }












}