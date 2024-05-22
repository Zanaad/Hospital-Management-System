package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.dto.ChangePasswordDto;
import service.Alerts;
import service.ChangePwdService;

public class AdminAccountController {

    @FXML
    private TextField ChangePwdEmail;

    @FXML
    private Button changePasswordbtn;

    @FXML
    private PasswordField confirmNewPassword;

    @FXML
    private PasswordField currentPassword;

    @FXML
    private PasswordField newPassword;

    @FXML
    private AnchorPane profile_form;

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
            boolean changed = ChangePwdService.changePassword(change);
            if (changed) {
                Alerts.successMessage("Password was successfully changed.");
            } else {
                Alerts.errorMessage("Password was not changed");
            }
        }
    }
}
