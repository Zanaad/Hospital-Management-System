package model.dto.ReportDto;

import java.sql.Date;

public class OthersDto extends reportDto{

    public OthersDto(int id, String description, String patient, Date date, String time){
        super(id, description, patient, date, time);
    }
}