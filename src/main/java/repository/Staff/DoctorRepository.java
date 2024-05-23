package repository.Staff;

import database.DatabaseUtil;
import model.dto.StaffDto.CreateDoctorDto;
import model.dto.StaffDto.DoctorDto;
import model.filter.UserFilter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepository extends StaffRepository {
    private static final String query = """
             INSERT INTO doctors(doctor_id, doctor_firstName, doctor_lastName, doctor_birthdate, doctor_phone, doctor_email, doctor_hashPassword, doctor_salt, doctor_address, doctor_department, doctor_university, doctor_start, doctor_end, bankName, bankAccount, routingNumber)
             VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

    public static boolean createDoctor(CreateDoctorDto doctorData) {
        return createStaff(doctorData, query);
    }

    public static List<DoctorDto> getByFilter(UserFilter filter) {
        String filterQuery = "SELECT * FROM doctors WHERE 1=1" + filter.buildQuery();
        return fetchDoctors(filterQuery);
    }

    public static List<DoctorDto> getAllDoctors() {
        String query = "SELECT * FROM doctors";
        return fetchDoctors(query);
    }

    public static List<DoctorDto> fetchDoctors(String query) {
        List<DoctorDto> doctors = new ArrayList<>();
        try {
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet result = pst.executeQuery();

            while (result.next()) {
                DoctorDto doctor = new DoctorDto(result.getString("doctor_id"), result.getString("doctor_firstName"), result.getString("doctor_lastName"), result.getDate("doctor_birthdate"), result.getString("doctor_phone"), result.getString("doctor_email"), result.getString("doctor_hashPassword"), result.getString("doctor_address"), result.getString("doctor_department"), result.getString("doctor_university"), result.getDate("doctor_start"), result.getDate("doctor_end"), result.getString("bankName"), result.getString("bankAccount"), result.getString("routingNumber"));
                doctors.add(doctor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctors;
    }
}
