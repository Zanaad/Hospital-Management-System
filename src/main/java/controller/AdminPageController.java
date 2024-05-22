package controller;

import app.Navigator;
import database.DatabaseUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Staff;
import model.dto.ChangePasswordDto;
import model.dto.DepartmentDto;
import model.dto.StaffDto.DoctorDto;
import model.dto.StaffDto.NurseDto;
import model.dto.StaffDto.ReceptionistDto;

import service.CountStaffService;
import service.Alerts;
import service.ChangePwdService;
import service.DepartmentService;
import service.Staff.DoctorService;
import service.Staff.NurseService;
import service.Staff.ReceptionistService;
import service.Table;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


public class AdminPageController implements Initializable {

    @FXML
    private Button account_btn;

    @FXML
    private Button add_doctor_btn;

    @FXML
    private Button add_nurse_btn;

    @FXML
    private Button add_receptionist_btn;

    @FXML
    private Button dashboard_btn;
    @FXML
    private Button logout_btn;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Label dep_count;

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
    private Label docs_count;

    @FXML
    private Button doctors_btn;

    @FXML
    private TableColumn<?, ?> dep_col_name;
    @FXML
    private TableColumn<?, ?> dep_col_desc;
    @FXML
    private TableColumn<?, ?> doctors_col_address;

    @FXML
    private TableColumn<?, ?> doctors_col_department;

    @FXML
    private TableColumn<?, ?> doctors_col_email;
    @FXML
    private TableColumn<?, ?> doctors_col_ID;
    @FXML
    private TableColumn<?, ?> nurse_col_ID;
    @FXML
    private TableColumn<?, ?> rec_col_ID;

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
    private TableView<Staff> receptionist_table;
    @FXML
    private TableView<DepartmentDto> department_table;

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
    private Button nurse_btn;

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
    private TableColumn<?, ?> nurse_col_university;

    @FXML
    private AnchorPane nurse_form;

    @FXML
    private Label nurses_count;

    @FXML
    private TableView<Staff> nurses_table;

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
    private Label rec_count;

    @FXML
    private Button receptionist_btn;

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
    private TableColumn<?, ?> rec_col_uni;

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
    private PasswordField currentPassword;
    @FXML
    private PasswordField newPassword;
    @FXML
    private PasswordField confirmNewPassword;
    @FXML
    private TextField ChangePwdEmail;

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

    public ObservableList<DepartmentDto> getDepartments() {
        ObservableList<DepartmentDto> listDepartments = FXCollections.observableArrayList();
        String query = "select * from departments";
        Connection con = DatabaseUtil.getConnection();
        try {
            PreparedStatement prepare = con.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                DepartmentDto depData = new DepartmentDto(result.getString("department_name"), result.getString("department_description"));
                listDepartments.add(depData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDepartments;
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

    public ObservableList<Staff> getReceptionists() {
        ObservableList<Staff> listReceptionists = FXCollections.observableArrayList();
        String query = "select * from receptionists";
        Connection con = DatabaseUtil.getConnection();
        try {
            PreparedStatement prepare = con.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                Staff rec = new Staff(result.getInt("receptionist_id"), result.getString("receptionist_firstName"), result.getString("receptionist_department"), result.getString("receptionist_phone"), result.getString("receptionist_email"), result.getString("receptionist_university"), result.getString("receptionist_address"));
                listReceptionists.add(rec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listReceptionists;
    }

    public void nurseDisplayData() {
        Table.staffDisplayData(nurse_col_ID, nurse_col_name, nurse_col_department, nurse_col_phone, nurse_col_email, nurse_col_university, nurse_col_address);
        nurses_table.setItems(getNurses());
    }


    public void doctorDisplayData() {
        Table.staffDisplayData(doctors_col_ID, doctors_col_name, doctors_col_department, doctors_col_phone, doctors_col_email, doctors_col_uni, doctors_col_address);
        doctors_table.setItems(getDoctors());
    }

    public void recDisplayData() {
        Table.staffDisplayData(rec_col_ID, rec_col_name, rec_col_department, rec_col_phone, rec_col_email, rec_col_uni, rec_col_address);
        receptionist_table.setItems(getReceptionists());
    }

    public void depDisplayData() {
        dep_col_name.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
        dep_col_desc.setCellValueFactory(new PropertyValueFactory<>("departmentDescription"));
        department_table.setItems(getDepartments());
    }

    public void staff_count() {
        CountStaffService.countStaff(nurses_count, CountStaffService.countNurse);
        CountStaffService.countStaff(docs_count, CountStaffService.countDoctor);
        CountStaffService.countStaff(rec_count, CountStaffService.countReceptionist);
        CountStaffService.countStaff(dep_count, CountStaffService.countDepartment);
    }

    public void initialize(URL location, ResourceBundle resources) {
        nurseDisplayData();
        doctorDisplayData();
        recDisplayData();
        depDisplayData();
        staff_count();
        loadDepartmentNames();
        this.translate();
//        UpdatePwdRepository.addSaltAndHashToAdmins();
    }

    @FXML
    public void changePassword() {
        String currentPassword = this.currentPassword.getText();
        String newPassword = this.newPassword.getText();
        String confirmNewPassword = this.confirmNewPassword.getText();
        if (currentPassword.isBlank() || ChangePwdEmail.getText().isEmpty() || newPassword.isBlank() || confirmNewPassword.isEmpty())
            Alerts.errorMessage("Please fill all the fields before proceeding.");
        else if (!newPassword.equals(confirmNewPassword)) {
            Alerts.errorMessage("Passwords do not match.");
        } else {
            ChangePasswordDto change = new ChangePasswordDto(this.ChangePwdEmail.getText(), this.currentPassword.getText(), this.newPassword.getText(), this.confirmNewPassword.getText());
            boolean changed = ChangePwdService.changePassword(change);
            if (changed) {
                Alerts.successMessage("Password was successfully changed.");
            } else {
                Alerts.errorMessage("Password was not changed");
            }
        }
    }


    private void loadDepartmentNames() {
        List<String> departmentNames = DepartmentService.getAllDepartmentNames();
        ObservableList<String> observableList = FXCollections.observableArrayList(departmentNames);
        docDep.setItems(observableList);
        recDep.setItems(observableList);
        nurseDep.setItems(observableList);
    }

    @FXML
    public void handleLanguage(ActionEvent event) {
        Locale defaultLocale = Locale.getDefault();
        if (defaultLocale.getLanguage().equals("en")) {
            Locale.setDefault(new Locale("sq"));
        } else {
            Locale.setDefault(Locale.ENGLISH);
        }
        this.translate();
    }

    private void translate() {
        Locale locale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle("translations.content", locale);
        this.dashboard_btn.setText(rb.getString("Dashboard"));
        this.department_btn.setText(rb.getString("Departments"));
        this.doctors_btn.setText(rb.getString("Doctors"));
        this.nurse_btn.setText(rb.getString("Nurses"));
        this.receptionist_btn.setText(rb.getString("Receptionists"));
        this.account_btn.setText(rb.getString("Account"));
        this.logout_btn.setText(rb.getString("Logout"));
        this.add_doctor_btn.setText(rb.getString("Add New Doctor"));
        this.add_nurse_btn.setText(rb.getString("Add New Nurse"));
        this.add_receptionist_btn.setText(rb.getString("Add New Receptionist"));
    }
}

