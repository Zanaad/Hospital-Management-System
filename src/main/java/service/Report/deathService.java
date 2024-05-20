package service.Report;

import model.dto.ReportDto.*;

import repository.Report.BirthRepository;
import repository.Report.DeathRepository;
import repository.Report.OperationRepository;

public class deathService {
    public static boolean createDeath(DeathsDto deathData) {


        createDeathsDto createDeathDto = new createDeathsDto(
                deathData.getDescription(),
                deathData.getPatient(),
                deathData.getDate(),
                deathData.getTime()
        );
        return DeathRepository.createDeath(createDeathDto);
    }
}