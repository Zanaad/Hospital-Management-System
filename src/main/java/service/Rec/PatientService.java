package service.Rec;

import model.dto.RecDto.CreatePatientDto;
import model.dto.RecDto.PatientDto;
import repository.Rec.PatientRepository;


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
