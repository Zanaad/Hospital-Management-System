package model;

import java.sql.Date;

public class Births {
    private int birthID;
    private String description;
    private String patient;
    private String newborn;
    private Date date;
    private String time;

    public Births(int birthID, String description, String patient, String newborn, Date date, String time) {
        this.birthID = birthID;
        this.description = description;
        this.patient = patient;
        this.newborn = newborn;
        this.date = date;
        this.time = time;
    }

    public String getNewborn() {
        return newborn;
    }

    public int getBirthID() {
        return birthID;
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
