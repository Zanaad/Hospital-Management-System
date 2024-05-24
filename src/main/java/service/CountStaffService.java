package service;

import database.DatabaseUtil;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CountStaffService {
    public static final String countNurse = "select count(id) from nurses";
    public static final String countDoctor = "select count(id) from doctors";
    public static final String countReceptionist = "select count(id) from receptionists";
    public static final String countDepartment = "select count(department_id) from departments";
    public static final String countPatients = "select count(patient_id) from patients";
    public static final String countAppointments = "select count(appointment_id) from appointments";

    public static int getCount(String query, String depName) {
        int count = 0;
        try {
            Connection con = DatabaseUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            if (depName != null) {
                ps.setString(1, depName);
            }
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int getCount(String query) {
        return getCount(query, null);
    }

    public static void countStaff(Label label, String query) {
        int count = getCount(query);
        label.setText(String.valueOf(count));
    }

    public static void updateDepTable(String depName) {
        String countDocs = "select count(id) from doctors where department=?";
        String countNurses = "select count(id) from nurses where department=?";
        int nrDoctors = getCount(countDocs, depName);
        int nrNurses = getCount(countNurses, depName);

        String query = "UPDATE departments SET nrDoctors=?, nrNurses=? WHERE department_name=?";
        try {
            Connection con = DatabaseUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, nrDoctors);
            ps.setInt(2, nrNurses);
            ps.setString(3, depName);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
