package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import repository.ChangePwdRepository;
import service.ChartService;
import service.CountStaffService;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {
    @FXML
    private Label app_count;

    @FXML
    private AreaChart<String, Number> AreaChartPatients;

    @FXML
    private PieChart PieChartEmp;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.staff_count();
        ChartService.patientAreaChart(AreaChartPatients);
        this.pieChartEmployeesData();
        ChangePwdRepository.addSaltAndHashToAdmins();
    }

    public void staff_count() {
        CountStaffService.countStaff(nurses_count, CountStaffService.countNurse);
        CountStaffService.countStaff(docs_count, CountStaffService.countDoctor);
        CountStaffService.countStaff(rec_count, CountStaffService.countReceptionist);
        CountStaffService.countStaff(dep_count, CountStaffService.countDepartment);
        CountStaffService.countStaff(patients_count, CountStaffService.countPatients);
        CountStaffService.countStaff(app_count, CountStaffService.countAppointments);
    }

    private void pieChartEmployeesData() {
        int nrDocs = CountStaffService.getCount(CountStaffService.countDoctor);
        int nrNurses = CountStaffService.getCount(CountStaffService.countNurse);
        int nrRecs = CountStaffService.getCount(CountStaffService.countReceptionist);
        PieChartEmp.setPrefWidth(400);
        PieChartEmp.setPrefHeight(400);
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(new PieChart.Data("Doctors", nrDocs), new PieChart.Data("Nurses", nrNurses), new PieChart.Data("Receptionists", nrRecs));

        PieChartEmp.setData(pieChartData);
    }
}
