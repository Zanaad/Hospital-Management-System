package model.dto.ReportDto;

import java.sql.Date;

public class createBirthDto extends createReportDto{
    public createBirthDto(String description, String patient, String newBorn, Date date, String time ){
        super(description,patient,date,time);
        this.setNewBorn(newBorn);
    }
}
