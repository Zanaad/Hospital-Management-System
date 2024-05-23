package repository.Staff;

import model.dto.StaffDto.CreateReceptionistDto;

public class ReceptionistRepository extends StaffRepository {
    private static final String query = """
            INSERT INTO receptionists(receptionist_id, receptionist_firstName, receptionist_lastName, receptionist_birthdate, receptionist_phone, receptionist_email, receptionist_hashPassword, receptionist_salt, receptionist_address, receptionist_department, receptionist_university, receptionist_start, receptionist_end, bankName, bankAccount, routingNumber)
            VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

    public static boolean createReceptionist(CreateReceptionistDto receptionistData) {
        return createStaff(receptionistData, query);
    }
}
