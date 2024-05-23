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
import model.dto.StaffDto.ReceptionistDto;
import repository.DepartmentRepository;
import repository.Staff.ReceptionistRepository;
import service.Staff.ReceptionistService;
import service.Table;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class AddRecController implements Initializable {

    @FXML
    private Button add_receptionist_btn;

    @FXML
    private TextField recAccount;
    @FXML
    private TextField recID;
    @FXML
    private TextField recAddress;

    @FXML
    private TextField recBank;

    @FXML
    private DatePicker recBirthdate;

    @FXML
    private ComboBox<String> recDep;

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
    private DatePicker recStart;

    @FXML
    private TextField recUni;

    @FXML
    private TableColumn<?, ?> rec_col_ID;

    @FXML
    private TableColumn<?, ?> rec_col_address;

    @FXML
    private TableColumn<?, ?> rec_col_department;

    @FXML
    private TableColumn<?, ?> rec_col_email;

    @FXML
    private TableColumn<?, ?> rec_col_name;

    @FXML
    private TableColumn<?, ?> rec_col_phone;

    @FXML
    private TableColumn<?, ?> rec_col_status;

    @FXML
    private TableColumn<?, ?> rec_col_uni;

    @FXML
    private TableColumn<?, ?> rec_col_surname;

    @FXML
    private AnchorPane receptionist_form;

    @FXML
    private TableView<ReceptionistDto> receptionist_table;

    @FXML
    private Button register_receptionist_btn;

    @FXML
    private AnchorPane register_receptionist_form;

    @FXML
    void registerReceptionist(ActionEvent event) {
        Date birthdate = Date.valueOf(this.recBirthdate.getValue());
        Date startDate = Date.valueOf(this.recStart.getValue());
        Date endDate = Date.valueOf(this.recEnd.getValue());

        ReceptionistDto staff = new ReceptionistDto(this.recID.getText(), this.recFirstName.getText(), this.recLastName.getText(), birthdate, this.recPhone.getText(), this.recEmail.getText(), this.recPassword.getText(), this.recAddress.getText(), (String) this.recDep.getValue(), this.recUni.getText(), startDate, endDate, this.recBank.getText(), this.recAccount.getText(), this.recRoutingNr.getText());
        boolean staffCreated = ReceptionistService.createReceptionist(staff);
        if (staffCreated) {
            Navigator.navigate(event, Navigator.AdminMainForm);
        }

    }

    @FXML
    void switchForm(ActionEvent event) {
        if (event.getSource() == add_receptionist_btn) {
            register_receptionist_form.setVisible(true);
            receptionist_form.setVisible(false);
        }
    }

    public ObservableList<ReceptionistDto> getReceptionists() {
        return FXCollections.observableArrayList(ReceptionistRepository.getAllReceptionists());
    }

    public void recDisplayData() {
        Table.staffDisplayData(rec_col_ID, rec_col_name, rec_col_surname, rec_col_department, rec_col_phone, rec_col_email, rec_col_uni, rec_col_address);
        receptionist_table.setItems(getReceptionists());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        recDisplayData();
        loadDepartmentNames();
    }

    private void loadDepartmentNames() {
        List<String> departmentNames = DepartmentRepository.getAllDepartmentNames();
        ObservableList<String> observableList = FXCollections.observableArrayList(departmentNames);
        recDep.setItems(observableList);
    }

    public void handleRecFilter(ActionEvent event) {
    }
}
