package model.dto.ReportDto;

import java.sql.Date;

public class OperationDto extends reportDto{

    public OperationDto(int id, String description,String patient, String doctor, Date date, String time){
        super(id, description, patient, date, time);
        this.setDoctor(doctor);
    }
}
