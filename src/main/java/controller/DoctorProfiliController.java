package controller;

import app.Navigator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.dto.DoktorDto;
import repository.Doc.Doktor;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class DoctorProfiliController implements Initializable {
    @FXML
    private Label AddressLbl;
    @FXML
    private Label AddressLbl1;


    @FXML
    private Button AppBtn;

    @FXML
    private Label DoctorLbl;

    @FXML
    private Button EditBtn;

    @FXML
    private Label EditProfileLbl;

    @FXML
    private Label FeaturesLbl;

    @FXML
    private Label Hospitalbl;

    @FXML
    private Label LastNameLbl;

    @FXML
    private Label LastNameLbl1;


    @FXML
    private Button ManageBtn;

    @FXML
    private Label NameLbl;
    @FXML
    private Label NameLbl1;

    @FXML
    private Label ProfileLbl;

    @FXML
    private Button RegisterBtn;

    @FXML
    private Label SettingsLbl;

    @FXML
    private Label SpecialismLbl;

    @FXML
    private Label SpecialismLbl1;

    @FXML
    private Label TelLbl;
    @FXML
    private Label TelLbl1;

    @FXML
    private Button UpdateBtn;

    @FXML
    private Label WelcomeLbl;

    @FXML
    private Label labelAdresa;

    @FXML
    private Label labelEmri;

    @FXML
    private Label labelID;

    @FXML
    private Label labelMbiemri;

    @FXML
    private Label labelNrTel;

    @FXML
    private Label labelSpecializimi;

    @FXML
    private TextArea txtAdresa;

    @FXML
    private TextField txtEmri;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtMbiemri;

    @FXML
    private TextField txtNrTel;

    @FXML
    private TextField txtSpecializimi;


    @FXML
    void handleClickApp(MouseEvent event) {
        Navigator.navigate(event, Navigator.Doctor_App);
    }

    @FXML
    void handleMenaxho(MouseEvent event) {
        Navigator.navigate(event, Navigator.Doctor_Menaxho);
    }

    @FXML
    void handleRegjistro(MouseEvent event) {
        Navigator.navigate(event, Navigator.Doctor_Shto);
    }

    @FXML
    void handleUpdate(MouseEvent event) {
        Doktor doktorRepository = new Doktor();
        doktorRepository.updateDoctor(Integer.parseInt(txtID.getText()), txtEmri.getText(), txtMbiemri.getText(), txtAdresa.getText(), Integer.parseInt(txtNrTel.getText()), txtSpecializimi.getText());
    }

    public void initialize(URL url, ResourceBundle rb) {
        Doktor doktorRepository = new Doktor();
        DoktorDto doctor = doktorRepository.getDoctorData(1);

        if (doctor != null) {
            txtID.setText(String.valueOf(doctor.getID()));
            txtEmri.setText(doctor.getEmri());
            txtMbiemri.setText(doctor.getMbiemri());
            txtNrTel.setText(String.valueOf(doctor.getNrTel()));
            txtAdresa.setText(doctor.getAdresa());
            txtSpecializimi.setText(doctor.getSpecializimi());

            txtNrTel.textProperty().addListener((observable, oldValue, newValue) -> labelNrTel.setText(newValue));
            txtAdresa.textProperty().addListener((observable, oldValue, newValue) -> labelAdresa.setText(newValue));
            txtEmri.textProperty().addListener((observable, oldValue, newValue) -> labelEmri.setText(newValue));
            txtID.textProperty().addListener((observable, oldValue, newValue) -> labelID.setText(newValue));
            txtMbiemri.textProperty().addListener((observable, oldValue, newValue) -> labelMbiemri.setText(newValue));
            txtSpecializimi.textProperty().addListener((observable, oldValue, newValue) -> labelSpecializimi.setText(newValue));
        }
        updateLabels(doctor);
    }

    private void updateLabels(DoktorDto doctor) {
        if (doctor != null) {
            labelID.setText(String.valueOf(doctor.getID()));
            labelEmri.setText(doctor.getEmri());
            labelMbiemri.setText(doctor.getMbiemri());
            labelAdresa.setText(doctor.getAdresa());
            labelNrTel.setText(String.valueOf(doctor.getNrTel()));
            labelSpecializimi.setText(doctor.getSpecializimi());
        }
    }



    //translate

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
        this.RegisterBtn.setText(rb.getString("Register Pacient"));
        this.AppBtn.setText(rb.getString("Appointments"));

        this.DoctorLbl.setText(rb.getString("Doctor"));
        this.FeaturesLbl.setText(rb.getString("Features"));
        this.SettingsLbl.setText(rb.getString("Change Settings"));
        this.WelcomeLbl.setText(rb.getString("Welcome"));
        this.AddressLbl.setText(rb.getString("Address"));
        this.AddressLbl1.setText(rb.getString("Address"));
        this.EditProfileLbl.setText(rb.getString("Edit Profile"));
        this.Hospitalbl.setText(rb.getString("Hospital Management"));
        this.LastNameLbl.setText(rb.getString("Last Name"));
        this.LastNameLbl1.setText(rb.getString("Last Name"));
        this.TelLbl.setText(rb.getString("Tel Number"));
        this.TelLbl1.setText(rb.getString("Tel Number"));
        this.ProfileLbl.setText(rb.getString("Profile"));
        this.NameLbl.setText(rb.getString("Name"));
        this.NameLbl1.setText(rb.getString("Name"));
        this.SpecialismLbl.setText(rb.getString("Specialism"));
        this.SpecialismLbl1.setText(rb.getString("Specialism"));
        this.UpdateBtn.setText(rb.getString("Update"));
    }
}
