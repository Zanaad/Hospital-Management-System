package model.dto.ReportDto;

import java.sql.Date;

public class createReportDto {
    private String id;
    private String description;
    private String patient;
    private Date date;
    private String time;
    private String doctor;

    public createReportDto(String id, String description, String patient, Date date, String time) {
        this.id = id;
        this.description = description;
        this.patient = patient;
        this.date = date;
        this.time = time;
    }


    public String getId() {
        return id;
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

    public String getDoctor() {
        return doctor;
    }

    // Setters
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
