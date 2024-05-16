package model_repository;

import database.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Doktor {
    int ID,NrTel;
    String emri,mbiemri,adresa,specializimi;

    public Doktor(int ID, int nrTel, String emri, String mbiemri, String adresa, String specializimi) {
        this.ID = ID;
        NrTel = nrTel;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.adresa = adresa;
        this.specializimi = specializimi;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNrTel() {
        return NrTel;
    }

    public void setNrTel(int nrTel) {
        NrTel = nrTel;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getSpecializimi() {
        return specializimi;
    }

    public void setSpecializimi(String specializimi) {
        this.specializimi = specializimi;
    }
public static Doktor getDoctorData(int doctorID) {
        Doktor doctor = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DBconnection.getConnection();
            String query = "SELECT * FROM doktori WHERE ID = ?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, doctorID);
            rs = pst.executeQuery();

            if (rs.next()) {
                int ID = rs.getInt("ID");
                int nrTel = rs.getInt("NrTel");
                String emri = rs.getString("emri");
                String mbiemri = rs.getString("mbiemri");
                String adresa = rs.getString("adresa");
                String specializimi = rs.getString("specializimi");

                doctor = new Doktor(ID, nrTel, emri, mbiemri, adresa, specializimi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doctor;
    }

}
