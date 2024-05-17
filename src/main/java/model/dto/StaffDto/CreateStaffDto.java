package model.dto.StaffDto;

import java.sql.Date;

public class CreateStaffDto {
    private String firstName;
    private String lastName;
    private Date birthdate;
    private String phone;
    private String email;
    private String hashPassword;
    private String salt;
    private String address;
    private String department;
    private String specialization;
    private Date startDate;
    private Date endDate;
    private String bankName;
    private String bankAccount;
    private String routingNumber;

    public CreateStaffDto(String firstName, String lastName, Date birthdate, String phone, String email, String hashPassword, String salt, String address, String department, String specialization, Date startDate, Date endDate, String bankName, String bankAccount, String routingNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.phone = phone;
        this.email = email;
        this.hashPassword = hashPassword;
        this.salt = salt;
        this.address = address;
        this.department = department;
        this.specialization = specialization;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bankName = bankName;
        this.bankAccount = bankAccount;
        this.routingNumber = routingNumber;
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

    public String getHashPassword() {
        return hashPassword;
    }

    public String getSalt() {
        return salt;
    }

    public String getAddress() {
        return address;
    }

    public String getDepartment() {
        return department;
    }

    public String getSpecialization() {
        return specialization;
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
}