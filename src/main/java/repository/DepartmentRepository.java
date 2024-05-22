package repository;

import database.DatabaseUtil;
import model.dto.CreateDepartmentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    public static List<String> getAllDepartmentNames() {
        List<String> departments = new ArrayList<>();
        String query = "SELECT department_name FROM departments";

        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                departments.add(resultSet.getString("department_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return departments;
    }

}
