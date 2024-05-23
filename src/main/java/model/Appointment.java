package model;

import java.sql.Date;

public class Appointment
{
    private String id;
    private String firstName;
    private String department;
    private String doctor;
    private String nurse;
    private String phone;
    private String address;
    private Date date;

    private String hour;

    public Appointment(String id, String firstName, String department, String doctor, String nurse, String phone, String address, Date date,String hour) {
        this.id = id;
        this.firstName = firstName;
        this.department = department;
        this.doctor = doctor;
        this.nurse = nurse;
        this.phone = phone;
        this.address = address;
        this.date = date;
        this.hour=hour;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getDepartment() {
        return department;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getNurse() {
        return nurse;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Date getDate() {
        return date;
    }
    public String getHour() {
        return hour;
    }

}
