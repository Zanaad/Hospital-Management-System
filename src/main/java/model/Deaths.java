package model;

import java.sql.Date;

public class Deaths {
    private int deathID;
    private String description;
    private String patient;
    private Date date;
    private String time;

    public Deaths(int deathID, String description, String patient, Date date, String time) {
        this.deathID = deathID;
        this.description = description;
        this.patient = patient;
        this.date = date;
        this.time = time;
    }

    public int getDeathID() {
        return deathID;
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
