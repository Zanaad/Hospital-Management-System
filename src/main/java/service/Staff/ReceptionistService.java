package service.Staff;

import model.User;
import model.dto.LoginUserDto;
import model.dto.StaffDto.CreateReceptionistDto;
import model.dto.StaffDto.ReceptionistDto;
import model.filter.Filter;
import repository.Staff.ReceptionistRepository;
import service.PasswordHasher;

import java.util.List;

public class ReceptionistService extends StaffService {
    public static boolean createReceptionist(ReceptionistDto receptionistData) {
        String id = registerRecID();
        String password = ReceptionistRepository.generateRecPassword(receptionistData.getFirstName());
        String salt = PasswordHasher.generateSalt();
        String passwordHash = PasswordHasher.generateSaltedHash(password, salt);

        CreateReceptionistDto createReceptionistDto = new CreateReceptionistDto(id, receptionistData.getFirstName(), receptionistData.getLastName(), receptionistData.getBirthdate(), receptionistData.getPhone(), receptionistData.getEmail(), passwordHash, salt, receptionistData.getAddress(), receptionistData.getDepartment(), receptionistData.getUniversity(), receptionistData.getStartDate(), receptionistData.getEndDate(), receptionistData.getBankName(), receptionistData.getBankAccount(), receptionistData.getRoutingNumber());
        return ReceptionistRepository.createReceptionist(createReceptionistDto);
    }

    public static List<ReceptionistDto> filter(Filter filter) {
        return ReceptionistRepository.getByFilter(filter);
    }

    public static String registerRecID() {
        return ReceptionistRepository.generateRecID();
    }

    public static boolean login(LoginUserDto loginData) {
        User user = ReceptionistRepository.getRecByEmail(loginData.getEmail());
        return login(loginData, user);
    }
}
