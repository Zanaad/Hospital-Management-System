package repository.Report;

import database.DatabaseUtil;
import model.dto.ReportDto.createBedDto;
import model.dto.ReportDto.createBirthDto;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BedsRepository {
    public static boolean createBeds(createBedDto bedData) {
        Connection conn = DatabaseUtil.getConnection();
        String query = """
                INSERT INTO beds(
                                         bed_patient,
                                         bed_number
                                         )
                value(?,?)
                """;

        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,bedData.getPatient());
            pst.setString(2,bedData.getBed());

            pst.execute();
            pst.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
