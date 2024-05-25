package repository.Staff;

import database.DatabaseUtil;
import model.dto.CreateDepartmentDto;
import model.dto.DepartmentDto;
import model.filter.DepFilter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {
    public static boolean createDepartment(CreateDepartmentDto departmentData) {
        Connection conn = DatabaseUtil.getConnection();
        String query = """
                INSERT INTO departments(department_id,department_name, department_description, nrDoctors, nrNurses)
                value(?,?,?,?,?)
                """;
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, departmentData.getId());
            pst.setString(2, departmentData.getDepartmentName());
            pst.setString(3, departmentData.getDepartmentDescription());
            pst.setInt(4, departmentData.getNrDoctors());
            pst.setInt(5, departmentData.getNrNurses());

            pst.execute();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static List<DepartmentDto> getByFilter(DepFilter filter) {
        String filterQuery = "SELECT * FROM departments WHERE 1=1" + filter.buildQuery();
        return fetchDepartments(filterQuery);
    }

    public static List<DepartmentDto> getAllDepartments() {
        String query = "SELECT * FROM departments";
        return fetchDepartments(query);
    }

    public static List<DepartmentDto> fetchDepartments(String query) {
        List<DepartmentDto> departments = new ArrayList<>();
        try {
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                DepartmentDto dep = new DepartmentDto(result.getString("department_id"), result.getString("department_name"), result.getString("department_description"), result.getInt("nrDoctors"), result.getInt("nrNurses"));
                departments.add(dep);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

    //get department names to add in the combo boxes dynamically
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
