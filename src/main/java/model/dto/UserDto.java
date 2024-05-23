package model.dto;

public class UserDto {
    private String email;
    private String password;



    public UserDto( String password,String email) {
        this.email = email;
        this.password = password;

    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}