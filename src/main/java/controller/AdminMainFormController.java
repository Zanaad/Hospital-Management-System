package controller;

import app.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class AdminMainFormController implements Initializable {

    @FXML
    private Button account_btn;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Button department_btn;

    @FXML
    private Button doctors_btn;

    @FXML
    private Button logout_btn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button nurse_btn;

    @FXML
    private Button receptionist_btn;
    @FXML
    private AnchorPane contentPane;

    @FXML
    void switchForm(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonID = button.getId();
        switch (buttonID) {
            case "dashboard_btn":
                Navigator.loadContent(contentPane, "AdminDashboard.fxml");
                break;
            case "account_btn":
                Navigator.loadContent(contentPane, "AdminAccount.fxml");
                break;
            case "department_btn":
                Navigator.loadContent(contentPane, "AddDepartment.fxml");
                break;
            case "doctors_btn":
                Navigator.loadContent(contentPane, "AddDoctor.fxml");
                break;
            case "nurse_btn":
                Navigator.loadContent(contentPane, "AddNurse.fxml");
                break;
            case "receptionist_btn":
                Navigator.loadContent(contentPane, "AddRec.fxml");
                break;
            default:
                Navigator.loadContent(contentPane, "AdminDashboard.fxml");
        }
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
        this.dashboard_btn.setText(rb.getString("Dashboard"));
        this.department_btn.setText(rb.getString("Departments"));
        this.doctors_btn.setText(rb.getString("Doctors"));
        this.nurse_btn.setText(rb.getString("Nurses"));
        this.receptionist_btn.setText(rb.getString("Receptionists"));
        this.account_btn.setText(rb.getString("Account"));
        this.logout_btn.setText(rb.getString("Logout"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Navigator.loadContent(contentPane, "AdminDashboard.fxml");
        this.translate();
    }
}
