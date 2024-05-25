package repository.Report;


import database.DatabaseUtil;
import model.dto.ReportDto.createDeathsDto;
import model.dto.ReportDto.createOperationDto;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeathRepository extends ReportRepository {
    public static boolean createDeath(createDeathsDto deathData) {
        Connection conn = DatabaseUtil.getConnection();
        String query = """
                INSERT INTO deaths(
                                         death_description,
                                         death_patient,
                                         death_date,
                                         death_time)
                value(?,?,?,?)
                """;

        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,deathData.getDescription());
            pst.setString(2,deathData.getPatient());
            pst.setDate(3,deathData.getDate());
            pst.setString(4, deathData.getTime());


            pst.execute();
            pst.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}