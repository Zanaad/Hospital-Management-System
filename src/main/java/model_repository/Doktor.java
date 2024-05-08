package model_repository;

import database.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public static ObservableList<Doktor> getDoktorData(){
        Connection conn= DBconnection.getConnection();
        ObservableList<Doktor> list= FXCollections.observableArrayList();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from doktori");
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                list.add(new Doktor(Integer.parseInt(rs.getString("ID")),
                        Integer.parseInt(rs.getString("nrtel")),
                        rs.getString("emri"),
                        rs.getString("mbiemri"),
                        rs.getString("adresa"),
                        rs.getString("specializimi")


                ));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }
}
