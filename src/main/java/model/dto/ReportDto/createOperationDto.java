package model.dto.ReportDto;

import java.sql.Date;

public class createOperationDto extends createReportDto{
    public createOperationDto(String description, String patient, String doctor, Date date, String time) {
        super(description,patient,doctor, date,time);
    }
}
