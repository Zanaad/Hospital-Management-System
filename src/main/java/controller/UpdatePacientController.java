package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.dto.PacientDto;
import repository.Doc.Pacient;

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

    @FXML
    void handleUpdate(ActionEvent event) {
        Pacient.updatePacient(selectedPacient,txtemri.getText(),txtmbiemri.getText(),txtgjinia.getText(),Integer.parseInt(txtmosha.getText()),txtditelindja.getText(),Integer.parseInt(txtTel.getText()),txtadresa.getText(),txtDataSh.getText(), txtDataL.getText(), txtDiagnoza.getText(),
                txtTretmani.getText(), txtPershkrimi.getText(), Integer.parseInt(txtPagesa.getText()));
    }
}