package model.dto.ReportDto;

import java.sql.Date;

public class BirthsDto extends reportDto{
    public BirthsDto(String description, String patient, String newBorn, Date date, String time ){
        super(description,patient,date,time);
        this.setNewBorn(newBorn);
    }
}
