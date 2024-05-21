package service.Rec;

import model.dto.CreateDepartmentDto;
import model.dto.RecDto.CreatePatientDto;
import model.dto.RecDto.PatientDto;
import model.dto.StaffDto.CreateReceptionistDto;
import model.dto.StaffDto.ReceptionistDto;
import repository.Rec.PatientRepository;
import repository.Staff.ReceptionistRepository;
import service.PasswordHasher;

public class PatientService
{
    public static boolean createPatient(PatientDto patientData) {

        CreatePatientDto createPatientDto = new CreatePatientDto(
                patientData.getPFirstName(),
                patientData.getPLastName(),
                patientData.getPBirthdate(),
                patientData.getPphone(),
                patientData.getPEmail(),
                patientData.getPaddress(),
                patientData.getPdepartment(),
                patientData.getPdoctor(),
                patientData.getPnurse(),
                patientData.getPdate(),
                patientData.getPpayment()
        );
        return PatientRepository.createPatient(createPatientDto);
    }
}
