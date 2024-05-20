package repository.Report;


import model.dto.ReportDto.createOperationDto;


public class OperationRepository extends ReportRepository {
    private static final String query = """
            INSERT INTO (opDescription, opPatient, opDoctor, opData, opTime)
            VALUES (?, ?, ?, ?, ?)
            """;

    public static boolean createOperation(createOperationDto receptionistData) {
        return createReport(receptionistData, query);
    }
}