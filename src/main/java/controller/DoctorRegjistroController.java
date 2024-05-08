package controller;
import app.Navigator;
import java.sql.Connection;

import database.DBconnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    private TextArea txtPershkrimi;



    @FXML
    private TextField txtTel;

    @FXML
    private TextField txtTretmani;




    Connection conn=null;


    ResultSet rs=null;

    PreparedStatement pst=null;

    @FXML
    void handleRegjistroPacient(ActionEvent event) {
        conn= DBconnection.getConnection();
        String sql="insert into pacienti (PID,emri,mbiemri,gjinia,mosha,ditelindja,nrtel,adresa,dataeshtrirjes,dataelirimit,diagnoza,tretmani,pershkrimi,pagesa) values (? , ? , ? , ? , ? , ? , ?, ? , ? , ? , ? , ? , ? , ?  )";
        try{
            pst=conn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txtPID.getText()));
            pst.setString(2,txtemri.getText());
            pst.setString(3,txtmbiemri.getText());
            pst.setString(4,txtgjinia.getText());
            pst.setInt(5, Integer.parseInt(txtmosha.getText()));
            pst.setString(6,txtditelindja.getText());
            pst.setInt(7, Integer.parseInt(txtTel.getText()));
            pst.setString(8,txtadresa.getText());
            pst.setString(9,txtDataSh.getText());
            pst.setString(10,txtDataL.getText());
            pst.setString(11,txtDiagnoza.getText());
            pst.setString(12,txtTretmani.getText());
            pst.setString(13,txtPershkrimi.getText());
            pst.setInt(14, Integer.parseInt(txtPagesa.getText()));

            pst.execute();
            pst.close();




        }
        catch(Exception e){
            e.printStackTrace();

        }

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
    void handleLab(MouseEvent event) {


    }




}

