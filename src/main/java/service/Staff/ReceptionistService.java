package service.Staff;

import model.dto.StaffDto.CreateReceptionistDto;
import model.dto.StaffDto.ReceptionistDto;
import repository.Staff.ReceptionistRepository;
import service.PasswordHasher;

public class ReceptionistService {
    public static boolean createReceptionist(ReceptionistDto receptionistData) {
        String password = receptionistData.getPassword();
        String salt = PasswordHasher.generateSalt();
        String passwordHash = PasswordHasher.generateSaltedHash(password, salt);

        CreateReceptionistDto createReceptionistDto = new CreateReceptionistDto(
                receptionistData.getId(),
                receptionistData.getFirstName(),
                receptionistData.getLastName(),
                receptionistData.getBirthdate(),
                receptionistData.getPhone(),
                receptionistData.getEmail(),
                passwordHash,
                salt,
                receptionistData.getAddress(),
                receptionistData.getDepartment(),
                receptionistData.getUniversity(),
                receptionistData.getStartDate(),
                receptionistData.getEndDate(),
                receptionistData.getBankName(),
                receptionistData.getBankAccount(),
                receptionistData.getRoutingNumber()
        );
        return ReceptionistRepository.createReceptionist(createReceptionistDto);
    }
}
