package controller;

import app.Navigator;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.TakimetDto;
import repository.Doc.Takimet;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.net.URL;
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
    private Button btnShtotakim;

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
}