package app;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

import java.io.IOException;

public class Navigator {
    public final static String AdminPage = "AdminPage.fxml";
    public final static String ReceptionistPage = "ReceptionistPage.fxml";
    public final static String NursePage = "NursePage.fxml";

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


    private static Pane loadPane(String form) {

        ResourceBundle bundle = ResourceBundle.getBundle("translations.content", Locale.getDefault());
        FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(form), bundle);
        try {
            return loader.load();
        } catch (IOException ioe) {
            return null;
        }
    }
}