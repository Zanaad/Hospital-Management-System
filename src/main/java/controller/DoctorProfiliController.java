package controller;

import app.Navigator;
import database.DBconnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model_repository.Doktor;
import model_repository.Takimet;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DoctorProfiliController{


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
    void handleUpdate(MouseEvent event) {

          //duhet mu kry
        //labels me ndryshu kur bohet update profili
    }


    @FXML
    void handleClickApp(MouseEvent event) {

        Navigator.navigate(event, Navigator.Doctor_App);
    }

    @FXML
    void handleLab(MouseEvent event) {

    }

    @FXML
    void handleMenaxho(MouseEvent event) {

        Navigator.navigate(event, Navigator.Doctor_Menaxho);
    }

    @FXML
    void handleRegjistro(MouseEvent event) {

        Navigator.navigate(event, Navigator.Doctor_Shto);
    }

}

