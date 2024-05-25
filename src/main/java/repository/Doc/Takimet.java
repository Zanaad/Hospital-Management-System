package repository.Doc;

import database.DatabaseUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.dto.TakimetDto;
import java.sql.SQLException;

public class Takimet {

    public static ObservableList<TakimetDto> getTakimetData() {
        ObservableList<TakimetDto> takimetList = FXCollections.observableArrayList();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DatabaseUtil.getConnection();
            pst = conn.prepareStatement("SELECT * FROM takimet");
            rs = pst.executeQuery();

            while (rs.next()) {
                TakimetDto takim = new TakimetDto(
                        rs.getInt("ID"),
                        rs.getString("emri"),
                        rs.getString("mbiemri"),
                        rs.getString("gjinia"),
                        rs.getInt("mosha"),
                        rs.getString("adresa"),
                        rs.getString("datae")
                );
                takimetList.add(takim);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return takimetList;
    }

    public static void addTakim(int id, String emri, String mbiemri, String gjinia, int mosha, String adresa, String datae) {
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = DatabaseUtil.getConnection();
            String sql = "INSERT INTO takimet (ID, emri, mbiemri, gjinia, mosha, adresa, datae) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, emri);
            pst.setString(3, mbiemri);
            pst.setString(4, gjinia);
            pst.setInt(5, mosha);
            pst.setString(6, adresa);
            pst.setString(7, datae);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
