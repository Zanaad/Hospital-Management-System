package repository.Report;


import model.dto.ReportDto.createDeathsDto;

public class DeathRepository extends ReportRepository {
    private static final String query = """
            INSERT INTO (death_description, death_patient, death_date, death_time)
            VALUES (?, ?, ?, ?)
            """;

    public static boolean createDeath(createDeathsDto deathData) {
        return createReport(deathData, query);
    }
}