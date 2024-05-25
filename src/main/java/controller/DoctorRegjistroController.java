package controller;

import app.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import repository.Doc.Pacient;

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



