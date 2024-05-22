package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import service.CountStaffService;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {
    @FXML
    private Label app_count;

    @FXML
    private BarChart<?, ?> dashboad_chart_AD;

    @FXML
    private AreaChart<?, ?> dashboad_chart_PD;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Label dep_count;

    @FXML
    private Label docs_count;

    @FXML
    private Label lblDocs;

    @FXML
    private Label lblNurses;

    @FXML
    private Label lblRecs;

    @FXML
    private Label nurses_count;

    @FXML
    private Label patients_count;

    @FXML
    private Label rec_count;

    public void staff_count() {
        CountStaffService.countStaff(nurses_count, CountStaffService.countNurse);
        CountStaffService.countStaff(docs_count, CountStaffService.countDoctor);
        CountStaffService.countStaff(rec_count, CountStaffService.countReceptionist);
        CountStaffService.countStaff(dep_count, CountStaffService.countDepartment);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.staff_count();
    }

}
