package service;


import model.dto.LoginUserDto;
import model.User;

public class UserService {
   public static User login(LoginUserDto loginData) {
        // Implement your logic to authenticate the user using the provided username and password
        // For demonstration purposes, let's assume we have a predefined user with different roles
        if (loginData.getUsername().equals("doctor") && loginData.getPassword().equals("doctor")) {
            // If credentials match for doctor user, return a User object with role "Doctor"
            return new User("doctor", "doctor", "Doctor");
        } else if (loginData.getUsername().equals("nurse") && loginData.getPassword().equals("nurse")) {
            // If credentials match for nurse user, return a User object with role "Nurse"
            return new User("nurse", "nurse", "Nurse");
        } else if (loginData.getUsername().equals("receptionist") && loginData.getPassword().equals("receptionist")) {
            // If credentials match for receptionist user, return a User object with role "Receptionist"
            return new User("receptionist", "receptionist", "Receptionist");
        } else if (loginData.getUsername().equals("admin") && loginData.getPassword().equals("admin")) {
            // If credentials match for admin user, return a User object with role "Admin"
            return new User("admin", "admin", "Admin");
        } else {
            // If credentials don't match, return null
            return null;
        }
    }

    public static boolean createUser(User user) {
        // Implement your logic to create a new user
        // For demonstration purposes, let's assume the user creation is successful
        return true;
    }


}




