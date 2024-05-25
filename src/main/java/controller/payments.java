package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.dto.StaffDto.DoctorDto;
import model.filter.DoctorFilter;
import repository.Staff.DoctorRepository;
import service.Staff.DoctorService;
import service.Table;

import java.util.List;

public class payments {

    @FXML
    private TextField PatPhone;

    @FXML
    private TextField PatientD;

    @FXML
    private TextField docAccount;

    @FXML
    private TextField docAddress;

    @FXML
    private TextField docBank;

    @FXML
    private DatePicker docStart;

    @FXML
    private TextField docUni;

    @FXML
    private TableColumn<?, ?> doctor_col_patient;

    @FXML
    private TableColumn<?, ?> end_col_date;

    @FXML
    private TextField filterDoc;

    @FXML
    private TextField filterPatName;

    @FXML
    private TextField filterPatPay;

    @FXML
    private Button filter_payments_btn;

    @FXML
    private TableColumn<?, ?> first_col_date;

    @FXML
    private TextField patFirstName;

    @FXML
    private TextField patLastName;

    @FXML
    private TableView<pay> patent_payments_table;

    @FXML
    private TableColumn<?, ?> patient_col_ID;

    @FXML
    private TableColumn<?, ?> patient_col_name;

    @FXML
    private TableColumn<?, ?> patient_col_pay;

    @FXML
    private TableColumn<?, ?> patient_col_phone;

    @FXML
    private TableColumn<?, ?> patient_col_surname;

    @FXML
    private AnchorPane patient_payments_form;

    @FXML
    private AnchorPane patient_table;

    @FXML
    private AnchorPane payment_form;

    @FXML
    private Button register_doctor_btn;

    @FXML
    private Button update_btn;

    @Override
    public ObservableList<pay> getDoctors() {
        return FXCollections.observableArrayList(DoctorRepository.getAllDoctors());
    }

    public void PaymentDisplayData() {
        Table.staffDisplayData(patient_col_ID, patient_col_name, patient_col_surname, patient_col_phone,first_col_date,end_col_date, doctor_col_patient , patient_col_pay);
        payments_table.setItems(getDoctors());
    }

    @FXML
    void filter_payments_btn (ActionEvent event) {
        String firstName = filterPatName.getText();
        String name = filterDoc.getText();
        patent_payments_table filter = new patent_payments_table (firstName, name);
        List<pay> filteredPayments = DoctorService.filter(filter);
        updatePayentsTable(filteredPayments);
    }


    public void updatePayentsTable(List<pay> payments) {
        ObservableList<DoctorDto> listDoctors = FXCollections.observableArrayList(payemts);
        payments_table.setItems(listDoctors);
    }

}

