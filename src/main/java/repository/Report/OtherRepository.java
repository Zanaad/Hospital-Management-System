package repository.Report;


import database.DatabaseUtil;
import model.dto.ReportDto.createDeathsDto;
import model.dto.ReportDto.createOthersDto;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OtherRepository extends ReportRepository {
    public static boolean createOther(createOthersDto otherData) {
        Connection conn = DatabaseUtil.getConnection();
        String query = """
                INSERT INTO others(
                                         other_description,
                                         other_patient,
                                         other_date,
                                         other_time)
                value(?,?,?,?)
                """;

        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,otherData.getDescription());
            pst.setString(2,otherData.getPatient());
            pst.setDate(3,otherData.getDate());
            pst.setString(4,otherData.getTime());


            pst.execute();
            pst.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}