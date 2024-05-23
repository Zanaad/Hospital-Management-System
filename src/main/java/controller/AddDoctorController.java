package controller;

import app.Navigator;
import database.DatabaseUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.Staff;
import model.dto.StaffDto.DoctorDto;
import model.filter.UserFilter;
import repository.DepartmentRepository;
import repository.Staff.DoctorRepository;
import service.Staff.DoctorService;
import service.Table;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddDoctorController implements Initializable {

    @FXML
    private Button add_doctor_btn;

    @FXML
    private TextField docAccount;

    @FXML
    private TextField docAddress;

    @FXML
    private TextField docBank;

    @FXML
    private DatePicker docBirthdate;

    @FXML
    private ComboBox<String> docDep;

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
    private DatePicker docStart;

    @FXML
    private TextField docUni;

    @FXML
    private AnchorPane doctor_table;

    @FXML
    private TableColumn<?, ?> doctors_col_ID;

    @FXML
    private TableColumn<?, ?> doctors_col_action;

    @FXML
    private TableColumn<?, ?> doctors_col_address;

    @FXML
    private TableColumn<?, ?> doctors_col_department;

    @FXML
    private TableColumn<?, ?> doctors_col_email;

    @FXML
    private TableColumn<?, ?> doctors_col_name;

    @FXML
    private TableColumn<?, ?> doctors_col_phone;

    @FXML
    private TableColumn<?, ?> doctors_col_uni;

    @FXML
    private AnchorPane doctors_form;

    @FXML
    private TableView<Staff> doctors_table;

    @FXML
    private Button filter_doctor_btn;

    @FXML
    private Button register_doctor_btn;

    @FXML
    private AnchorPane register_doctor_form;
    @FXML
    private TextField filterDocName;
    @FXML
    private TextField filterDocEmail;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        doctorDisplayData();
        loadDepartmentNames();
    }

    //Switch to the register form
    @FXML
    void switchForm(ActionEvent event) {
        if (event.getSource() == add_doctor_btn) {
            register_doctor_form.setVisible(true);
            doctors_form.setVisible(false);
        }

    }

    //Method for registering doctors
    @FXML
    void registerDoctor(ActionEvent event) {
        Date birthdate = Date.valueOf(this.docBirthdate.getValue());
        Date startDate = Date.valueOf(this.docStart.getValue());
        Date endDate = Date.valueOf(this.docEnd.getValue());

        DoctorDto staff = new DoctorDto(this.docFirstName.getText(), this.docLastName.getText(), birthdate, this.docPhone.getText(), this.docEmail.getText(), this.docPassword.getText(), this.docAddress.getText(), (String) this.docDep.getValue(), this.docUni.getText(), startDate, endDate, this.docBank.getText(), this.docAccount.getText(), this.docRoutingNr.getText());
        boolean staffCreated = DoctorService.createDoctor(staff);
        if (staffCreated) {
            Navigator.navigate(event, Navigator.AdminMainForm);
        }
    }

    //Adding doctors in the table
    public ObservableList<Staff> getDoctors() {
        return FXCollections.observableArrayList(DoctorRepository.getAllDoctors());
    }

    public void doctorDisplayData() {
        Table.staffDisplayData(doctors_col_ID, doctors_col_name, doctors_col_department, doctors_col_phone, doctors_col_email, doctors_col_uni, doctors_col_address);
        doctors_table.setItems(getDoctors());
    }

    //Filter doctors
    @FXML
    void handleDoctorFilter(ActionEvent event) {
        String firstName = filterDocName.getText();
        String email = filterDocEmail.getText();

        UserFilter filter = new UserFilter(firstName, email);
        List<Staff> filteredDoctors = DoctorService.filter(filter);
        updateDoctorTable(filteredDoctors);
    }


    public void updateDoctorTable(List<Staff> doctors) {
        ObservableList<Staff> listDoctors = FXCollections.observableArrayList(doctors);
        doctors_table.setItems(listDoctors);
    }

    //Load department names into combo boxes
    private void loadDepartmentNames() {
        List<String> departmentNames = DepartmentRepository.getAllDepartmentNames();
        ObservableList<String> observableList = FXCollections.observableArrayList(departmentNames);
        docDep.setItems(observableList);
    }
}
