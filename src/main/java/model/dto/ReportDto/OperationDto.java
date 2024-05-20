package model.dto.ReportDto;

import java.sql.Date;

public class OperationDto extends reportDto{

    public OperationDto(String description,String patient, String doctor, Date date, String time){
        super(description, patient, doctor, date, time);
    }

}
