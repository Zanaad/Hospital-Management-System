package model.dto;

public class UpdateUserDto {
    private String id;
    private String passwordHash;

    public UpdateUserDto(String id, String passwordHash) {
        this.id = id;
        this.passwordHash = passwordHash;
    }

    public String getId() {
        return id;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}