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
            INSERT INTO receptionists(receptionist_id, receptionist_firstName, receptionist_lastName, receptionist_birthdate, receptionist_phone, receptionist_email, receptionist_hashPassword, receptionist_salt, receptionist_address, receptionist_department, receptionist_university, receptionist_start, receptionist_end, bankName, bankAccount, routingNumber)
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
                ReceptionistDto receptionist = new ReceptionistDto(result.getString("receptionist_id"), result.getString("receptionist_firstName"), result.getString("receptionist_lastName"), result.getDate("receptionist_birthdate"), result.getString("receptionist_phone"), result.getString("receptionist_email"), result.getString("receptionist_hashPassword"), result.getString("receptionist_address"), result.getString("receptionist_department"), result.getString("receptionist_university"), result.getDate("receptionist_start"), result.getDate("receptionist_end"), result.getString("bankName"), result.getString("bankAccount"), result.getString("routingNumber"));
                receptionists.add(receptionist);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return receptionists;
    }
}
