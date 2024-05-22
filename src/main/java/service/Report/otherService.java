package service.Report;


import model.dto.ReportDto.OthersDto;
import model.dto.ReportDto.createOthersDto;
import repository.Report.OtherRepository;

public class otherService {
    public static boolean createOther(OthersDto otherData) {

        createOthersDto createOthersDto = new createOthersDto(
                otherData.getID(),
                otherData.getDescription(),
                otherData.getPatient(),
                otherData.getDate(),
                otherData.getTime()
        );
        return OtherRepository.createOther(createOthersDto);
    }
}