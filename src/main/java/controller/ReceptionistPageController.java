package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class ReceptionistPageController
{
    @FXML
    private Button account_btn;

    @FXML
    private Button accountant_btn;

    @FXML
    private AnchorPane accountant_form;

    @FXML
    private Button add_doctor_btn;

    @FXML
    private Button add_nurse_btn;

    @FXML
    private Button add_receptionist_btn;

    @FXML
    private ComboBox<?> docDep;

    @FXML
    private Button dashboard_btn;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Button department_btn;

    @FXML
    private AnchorPane department_form;

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
    private AnchorPane doctor_table;

    @FXML
    private Button doctors_btn;

    @FXML
    private AnchorPane doctors_form;

    @FXML
    private TextField nurseAccount;

    @FXML
    private TextField nurseAddress;

    @FXML
    private TextField nurseBank;

    @FXML
    private DatePicker nurseBirthdate;

    @FXML
    private ComboBox<?> nurseDep;

    @FXML
    private TextField nurseEmail;

    @FXML
    private DatePicker nurseEnd;

    @FXML
    private TextField nurseFirstName;

    @FXML
    private TextField nurseLastName;

    @FXML
    private PasswordField nursePassword;

    @FXML
    private TextField nursePhone;

    @FXML
    private TextField nurseRoutingNr;

    @FXML
    private TextField nurseSpecialization;

    @FXML
    private DatePicker nurseStart;

    @FXML
    private Button nurse_btn;

    @FXML
    private AnchorPane nurse_form;

    @FXML
    private AnchorPane profile_form;

    @FXML
    private TextField recAccount;

    @FXML
    private TextField recAddress;

    @FXML
    private TextField recBank;

    @FXML
    private DatePicker recBirthdate;

    @FXML
    private ComboBox<?> recDep;

    @FXML
    private TextField recEmail;

    @FXML
    private DatePicker recEnd;

    @FXML
    private TextField recFirstName;

    @FXML
    private TextField recLastName;

    @FXML
    private PasswordField recPassword;

    @FXML
    private TextField recPhone;

    @FXML
    private TextField recRoutingNr;

    @FXML
    private TextField recSpecialization;

    @FXML
    private DatePicker recStart;

    @FXML
    private Button receptionist_btn;

    @FXML
    private AnchorPane receptionist_form;

    @FXML
    private AnchorPane register_doctor_form;

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
        else if (event.getSource() == department_btn) showForm(department_form);
        else if (event.getSource() == doctors_btn) showForm(doctors_form);
        else if (event.getSource() == nurse_btn) showForm(nurse_form);
        else if (event.getSource() == accountant_btn) showForm(accountant_form);
        else if (event.getSource() == account_btn) showForm(profile_form);
        else if (event.getSource() == receptionist_btn) showForm(receptionist_form);
        else if (event.getSource() == add_doctor_btn) showForm(register_doctor_form);
        else if (event.getSource() == add_nurse_btn) showForm(register_nurse_form);
        else if (event.getSource() == add_receptionist_btn) showForm(register_receptionist_form);

    }
    private void showForm(AnchorPane form) {
        dashboard_form.setVisible(form == dashboard_form);
        doctors_form.setVisible(form == doctors_form);
        nurse_form.setVisible(form == nurse_form);
        accountant_form.setVisible(form == accountant_form);
        profile_form.setVisible(form == profile_form);
        receptionist_form.setVisible(form == receptionist_form);
        department_form.setVisible(form == department_form);
        register_doctor_form.setVisible(form == register_doctor_form);
        register_nurse_form.setVisible(form == register_nurse_form);
        register_receptionist_form.setVisible(form == register_receptionist_form);
    }
}
