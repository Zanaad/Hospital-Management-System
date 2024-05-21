package repository;

import database.DatabaseUtil;
import model.dto.CreateDepartmentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DepartmentRepository {
    public static boolean createDepartment(CreateDepartmentDto departmentData) {
        Connection conn = DatabaseUtil.getConnection();
        String query = """
                INSERT INTO departments(department_name, department_description)
                value(?,?)
                """;
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, departmentData.getDepartmentName());
            pst.setString(2, departmentData.getDepartmentDescription());
            pst.execute();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
