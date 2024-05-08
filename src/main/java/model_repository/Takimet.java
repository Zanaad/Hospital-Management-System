package model_repository;

import database.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Takimet {

    int ID;
    int mosha;
    String emri, mbiemri, gjinia, adresa,  datae;


    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMosha(int mosha) {
        this.mosha = mosha;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public void setGjinia(String gjinia) {
        this.gjinia = gjinia;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }



    public void setDatae(String datae) {
        this.datae = datae;
    }

    public int getID() {
        return ID;
    }

    public int getMosha() {
        return mosha;
    }

    public String getEmri() {
        return emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public String getGjinia() {
        return gjinia;
    }

    public String getAdresa() {
        return adresa;
    }



    public String getDatae() {
        return datae;
    }

    public Takimet(int ID, int mosha, String emri, String mbiemri, String gjinia, String adresa, String datae) {
        this.ID = ID;
        this.mosha = mosha;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.gjinia = gjinia;
        this.adresa = adresa;

        this.datae = datae;
    }

    public static ObservableList<Takimet> getTakimetData(){
        Connection conn=DBconnection.getConnection();
        ObservableList<Takimet> list=FXCollections.observableArrayList();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from takimet");
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                list.add(new Takimet(Integer.parseInt(rs.getString("ID")),
                        Integer.parseInt(rs.getString("mosha")),
                        rs.getString("emri"),
                        rs.getString("mbiemri"),
                        rs.getString("gjinia"),
                        rs.getString("adresa"),

                        rs.getString("datae")
                ));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }





}
