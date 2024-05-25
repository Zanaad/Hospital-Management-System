package service.Staff;

import model.User;
import model.dto.LoginUserDto;
import service.Alerts;
import service.PasswordHasher;

public class StaffService {

    static boolean login(LoginUserDto loginData, User user) {
        if (user == null) {
            Alerts.errorMessage("User not found");
            return false;
        }
        String password = loginData.getPassword();
        String salt = user.getSalt();
        String passwordHash = user.getHashPassword();
        return PasswordHasher.compareSaltedHash(password, salt, passwordHash);
    }
}
