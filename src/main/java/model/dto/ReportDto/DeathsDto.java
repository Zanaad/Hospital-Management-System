package model.dto.ReportDto;

import java.sql.Date;

public class DeathsDto extends reportDto{

    public DeathsDto(int id, String description,String patient, Date date, String time){
        super(id, description, patient, date, time);
    }
}