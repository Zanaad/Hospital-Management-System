package service;

import database.DatabaseUtil;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChartService {
    public static void areaChart(AreaChart<String, Number> areaChart, String query) {
        areaChart.getData().clear();
        Connection connect = DatabaseUtil.getConnection();
        XYChart.Series chart = new XYChart.Series<>();
        try {
            PreparedStatement prepare = connect.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
            }
            areaChart.getData().add(chart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void patientAreaChart(AreaChart<String, Number> areaChart) {
        String selectData = "SELECT DATE(patient_date) AS patient_date, COUNT(patient_id) AS patient_count FROM patients GROUP BY DATE(patient_date) ORDER BY DATE(patient_date) ASC;";
        areaChart(areaChart, selectData);
    }

    public static void appointmentAreaChart(AreaChart<String, Number> areaChart) {
        String selectData = "SELECT DATE(appointment_date) AS appointment_date, COUNT(appointment_id) AS appointment_count FROM appointments GROUP BY DATE(appointment_date) ORDER BY DATE(appointment_date) ASC;";
        areaChart(areaChart, selectData);
    }

    public static void donorsAreaChart(AreaChart<String, Number> areaChart) {
        String selectData = "SELECT DATE(donor_lastDonation) AS donor_lastDonation, COUNT(donor_ID) AS donor_count FROM donors GROUP BY DATE(donor_lastDonation) ORDER BY DATE(donor_lastDonation) ASC;";
        areaChart(areaChart, selectData);
    }
}
