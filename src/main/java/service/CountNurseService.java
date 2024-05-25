package service;

import database.DatabaseUtil;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CountNurseService {
    public static final String countDonors = "select count(donor_id) from donors";


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

    public static void count(Label label, String query) {
        int count = getCount(query);
        label.setText(String.valueOf(count));
    }

}
