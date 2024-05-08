package service;

import model.dto.CreateStaffDto;
import model.dto.StaffDto;
import repository.StaffRepository;

public class StaffService {
    public static boolean createStaff(StaffDto staffData) {
        String password = staffData.getPassword();
        String salt = PasswordHasher.generateSalt();
        String passwordHash = PasswordHasher.generateSaltedHash(password, salt);

        CreateStaffDto createStaffDto = new CreateStaffDto(
                staffData.getFirstName(),
                staffData.getLastName(),
                staffData.getBirthdate(),
                staffData.getPhone(),
                staffData.getEmail(),
                passwordHash,
                salt,
                staffData.getAddress(),
                staffData.getPosition(),
                staffData.getDepartment(),
                staffData.getSpecialization(),
                staffData.getStartDate(),
                staffData.getEndDate(),
                staffData.getBankName(),
                staffData.getBankAccount(),
                staffData.getRoutingNumber()
        );
        return StaffRepository.createStaff(createStaffDto);
    }
}
