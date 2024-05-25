package repository.Report;


import database.DatabaseUtil;
import model.dto.ReportDto.createOperationDto;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class OperationRepository extends ReportRepository {
    public static boolean createOperation(createOperationDto operationData) {
        Connection conn = DatabaseUtil.getConnection();
        String query = """
                INSERT INTO operations(
                                         opDescription,
                                         opPatient,
                                         opDoctor,
                                         opDate,
                                         opTime)
                value(?,?,?,?,?)
                """;

        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, operationData.getDescription());
            pst.setString(2, operationData.getPatient());
            pst.setString(3, operationData.getDoctor());
            pst.setDate(4, operationData.getDate());
            pst.setString(5, operationData.getTime());


            pst.execute();
            pst.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}