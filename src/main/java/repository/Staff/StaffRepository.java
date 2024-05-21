package repository.Staff;

import database.DatabaseUtil;
import model.dto.StaffDto.CreateStaffDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StaffRepository {
    public static boolean createStaff(CreateStaffDto staffData, String query) {
        Connection conn = DatabaseUtil.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, staffData.getFirstName());
            pst.setString(2, staffData.getLastName());
            pst.setDate(3, staffData.getBirthdate());
            pst.setString(4, staffData.getPhone());
            pst.setString(5, staffData.getEmail());
            pst.setString(6, staffData.getHashPassword());
            pst.setString(7, staffData.getSalt());
            pst.setString(8, staffData.getAddress());
            pst.setString(9, staffData.getDepartment());
            pst.setString(10, staffData.getUniversity());
            pst.setDate(11, staffData.getStartDate());
            pst.setDate(12, staffData.getEndDate());
            pst.setString(13, staffData.getBankName());
            pst.setString(14, staffData.getBankAccount());
            pst.setString(15, staffData.getRoutingNumber());
            pst.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
}
