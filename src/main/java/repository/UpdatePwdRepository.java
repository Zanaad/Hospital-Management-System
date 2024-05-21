package repository;

import database.DatabaseUtil;
import model.dto.UpdateUserDto;
import service.PasswordHasher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static service.PasswordHasher.generateSalt;

public class UpdatePwdRepository {
    private String currentPassword;

    public static void addSaltAndHashToAdmins() {
        String selectQuery = "SELECT id, salt, passwordHash FROM admin";
        String updateQuery = "UPDATE admin SET salt = ?, passwordHash = ? WHERE id = ? AND (salt IS NULL OR passwordHash IS NULL)";

        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement selectStatement = connection.prepareStatement(selectQuery); PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {

            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String salt = resultSet.getString("salt");
                String passwordHash = resultSet.getString("passwordHash");

                if (salt == null || passwordHash == null) {
                    salt = PasswordHasher.generateSalt();
                    String password = "defaultPassword";
                    String hashedPassword = PasswordHasher.generateSaltedHash(password, salt);

                    updateStatement.setString(1, salt);
                    updateStatement.setString(2, hashedPassword);
                    updateStatement.setInt(3, id);

                    updateStatement.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkPassword(String userID, String newPassword) {
        String query = "SELECT salt, hashPassword from admin where id=?";
        try {
            Connection con = DatabaseUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String salt = rs.getString("salt");
                String hashPassword = rs.getString("hashPassword");
                return PasswordHasher.compareSaltedHash(newPassword, salt, hashPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updatePassword(UpdateUserDto userDto) {
        String salt = generateSalt();
        String saltedHash = PasswordHasher.generateSaltedHash(userDto.getPasswordHash(), salt);
        String query = "UPDATE admin SET salt = ?, hashPassword = ? WHERE id = ?";
        try {
            Connection con = DatabaseUtil.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, salt);
            pst.setString(2, saltedHash);
            pst.setString(3, userDto.getId());
            int rowsUpdated = pst.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
