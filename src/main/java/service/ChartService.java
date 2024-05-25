package service;

import database.DatabaseUtil;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChartService {
    public static void patientAreaChart(AreaChart<String, Number> areaChart) {
        areaChart.getData().clear();
        String selectData = "SELECT DATE(patient_date) AS patient_date, COUNT(patient_id) AS patient_count FROM patients GROUP BY DATE(patient_date) ORDER BY DATE(patient_date) ASC;";
        Connection connect = DatabaseUtil.getConnection();
        XYChart.Series chart = new XYChart.Series<>();
        try {
            PreparedStatement prepare = connect.prepareStatement(selectData);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
            }
            areaChart.getData().add(chart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void appointmentAreaChart(AreaChart<String, Number> areaChart) {
        areaChart.getData().clear();
        String selectData = "SELECT DATE(appointment_date) AS patient_date, COUNT(appointment_id) AS appointment_count FROM patients GROUP BY DATE(appointment_date) ORDER BY DATE(appointment_date) ASC;";
        Connection connect = DatabaseUtil.getConnection();
        XYChart.Series chart = new XYChart.Series<>();
        try {
            PreparedStatement prepare = connect.prepareStatement(selectData);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
            }
            areaChart.getData().add(chart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
