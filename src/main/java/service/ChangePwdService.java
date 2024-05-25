package service;

import model.dto.ChangePasswordDto;
import model.dto.UpdateUserPasswordDto;
import repository.ChangePwdRepository;

public class ChangePwdService {

    public static boolean changePassword(ChangePasswordDto user) {
        UpdateUserPasswordDto userPasswordInfo = ChangePwdRepository.getUserPasswordInfo(user.getEmail());
        if (userPasswordInfo == null) {
            return false;
        }
        String storedPasswordHash = userPasswordInfo.getPasswordHash();
        String salt = userPasswordInfo.getSalt();
        if (!PasswordHasher.compareSaltedHash(user.getCurrentPassword(), salt, storedPasswordHash)) {
            Alerts.errorMessage("Credentials are not correct");
            return false;
        }
        return ChangePwdRepository.changePwd(user, salt);
    }
}

