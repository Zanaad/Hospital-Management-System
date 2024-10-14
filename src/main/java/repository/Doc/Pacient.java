package repository.Doc;

import database.DatabaseUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.PacientDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pacient {
    public static ObservableList<PacientDto> getPacientData() {
        Connection conn = DatabaseUtil.getConnection();
        ObservableList<PacientDto> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from pacienti");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new PacientDto(Integer.parseInt(rs.getString("PID")),
                        Integer.parseInt(rs.getString("mosha")),
                        Integer.parseInt(rs.getString("pagesa")),
                        Integer.parseInt(rs.getString("nrtel")),
                        rs.getString("emri"),
                        rs.getString("mbiemri"),
                        rs.getString("gjinia"),
                        rs.getString("ditelindja"),
                        rs.getString("adresa"),
                        rs.getString("dataeshtrirjes"),
                        rs.getString("dataelirimit"),
                        rs.getString("diagnoza"),
                        rs.getString("tretmani"),
                        rs.getString("pershkrimi")


                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void updatePacient(PacientDto selectedPacient, String emri, String mbiemri, String gjinia, int mosha, String ditelindja, int nrtel, String adresa, String dataSh, String dataL, String diagnoza,
                                     String tretmani, String pershkrimi, int pagesa) {
        Connection conn = null;
        PreparedStatement pst = null;

        String sql = "UPDATE pacienti SET emri=?, mbiemri=?, gjinia=?, mosha=?, ditelindja=?, nrtel=?, adresa=?, dataeshtrirjes=?, dataelirimit=?, diagnoza=?, tretmani=?, pershkrimi=?, pagesa=? WHERE PID=?";
        try {
            conn = DatabaseUtil.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setString(1, emri);
            pst.setString(2, mbiemri);
            pst.setString(3, gjinia);
            pst.setInt(4, mosha);
            pst.setString(5, ditelindja);
            pst.setInt(6, nrtel);
            pst.setString(7, adresa);
            pst.setString(8, dataSh);
            pst.setString(9, dataL);
            pst.setString(10, diagnoza);
            pst.setString(11, tretmani);
            pst.setString(12, pershkrimi);
            pst.setInt(13, pagesa);
            pst.setInt(14, selectedPacient.getPID());

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("te dhenat jane perditesuar me sukses.");
            } else {
                System.out.println("deshtim");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void regjistroPacient(int PID, String emri, String mbiemri, String gjinia, int mosha, String ditelindja,
                                        int nrtel, String adresa, String dataeshtrirjes, String dataelirimit, String diagnoza,
                                        String tretmani, String pershkrimi, int pagesa) {
        Connection conn = null;
        PreparedStatement pst = null;

        String sql = "INSERT INTO pacienti (PID, emri, mbiemri, gjinia, mosha, ditelindja, nrtel, adresa, dataeshtrirjes, dataelirimit, diagnoza, tretmani, pershkrimi, pagesa) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = DatabaseUtil.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setInt(1, PID);
            pst.setString(2, emri);
            pst.setString(3, mbiemri);
            pst.setString(4, gjinia);
            pst.setInt(5, mosha);
            pst.setString(6, ditelindja);
            pst.setInt(7, nrtel);
            pst.setString(8, adresa);
            pst.setString(9, dataeshtrirjes);
            pst.setString(10, dataelirimit);
            pst.setString(11, diagnoza);
            pst.setString(12, tretmani);
            pst.setString(13, pershkrimi);
            pst.setInt(14, pagesa);

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
