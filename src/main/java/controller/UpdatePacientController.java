package controller;

import app.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.dto.PacientDto;
import repository.Doc.Pacient;

import java.util.Locale;
import java.util.ResourceBundle;

public class UpdatePacientController {

    @FXML
    private TextField txtDataL;

    @FXML
    private TextField txtDataSh;

    @FXML
    private TextField txtDiagnoza;

    @FXML
    private TextField txtPID;

    @FXML
    private TextField txtPagesa;

    @FXML
    private TextArea txtPershkrimi;

    @FXML
    private TextField txtTel;

    @FXML
    private TextField txtTretmani;

    @FXML
    private TextField txtadresa;

    @FXML
    private TextField txtditelindja;

    @FXML
    private TextField txtemri;

    @FXML
    private TextField txtgjinia;

    @FXML
    private TextField txtmbiemri;

    @FXML
    private TextField txtmosha;

    @FXML
    private Label AddressLbl;

    @FXML
    private Label AgeLbl;

    @FXML
    private Label BirthdatLbl;

    @FXML
    private Label ChargeLbl;

    @FXML
    private Label DescriptionLbl;

    @FXML
    private Label DiagnoseLbl;

    @FXML
    private Label DischargeLbl;

    @FXML
    private Label GenderLbl;

    @FXML
    private Label LastNameLbl;

    @FXML
    private Label NameLbl;

    @FXML
    private Label PaymentLbl;

    @FXML
    private Label TelNumberlbl;

    @FXML
    private Label TretmantLbl;

    @FXML
    private Button UpdateBtn;

    @FXML
    private Label UpdateLbl;









    private PacientDto selectedPacient;

    public void initData(PacientDto pacient) {
        selectedPacient = pacient;

        txtDataL.setText(selectedPacient.getDataelirimit());
        txtDataSh.setText(selectedPacient.getDataeshtrirjes());
        txtDiagnoza.setText(selectedPacient.getDiagnoza());
        txtPID.setText(String.valueOf(selectedPacient.getPID()));
        txtPagesa.setText(String.valueOf(selectedPacient.getPagesa()));
        txtPershkrimi.setText(selectedPacient.getPershkrimi());
        txtTel.setText(String.valueOf(selectedPacient.getNrtel()));
        txtTretmani.setText(selectedPacient.getTretmani());
        txtadresa.setText(selectedPacient.getAdresa());
        txtditelindja.setText(selectedPacient.getDitelindja());
        txtemri.setText(selectedPacient.getEmri());
        txtgjinia.setText(selectedPacient.getGjinia());
        txtmbiemri.setText(selectedPacient.getMbiemri());
        txtmosha.setText(String.valueOf(selectedPacient.getMosha()));
    }

    public void handleUpdate(javafx.scene.input.MouseEvent mouseEvent) {

        Pacient.updatePacient(selectedPacient, txtemri.getText(), txtmbiemri.getText(), txtgjinia.getText(), Integer.parseInt(txtmosha.getText()), txtditelindja.getText(), Integer.parseInt(txtTel.getText()), txtadresa.getText(), txtDataSh.getText(), txtDataL.getText(), txtDiagnoza.getText(), txtTretmani.getText(), txtPershkrimi.getText(), Integer.parseInt(txtPagesa.getText()));
        Navigator.navigate(mouseEvent, Navigator.Doctor_Menaxho);
    }





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


        this.NameLbl.setText(rb.getString("Name"));
        this.LastNameLbl.setText(rb.getString("Last Name"));
        this.AddressLbl.setText(rb.getString("Address"));
        this.AgeLbl.setText(rb.getString("Age"));
        this.GenderLbl.setText(rb.getString("Gender"));
        this.BirthdatLbl.setText(rb.getString("Birthday"));
        this.TelNumberlbl.setText(rb.getString("Tel Number"));
        this.ChargeLbl.setText(rb.getString("Charge Day"));
        this.DischargeLbl.setText(rb.getString("Discharge Day"));
        this.DiagnoseLbl.setText(rb.getString("Diagnose"));
        this.TretmantLbl.setText(rb.getString("Tretmant"));
        this.DescriptionLbl.setText(rb.getString("Description"));
        this.PaymentLbl.setText(rb.getString("Payment"));

        this.UpdateBtn.setText(rb.getString("Update"));
        this.UpdateLbl.setText(rb.getString("Update Pacient"));





    }
}
