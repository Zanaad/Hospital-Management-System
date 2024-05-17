package service.Staff;

import model.dto.StaffDto.CreateNurseDto;
import model.dto.StaffDto.NurseDto;
import repository.Staff.NurseRepository;
import service.PasswordHasher;

public class NurseService {

    public static boolean createNurse(NurseDto nurseData) {
        String password = nurseData.getPassword();
        String salt = PasswordHasher.generateSalt();
        String passwordHash = PasswordHasher.generateSaltedHash(password, salt);

        CreateNurseDto createNurseDto = new CreateNurseDto(
                nurseData.getFirstName(),
                nurseData.getLastName(),
                nurseData.getBirthdate(),
                nurseData.getPhone(),
                nurseData.getEmail(),
                passwordHash,
                salt,
                nurseData.getAddress(),
                nurseData.getDepartment(),
                nurseData.getSpecialization(),
                nurseData.getStartDate(),
                nurseData.getEndDate(),
                nurseData.getBankName(),
                nurseData.getBankAccount(),
                nurseData.getRoutingNumber()
        );
        return NurseRepository.createNurse(createNurseDto);
    }
}
