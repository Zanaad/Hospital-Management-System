package model.dto;

public class UpdateUserDto {
    private int id;
    private String passwordHash;

    public UpdateUserDto(int id, String passwordHash) {
        this.id = id;
        this.passwordHash = passwordHash;
    }

    public int getId() {
        return id;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}