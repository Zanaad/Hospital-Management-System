package repository.Doc;

import database.DatabaseUtil;
import model.dto.DoktorDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Doktor{

    public DoktorDto getDoctorData(int doctorID) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DoktorDto doctor = null;

        try {
            conn = DatabaseUtil.getConnection();
            pst = conn.prepareStatement("SELECT * FROM doktori WHERE ID = ?");
            pst.setInt(1, doctorID);
            rs = pst.executeQuery();

            if (rs.next()) {
                doctor = new DoktorDto(
                        rs.getInt("ID"),
                        rs.getInt("nrtel"),
                        rs.getString("emri"),
                        rs.getString("mbiemri"),
                        rs.getString("adresa"),

                        rs.getString("specializimi")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }

    public void updateDoctor(int id, String emri, String mbiemri, String adresa, int nrTel, String specializimi) {
        Connection conn = null;
        PreparedStatement pst = null;

        String sql = "UPDATE doktori SET emri=?, mbiemri=?, adresa=?, nrtel=?, specializimi=? WHERE ID=?";
        try {
            conn = DatabaseUtil.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setString(1, emri);
            pst.setString(2, mbiemri);
            pst.setString(3, adresa);
            pst.setInt(4, nrTel);
            pst.setString(5, specializimi);
            pst.setInt(6, id);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Te dhenat e doktorrit jane perditesuar.");
            } else {
                System.out.println("perditesimi deshtoj.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}