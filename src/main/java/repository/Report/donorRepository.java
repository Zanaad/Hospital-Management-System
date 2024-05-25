package repository.Report;

import database.DatabaseUtil;
import model.dto.ReportDto.createBirthDto;
import model.dto.ReportDto.createDonorDto;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class donorRepository {

    public static boolean createDonor(createDonorDto donorData) {
        Connection conn = DatabaseUtil.getConnection();
        String query = """
                INSERT INTO donors(      donor_patient,
                                         donor_bloodGroup,
                                         donor_age,
                                         donor_gender,
                                         donor_lastDonation)
                value(?,?,?,?,?)
                """;

        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,donorData.getPatient());
            pst.setString(2,donorData.getBloodGroup());
            pst.setInt(3,donorData.getAge());
            pst.setString(4,donorData.getGender());
            pst.setDate(5,donorData.getLastDonationDate());


            pst.execute();
            pst.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}