package controller;

import app.Navigator;
import database.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model_repository.Pacient;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DoctorMenaxhoController implements Initializable {
    @FXML
    private TableColumn<Pacient, String> AdresaColumn;

    @FXML
    private TableColumn<Pacient, String> DataShColumn;

    @FXML
    private TableColumn<Pacient, String> DatalColumn;

    @FXML
    private TableColumn<Pacient, String> DiagnozaColumn;

    @FXML
    private TableColumn<Pacient, String> DitelindjaColumn;

    @FXML
    private TableColumn<Pacient, String> EmriColumn;

    @FXML
    private TableColumn<Pacient, String> GjiniaColumn;

    @FXML
    private TableColumn<Pacient, String> MbiemriColumn;




    @FXML
    private TableColumn<Pacient, Integer> MoshaColumn;

    @FXML
    private TableColumn<Pacient, Integer> NRTelColumn;

    @FXML
    private TableColumn<Pacient, Integer> PIDColumn;

    @FXML
    private TableColumn<Pacient, Integer> PagesaColumn;

    @FXML
    private TableColumn<Pacient, String> PershkrimiColumn;

    @FXML
    private TableColumn<Pacient, String> TretmaniColumn;

    @FXML
    private TableColumn<Pacient,String> EditColumn;

    @FXML
    private TableView<Pacient> table1;

    @FXML
    private TextField txtSearch;




    ObservableList<Pacient> listF = FXCollections.observableArrayList();





    @FXML
    void handleClickApp(MouseEvent event) {

        Navigator.navigate(event, Navigator.Doctor_App);

    }

    @FXML
    void handleLab(MouseEvent event) {

    }



    @FXML
    void handleProfili(MouseEvent event) {

        Navigator.navigate(event, Navigator.Doctor_Profili);
    }

    @FXML
    void handleRegjistro(MouseEvent event) {

        Navigator.navigate(event, Navigator.Doctor_Shto);

    }

    public void refreshTable() {
        listF.clear();
        listF.addAll(Pacient.getPacientData());
        table1.setItems(listF);
    }

    public void initialize(URL url, ResourceBundle rb) {

        PIDColumn.setCellValueFactory(new PropertyValueFactory<Pacient, Integer>("PID"));
        EmriColumn.setCellValueFactory(new PropertyValueFactory<Pacient, String>("emri"));
        MbiemriColumn.setCellValueFactory(new PropertyValueFactory<Pacient, String>("mbiemri"));
        GjiniaColumn.setCellValueFactory(new PropertyValueFactory<Pacient, String>("gjinia"));
        MoshaColumn.setCellValueFactory(new PropertyValueFactory<Pacient, Integer>("mosha"));
        DitelindjaColumn.setCellValueFactory(new PropertyValueFactory<Pacient, String>("ditelindja"));
        NRTelColumn.setCellValueFactory(new PropertyValueFactory<Pacient, Integer>("nrtel"));
        AdresaColumn.setCellValueFactory(new PropertyValueFactory<Pacient, String>("adresa"));
        DataShColumn.setCellValueFactory(new PropertyValueFactory<Pacient, String>("dataeshtrirjes"));
        DatalColumn.setCellValueFactory(new PropertyValueFactory<Pacient, String>("dataelirimit"));
        DiagnozaColumn.setCellValueFactory(new PropertyValueFactory<Pacient, String>("diagnoza"));
        TretmaniColumn.setCellValueFactory(new PropertyValueFactory<Pacient, String>("tretmani"));
        PershkrimiColumn.setCellValueFactory(new PropertyValueFactory<Pacient, String>("pershkrimi"));
        PagesaColumn.setCellValueFactory(new PropertyValueFactory<Pacient, Integer>("pagesa"));

        // popullimi i tabeles
        listF.addAll(Pacient.getPacientData());
        table1.setItems(listF);

        // searchi
        FilteredList<Pacient> filteredData = new FilteredList<>(listF, b -> true);
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(pacient -> {
                if (newValue == null || newValue.trim().isEmpty()) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();
                return pacient.getEmri().toLowerCase().contains(searchKeyword) ||
                        pacient.getMbiemri().toLowerCase().contains(searchKeyword) ||
                        pacient.getAdresa().toLowerCase().contains(searchKeyword) ||
                        pacient.getDiagnoza().toLowerCase().contains(searchKeyword);
            });

            SortedList<Pacient> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(table1.comparatorProperty());
            table1.setItems(sortedData);
        });


        EditColumn.setCellFactory(param->new TableCell<Pacient,String>(){
            final Button updateButton=new Button("Update");
            final Button deleteButton=new Button("Delete");


            @Override
            protected void updateItem(String item,boolean empty){
                super.updateItem(item,empty);

                if(empty){
                    setGraphic(null);
                    setText(null);
                }else{
                    HBox buttonsContainer=new HBox(updateButton,deleteButton);
                    setGraphic(buttonsContainer);
                  //metoda per update-kur klikohet update me dal fxml file per regjistro edhe qajo mi pas ni buton per update vetem kur klikohet
                   //ky butoni update te tabela

                    updateButton.setOnAction(event -> {

                        Pacient selectedPacient = getTableView().getItems().get(getIndex());

                        // qitu hapet forma per update kur klikohet butoni
                        try {
                            URL url = new File("src/main/resources/app/Update.fxml").toURI().toURL();

                            FXMLLoader loader = new FXMLLoader(url);
                            Parent root = loader.load();
                            Scene scene = new Scene(root);
                            UpdatePacientController controller = loader.getController();

                            controller.initData(selectedPacient);

                            Stage stage = (Stage) updateButton.getScene().getWindow();
                            stage.setScene(scene);
                            stage.show();





                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });




                    //metoda per mi fshi ni pacient
                    deleteButton.setOnAction(event->{
                        Pacient p=getTableView().getItems().get(getIndex());
                        int pacientId=p.getPID();
                        try{
                            Connection conn=DBconnection.getConnection();
                            String sql="DELETE FROM pacienti WHERE PID=?";
                            PreparedStatement pr=conn.prepareStatement(sql);
                            pr.setInt(1,pacientId);
                            pr.executeUpdate();

                            refreshTable();
                        }catch(SQLException e){
                            e.getMessage();
                        }
                    });




                }
            }
        });
    }




}

