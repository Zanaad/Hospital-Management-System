package repository.Report;

import model.dto.ReportDto.createBirthDto;

public class BirthRepository extends ReportRepository {
    private static final String query = """
            INSERT INTO (biDescription, biPatient, biNewBorn, biDate, biTime)
            VALUES (?, ?, ?, ?, ?)
            """;

    public static boolean createBirth(createBirthDto birthData) {
        return createReport(birthData, query);
    }
}
