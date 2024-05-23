package service.Staff;

import model.dto.StaffDto.CreateDoctorDto;
import model.dto.StaffDto.DoctorDto;
import model.filter.UserFilter;
import repository.Staff.DoctorRepository;
import service.PasswordHasher;

import java.util.List;

public class DoctorService {
    public static boolean createDoctor(DoctorDto doctorData) {
        String password = doctorData.getPassword();
        String salt = PasswordHasher.generateSalt();
        String passwordHash = PasswordHasher.generateSaltedHash(password, salt);

        CreateDoctorDto createDoctorDto = new CreateDoctorDto(
                doctorData.getId(),
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

    public static List<DoctorDto> filter(UserFilter filter) {
        return DoctorRepository.getByFilter(filter);
    }
}
