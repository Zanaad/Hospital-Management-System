package model.dto.StaffDto;

import java.sql.Date;

public class DoctorDto extends StaffDto {
    private String specialty;

    public DoctorDto(String id, String firstName, String lastName, Date birthdate, String phone, String email, String password, String address, String department, String university, String specialty, Date startDate, Date endDate, String bankName, String bankAccount, String routingNumber) {
        super(id, firstName, lastName, birthdate, phone, email, password, address, department, university, startDate, endDate, bankName, bankAccount, routingNumber);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
