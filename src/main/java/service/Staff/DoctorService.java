package service.Staff;

import model.User;
import model.dto.LoginUserDto;
import model.dto.StaffDto.CreateDoctorDto;
import model.dto.StaffDto.DoctorDto;
import model.filter.DoctorFilter;
import model.filter.UserFilter;
import repository.Staff.DoctorRepository;
import service.Alerts;
import service.PasswordHasher;

import java.util.List;

public class DoctorService extends StaffService {
    public static boolean createDoctor(DoctorDto doctorData) {
        String id = registerDoctorID();
        String password = DoctorRepository.generateDocPassword(doctorData.getFirstName());
        String salt = PasswordHasher.generateSalt();
        String passwordHash = PasswordHasher.generateSaltedHash(password, salt);

        CreateDoctorDto createDoctorDto = new CreateDoctorDto(
                id,
                doctorData.getFirstName(),
                doctorData.getLastName(),
                doctorData.getBirthdate(),
                doctorData.getPhone(),
                doctorData.getEmail(),
                passwordHash,
                salt,
                doctorData.getAddress(),
                doctorData.getDepartment(),
                doctorData.getUniversity(),
                doctorData.getStartDate(),
                doctorData.getEndDate(),
                doctorData.getBankName(),
                doctorData.getBankAccount(),
                doctorData.getRoutingNumber()
        );
        return DoctorRepository.createDoctor(createDoctorDto);
    }

    public static boolean login(LoginUserDto loginData) {
        User user = DoctorRepository.getDoctorByEmail(loginData.getEmail());
        return login(loginData, user);
    }

    public static List<DoctorDto> filter(DoctorFilter filter) {
        return DoctorRepository.getByFilter(filter);
    }

    public static String registerDoctorID() {
        return DoctorRepository.generateDoctorID();
    }
}
