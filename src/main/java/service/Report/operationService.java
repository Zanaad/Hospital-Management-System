package service.Report;


import model.dto.ReportDto.OperationDto;
import model.dto.ReportDto.createOperationDto;
import model.dto.StaffDto.CreateReceptionistDto;
import model.dto.StaffDto.ReceptionistDto;
import repository.Report.OperationRepository;
import repository.Staff.ReceptionistRepository;
import service.PasswordHasher;

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