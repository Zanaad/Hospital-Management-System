package controller;

import app.Navigator;
import java.sql.Connection;
import model_repository.Takimet;
import database.DBconnection;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class DoctorAppController implements Initializable {


    @FXML
    private TableColumn<Takimet, String> AdresaColumn;

    @FXML
    private TableColumn<Takimet, String> DataColumn;

    @FXML
    private TableColumn<Takimet, String> EmriColumn;

    @FXML
    private TableColumn<Takimet, String> GjiniaColumn;

    @FXML
    private TableColumn<Takimet,Integer > IDColumn;

    @FXML
    private TableColumn<Takimet, String> MbiemriColumn;

    @FXML
    private TableColumn<Takimet, Integer> MoshaColumn;




    @FXML
    private Button btnShtotakim;

    @FXML
    private TableView<Takimet> table;

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




    ObservableList<Takimet> listM;
    Connection conn=null;


    ResultSet rs=null;

    PreparedStatement pst=null;

    @FXML
    void handleShtotakim(ActionEvent event) {
        conn=DBconnection.getConnection();
        String sql="insert into takimet (ID,emri,mbiemri,gjinia,mosha,adresa,datae) values (? , ? , ? , ? , ? , ? , ?  )";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,txtID.getText());
            pst.setString(2,txtEmri.getText());
            pst.setString(3,txtMbiemri.getText());
            pst.setString(4,txtGjinia.getText());
            pst.setString(5,txtMosha.getText());
            pst.setString(6,txtAdresa.getText());

            pst.setString(7,txtData.getText());
            pst.execute();

            Takimet newTakimet = new Takimet(Integer.parseInt(txtID.getText()),
                    Integer.parseInt(txtMosha.getText()),
                    txtEmri.getText(),
                    txtMbiemri.getText(),
                    txtGjinia.getText(),
                    txtAdresa.getText(),
                    txtData.getText());


            table.getItems().add(newTakimet);


        }
        catch(Exception e){
                e.printStackTrace();

        }

    }


    public void initialize(URL url, ResourceBundle rb){
        IDColumn.setCellValueFactory(new PropertyValueFactory<Takimet,Integer>("ID"));
        EmriColumn.setCellValueFactory(new PropertyValueFactory<Takimet,String>("emri"));
        MbiemriColumn.setCellValueFactory(new PropertyValueFactory<Takimet,String>("mbiemri"));
        GjiniaColumn.setCellValueFactory(new PropertyValueFactory<Takimet,String>("gjinia"));
        MoshaColumn.setCellValueFactory(new PropertyValueFactory<Takimet,Integer>("mosha"));
        AdresaColumn.setCellValueFactory(new PropertyValueFactory<Takimet,String>("adresa"));

        DataColumn.setCellValueFactory(new PropertyValueFactory<Takimet,String>("datae"));


        listM= Takimet.getTakimetData();
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
    void handleRegjistro(MouseEvent event)
    {
        Navigator.navigate(event, Navigator.Doctor_Shto);
    }

    @FXML
    void handleLab(MouseEvent event) {

    }


}

