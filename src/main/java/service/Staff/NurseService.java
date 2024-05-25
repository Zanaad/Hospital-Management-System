package service.Staff;

import model.User;
import model.dto.LoginUserDto;
import model.dto.StaffDto.CreateNurseDto;
import model.dto.StaffDto.NurseDto;
import model.filter.NurseFilter;
import model.filter.UserFilter;
import repository.Staff.NurseRepository;
import repository.Staff.StaffRepository;
import service.Alerts;
import service.PasswordHasher;

import java.util.List;

public class NurseService extends StaffService {

    public static boolean createNurse(NurseDto nurseData) {
        String id = registerNurseID();
        String password = NurseRepository.generateNursePassword(nurseData.getFirstName());
        String salt = PasswordHasher.generateSalt();
        String passwordHash = PasswordHasher.generateSaltedHash(password, salt);

        CreateNurseDto createNurseDto = new CreateNurseDto(id, nurseData.getFirstName(), nurseData.getLastName(), nurseData.getBirthdate(), nurseData.getPhone(), nurseData.getEmail(), passwordHash, salt, nurseData.getAddress(), nurseData.getDepartment(), nurseData.getUniversity(), nurseData.getStartDate(), nurseData.getEndDate(), nurseData.getBankName(), nurseData.getBankAccount(), nurseData.getRoutingNumber());
        return NurseRepository.createNurse(createNurseDto);
    }

    public static List<NurseDto> filter(NurseFilter filter) {
        return NurseRepository.getByFilter(filter);
    }

    public static String registerNurseID() {
        return NurseRepository.generateNurseID();
    }

    public static boolean login(LoginUserDto loginData) {
        User user = NurseRepository.getNurseByEmail(loginData.getEmail());
        return login(loginData, user);
    }


}
