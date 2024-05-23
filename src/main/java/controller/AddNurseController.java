package controller;

import app.Navigator;
import database.DatabaseUtil;
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
import model.Staff;
import model.dto.StaffDto.NurseDto;
import repository.DepartmentRepository;
import service.Staff.NurseService;
import service.Table;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ResourceBundle;

public class AddNurseController implements Initializable {

    @FXML
    private Button add_nurse_btn;

    @FXML
    private TextField nurseAccount;

    @FXML
    private TextField nurseAddress;
    @FXML
    private TextField nurseID;

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
    private TableColumn<?, ?> nurse_col_action;

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
    private TableColumn<?, ?> nurse_col_status;

    @FXML
    private TableColumn<?, ?> nurse_col_university;

    @FXML
    private AnchorPane nurse_form;

    @FXML
    private TableView<Staff> nurses_table;

    @FXML
    private Button register_nurse_btn;

    @FXML
    private AnchorPane register_nurse_form;

    @FXML
    void registerNurse(ActionEvent event) {
        Date birthdate = Date.valueOf(this.nurseBirthdate.getValue());
        Date startDate = Date.valueOf(this.nurseStart.getValue());
        Date endDate = Date.valueOf(this.nurseEnd.getValue());

        NurseDto staff = new NurseDto(this.nurseID.getText(), this.nurseFirstName.getText(), this.nurseLastName.getText(), birthdate, this.nursePhone.getText(), this.nurseEmail.getText(), this.nursePassword.getText(), this.nurseAddress.getText(), (String) this.nurseDep.getValue(), this.nurseUni.getText(), startDate, endDate, this.nurseBank.getText(), this.nurseAccount.getText(), this.nurseRoutingNr.getText());
        boolean staffCreated = NurseService.createNurse(staff);
        if (staffCreated) {
            Navigator.navigate(event, Navigator.AdminMainForm);
        }
    }

    @FXML
    void switchForm(ActionEvent event) {
        if (event.getSource() == add_nurse_btn) {
            register_nurse_form.setVisible(true);
            nurse_form.setVisible(false);
        }
    }

    public ObservableList<Staff> getNurses() {
        ObservableList<Staff> listNurses = FXCollections.observableArrayList();
        String query = "select * from nurses";
        Connection con = DatabaseUtil.getConnection();
        try {
            PreparedStatement prepare = con.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                Staff nurse = new Staff(result.getInt("nurse_id"), result.getString("nurse_firstName"), result.getString("nurse_department"), result.getString("nurse_phone"), result.getString("nurse_email"), result.getString("nurse_university"), result.getString("nurse_address"));
                listNurses.add(nurse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNurses;
    }

    public void nurseDisplayData() {
        Table.staffDisplayData(nurse_col_ID, nurse_col_name, nurse_col_department, nurse_col_phone, nurse_col_email, nurse_col_university, nurse_col_address);
        nurses_table.setItems(getNurses());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nurseDisplayData();
        loadDepartmentNames();
    }

    private void loadDepartmentNames() {
        List<String> departmentNames = DepartmentRepository.getAllDepartmentNames();
        ObservableList<String> observableList = FXCollections.observableArrayList(departmentNames);
        nurseDep.setItems(observableList);
    }

    public void handleNurseFilter(ActionEvent event) {

    }
}
