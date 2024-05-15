package controller;

import app.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.dto.CreateDepartmentDto;
import model.dto.DepartmentDto;
import model.dto.StaffDto;
import service.DepartmentService;
import service.StaffService;

import java.sql.Date;


public class AdminPageController {

    @FXML
    private Button accountant_btn;

    @FXML
    private AnchorPane accountant_form;

    @FXML
    private ComboBox<?> comboxDepartment;

    @FXML
    private ComboBox<?> comboxPosition;
    @FXML
    private Button account_btn;
    @FXML
    private Button dashboard_btn;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private DatePicker dataStart;

    @FXML
    private DatePicker dateEnd;

    @FXML
    private Button department_btn;

    @FXML
    private AnchorPane department_form;

    @FXML
    private Button doctors_btn;

    @FXML
    private AnchorPane doctors_form;

    @FXML
    private Button nurse_btn;

    @FXML
    private AnchorPane nurse_form;

    @FXML
    private AnchorPane profile_form;

    @FXML
    private PasswordField pwdPassword;

    @FXML
    private Button receptionist_btn;

    @FXML
    private AnchorPane receptionist_form;

    @FXML
    private Button register_accountant_btn;

    @FXML
    private Button register_doctor_btn;

    @FXML
    private Button register_nurse_btn;

    @FXML
    private Button register_receptionist_btn;

    @FXML
    private AnchorPane register_staff_form;

    @FXML
    private TextField txtAccountOwner;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtBankName;

    @FXML
    private DatePicker txtBirthdate;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtRoutingNumber;

    @FXML
    private TextField txtSpecialization;
    @FXML
    private TextField txtDepartmentName;
    @FXML
    private TextArea txtDepartmentDescription;

    @FXML
    void registerStaff(ActionEvent event) {

        Date birthdate = Date.valueOf(this.txtBirthdate.getValue());
        Date startDate = Date.valueOf(this.dataStart.getValue());
        Date endDate = Date.valueOf(this.dateEnd.getValue());

        StaffDto staff = new StaffDto(this.txtFirstName.getText(), this.txtLastName.getText(), birthdate, this.txtPhone.getText(), this.txtEmail.getText(), this.pwdPassword.getText(), this.txtAddress.getText(), (String) this.comboxPosition.getValue(), (String) this.comboxDepartment.getValue(), this.txtSpecialization.getText(), startDate, endDate, this.txtBankName.getText(), this.txtAccountOwner.getText(), this.txtRoutingNumber.getText());
        boolean staffCreated = StaffService.createStaff(staff);
        if (staffCreated) {
            Navigator.navigate(event, Navigator.AdminPage);
        }
    }

    @FXML
    void registerDepartment(ActionEvent event) {
        DepartmentDto department = new DepartmentDto(this.txtDepartmentName.getText(), this.txtDepartmentDescription.getText());
        boolean departmentCreated = DepartmentService.createDepartment(department);
        if (departmentCreated) Navigator.navigate(event, Navigator.AdminPage);
    }

    @FXML
    void switchForm(ActionEvent event) {
        if (event.getSource() == dashboard_btn) {
            showForm(dashboard_form);
        } else if (event.getSource() == department_btn) {
            showForm(department_form);
        } else if (event.getSource() == doctors_btn) {
            showForm(doctors_form);
        } else if (event.getSource() == nurse_btn) {
            showForm(nurse_form);
        } else if (event.getSource() == accountant_btn) {
            showForm(accountant_form);
        } else if (event.getSource() == account_btn) {
            showForm(profile_form);
        } else if (event.getSource() == receptionist_btn) {
            showForm(receptionist_form);
        } else if (event.getSource() == register_doctor_btn || event.getSource() == register_accountant_btn || event.getSource() == register_receptionist_btn || event.getSource() == register_nurse_btn) {
            showForm(register_staff_form);
        }
    }

    private void showForm(AnchorPane form) {
        dashboard_form.setVisible(form == dashboard_form);
        doctors_form.setVisible(form == doctors_form);
        nurse_form.setVisible(form == nurse_form);
        accountant_form.setVisible(form == accountant_form);
        profile_form.setVisible(form == profile_form);
        receptionist_form.setVisible(form == receptionist_form);
        register_staff_form.setVisible(form == register_staff_form);
        department_form.setVisible(form == department_form);
    }

}
