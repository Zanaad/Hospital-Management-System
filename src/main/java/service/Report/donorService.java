package service.Report;


import model.dto.ReportDto.DonorDto;
import model.dto.ReportDto.createDonorDto;
import repository.Report.donorRepository;


public class donorService {


    public static boolean createDonor(DonorDto donorData) {
        String query = "INSERT INTO donors (blood_group, age, gender, last_donation_date) VALUES (?, ?, ?, ?)";
        createDonorDto createDonorDto = new createDonorDto(
                donorData.getBloodGroup(),
                donorData.getAge(),
                donorData.getGender(),
                donorData.getLastDonationDate()
        );
        return donorRepository.createDonor(createDonorDto, query);
    }
}
