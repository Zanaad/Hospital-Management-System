package repository.Staff;

import database.DatabaseUtil;
import model.dto.StaffDto.CreateStaffDto;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StaffRepository {
    public static boolean createStaff(CreateStaffDto staffData, String query) {
        Connection conn = DatabaseUtil.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, staffData.getId());
            pst.setString(2, staffData.getFirstName());
            pst.setString(3, staffData.getLastName());
            pst.setDate(4, staffData.getBirthdate());
            pst.setString(5, staffData.getPhone());
            pst.setString(6, staffData.getEmail());
            pst.setString(7, staffData.getHashPassword());
            pst.setString(8, staffData.getSalt());
            pst.setString(9, staffData.getAddress());
            pst.setString(10, staffData.getDepartment());
            pst.setString(11, staffData.getUniversity());
            pst.setDate(12, staffData.getStartDate());
            pst.setDate(13, staffData.getEndDate());
            pst.setString(14, staffData.getBankName());
            pst.setString(15, staffData.getBankAccount());
            pst.setString(16, staffData.getRoutingNumber());
            pst.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
}
