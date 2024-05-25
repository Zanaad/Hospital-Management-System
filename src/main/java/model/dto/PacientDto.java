package model.dto;

public class PacientDto {
    int PID,mosha,nrtel,pagesa;
    String emri,mbiemri,gjinia,ditelindja,adresa,dataeshtrirjes,dataelirimit,diagnoza,tretmani,pershkrimi;

    public PacientDto(int PID, int mosha, int nrtel, int pagesa, String emri, String mbiemri, String gjinia, String ditelindja, String adresa, String dataeshtrirjes, String dataelirimit, String diagnoza, String tretmani, String pershkrimi) {
        this.PID = PID;
        this.mosha = mosha;
        this.nrtel = nrtel;
        this.pagesa = pagesa;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.gjinia = gjinia;
        this.ditelindja = ditelindja;
        this.adresa = adresa;
        this.dataeshtrirjes = dataeshtrirjes;
        this.dataelirimit = dataelirimit;
        this.diagnoza = diagnoza;
        this.tretmani = tretmani;
        this.pershkrimi = pershkrimi;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public int getMosha() {
        return mosha;
    }

    public void setMosha(int mosha) {
        this.mosha = mosha;
    }

    public int getNrtel() {
        return nrtel;
    }

    public void setNrtel(int nrtel) {
        this.nrtel = nrtel;
    }

    public int getPagesa() {
        return pagesa;
    }

    public void setPagesa(int pagesa) {
        this.pagesa = pagesa;
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

    public String getGjinia() {
        return gjinia;
    }

    public void setGjinia(String gjinia) {
        this.gjinia = gjinia;
    }

    public String getDitelindja() {
        return ditelindja;
    }

    public void setDitelindja(String ditelindja) {
        this.ditelindja = ditelindja;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getDataeshtrirjes() {
        return dataeshtrirjes;
    }

    public void setDataeshtrirjes(String dataeshtrirjes) {
        this.dataeshtrirjes = dataeshtrirjes;
    }

    public String getDataelirimit() {
        return dataelirimit;
    }

    public void setDataelirimit(String dataelirimit) {
        this.dataelirimit = dataelirimit;
    }

    public String getDiagnoza() {
        return diagnoza;
    }

    public void setDiagnoza(String diagnoza) {
        this.diagnoza = diagnoza;
    }

    public String getTretmani() {
        return tretmani;
    }

    public void setTretmani(String tretmani) {
        this.tretmani = tretmani;
    }

    public String getPershkrimi() {
        return pershkrimi;
    }

    public void setPershkrimi(String pershkrimi) {
        this.pershkrimi = pershkrimi;
    }
}
