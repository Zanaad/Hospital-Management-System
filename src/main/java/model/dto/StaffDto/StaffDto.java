package model.dto.StaffDto;

import java.sql.Date;

public class StaffDto {
    private String id;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private String phone;
    private String email;
    private String password;
    private String address;
    private String department;
    private String university;
    private Date startDate;
    private Date endDate;
    private String bankName;
    private String bankAccount;
    private String routingNumber;

    public StaffDto(String id, String firstName, String lastName, Date birthdate, String phone, String email, String password, String address, String department, String university, Date startDate, Date endDate, String bankName, String bankAccount, String routingNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.address = address;
        this.department = department;
        this.university = university;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bankName = bankName;
        this.bankAccount = bankAccount;
        this.routingNumber = routingNumber;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getDepartment() {
        return department;
    }

    public String getUniversity() {
        return university;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }
}