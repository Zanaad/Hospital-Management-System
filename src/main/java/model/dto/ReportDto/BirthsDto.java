package model.dto.ReportDto;

import java.sql.Date;

public class BirthsDto {
    private String birth_description;
    private String birth_patient;
    private String birth_newborn;
    private Date birth_date;
    private String birth_time;

    public BirthsDto(String birth_description, String birth_patient, String birth_newborn, Date birth_date, String birth_time) {
        this.birth_description = birth_description;
        this.birth_patient = birth_patient;
        this.birth_newborn = birth_newborn;
        this.birth_date = birth_date;
        this.birth_time = birth_time;
    }




    public String getBirth_description() {
        return birth_description;
    }

    public void setBirth_description(String birth_description) {
        this.birth_description = birth_description;
    }

    public String getBirth_patient() {
        return birth_patient;
    }

    public void setBirth_patient(String birth_patient) {
        this.birth_patient = birth_patient;
    }

    public String getBirth_newborn() {
        return birth_newborn;
    }

    public void setBirth_newborn(String birth_newborn) {
        this.birth_newborn = birth_newborn;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getBirth_time() {
        return birth_time;
    }

    public void setBirth_time(String birth_time) {
        this.birth_time = birth_time;
    }
}
