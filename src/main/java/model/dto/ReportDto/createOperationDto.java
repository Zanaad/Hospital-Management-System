package model.dto.ReportDto;

import java.sql.Date;


public class createOperationDto extends createReportDto {
    public createOperationDto(String id, String description, String patient, String doctor, Date date, String time) {
        super(id, description, patient, date, time);
        this.setDoctor(doctor);
    }
}