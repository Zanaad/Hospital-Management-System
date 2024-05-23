package service.Report;

import model.dto.ReportDto.BirthsDto;
import model.dto.ReportDto.createBirthDto;

import repository.Report.BirthRepository;

public class birthService {
    public static boolean createBirth(BirthsDto birthData) {

        createBirthDto createBirthDto = new createBirthDto(
                birthData.getBirthID(),
                birthData.getBirth_description(),
                birthData.getBirth_patient(),
                birthData.getBirth_newborn(),
                birthData.getBirth_date(),
                birthData.getBirth_time()
        );
        return BirthRepository.createBirth(createBirthDto);
    }
}