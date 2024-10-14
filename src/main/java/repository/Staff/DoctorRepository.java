package repository.Staff;

import database.DatabaseUtil;
import model.User;
import model.dto.StaffDto.CreateDoctorDto;
import model.dto.StaffDto.DoctorDto;
import model.filter.DoctorFilter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepository extends StaffRepository {
    private static final String query = """
             INSERT INTO doctors(id, firstName, lastName, birthdate, phone, email, hashPassword, salt, address, department, university, specialty, contractStart, contractEnd, bankName, bankAccount, routingNumber)
             VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

    public static boolean createDoctor(CreateDoctorDto doctorData) {
        return createStaff(doctorData, query);
    }

    public static User getDoctorByEmail(String email) {
        return getStaffByEmail(email, "doctors");
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
                DoctorDto doctor = new DoctorDto(result.getString("id"), result.getString("firstName"), result.getString("lastName"), result.getDate("birthdate"), result.getString("phone"), result.getString("email"), result.getString("hashPassword"), result.getString("address"), result.getString("department"), result.getString("university"), result.getString("specialty"), result.getDate("contractStart"), result.getDate("contractEnd"), result.getString("bankName"), result.getString("bankAccount"), result.getString("routingNumber"));
                doctors.add(doctor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public static String generateDoctorID() {
        String prefix = "DID-";
        String tableName = "doctors";
        return generateID(prefix, tableName);
    }

    public static String generateDocPassword(String firstName) {
        String id = generateDoctorID();
        System.out.println(generatePassword(firstName, id));
        return generatePassword(firstName, id);
    }

    public static List<String> getAllDoctorsNames() {
        String query = "SELECT firstName FROM doctors";
        return getStaffNames(query);
    }

    public static boolean deleteDoctor(String id) {
        String query = "DELETE FROM doctors WHERE id = ?";
        return deleteStaff(query, id);
    }

    public static boolean updateDoctor(DoctorDto doctor) {
        String query = "UPDATE doctors SET firstName = ?, lastName = ?, department = ?, phone = ?, email = ?, university = ?, address = ?, specialty = ? WHERE id = ?";
        return updateStaff(doctor, query);
    }
}
