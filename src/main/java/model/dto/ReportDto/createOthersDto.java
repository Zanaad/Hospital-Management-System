package model.dto.ReportDto;


import java.sql.Date;

public class createOthersDto extends createReportDto{

    public createOthersDto(int id, String description, String patient, Date date, String time){
        super(id, description, patient, date, time);
    }
}