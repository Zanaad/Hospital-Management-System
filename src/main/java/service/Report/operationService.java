package service.Report;


import model.dto.ReportDto.OperationDto;
import model.dto.ReportDto.createOperationDto;
import repository.Report.OperationRepository;

public class operationService {
    public static boolean createOperation(OperationDto operationData) {


        createOperationDto createOperationDto = new createOperationDto(
                operationData.getDescription(),
                operationData.getPatient(),
                operationData.getDoctor(),
                operationData.getDate(),
                operationData.getTime()
                );
        return OperationRepository.createOperation(createOperationDto);
    }
}