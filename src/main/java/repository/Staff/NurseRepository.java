package repository.Staff;

import model.dto.StaffDto.CreateNurseDto;

public class NurseRepository extends StaffRepository {
    private static final String query = """
            INSERT INTO nurses(nurse_firstName, nurse_lastName, nurse_birthdate, nurse_phone, nurse_email, nurse_hashPassword, nurse_salt, nurse_address, nurse_department, nurse_specialization, nurse_start, nurse_end, bankName, bankAccount, routingNumber)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

    public static boolean createNurse(CreateNurseDto nurseData) {
        return createStaff(nurseData, query);
    }
}
