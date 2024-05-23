package repository.Staff;

import database.DatabaseUtil;
import model.dto.StaffDto.CreateDoctorDto;
import model.dto.StaffDto.DoctorDto;
import model.filter.DoctorFilter;
import model.filter.UserFilter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepository extends StaffRepository {
    private static final String query = """
             INSERT INTO doctors(id, firstName, lastName, birthdate, phone, email, hashPassword, salt, address, department, university, contractStart, contractEnd, bankName, bankAccount, routingNumber)
             VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

    public static boolean createDoctor(CreateDoctorDto doctorData) {
        return createStaff(doctorData, query);
    }

    public static List<DoctorDto> getByFilter(DoctorFilter filter) {
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
                DoctorDto doctor = new DoctorDto(result.getString("id"), result.getString("firstName"), result.getString("lastName"), result.getDate("birthdate"), result.getString("phone"), result.getString("email"), result.getString("hashPassword"), result.getString("address"), result.getString("department"), result.getString("university"), result.getDate("contractStart"), result.getDate("contractEnd"), result.getString("bankName"), result.getString("bankAccount"), result.getString("routingNumber"));
                doctors.add(doctor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctors;
    }
}
