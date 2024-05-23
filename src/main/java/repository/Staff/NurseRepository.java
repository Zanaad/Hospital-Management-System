package repository.Staff;

import database.DatabaseUtil;
import model.Staff;
import model.dto.StaffDto.CreateNurseDto;
import model.filter.UserFilter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NurseRepository extends StaffRepository {
    private static final String query = """
            INSERT INTO nurses(nurse_id,nurse_firstName, nurse_lastName, nurse_birthdate, nurse_phone, nurse_email, nurse_hashPassword, nurse_salt, nurse_address, nurse_department, nurse_university, nurse_start, nurse_end, bankName, bankAccount, routingNumber)
            VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

    public static boolean createNurse(CreateNurseDto nurseData) {
        return createStaff(nurseData, query);
    }

    public static List<Staff> getByFilter(UserFilter filter) {
        String filterQuery = "SELECT * FROM nurses WHERE 1=1" + filter.buildQuery();
        return fetchNurses(filterQuery);
    }

    public static List<Staff> getAllNurses() {
        String query = "SELECT * FROM nurses";
        return fetchNurses(query);
    }

    public static List<Staff> fetchNurses(String query) {
        List<Staff> nurses = new ArrayList<>();
        try {
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                Staff nurse = new Staff(result.getInt("nurse_id"), result.getString("nurse_firstName"), result.getString("nurse_department"), result.getString("nurse_phone"), result.getString("nurse_email"), result.getString("nurse_university"), result.getString("nurse_address"));
                nurses.add(nurse);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nurses;
    }
}
