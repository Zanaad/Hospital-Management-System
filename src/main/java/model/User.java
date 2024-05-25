package model;


public class User {
    private String email;
    private String salt;
    private String hashPassword;

    public User(String email, String salt, String hashPassword) {
        this.email = email;
        this.salt = salt;
        this.hashPassword = hashPassword;
    }

    public String getEmail() {
        return email;
    }

    public String getSalt() {
        return salt;
    }

    public String getHashPassword() {
        return hashPassword;
    }
}

