package service.Rec;

import model.Patient;
import model.dto.RecDto.CreatePatientDto;
import model.dto.RecDto.PatientDto;
import model.dto.StaffDto.DoctorDto;
import model.filter.DoctorFilter;
import model.filter.PatientFilter;
import repository.Rec.PatientRepository;
import repository.Staff.DoctorRepository;

import java.util.List;


public class PatientService {
    public static boolean createPatient(PatientDto patientData) {

        CreatePatientDto createPatientDto = new CreatePatientDto(
                patientData.getPfirstName(),
                patientData.getPlastName(),
                patientData.getPbirthdate(),
                patientData.getPphone(),
                patientData.getPemail(),
                patientData.getPaddress(),
                patientData.getPdepartment(),
                patientData.getPdoctor(),
                patientData.getPnurse(),
                patientData.getPdate(),
                patientData.getPpayment()
        );
        return PatientRepository.createPatient(createPatientDto);
    }

    public static List<Patient> filter(PatientFilter filter) {
        return PatientRepository.getByFilter(filter);
    }

}
