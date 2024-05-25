package repository.Report;

import database.DatabaseUtil;
import model.dto.ReportDto.createBirthDto;
import model.dto.ReportDto.createOperationDto;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BirthRepository extends ReportRepository {
    public static boolean createBirth(createBirthDto birthData) {
        Connection conn = DatabaseUtil.getConnection();
        String query = """
                INSERT INTO births(
                                         birth_description,
                                         birth_patient,
                                         birth_newborn,
                                         birth_date,
                                         birth_time)
                value(?,?,?,?,?)
                """;

        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,birthData.getDescription());
            pst.setString(2,birthData.getPatient());
            pst.setString(3,birthData.getNewBorn());
            pst.setDate(4,birthData.getDate());
            pst.setString(5,birthData.getTime());


            pst.execute();
            pst.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
