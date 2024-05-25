package model.dto.ReportDto;

import java.sql.Date;

public class DonorDto {
        private String patient;
        private int age;
        private String bloodGroup;
        private String gender;
        private Date lastDonationDate;


        public DonorDto(String patient,String bloodGroup, int age, String gender, Date lastDonationDate) {

            this.patient=patient;
            this.age = age;
            this.bloodGroup = bloodGroup;
            this.gender = gender;
            this.lastDonationDate = lastDonationDate;
        }


    public String getPatient() {
        return patient;
    }

    public int getAge() {
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
