package model;

import java.sql.Date;

public class Operation {
    private String operationID;
    private String description;
    private String patient;
    private String doctor;
    private Date date;
    private String time;

    public Operation(String operationID, String description, String patient, String doctor, Date date, String time) {
        this.operationID = operationID;
        this.description = description;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    public String getOperationID() {
        return operationID;
    }

    public String getDescription() {
        return description;
    }

    public String getPatient() {
        return patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
