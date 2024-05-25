package service.Report;

import model.dto.ReportDto.bedDto;
import model.dto.ReportDto.createBedDto;
import repository.Report.BedsRepository;

public class bedService {
    public static boolean createBed(bedDto bedsData) {

        createBedDto createBedDto = new createBedDto(
               bedsData.getPatient(),
               bedsData.getBed()
        );
        return BedsRepository.createBeds(createBedDto);
    }
}
