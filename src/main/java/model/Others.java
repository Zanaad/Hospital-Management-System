package model;

import java.sql.Date;

public class Others {
    private int otherID;
    private String description;
    private String patient;
    private Date date;
    private String time;

    public Others(int otherID, String description, String patient, Date date, String time) {
        this.otherID = otherID;
        this.description = description;
        this.patient = patient;
        this.date = date;
        this.time = time;
    }

    public int getOtherID() {
        return otherID;
    }

    public String getDescription() {
        return description;
    }

    public String getPatient() {
        return patient;
    }

    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
