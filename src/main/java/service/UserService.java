package service;


import model.dto.LoginUserDto;
import model.User;

public class UserService {
   public static User login(LoginUserDto loginData) {

        if (loginData.getUsername().equals("doctor") && loginData.getPassword().equals("doctor"))
        {"

            return new User("doctor", "doctor", "Doctor");
        } else if (loginData.getUsername().equals("nurse") && loginData.getPassword().equals("nurse")) {

            return new User("nurse", "nurse", "Nurse");
        } else if (loginData.getUsername().equals("receptionist") && loginData.getPassword().equals("receptionist")) {

            return new User("receptionist", "receptionist", "Receptionist");
        } else if (loginData.getUsername().equals("admin") && loginData.getPassword().equals("admin")) {

            return new User("admin", "admin", "Admin");
        } else {

            return null;
        }
    }


    public static boolean createUser(User user) {
        // Implement your logic to create a new user
        // For demonstration purposes, let's assume the user creation is successful
        return true;
    }


}




