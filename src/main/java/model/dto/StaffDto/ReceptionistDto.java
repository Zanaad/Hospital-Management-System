package model.dto.StaffDto;

import java.sql.Date;

public class ReceptionistDto extends StaffDto {
    public ReceptionistDto(String firstName, String lastName, Date birthdate, String phone, String email, String password, String address, String department, String specialization, Date startDate, Date endDate, String bankName, String bankAccount, String routingNumber) {
        super(firstName, lastName, birthdate, phone, email, password, address, department, specialization, startDate, endDate, bankName, bankAccount, routingNumber);
    }
}
