package repository.Staff;

import database.DatabaseUtil;
import model.User;
import model.dto.ChangePasswordDto;
import model.dto.UpdateUserPasswordDto;
import service.PasswordHasher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminRepository extends StaffRepository {
    public static void addSaltAndHashToAdmins() {
        String selectQuery = "SELECT id, salt, hashPassword FROM admin";
        String updateQuery = "UPDATE admin SET salt = ?, hashPassword = ? WHERE id = ?";

        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String salt = resultSet.getString("salt");
                String passwordHash = resultSet.getString("hashPassword");

                if (salt == null || passwordHash == null) {
                    salt = PasswordHasher.generateSalt();
                    String password = "defaultPassword";
                    passwordHash = PasswordHasher.generateSaltedHash(password, salt);

                    updateStatement.setString(1, salt);
                    updateStatement.setString(2, passwordHash);
                    updateStatement.setInt(3, id);
                    updateStatement.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static UpdateUserPasswordDto getUserPasswordInfo(String email) {
        String query = "SELECT salt, passwordHash FROM admin WHERE email=?";
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
        String query = "UPDATE admin SET passwordHash=? WHERE email=?";
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

    public static boolean updateAdminDetails(User user) {
        String query = "UPDATE admin SET firstName=?, lastName=?, email=?, address=? WHERE id=?";
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

    public static User getAdminByEmail(String email) {
        return getStaffByEmail(email, "admin");
    }
}