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

        try (
                Connection connection = DatabaseUtil.getConnection();
                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {

            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String salt = resultSet.getString("salt");
                String passwordHash = resultSet.getString("passwordHash");

                // Check if salt or passwordHash is empty
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
}
