package controller;

import app.Navigator;
import app.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;
import model.dto.LoginUserDto;
import service.UserService;



public class LoginController {
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField pwdPassword;
    @FXML
    private ComboBox<String> userTypeComboBox;

    @FXML
    private void handleLoginClick(ActionEvent ae) {
        LoginUserDto loginUserData = new LoginUserDto(
                this.txtEmail.getText(),
                this.pwdPassword.getText()

        );

        User user = UserService.login(loginUserData);

        if (user != null) {
            SessionManager.setUser(user);
            switch (user.getRole().toLowerCase()) {
                case "admin":
                    System.out.println("Admin login");
                    Navigator.navigate(ae, Navigator.AdminPage);
                    break;
               /* case "doctor":
                    System.out.println("Doctor login");
                    Navigator.navigate(ae, Navigator.DoctorPage);
                    break;*/
                case "nurse":
                    System.out.println("Nurse login");
                    Navigator.navigate(ae, Navigator.NursePage);
                    break;
                case "receptionist":
                    System.out.println("Receptionist login");
                    Navigator.navigate(ae, Navigator.ReceptionistPage);
                    break;
                default:
                    System.out.println("Unknown user role");
                    break;
            }
        } else {
            System.out.println("Login failed. Please check your credentials.");
            // You can also display an alert or message to the user here
        }
    }
    }

