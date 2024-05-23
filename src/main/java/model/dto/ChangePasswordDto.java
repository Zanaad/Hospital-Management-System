package model.dto;

public class ChangePasswordDto {
    private String email;
    private String currentPassword;
    private String newPassword;
    private String confirmNewPassword;

    public ChangePasswordDto(String email, String currentPassword, String newPassword, String confirmNewPassword) {
        this.email = email;
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
        this.confirmNewPassword = confirmNewPassword;
    }

    public String getEmail() {
        return email;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

}