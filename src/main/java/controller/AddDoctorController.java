package controller;

import app.Navigator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.dto.StaffDto.DoctorDto;
import model.dto.StaffDto.StaffDto;
import model.filter.DoctorFilter;
import repository.Staff.DepartmentRepository;
import repository.Staff.DoctorRepository;
import service.Alerts;
import service.Staff.DepartmentService;
import service.Staff.DoctorService;
import service.TableService;

import java.net.URL;
import java.sql.Date;
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
    private TextField docSpecialty;

    @FXML
    private TextField docBank;

    @FXML
    private DatePicker docBirthdate;

    @FXML
    private ComboBox<String> docDep;
    @FXML
    private TextField docID;
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
    private TextField filterDocSpecialty;

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
    private TableColumn<?, ?> doctors_col_surname;

    @FXML
    private TableColumn<?, ?> doctors_col_uni;

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
    private TableColumn<?, ?> doctors_col_specialty;
    @FXML
    private TableColumn<StaffDto, Void> doctors_col_action;

    @FXML
    private AnchorPane doctors_form;

    @FXML
    private TableView<DoctorDto> doctors_table;

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
        docID.setDisable(true);
        docID.setText(DoctorService.registerDoctorID());
        docPassword.setDisable(true);
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
        Date birthdate = null;
        Date startDate = null;
        Date endDate = null;

        if (this.docBirthdate.getValue() != null) {
            birthdate = Date.valueOf(this.docBirthdate.getValue());
        }
        if (this.docStart.getValue() != null) {
            startDate = Date.valueOf(this.docStart.getValue());
        }

        if (this.docEnd.getValue() != null) {
            endDate = Date.valueOf(this.docEnd.getValue());
        }
        if (DoctorService.isEmailInUse(this.docEmail.getText())) {
            Alerts.errorMessage("Email is already in use. Please use a different email.");
            return;
        }
        if (this.docEmail.getText().isEmpty()) {
            Alerts.errorMessage("Please enter a valid email address.");
            return;
        }
        DoctorDto staff = new DoctorDto(null, this.docFirstName.getText(), this.docLastName.getText(), birthdate, this.docPhone.getText(), this.docEmail.getText(), null, this.docAddress.getText(), (String) this.docDep.getValue(), this.docUni.getText(), this.docSpecialty.getText(), startDate, endDate, this.docBank.getText(), this.docAccount.getText(), this.docRoutingNr.getText());
        boolean staffCreated = DoctorService.createDoctor(staff);
        if (staffCreated) {
            Alerts.successMessage("Doctor registered successfully!");
            Navigator.navigate(event, Navigator.AdminMainForm);
            DepartmentService.updateDepTable(this.docDep.getValue());
        } else {
            Alerts.errorMessage("Something went wrong! Please try again.");
        }
    }

    //Adding doctors in the table
    public ObservableList<DoctorDto> getDoctors() {
        return FXCollections.observableArrayList(DoctorRepository.getAllDoctors());
    }

    public void doctorDisplayData() {
        TableService.doctorDisplayData(doctors_table, doctors_col_ID, doctors_col_name, doctors_col_surname, doctors_col_department, doctors_col_phone, doctors_col_email, doctors_col_uni, doctors_col_specialty, doctors_col_address, doctors_col_action);
        doctors_table.setItems(getDoctors());
    }

    //Filter doctors
    @FXML
    void handleDoctorFilter(ActionEvent event) {
        String firstName = filterDocName.getText();
        String email = filterDocEmail.getText();
        String specialty = filterDocSpecialty.getText();
        DoctorFilter filter = new DoctorFilter(firstName, email, specialty);
        List<DoctorDto> filteredDoctors = DoctorService.filter(filter);
        updateDoctorTable(filteredDoctors);
    }


    public void updateDoctorTable(List<DoctorDto> doctors) {
        ObservableList<DoctorDto> listDoctors = FXCollections.observableArrayList(doctors);
        doctors_table.setItems(listDoctors);
    }

    //Load department names into combo boxes
    private void loadDepartmentNames() {
        List<String> departmentNames = DepartmentRepository.getAllDepartmentNames();
        ObservableList<String> observableList = FXCollections.observableArrayList(departmentNames);
        docDep.setItems(observableList);
    }
}
