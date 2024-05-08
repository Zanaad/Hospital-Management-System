package controller;

import database.DBconnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model_repository.Pacient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    private Pacient selectedPacient;


    // qito merren te dhenat pi rreshtit
    public void initData(Pacient pacient) {
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
        Connection conn = null;
        PreparedStatement pst = null;

        String sql = "UPDATE pacienti SET emri=?, mbiemri=?, gjinia=?, mosha=?, ditelindja=?, nrtel=?, adresa=?, dataeshtrirjes=?, dataelirimit=?, diagnoza=?, tretmani=?, pershkrimi=?, pagesa=? WHERE PID=?";
        try {
            conn = DBconnection.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setString(1, txtemri.getText());
            pst.setString(2, txtmbiemri.getText());
            pst.setString(3, txtgjinia.getText());
            pst.setInt(4, Integer.parseInt(txtmosha.getText()));
            pst.setString(5, txtditelindja.getText());
            pst.setInt(6, Integer.parseInt(txtTel.getText()));
            pst.setString(7, txtadresa.getText());
            pst.setString(8, txtDataSh.getText());
            pst.setString(9, txtDataL.getText());
            pst.setString(10, txtDiagnoza.getText());
            pst.setString(11, txtTretmani.getText());
            pst.setString(12, txtPershkrimi.getText());
            pst.setInt(13, Integer.parseInt(txtPagesa.getText()));
            pst.setInt(14, Integer.parseInt(txtPID.getText()));

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("te dhenat jane perditesuar me sukses.");
            } else {
                System.out.println("deshtim");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

}
