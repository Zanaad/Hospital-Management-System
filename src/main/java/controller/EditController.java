package controller;

import app.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.dto.StaffDto.DoctorDto;
import model.dto.StaffDto.NurseDto;
import model.dto.StaffDto.ReceptionistDto;
import model.dto.StaffDto.StaffDto;
import repository.Staff.DoctorRepository;
import repository.Staff.NurseRepository;
import repository.Staff.ReceptionistRepository;
import service.Alerts;
import javafx.stage.Stage;

import java.sql.Date;

public class EditController {

    @FXML
    private TextField ID;

    @FXML
    private TextField account;

    @FXML
    private TextField address;

    @FXML
    private TextField bank;

    @FXML
    private DatePicker birthdate;

    @FXML
    private DatePicker contractEnd;

    @FXML
    private DatePicker contractStart;

    @FXML
    private ComboBox<String> department;

    @FXML
    private TextField email;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField phone;

    @FXML
    private TextField routingNr;

    @FXML
    private TextField specialty;

    @FXML
    private TextField university;
    private StaffDto staff;

    public void setStaff(StaffDto staff) {
        this.staff = staff;
        populateFields();
    }

    private void populateFields() {
        ID.setText(String.valueOf(staff.getId()));
        firstName.setText(staff.getFirstName());
        lastName.setText(staff.getLastName());
        department.setValue(staff.getDepartment());
        birthdate.setValue(staff.getBirthdate().toLocalDate());
        phone.setText(staff.getPhone());
        email.setText(staff.getEmail());
        university.setText(staff.getUniversity());
        address.setText(staff.getAddress());
        contractStart.setValue(staff.getStartDate().toLocalDate());
        contractEnd.setValue(staff.getEndDate().toLocalDate());
        bank.setText(staff.getBankName());
        account.setText(staff.getBankAccount());
        routingNr.setText(staff.getRoutingNumber());
        if (staff instanceof DoctorDto) {
            specialty.setText(((DoctorDto) staff).getSpecialty());
            specialty.setVisible(true);
        } else {
            specialty.setVisible(false);
        }
    }

    @FXML
    private void handleUpdate(ActionEvent event) {
        staff.setFirstName(firstName.getText());
        staff.setLastName(lastName.getText());
        staff.setDepartment(department.getValue());
        staff.setBirthdate(Date.valueOf(birthdate.getValue()));
        staff.setPhone(phone.getText());
        staff.setEmail(email.getText());
        staff.setUniversity(university.getText());
        staff.setAddress(address.getText());
        staff.setDepartment(department.getValue());
        staff.setUniversity(university.getText());
        staff.setStartDate(Date.valueOf(contractStart.getValue()));
        staff.setEndDate(Date.valueOf(contractEnd.getValue()));
        staff.setBankName(bank.getText());
        staff.setBankAccount(account.getText());
        staff.setRoutingNumber(routingNr.getText());
        if (staff instanceof DoctorDto) {
            ((DoctorDto) staff).setSpecialty(specialty.getText());
        }


        boolean success = false;
        if (staff instanceof DoctorDto) {
            success = DoctorRepository.updateDoctor((DoctorDto) staff);
        } else if (staff instanceof NurseDto) {
            success = NurseRepository.updateNurse((NurseDto) staff);
        } else if (staff instanceof ReceptionistDto) {
            success = ReceptionistRepository.updateRec((ReceptionistDto) staff);
        }
        if (success) {
            Alerts.successMessage("Update successful");
            Navigator.navigate(event, Navigator.AdminMainForm);
        } else {
            Alerts.errorMessage("Update failed");
        }
    }

    @FXML
    void handleCancel(ActionEvent event) {
        closeEditForm(event);
        Navigator.navigate(event, Navigator.AdminMainForm);
    }

    private void closeEditForm(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}
