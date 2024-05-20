package app;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigator {
    public final static String AdminPage = "AdminPage.fxml";
    public final static String ReceptionistPage = "ReceptionistPage.fxml";
    public final static String NursePage = "NursePage.fxml";

    public final static String NursePage = "NursePage.fxml";
    public static void navigate(Stage stage, String page) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Navigator.class.getResource(page)
            );
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void navigate(Event event, String page) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        navigate(stage, page);
    }
}