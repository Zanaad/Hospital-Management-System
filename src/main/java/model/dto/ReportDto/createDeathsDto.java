package model.dto.ReportDto;

import java.sql.Date;

public class createDeathsDto extends createReportDto{

    public createDeathsDto(int id, String description, String patient, Date date, String time){
        super(id, description, patient, date, time);
    }
}