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
import model.filter.DoctorFilter;
import model.filter.UserFilter;
import repository.DepartmentRepository;
import repository.Staff.DoctorRepository;
import service.CountStaffService;
import service.DepartmentService;
import service.Staff.DoctorService;
import service.Table;

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

        DoctorDto staff = new DoctorDto(this.docID.getText(), this.docFirstName.getText(), this.docLastName.getText(), birthdate, this.docPhone.getText(), this.docEmail.getText(), this.docPassword.getText(), this.docAddress.getText(), (String) this.docDep.getValue(), this.docUni.getText(), startDate, endDate, this.docBank.getText(), this.docAccount.getText(), this.docRoutingNr.getText());
        boolean staffCreated = DoctorService.createDoctor(staff);
        if (staffCreated) {
            Navigator.navigate(event, Navigator.AdminMainForm);
            DepartmentService.updateDepTable(this.docDep.getValue());
        }
    }

    //Adding doctors in the table
    public ObservableList<DoctorDto> getDoctors() {
        return FXCollections.observableArrayList(DoctorRepository.getAllDoctors());
    }

    public void doctorDisplayData() {
        Table.staffDisplayData(doctors_col_ID, doctors_col_name, doctors_col_surname, doctors_col_department, doctors_col_phone, doctors_col_email, doctors_col_specialty, doctors_col_address);
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
