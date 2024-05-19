package repository.Staff;

import model.dto.StaffDto.CreateDoctorDto;


public class DoctorRepository extends StaffRepository {
    private static final String query = """
             INSERT INTO doctors(doctor_firstName, doctor_lastName, doctor_birthdate, doctor_phone, doctor_email, doctor_hashPassword, doctor_salt, doctor_address, doctor_department, doctor_university, doctor_start, doctor_end, bankName, bankAccount, routingNumber)
             VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

    public static boolean createDoctor(CreateDoctorDto doctorData) {
        return createStaff(doctorData, query);
    }
}
