package model;

import java.sql.Date;

public class Others {
    private String otherID;
    private String description;
    private String patient;
    private Date date;
    private String time;

    public Others(String otherID, String description, String patient, Date date, String time) {
        this.otherID = otherID;
        this.description = description;
        this.patient = patient;
        this.date = date;
        this.time = time;
    }

    public String getOtherID() {
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
