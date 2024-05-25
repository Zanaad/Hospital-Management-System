package controller;

import app.Navigator;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.TakimetDto;
import repository.Doc.Takimet;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class DoctorAppController implements Initializable {

    @FXML
    private TableColumn<TakimetDto, String> AdresaColumn;

    @FXML
    private TableColumn<TakimetDto, String> DataColumn;

    @FXML
    private TableColumn<TakimetDto, String> EmriColumn;

    @FXML
    private TableColumn<TakimetDto, String> GjiniaColumn;

    @FXML
    private TableColumn<TakimetDto,Integer > IDColumn;

    @FXML
    private TableColumn<TakimetDto, String> MbiemriColumn;

    @FXML
    private TableColumn<TakimetDto, Integer> MoshaColumn;

    @FXML
    private TableView<TakimetDto> table;

    @FXML
    private TextField txtAdresa;

    @FXML
    private TextField txtData;

    @FXML
    private TextField txtEmri;

    @FXML
    private TextField txtGjinia;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtMbiemri;

    @FXML
    private TextField txtMosha;




    @FXML
    private Label AddappLbl;

    @FXML
    private Label AddressLbl;

    @FXML
    private Label Agelbl;

    @FXML
    private Button AppointmentsBtn;


    @FXML
    private Label DateLbl;

    @FXML
    private Label DoctorLabel;

    @FXML
    private Button EditBtn;



    @FXML
    private Label Featureslabel;

    @FXML
    private Label GenderLbl;



    @FXML
    private Label Lastnamelbl;

    @FXML
    private Button ManageBtn;




    @FXML
    private Label NameLabel;

    @FXML
    private Button RegisterBtn;

    @FXML
    private Label applabel;

    @FXML
    private Button btnShtotakim;

    @FXML
    private Label hospitallabel;

    @FXML
    private Label settingsLabel;


    @FXML
    private Label welcomeLabel;

    ObservableList<TakimetDto> listM;


    @FXML
    void handleShtotakim(ActionEvent event) {
        int id = Integer.parseInt(txtID.getText());
        int mosha = Integer.parseInt(txtMosha.getText());
        String emri = txtEmri.getText();
        String mbiemri = txtMbiemri.getText();
        String gjinia = txtGjinia.getText();
        String adresa = txtAdresa.getText();
        String datae = txtData.getText();

        Takimet.addTakim(id, emri, mbiemri, gjinia, mosha, adresa, datae);
        listM.add(new TakimetDto(id, emri, mbiemri, gjinia, mosha, adresa, datae));

    }

    public void initialize(URL url, ResourceBundle rb) {
        IDColumn.setCellValueFactory(new PropertyValueFactory<TakimetDto, Integer>("ID"));
        EmriColumn.setCellValueFactory(new PropertyValueFactory<TakimetDto, String>("emri"));
        MbiemriColumn.setCellValueFactory(new PropertyValueFactory<TakimetDto, String>("mbiemri"));
        GjiniaColumn.setCellValueFactory(new PropertyValueFactory<TakimetDto, String>("gjinia"));
        MoshaColumn.setCellValueFactory(new PropertyValueFactory<TakimetDto, Integer>("mosha"));
        AdresaColumn.setCellValueFactory(new PropertyValueFactory<TakimetDto, String>("adresa"));
        DataColumn.setCellValueFactory(new PropertyValueFactory<TakimetDto, String>("datae"));
        listM = Takimet.getTakimetData();
        table.setItems(listM);
    }

    @FXML
    void handleMenaxho(MouseEvent event) {
        Navigator.navigate(event, Navigator.Doctor_Menaxho);
    }

    @FXML
    void handleProfili(MouseEvent event) {
        Navigator.navigate(event, Navigator.Doctor_Profili);
    }

    @FXML
    void handleRegjistro(MouseEvent event) {
        Navigator.navigate(event, Navigator.Doctor_Shto);
    }


    //perkthimi
    @FXML
    public void handleLanguage() {
        Locale defaultLocale = Locale.getDefault();
        if (defaultLocale.getLanguage().equals("en")) {
            Locale.setDefault(new Locale("sq"));
        } else {
            Locale.setDefault(Locale.ENGLISH);
        }
        this.translate();

    }

    public void  translate(){
        Locale locale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle("translations.content", locale);
        this.welcomeLabel.setText(rb.getString("Welcome"));
        this.DataColumn.setText(rb.getString("Date"));
        this.IDColumn.setText(rb.getString("Appointment ID"));
        this.AdresaColumn.setText(rb.getString("Address"));
        this.EmriColumn.setText(rb.getString("Name"));
        this.MbiemriColumn.setText(rb.getString("Last Name"));
        this.MoshaColumn.setText(rb.getString("Age"));
        this.GjiniaColumn.setText(rb.getString("Gender"));
        this.hospitallabel.setText(rb.getString("Hospital Management"));
        this.applabel.setText(rb.getString("Appointments"));
        this.DoctorLabel.setText(rb.getString("Doctor"));
        this.Featureslabel.setText(rb.getString("Features"));
        this.settingsLabel.setText(rb.getString("Change Settings"));
        this.AddappLbl.setText(rb.getString("Add Appointment"));
        this.NameLabel.setText(rb.getString("First Name"));
        this.Lastnamelbl.setText(rb.getString("Last Name"));
        this.Agelbl.setText(rb.getString("Age"));
        this.GenderLbl.setText(rb.getString("Gender"));
        this.AddressLbl.setText(rb.getString("Address"));
        this.DateLbl.setText(rb.getString("Date"));
        this.btnShtotakim.setText(rb.getString("Add Appointment"));
        this.EditBtn.setText(rb.getString("Edit Profile"));
        this.ManageBtn.setText(rb.getString("Manage Pacient"));
        this.RegisterBtn.setText(rb.getString("Register Pacient"));
        this.AppointmentsBtn.setText(rb.getString("Appointments"));

    }





}