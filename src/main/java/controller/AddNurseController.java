package controller;

import app.Navigator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.dto.StaffDto.NurseDto;
import model.dto.StaffDto.StaffDto;
import model.filter.NurseFilter;
import repository.Staff.DepartmentRepository;
import repository.Staff.NurseRepository;
import service.Alerts;
import service.Staff.DepartmentService;
import service.Staff.NurseService;
import service.TableService;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class AddNurseController implements Initializable {

    @FXML
    private Button add_nurse_btn;

    @FXML
    private TextField filterNurseEmail;

    @FXML
    private TextField filterNurseName;
    @FXML
    private TextField filterNurseDep;
    @FXML
    private TextField nurseAccount;

    @FXML
    private TextField nurseAddress;

    @FXML
    private TextField nurseBank;

    @FXML
    private DatePicker nurseBirthdate;

    @FXML
    private ComboBox<String> nurseDep;

    @FXML
    private TextField nurseEmail;

    @FXML
    private DatePicker nurseEnd;

    @FXML
    private TextField nurseFirstName;

    @FXML
    private TextField nurseID;

    @FXML
    private TextField nurseLastName;

    @FXML
    private PasswordField nursePassword;

    @FXML
    private TextField nursePhone;

    @FXML
    private TextField nurseRoutingNr;

    @FXML
    private DatePicker nurseStart;

    @FXML
    private TextField nurseUni;

    @FXML
    private TableColumn<?, ?> nurse_col_ID;

    @FXML
    private TableColumn<StaffDto, Void> nurse_col_action;

    @FXML
    private TableColumn<?, ?> nurse_col_address;

    @FXML
    private TableColumn<?, ?> nurse_col_department;

    @FXML
    private TableColumn<?, ?> nurse_col_email;

    @FXML
    private TableColumn<?, ?> nurse_col_name;

    @FXML
    private TableColumn<?, ?> nurse_col_phone;

    @FXML
    private TableColumn<?, ?> nurse_col_surname;

    @FXML
    private TableColumn<?, ?> nurse_col_university;

    @FXML
    private AnchorPane nurse_form;

    @FXML
    private TableView<NurseDto> nurses_table;

    @FXML
    private AnchorPane register_nurse_form;

    @FXML
    void registerNurse(ActionEvent event) {
        Date birthdate = null;
        Date startDate = null;
        Date endDate = null;

        if (this.nurseBirthdate.getValue() != null) {
            birthdate = Date.valueOf(this.nurseBirthdate.getValue());
        }
        if (this.nurseStart.getValue() != null) {
            startDate = Date.valueOf(this.nurseStart.getValue());
        }

        if (this.nurseEnd.getValue() != null) {
            endDate = Date.valueOf(this.nurseEnd.getValue());
        }
        if (NurseService.isEmailInUse(this.nurseEmail.getText())) {
            Alerts.errorMessage("Email is already in use. Please use a different email.");
            return;
        }
        if (this.nurseEmail.getText().isEmpty()) {
            Alerts.errorMessage("Please enter a valid email address.");
            return;
        }
        NurseDto staff = new NurseDto(this.nurseID.getText(), this.nurseFirstName.getText(), this.nurseLastName.getText(), birthdate, this.nursePhone.getText(), this.nurseEmail.getText(), this.nursePassword.getText(), this.nurseAddress.getText(), (String) this.nurseDep.getValue(), this.nurseUni.getText(), startDate, endDate, this.nurseBank.getText(), this.nurseAccount.getText(), this.nurseRoutingNr.getText());
        boolean staffCreated = NurseService.createNurse(staff);
        if (staffCreated) {
            Alerts.successMessage("Nurse registered successfully!");
            DepartmentService.updateDepTable(this.nurseDep.getValue());
            Navigator.navigate(event, Navigator.AdminMainForm);
        } else {
            Alerts.errorMessage("Something went wrong! Please try again.");
        }
    }

    @FXML
    void switchForm(ActionEvent event) {
        if (event.getSource() == add_nurse_btn) {
            register_nurse_form.setVisible(true);
            nurse_form.setVisible(false);
        }
    }

    public ObservableList<NurseDto> getNurses() {
        return FXCollections.observableArrayList(NurseRepository.getAllNurses());
    }

    public void nurseDisplayData() {
        TableService.staffDisplayData(nurses_table, nurse_col_ID, nurse_col_name, nurse_col_surname, nurse_col_department, nurse_col_phone, nurse_col_email, nurse_col_university, nurse_col_address, nurse_col_action);
        nurses_table.setItems(getNurses());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nurseDisplayData();
        loadDepartmentNames();
        this.nurseID.setDisable(true);
        this.nurseID.setText(NurseService.registerNurseID());
        this.nursePassword.setDisable(true);
    }

    private void loadDepartmentNames() {
        List<String> departmentNames = DepartmentRepository.getAllDepartmentNames();
        ObservableList<String> observableList = FXCollections.observableArrayList(departmentNames);
        nurseDep.setItems(observableList);
    }

    @FXML
    public void handleNurseFilter(ActionEvent event) {
        String firstName = filterNurseName.getText();
        String email = filterNurseEmail.getText();
        String department = filterNurseDep.getText();
        NurseFilter filter = new NurseFilter(firstName, email, department);
        List<NurseDto> filteredNurses = NurseService.filter(filter);
        updateNurseTable(filteredNurses);
    }

    public void updateNurseTable(List<NurseDto> nurses) {
        ObservableList<NurseDto> listNurses = FXCollections.observableArrayList(nurses);
        nurses_table.setItems(listNurses);
    }
}
