package model.dto.ReportDto;

import java.sql.Date;

public class createDonorDto {

    private String age;
    private String bloodGroup;
    private String gender;
    private Date lastDonationDate;


    public createDonorDto(String bloodGroup, String age, String gender, Date lastDonationDate) {
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
        this.lastDonationDate = lastDonationDate;
    }

    public String getAge() {
        return age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getGender() {
        return gender;
    }

    public Date getLastDonationDate() {
        return lastDonationDate;
    }
}
