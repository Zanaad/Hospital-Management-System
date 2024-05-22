package service;

import model.dto.ChangePasswordDto;
import model.dto.UpdateUserPasswordDto;
import repository.ChangePwdRepository;

public class ChangePwdService {

    public static boolean changePassword(ChangePasswordDto ChangePasswordDto) {
        UpdateUserPasswordDto userPasswordInfo = ChangePwdRepository.getUserPasswordInfo(ChangePasswordDto.getEmail());
        if (userPasswordInfo == null) {
            return false;
        }
        String storedPasswordHash = userPasswordInfo.getPasswordHash();
        String salt = userPasswordInfo.getSalt();
        if (!PasswordHasher.compareSaltedHash(ChangePasswordDto.getCurrentPassword(), salt, storedPasswordHash)) {
            AlertMessage.errorMessage("Credentials are not correct");
            return false;
        }

        return ChangePwdRepository.changePwd(ChangePasswordDto, salt);
    }
}

