package model.dto.ReportDto;

import java.sql.Date;

public class OperationDto {
    private String id;
    private String description;
    private String patient;
    private String doctor;
    private Date date;
    private String time;

    public OperationDto(String id, String description, String patient, String doctor, Date date, String time) {
        this.id = id;
        this.description = description;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getID() {
        return id;
    }
}

