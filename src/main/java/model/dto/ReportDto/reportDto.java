package model.dto.ReportDto;

import java.sql.Date;

public class reportDto  {

    private String description;
    private String patient;
    private String doctor;
    private String newBorn;
    private Date date;
    private String time;

    public reportDto(String description, String patient, Date date, String time) {
        this.description = description;
        this.patient = patient;

        this.date = date;
        this.time = time;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public void setNewBorn(String newBorn) {
        this.newBorn = newBorn;
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

    public String getNewBorn(){
        return newBorn;
    }

    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
