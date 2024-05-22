package service;

import database.DatabaseUtil;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CountStaffService {
    public static void countStaff(Label label, String query) {
        int count = 0;
        try {
            Connection con = DatabaseUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            label.setText(String.valueOf(count));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
