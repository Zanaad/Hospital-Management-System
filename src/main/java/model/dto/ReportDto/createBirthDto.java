package model.dto.ReportDto;

import java.sql.Date;

public class createBirthDto extends createReportDto {

    private String newBorn;

    public createBirthDto(int id, String description, String patient, String newBorn, Date date, String time) {
        super(id, description, patient, date, time);
        this.newBorn = newBorn;
    }


    public String getNewBorn() {
        return newBorn;
    }

    public void setNewBorn(String newBorn) {
        this.newBorn = newBorn;
    }
}