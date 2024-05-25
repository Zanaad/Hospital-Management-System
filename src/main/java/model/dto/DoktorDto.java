package model.dto;
public class DoktorDto {
    int ID, NrTel;
    String emri, mbiemri, adresa, specializimi;

    public DoktorDto(int ID, int nrTel, String emri, String mbiemri, String adresa, String specializimi) {
        this.ID = ID;
        this.NrTel = nrTel;
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
        return this.NrTel;
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

    public void setSpecializimi(String specializimi){
        this.specializimi=specializimi;
    }
}