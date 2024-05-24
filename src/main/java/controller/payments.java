package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
    private ComboBox<?> docDep;

    @FXML
    private DatePicker docEnd;

    @FXML
    private TextField docRoutingNr;

    @FXML
    private TextField docSpecialty;

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
    private TableView<?> patent_payments_table;

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

    @FXML
    void handleDoctorFilter(ActionEvent event) {

    }

    @FXML
    void registerDoctor(ActionEvent event) {

    }

    @FXML
    void switchForm(ActionEvent event) {

    }

}
