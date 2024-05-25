package service.Report;


import model.dto.RecDto.CreatePatientDto;
import model.dto.ReportDto.DonorDto;
import model.dto.ReportDto.createDonorDto;
import repository.Rec.PatientRepository;
import repository.Report.donorRepository;


public class donorService {


    public static boolean createDonor(DonorDto donorData) {
        createDonorDto createDonorDto = new createDonorDto(
                donorData.getPatient(),
                donorData.getBloodGroup(),
                donorData.getAge(),
                donorData.getGender(),
                donorData.getLastDonationDate()

        );
        return donorRepository.createDonor(createDonorDto);
    }
}
