package repository.Staff;

import database.DatabaseUtil;
import model.dto.StaffDto.CreateReceptionistDto;
import model.dto.StaffDto.ReceptionistDto;
import model.filter.UserFilter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReceptionistRepository extends StaffRepository {
    private static final String query = """
            INSERT INTO receptionists(id, firstName, lastName, birthdate, phone, email, hashPassword, salt, address, department, university, contractStart, contractEnd, bankName, bankAccount, routingNumber)
            VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

    public static boolean createReceptionist(CreateReceptionistDto receptionistData) {
        return createStaff(receptionistData, query);
    }

    public static List<ReceptionistDto> getByFilter(UserFilter filter) {
        String filterQuery = "SELECT * FROM receptionists WHERE 1=1" + filter.buildQuery();
        return fetchReceptionists(filterQuery);
    }

    public static List<ReceptionistDto> getAllReceptionists() {
        String query = "SELECT * FROM receptionists";
        return fetchReceptionists(query);
    }

    public static List<ReceptionistDto> fetchReceptionists(String query) {
        List<ReceptionistDto> receptionists = new ArrayList<>();
        try {
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                ReceptionistDto receptionist = new ReceptionistDto(result.getString("id"), result.getString("firstName"), result.getString("lastName"), result.getDate("birthdate"), result.getString("phone"), result.getString("email"), result.getString("hashPassword"), result.getString("address"), result.getString("department"), result.getString("university"), result.getDate("contractStart"), result.getDate("contractEnd"), result.getString("bankName"), result.getString("bankAccount"), result.getString("routingNumber"));
                receptionists.add(receptionist);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return receptionists;
    }

    public static String generateRecID() {
        String prefix = "RID-";
        String tableName = "receptionists";
        return generateID(prefix, tableName);
    }

    public static String generateRecPassword(String firstName) {
        String id = generateRecID();
        return generatePassword(id, firstName);
    }
}

