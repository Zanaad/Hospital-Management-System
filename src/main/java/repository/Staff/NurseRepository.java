package repository.Staff;

import database.DatabaseUtil;
import model.User;
import model.dto.ChangePasswordDto;
import model.dto.StaffDto.CreateNurseDto;
import model.dto.StaffDto.NurseDto;
import model.dto.UpdateUserPasswordDto;
import model.filter.NurseFilter;
import service.PasswordHasher;

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

    public static boolean updateNurseDetails(User user) {
        String query = "UPDATE nurses SET firstName=?, lastName=?, email=?, address=? WHERE id=?";
        try {
            Connection con = DatabaseUtil.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, user.getFirstName());
            pst.setString(2, user.getLastName());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getAddress());
            pst.setString(5, user.getId());
            int rowsUpdated = pst.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static String generateNurseID() {
        String prefix = "NID-";
        String tableName = "nurses";
        return generateID(prefix, tableName);
    }

    public static String generateNursePassword(String firstName) {
        String id = generateNurseID();
        System.out.println(generatePassword(firstName, id));
        return generatePassword(firstName, id);
    }

    public static List<String> getAllNursesNames() {
        String query = "SELECT firstName FROM nurses";
        return getStaffNames(query);
    }

    public static boolean deleteNurse(String id) {
        String query = "DELETE FROM nurses WHERE id = ?";
        return deleteStaff(query, id);
    }

    public static boolean updateNurse(NurseDto nurse) {
        String query = "UPDATE nurses SET firstName = ?, lastName = ?, department = ?, phone = ?, email = ?, university = ?, address = ?, bankName = ? WHERE id = ?";
        return updateStaff(nurse, query);
    }


    public static UpdateUserPasswordDto getUserPasswordInfo(String email) {
        String query = "SELECT salt, passwordHash FROM nurses WHERE email=?";
        try {
            Connection con = DatabaseUtil.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String salt = rs.getString("salt");
                String passwordHash = rs.getString("passwordHash");
                return new UpdateUserPasswordDto(email, passwordHash, salt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean changePwd(ChangePasswordDto ChangePasswordDto, String salt) {
        String query = "UPDATE nurses SET passwordHash=? WHERE email=?";
        try {
            Connection con = DatabaseUtil.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, PasswordHasher.generateSaltedHash(ChangePasswordDto.getNewPassword(), salt));
            pst.setString(2, ChangePasswordDto.getEmail());
            int rowsUpdated = pst.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
