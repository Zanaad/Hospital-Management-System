package controller;

import app.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.User;
import model.dto.ChangePasswordDto;
import repository.Staff.AdminRepository;
import service.Alerts;
import service.Staff.AdminService;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class AdminAccountController implements Initializable {

    @FXML
    private TextField ChangePwdEmail;

    @FXML
    private AnchorPane account_form;

    @FXML
    private Label cNewPwd;

    @FXML
    private Label chCPwd;

    @FXML
    private Label chConfPwd;

    @FXML
    private Label chEmail;

    @FXML
    private Button changePasswordbtn;

    @FXML
    private PasswordField confirmNewPassword;

    @FXML
    private PasswordField currentPassword;

    @FXML
    private Label infoAddress;

    @FXML
    private Label infoEmail;

    @FXML
    private Label infoFirstName;

    @FXML
    private Label infoLastName;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblFirstName;

    @FXML
    private Label lblID;

    @FXML
    private Label lblLastName;

    @FXML
    private PasswordField newPassword;

    @FXML
    private Label upAddress;

    @FXML
    private Label upEmail;

    @FXML
    private Label upFirstName;

    @FXML
    private Label upLastName;

    @FXML
    private TextField updateAddress;

    @FXML
    private TextField updateEmail;

    @FXML
    private TextField updateFirstName;

    @FXML
    private TextField updateID;

    @FXML
    private TextField updateLastName;

    @FXML
    private Label yourInfo;

    @FXML
    void changePassword(ActionEvent event) {
        String currentPassword = this.currentPassword.getText();
        String newPassword = this.newPassword.getText();
        String confirmNewPassword = this.confirmNewPassword.getText();
        if (currentPassword.isBlank() || ChangePwdEmail.getText().isEmpty() || newPassword.isBlank() || confirmNewPassword.isEmpty())
            Alerts.errorMessage("Please fill all the fields before proceeding.");
        else if (!newPassword.equals(confirmNewPassword)) {
            Alerts.errorMessage("Passwords do not match.");
        } else {
            ChangePasswordDto change = new ChangePasswordDto(this.ChangePwdEmail.getText(), this.currentPassword.getText(), this.newPassword.getText(), this.confirmNewPassword.getText());
            boolean changed = AdminService.changePassword(change);
            if (changed) {
                Alerts.successMessage("Password was successfully changed.");
            } else {
                Alerts.errorMessage("Password was not changed");
            }
        }
    }

    public void translate() {
        Locale locale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle("translations.content", locale);
        this.infoFirstName.setText(rb.getString("First Name"));
        this.infoLastName.setText(rb.getString("Last Name"));
        this.infoEmail.setText(rb.getString("Email"));
        this.infoAddress.setText(rb.getString("Address"));
        this.upEmail.setText(rb.getString("Email"));
        this.upAddress.setText(rb.getString("Address"));
        this.upFirstName.setText(rb.getString("Address"));
        this.upLastName.setText(rb.getString("Address"));
        this.chConfPwd.setText(rb.getString("Confirm Password"));
        this.chEmail.setText(rb.getString("Email"));
        this.chCPwd.setText(rb.getString("Current Password"));
        this.cNewPwd.setText(rb.getString("New Password"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setAdminInfo();
        translate();
    }

    public void updateAccount(ActionEvent event) {

    }

    public void setAdminInfo() {
        User loggedAdmin = SessionManager.getCurrentUser();
        if (loggedAdmin != null) {
            lblID.setText(loggedAdmin.getId());
            lblFirstName.setText(loggedAdmin.getFirstName());
            lblLastName.setText(loggedAdmin.getLastName());
            lblEmail.setText(loggedAdmin.getEmail());
        } else {
            Alerts.errorMessage("Failed to load admin details.");
        }
    }
}
