package model.dto.StaffDto;

import java.sql.Date;

public class CreateReceptionistDto extends CreateStaffDto {
    public CreateReceptionistDto(String id, String firstName, String lastName, Date birthdate, String phone, String email, String hashPassword, String salt, String address, String department, String university, Date startDate, Date endDate, String bankName, String bankAccount, String routingNumber) {
        super(id, firstName, lastName, birthdate, phone, email, hashPassword, salt, address, department, university, startDate, endDate, bankName, bankAccount, routingNumber);
    }
}
