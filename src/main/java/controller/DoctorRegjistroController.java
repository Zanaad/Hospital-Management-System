package controller;

import app.Navigator;
import database.DatabaseUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import repository.Doc.Pacient;

import java.util.Locale;
import java.util.ResourceBundle;

public class DoctorRegjistroController {

    @FXML
    private TextField txtadresa;

    @FXML
    private TextField txtDataL;

    @FXML
    private TextField txtDataSh;

    @FXML
    private TextField txtDiagnoza;

    @FXML
    private TextField txtditelindja;

    @FXML
    private TextField txtemri;

    @FXML
    private TextField txtgjinia;

    @FXML
    private TextField txtPID;

    @FXML
    private TextField txtmbiemri;

    @FXML
    private TextField txtmosha;

    @FXML
    private TextField txtPagesa;

    @FXML
    private TextField txtTretmani;

    @FXML
    private TextArea txtPershkrimi;

    @FXML
    private TextField txtTel;


    @FXML
    private Label AddressLbl;

    @FXML
    private Label AgeLbl;

    @FXML
    private Button AppBtn;

    @FXML
    private Label BirthdatLbl;

    @FXML
    private Label ChargeLbl;

    @FXML
    private Label DashboardLbl;

    @FXML
    private Label DescriptionLbl;

    @FXML
    private Label DiagnoseLbl;

    @FXML
    private Label DischargeLbl;

    @FXML
    private Label DoctorLbl;

    @FXML
    private Button EditBtn;

    @FXML
    private Label FeaturesLbl;

    @FXML
    private Label GenderLbl;

    @FXML
    private Label HospitalLbl;

    @FXML
    private Label LastNameLbl;

    @FXML
    private Button ManageBtn;

    @FXML
    private Label NameLbl;

    @FXML
    private Label PaymentLbl;

    @FXML
    private Button RegisterPacientBtn;
    @FXML
    private Button RegisterBtn;

    @FXML
    private Label RegisterLbl;

    @FXML
    private Label SettingsLbl;

    @FXML
    private Label TelLbl;

    @FXML
    private Label TretmantLbl;

    @FXML
    private Label WelcomeLbl;






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

        this.EditBtn.setText(rb.getString("Edit Profile"));
        this.ManageBtn.setText(rb.getString("Manage Pacient"));
        this.RegisterPacientBtn.setText(rb.getString("Register"));
        this.RegisterBtn.setText(rb.getString("Register Pacient"));
        this.AppBtn.setText(rb.getString("Appointments"));

        this.WelcomeLbl.setText(rb.getString("Welcome"));
        this.DoctorLbl.setText(rb.getString("Doctor"));
        this.FeaturesLbl.setText(rb.getString("Features"));
        this.NameLbl.setText(rb.getString("Name"));
        this.LastNameLbl.setText(rb.getString("Last Name"));
        this.AddressLbl.setText(rb.getString("Address"));
        this.AgeLbl.setText(rb.getString("Age"));
        this.GenderLbl.setText(rb.getString("Gender"));
        this.BirthdatLbl.setText(rb.getString("Birthday"));
        this.TelLbl.setText(rb.getString("Tel Number"));
        this.ChargeLbl.setText(rb.getString("Charge Day"));
        this.DischargeLbl.setText(rb.getString("Discharge Day"));
        this.DiagnoseLbl.setText(rb.getString("Diagnose"));
        this.TretmantLbl.setText(rb.getString("Tretmant"));
        this.DescriptionLbl.setText(rb.getString("Description"));
        this.PaymentLbl.setText(rb.getString("Payment"));
        this.DashboardLbl.setText(rb.getString("Register Pacient"));
        this.HospitalLbl.setText(rb.getString("Hospital Management"));
        this.RegisterLbl.setText(rb.getString("Register Pacient"));
        this.SettingsLbl.setText(rb.getString("Change Settings"));




    }


    @FXML
    void handleClickApp(MouseEvent event) {
        Navigator.navigate(event, Navigator.Doctor_App);
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

    @FXML
    void handleRegjistroPacient(ActionEvent event) {
        Pacient.regjistroPacient(Integer.parseInt(txtPID.getText()), txtemri.getText(), txtmbiemri.getText(),
                txtgjinia.getText(), Integer.parseInt(txtmosha.getText()), txtditelindja.getText(), Integer.parseInt(txtTel.getText()),
                txtadresa.getText(), txtDataSh.getText(), txtDataL.getText(), txtDiagnoza.getText(), txtTretmani.getText(),
                txtPershkrimi.getText(), Integer.parseInt(txtPagesa.getText()));
    }
}





