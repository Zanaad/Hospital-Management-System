package repository.Report;

import database.DatabaseUtil;
import model.dto.ReportDto.createReportDto;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReportRepository {
    public static boolean createReport(createReportDto reportData, String query) {
        Connection conn = DatabaseUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, reportData.getDescription());
            pst.setString(2, reportData.getPatient());
            pst.setString(3,reportData.getDoctor() );
            pst.setDate(4, reportData.getDate());
            pst.setString(5, reportData.getTime());

            pst.execute();
            pst.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}