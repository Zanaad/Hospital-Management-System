package repository.Report;


import model.dto.ReportDto.createOthersDto;

public class OtherRepository extends ReportRepository {
    private static final String query = """
            INSERT INTO (other_description, other_patient, other_date, other_time)
            VALUES (?, ?, ?, ?)
            """;

    public static boolean createOther(createOthersDto otherData) {
        return createReport(otherData, query);
    }
}