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
import model.dto.StaffDto.DoctorDto;
import repository.DepartmentRepository;
import service.Staff.DoctorService;
import service.Table;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        doctorDisplayData();
        loadDepartmentNames();
    }

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

    @FXML
    void switchForm(ActionEvent event) {
        if (event.getSource() == add_doctor_btn) {
            register_doctor_form.setVisible(true);
            doctors_form.setVisible(false);
        }

    }

    public ObservableList<Staff> getDoctors() {
        ObservableList<Staff> listDoctors = FXCollections.observableArrayList();
        String query = "select * from doctors";
        Connection con = DatabaseUtil.getConnection();
        try {
            PreparedStatement prepare = con.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                Staff doctor = new Staff(result.getInt("doctor_id"), result.getString("doctor_firstName"), result.getString("doctor_department"), result.getString("doctor_phone"), result.getString("doctor_email"), result.getString("doctor_university"), result.getString("doctor_address"));
                listDoctors.add(doctor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDoctors;
    }

    public void doctorDisplayData() {
        Table.staffDisplayData(doctors_col_ID, doctors_col_name, doctors_col_department, doctors_col_phone, doctors_col_email, doctors_col_uni, doctors_col_address);
        doctors_table.setItems(getDoctors());
    }

    private void loadDepartmentNames() {
        List<String> departmentNames = DepartmentRepository.getAllDepartmentNames();
        ObservableList<String> observableList = FXCollections.observableArrayList(departmentNames);
        docDep.setItems(observableList);
    }

}
