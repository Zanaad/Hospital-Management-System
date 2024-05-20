package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

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
    private PasswordField recPassword;

    @FXML
    private TextField recPhone;

    @FXML
    private TextField recRoutingNr;

    @FXML
    private TextField recUni;

    @FXML
    private DatePicker recStart;








    //@FXML
    //private ComboBox<?> docDep;


    @FXML
    private TextField docAccount;

    @FXML
    private TextField docAddress;

    @FXML
    private TextField docBank;

    @FXML
    private DatePicker docBirthdate;

    @FXML
    private TextField docEmail;

    @FXML
    private DatePicker docEnd;

    @FXML
    private TextField docFirstName;

    @FXML
    private TextField docLastName;

    @FXML
    private PasswordField docPassword;

    @FXML
    private TextField docPhone;

    @FXML
    private TextField docRoutingNr;

    @FXML
    private TextField docSpecialization;

    @FXML
    private DatePicker docStart;

    @FXML
    private AnchorPane patient_table;



    @FXML
    private Button nurse_btn;

    @FXML
    private AnchorPane nurse_form;

    @FXML
    private TextField recSpecialization;


    @FXML
    private Button receptionist_btn;

    @FXML
    private AnchorPane receptionist_form;

    @FXML
    private AnchorPane register_doctor_form;

    @FXML
    private AnchorPane register_patient_form;

    @FXML
    private AnchorPane register_nurse_form;

    @FXML
    private AnchorPane register_receptionist_form;

    @FXML
    private TextArea txtDepartmentDescription;

    @FXML
    private TextField txtDepartmentName;
    @FXML
    void switchForm(ActionEvent event) {
        if (event.getSource() == dashboard_btn) showForm(dashboard_form);
        else if (event.getSource() == patients_btn) showForm(patients_form);
        else if (event.getSource() == appointments_btn) showForm(patients_form);
        else if (event.getSource() == account_btn) showForm(profile_form);
      //  else if (event.getSource() == receptionist_btn) showForm(receptionist_form);
        else if (event.getSource() == add_patient_btn) showForm(register_patient_form);
      //  else if (event.getSource() == add_nurse_btn) showForm(register_nurse_form);
      //  else if (event.getSource() == add_receptionist_btn) showForm(register_receptionist_form);

    }
    private void showForm(AnchorPane form) {
        dashboard_form.setVisible(form == dashboard_form);
        patients_form.setVisible(form == patients_form);
       // nurse_form.setVisible(form == nurse_form);
        //accountant_form.setVisible(form == accountant_form);
        profile_form.setVisible(form == profile_form);
        //receptionist_form.setVisible(form == receptionist_form);
        //department_form.setVisible(form == department_form);
        //register_doctor_form.setVisible(form == register_doctor_form);
        //register_nurse_form.setVisible(form == register_nurse_form);
        //register_receptionist_form.setVisible(form == register_receptionist_form);
    }
}
