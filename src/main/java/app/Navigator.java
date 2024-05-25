package app;

import controller.NursePageController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;
import java.io.IOException;

public class Navigator {
    public final static String AdminMainForm = "AdminMainForm.fxml";
    public final static String EditForm = "Edit.fxml";
    public final static String ReceptionistPage = "ReceptionistPage.fxml";
    public final static String NursePage = "NursePage.fxml";
    public final static String LoginPage = "Login.fxml";
    public final static String Doctor_App = "DoctorApp.fxml";
    public final static String Doctor_Shto = "DoctorRegjistro.fxml";
    public final static String Doctor_Menaxho = "DoctorMenaxho.fxml";
    public final static String Doctor_Profili = "DoctorProfili.fxml";
    private static ResourceBundle bundle = ResourceBundle.getBundle("translations.content", Locale.getDefault());

    public static void navigate(Event event, String form) {
        Node eventNode = (Node) event.getSource();
        Stage stage = (Stage) eventNode.getScene().getWindow();
        navigate(stage, form);
    }

    public static void navigate(Stage stage, String form) {
        Pane formPane = loadPane(form);
        Scene newScene = new Scene(formPane);
        stage.setScene(newScene);
        stage.show();
    }

    public static void navigateToForm(ActionEvent event, String page, String formToDisplay) {
        try {
            FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(page));
            loader.setResources(bundle);
            Parent root = loader.load();

            NursePageController controller = loader.getController();
            controller.setFormToDisplay(formToDisplay);
            Node eventNode = (Node) event.getSource();
            Stage stage = (Stage) eventNode.getScene().getWindow();
            navigate(stage, page);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadContent(AnchorPane contentPane, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(fxmlFile));
            loader.setResources(bundle);
            Node content = loader.load();
            contentPane.getChildren().setAll(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void handleLanguage() {
        Locale defaultLocale = Locale.getDefault();
        if (defaultLocale.getLanguage().equals("en")) {
            Locale.setDefault(new Locale("sq"));
        } else {
            Locale.setDefault(Locale.ENGLISH);
        }
        bundle = ResourceBundle.getBundle("translations.content", Locale.getDefault());
    }

    private static Pane loadPane(String form) {
        FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(form), bundle);
        try {
            return loader.load();
        } catch (IOException ioe) {
            return null;
        }
    }
}
