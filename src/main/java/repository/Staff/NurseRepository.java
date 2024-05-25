package repository.Staff;

import database.DatabaseUtil;
import model.User;
import model.dto.StaffDto.CreateNurseDto;
import model.dto.StaffDto.NurseDto;
import model.filter.NurseFilter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NurseRepository extends StaffRepository {
    private static final String query = """
            INSERT INTO nurses(id,firstName, lastName, birthdate, phone, email, hashPassword, salt, address, department, university, contractStart, contractEnd, bankName, bankAccount, routingNumber)
            VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

    public static boolean createNurse(CreateNurseDto nurseData) {
        return createStaff(nurseData, query);
    }
    public static User getNurseByEmail(String email) {
        return getStaffByEmail(email, "nurses");
    }
    public static List<NurseDto> getByFilter(NurseFilter filter) {
        String filterQuery = "SELECT * FROM nurses WHERE 1=1" + filter.buildQuery();
        return fetchNurses(filterQuery);
    }

    public static List<NurseDto> getAllNurses() {
        String query = "SELECT * FROM nurses";
        return fetchNurses(query);
    }

    public static List<NurseDto> fetchNurses(String query) {
        List<NurseDto> nurses = new ArrayList<>();
        try {
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                NurseDto nurse = new NurseDto(result.getString("id"), result.getString("firstName"), result.getString("lastName"), result.getDate("birthdate"), result.getString("phone"), result.getString("email"), result.getString("hashPassword"), result.getString("address"), result.getString("department"), result.getString("university"), result.getDate("contractStart"), result.getDate("contractEnd"), result.getString("bankName"), result.getString("bankAccount"), result.getString("routingNumber"));
                nurses.add(nurse);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nurses;
    }

    public static String generateNurseID() {
        String prefix = "NID-";
        String tableName = "nurses";
        return generateID(prefix, tableName);
    }

    public static String generateNursePassword(String firstName) {
        String id = generateNurseID();
        return generatePassword(id, firstName);
    }
}
