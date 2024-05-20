package service.Report;

import model.dto.ReportDto.BirthsDto;
import model.dto.ReportDto.OperationDto;
import model.dto.ReportDto.createBirthDto;

import repository.Report.BirthRepository;
import repository.Report.OperationRepository;

public class birthService {
    public static boolean createBirth(BirthsDto birthData) {


        createBirthDto createBirthDto = new createBirthDto(
                birthData.getDescription(),
                birthData.getPatient(),
                birthData.getNewBorn(),
                birthData.getDate(),
                birthData.getTime()
        );
        return BirthRepository.createBirth(createBirthDto);
    }
}