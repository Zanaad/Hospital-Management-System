package model.dto.StaffDto;

import java.sql.Date;

public class NurseDto extends StaffDto {
    public NurseDto(String id, String firstName, String lastName, Date birthdate, String phone, String email, String password, String address, String department, String university, Date startDate, Date endDate, String bankName, String bankAccount, String routingNumber) {
        super(id, firstName, lastName, birthdate, phone, email, password, address, department, university, startDate, endDate, bankName, bankAccount, routingNumber);
    }
}
