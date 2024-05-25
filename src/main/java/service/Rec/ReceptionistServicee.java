package service.Rec;

import app.SessionManager;
import model.User;
import model.dto.ChangePasswordDto;
import model.dto.LoginUserDto;
import model.dto.UpdateUserPasswordDto;
import repository.Rec.ReceptionistRepositoryy;
import repository.Staff.AdminRepository;
import service.Alerts;
import service.PasswordHasher;

public class ReceptionistServicee
{
    public static boolean changePassword(ChangePasswordDto user) {
        UpdateUserPasswordDto userPasswordInfo = AdminRepository.getUserPasswordInfo(user.getEmail());
        if (userPasswordInfo == null) {
            return false;
        }
        String storedPasswordHash = userPasswordInfo.getPasswordHash();
        String salt = userPasswordInfo.getSalt();
        if (!PasswordHasher.compareSaltedHash(user.getCurrentPassword(), salt, storedPasswordHash)) {
            Alerts.errorMessage("Credentials are not correct");
            return false;
        }
        return AdminRepository.changePwd(user, salt);
    }

    /*public static boolean login(LoginUserDto loginData) {
        User user = ReceptionistRepositoryy.getReceptionistByEmail(loginData.getEmail());
        boolean isLogin = login(loginData, user);
        if (isLogin) {
            SessionManager.setCurrentUser(user);
        }
        return isLogin;

    }

     */

    public static void logout() {
        SessionManager.clearSession();
    }

    public static boolean updateReceptionistDetails(User user) {
        return AdminRepository.updateAdminDetails(user);
    }
}

