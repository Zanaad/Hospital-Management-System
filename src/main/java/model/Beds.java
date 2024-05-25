package model;

public class Beds {
    private int bedID;
    private String patient;
    private String bed;

    public Beds(int birthID, String patient, String bed) {
        this.bedID = birthID;
        this.patient = patient;
        this.bed = bed;
    }

    public int getBirthID() {
        return bedID;
    }

    public String getPatient() {
        return patient;
    }

    public String getBed() {
        return bed;
    }
}
