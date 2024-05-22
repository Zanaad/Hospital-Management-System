package repository.Staff;

import database.DatabaseUtil;
import model.Staff;
import model.dto.StaffDto.CreateDoctorDto;
import model.filter.UserFilter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DoctorRepository extends StaffRepository {
    private static final String query = """
             INSERT INTO doctors(doctor_firstName, doctor_lastName, doctor_birthdate, doctor_phone, doctor_email, doctor_hashPassword, doctor_salt, doctor_address, doctor_department, doctor_university, doctor_start, doctor_end, bankName, bankAccount, routingNumber)
             VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

    public static boolean createDoctor(CreateDoctorDto doctorData) {
        return createStaff(doctorData, query);
    }

    public static List<Staff> getByFilter(UserFilter filter) {
        List<Staff> doctors = new ArrayList<>();
        String baseQuery = "SELECT * FROM doctors WHERE 1=1";
        String filterQuery = filter.buildQuery();
        String finalQuery = baseQuery + filterQuery;

        try {
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(finalQuery);
            ResultSet result = pst.executeQuery();

            while (result.next()) {
                Staff doctor = new Staff(result.getInt("doctor_id"), result.getString("doctor_firstName"), result.getString("doctor_department"), result.getString("doctor_phone"), result.getString("doctor_email"), result.getString("doctor_university"), result.getString("doctor_address"));
                doctors.add(doctor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctors;
    }
}