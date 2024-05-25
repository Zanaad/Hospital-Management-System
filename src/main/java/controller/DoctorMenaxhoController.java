package controller;

import app.Navigator;
import database.DatabaseUtil;
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
import model.dto.PacientDto;
import repository.Doc.Pacient;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class DoctorMenaxhoController implements Initializable {
    @FXML
    private TableColumn<PacientDto, String> AdresaColumn;

    @FXML
    private TableColumn<PacientDto, String> DataShColumn;

    @FXML
    private TableColumn<PacientDto, String> DatalColumn;

    @FXML
    private TableColumn<PacientDto, String> DiagnozaColumn;

    @FXML
    private TableColumn<PacientDto, String> DitelindjaColumn;

    @FXML
    private TableColumn<PacientDto, String> EmriColumn;

    @FXML
    private TableColumn<PacientDto, String> GjiniaColumn;

    @FXML
    private TableColumn<PacientDto, String> MbiemriColumn;


    @FXML
    private TableColumn<PacientDto, Integer> MoshaColumn;

    @FXML
    private TableColumn<PacientDto, Integer> NRTelColumn;

    @FXML
    private TableColumn<PacientDto, Integer> PIDColumn;

    @FXML
    private TableColumn<PacientDto, Integer> PagesaColumn;

    @FXML
    private TableColumn<PacientDto, String> PershkrimiColumn;

    @FXML
    private TableColumn<PacientDto, String> TretmaniColumn;

    @FXML
    private TableColumn<PacientDto, String> EditColumn;

    @FXML
    private TableView<PacientDto> table1;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button AppBtn;

    @FXML
    private Label DashsboardLbl;


    @FXML
    private Label DoctorLbl;

    @FXML
    private Button EditBtn;


    @FXML
    private Label HospitalLbl;

    @FXML
    private Button ManageBtn;

    @FXML
    private Label ManageLbl;


    @FXML
    private Label FeaturesLbl;

    @FXML
    private Button RegisterBtn;

    @FXML
    private Label SettingsLbl;


    @FXML
    private Label Welcomelbl;


    ObservableList<PacientDto> listF = FXCollections.observableArrayList();


    @FXML
    void handleClickApp(MouseEvent event) {

        Navigator.navigate(event, Navigator.Doctor_App);

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
    public void handleLanguage() {
        Locale defaultLocale = Locale.getDefault();
        if (defaultLocale.getLanguage().equals("en")) {
            Locale.setDefault(new Locale("sq"));
        } else {
            Locale.setDefault(Locale.ENGLISH);
        }
        this.translate();

    }

    public void translate() {
        Locale locale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle("translations.content", locale);
        this.AdresaColumn.setText(rb.getString("Address"));
        this.EmriColumn.setText(rb.getString("Name"));
        this.MbiemriColumn.setText(rb.getString("Last Name"));
        this.MoshaColumn.setText(rb.getString("Age"));
        this.GjiniaColumn.setText(rb.getString("Gender"));
        this.DitelindjaColumn.setText(rb.getString("Birthday"));
        this.DatalColumn.setText(rb.getString("Discharge Day"));
        this.DiagnozaColumn.setText(rb.getString("Diagnose"));
        this.TretmaniColumn.setText(rb.getString("Tretmant"));
        this.DataShColumn.setText(rb.getString("Charge Day"));
        this.NRTelColumn.setText(rb.getString("Tel Number"));
        this.PershkrimiColumn.setText(rb.getString("Description"));
        this.PagesaColumn.setText(rb.getString("Payment"));
        this.EditColumn.setText(rb.getString("Edit"));
        this.EditBtn.setText(rb.getString("Edit Profile"));
        this.ManageBtn.setText(rb.getString("Manage Pacient"));
        this.RegisterBtn.setText(rb.getString("Register Pacient"));
        this.AppBtn.setText(rb.getString("Appointments"));
        this.Welcomelbl.setText(rb.getString("Welcome"));
        this.DoctorLbl.setText(rb.getString("Doctor"));
        this.FeaturesLbl.setText(rb.getString("Features"));
        this.SettingsLbl.setText(rb.getString("Change Settings"));
        this.ManageLbl.setText(rb.getString("Manage Pacient"));
        this.DashsboardLbl.setText(rb.getString("Management Dashboard"));
        this.HospitalLbl.setText(rb.getString("Hospital Management"));

    }


    public void refreshTable() {
        listF.clear();
        listF.addAll(Pacient.getPacientData());
        table1.setItems(listF);
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        PIDColumn.setCellValueFactory(new PropertyValueFactory<PacientDto, Integer>("PID"));
        EmriColumn.setCellValueFactory(new PropertyValueFactory<PacientDto, String>("emri"));
        MbiemriColumn.setCellValueFactory(new PropertyValueFactory<PacientDto, String>("mbiemri"));
        GjiniaColumn.setCellValueFactory(new PropertyValueFactory<PacientDto, String>("gjinia"));
        MoshaColumn.setCellValueFactory(new PropertyValueFactory<PacientDto, Integer>("mosha"));
        DitelindjaColumn.setCellValueFactory(new PropertyValueFactory<PacientDto, String>("ditelindja"));
        NRTelColumn.setCellValueFactory(new PropertyValueFactory<PacientDto, Integer>("nrtel"));
        AdresaColumn.setCellValueFactory(new PropertyValueFactory<PacientDto, String>("adresa"));
        DataShColumn.setCellValueFactory(new PropertyValueFactory<PacientDto, String>("dataeshtrirjes"));
        DatalColumn.setCellValueFactory(new PropertyValueFactory<PacientDto, String>("dataelirimit"));
        DiagnozaColumn.setCellValueFactory(new PropertyValueFactory<PacientDto, String>("diagnoza"));
        TretmaniColumn.setCellValueFactory(new PropertyValueFactory<PacientDto, String>("tretmani"));
        PershkrimiColumn.setCellValueFactory(new PropertyValueFactory<PacientDto, String>("pershkrimi"));
        PagesaColumn.setCellValueFactory(new PropertyValueFactory<PacientDto, Integer>("pagesa"));

        refreshTable();

        FilteredList<PacientDto> filteredData = new FilteredList<>(listF, b -> true);
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(pacient -> {
                if (newValue == null || newValue.trim().isEmpty()) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();
                return pacient.getEmri().toLowerCase().contains(searchKeyword) || pacient.getMbiemri().toLowerCase().contains(searchKeyword) || pacient.getAdresa().toLowerCase().contains(searchKeyword) || pacient.getDiagnoza().toLowerCase().contains(searchKeyword);
            });

            SortedList<PacientDto> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(table1.comparatorProperty());
            table1.setItems(sortedData);
        });


        EditColumn.setCellFactory(param -> new TableCell<PacientDto, String>() {
            final Button updateButton = new Button("Update");
            final Button deleteButton = new Button("Delete");

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                    setText(null);
                } else {
                    HBox buttonsContainer = new HBox(updateButton, deleteButton);
                    setGraphic(buttonsContainer);

                    updateButton.setOnAction(event -> {
                        PacientDto selectedPacient = getTableView().getItems().get(getIndex());
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

                    deleteButton.setOnAction(event -> {
                        PacientDto p = getTableView().getItems().get(getIndex());
                        int pacientId = p.getPID();
                        try {
                            Connection conn = DatabaseUtil.getConnection();
                            String sql = "DELETE FROM pacienti WHERE PID=?";
                            PreparedStatement pr = conn.prepareStatement(sql);
                            pr.setInt(1, pacientId);
                            pr.executeUpdate();
                            refreshTable();
                        } catch (SQLException e) {
                            e.getMessage();
                        }
                    });
                }
            }
        });
    }


}

