package repository.Report;

import database.DatabaseUtil;
import model.dto.ReportDto.createDonorDto;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class donorRepository {

    public static boolean createDonor(createDonorDto donorData, String query) {
        Connection conn = DatabaseUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, donorData.getBloodGroup());
            pst.setString(2, donorData.getAge());
            pst.setString(3, donorData.getGender());
            pst.setDate(4, donorData.getLastDonationDate());

            pst.execute();
            pst.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}