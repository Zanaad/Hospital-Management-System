package model.dto.ReportDto;


import java.sql.Date;

public class createOthersDto extends createReportDto{

    public createOthersDto(String id, String description, String patient, Date date, String time){
        super(id, description, patient, date, time);
    }
}