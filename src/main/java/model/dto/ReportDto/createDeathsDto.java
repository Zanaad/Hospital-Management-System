package model.dto.ReportDto;

import java.sql.Date;

public class createDeathsDto extends createReportDto{

    public createDeathsDto(String description, String patient, Date date, String time){
        super(description, patient, date, time);

    }
}