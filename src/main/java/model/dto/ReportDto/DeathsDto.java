package model.dto.ReportDto;

import java.sql.Date;

public class DeathsDto extends reportDto{

    public DeathsDto(String description,String patient, Date date, String time){
        super(description, patient, date, time);
    }
}