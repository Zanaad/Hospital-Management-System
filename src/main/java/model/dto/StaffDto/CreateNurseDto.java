package model.dto.StaffDto;

import java.sql.Date;

public class CreateNurseDto extends CreateStaffDto {
    public CreateNurseDto(String firstName, String lastName, Date birthdate, String phone, String email, String hashPassword, String salt, String address, String department, String specialization, Date startDate, Date endDate, String bankName, String bankAccount, String routingNumber) {
        super(firstName, lastName, birthdate, phone, email, hashPassword, salt, address, department, specialization, startDate, endDate, bankName, bankAccount, routingNumber);
    }
}
