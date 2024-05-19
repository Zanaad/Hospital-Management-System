package controller;

import app.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.dto.DepartmentDto;
import model.dto.StaffDto.DoctorDto;
import model.dto.StaffDto.NurseDto;
import model.dto.StaffDto.ReceptionistDto;
import service.DepartmentService;
import service.Staff.DoctorService;
import service.Staff.NurseService;
import service.Staff.ReceptionistService;

import java.sql.Date;


public class AdminPageController {

    @FXML
    private Button account_btn;

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
    private TextField docUni;

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
    private TextField nurseUni;

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
    private TextField recUni;

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
    void registerNurse(ActionEvent event) {
        Date birthdate = Date.valueOf(this.nurseBirthdate.getValue());
        Date startDate = Date.valueOf(this.nurseStart.getValue());
        Date endDate = Date.valueOf(this.nurseEnd.getValue());

        NurseDto staff = new NurseDto(this.nurseFirstName.getText(), this.nurseLastName.getText(), birthdate, this.nursePhone.getText(), this.nurseEmail.getText(), this.nursePassword.getText(), this.nurseAddress.getText(), (String) this.nurseDep.getValue(), this.nurseUni.getText(), startDate, endDate, this.nurseBank.getText(), this.nurseAccount.getText(), this.nurseRoutingNr.getText());
        boolean staffCreated = NurseService.createNurse(staff);
        if (staffCreated) {
            Navigator.navigate(event, Navigator.AdminPage);
        }
    }

    @FXML
    public void registerDoctor(ActionEvent event) {
        Date birthdate = Date.valueOf(this.docBirthdate.getValue());
        Date startDate = Date.valueOf(this.docStart.getValue());
        Date endDate = Date.valueOf(this.docEnd.getValue());

        DoctorDto staff = new DoctorDto(this.docFirstName.getText(), this.docLastName.getText(), birthdate, this.docPhone.getText(), this.docEmail.getText(), this.docPassword.getText(), this.docAddress.getText(), (String) this.docDep.getValue(), this.docUni.getText(), startDate, endDate, this.docBank.getText(), this.docAccount.getText(), this.docRoutingNr.getText());
        boolean staffCreated = DoctorService.createDoctor(staff);
        if (staffCreated) {
            Navigator.navigate(event, Navigator.AdminPage);
        }
    }

    @FXML
    public void registerReceptionist(ActionEvent event) {
        Date birthdate = Date.valueOf(this.recBirthdate.getValue());
        Date startDate = Date.valueOf(this.recStart.getValue());
        Date endDate = Date.valueOf(this.recEnd.getValue());

        ReceptionistDto staff = new ReceptionistDto(this.recFirstName.getText(), this.recLastName.getText(), birthdate, this.recPhone.getText(), this.recEmail.getText(), this.recPassword.getText(), this.recAddress.getText(), (String) this.recDep.getValue(), this.recUni.getText(), startDate, endDate, this.recBank.getText(), this.recAccount.getText(), this.recRoutingNr.getText());
        boolean staffCreated = ReceptionistService.createReceptionist(staff);
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
        if (event.getSource() == dashboard_btn) showForm(dashboard_form);
        else if (event.getSource() == department_btn) showForm(department_form);
        else if (event.getSource() == doctors_btn) showForm(doctors_form);
        else if (event.getSource() == nurse_btn) showForm(nurse_form);
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
        profile_form.setVisible(form == profile_form);
        receptionist_form.setVisible(form == receptionist_form);
        department_form.setVisible(form == department_form);
        register_doctor_form.setVisible(form == register_doctor_form);
        register_nurse_form.setVisible(form == register_nurse_form);
        register_receptionist_form.setVisible(form == register_receptionist_form);
    }

}
