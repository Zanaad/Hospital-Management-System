package model;

import java.sql.Date;

public class BloodDonors {
    private int id;
    private String patient;
    private String bloodGroup;
    private int age;
    private String gender;
    private Date lastDonationDate;

    // Constructor
    public BloodDonors(int id, String patient, String bloodGroup, int age, String gender, Date lastDonationDate) {
        this.id=id;
        this.patient = patient;
        this.bloodGroup = bloodGroup;
        this.age = age;
        this.gender = gender;
        this.lastDonationDate = lastDonationDate;
    }

    // Getters
    public int getId(){return id;}
    public String getPatient() { return patient; }
    public String getBloodGroup() { return bloodGroup; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public Date getLastDonationDate() { return lastDonationDate; }
}
