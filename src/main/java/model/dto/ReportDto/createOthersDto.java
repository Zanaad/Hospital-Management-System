package model.dto.ReportDto;


import java.sql.Date;

public class createOthersDto extends createReportDto{

    public createOthersDto(String description, String patient, Date date, String time){
        super(description, patient, date, time);
    }
}