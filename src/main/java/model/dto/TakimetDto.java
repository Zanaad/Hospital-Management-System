package model.dto;

public class TakimetDto {
    int ID;
    int mosha;
    String emri, mbiemri, gjinia, adresa,  datae;

    public TakimetDto(int ID, String emri, String mbiemri, String gjinia,int mosha, String adresa, String datae) {
        this.ID = ID;
        this.mosha = mosha;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.gjinia = gjinia;
        this.adresa = adresa;

        this.datae = datae;
    }



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


}
