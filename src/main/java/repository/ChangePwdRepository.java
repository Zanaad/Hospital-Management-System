package repository;

import database.DatabaseUtil;
import model.dto.ChangePasswordDto;
import model.dto.UpdateUserPasswordDto;
import service.PasswordHasher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChangePwdRepository {

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
}
