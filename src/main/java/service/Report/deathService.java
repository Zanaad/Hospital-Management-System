package service.Report;

import model.dto.ReportDto.*;

import repository.Report.DeathRepository;

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