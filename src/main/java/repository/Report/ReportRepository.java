package repository.Report;

import database.DatabaseUtil;
import model.dto.ReportDto.createBirthDto;
import model.dto.ReportDto.createReportDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReportRepository {
    public static boolean createReport(createReportDto reportData, String query) {
        Connection conn = DatabaseUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(2, reportData.getDescription());
            pst.setString(3, reportData.getPatient());
            pst.setString(4, reportData.getDoctor());
            pst.setDate(5, reportData.getDate());
            pst.setString(6, reportData.getTime());

            // Check if reportData is an instance of CreateBirthDto and set newBorn field if it is

            if (reportData instanceof createBirthDto) {
                pst.setString(7, ((createBirthDto) reportData).getNewBorn());
            }

            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
