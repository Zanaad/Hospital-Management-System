package service;

import database.DatabaseUtil;
import model.dto.CreateDepartmentDto;
import model.dto.DepartmentDto;
import repository.DepartmentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    public static boolean createDepartment(DepartmentDto departmentData) {
        CreateDepartmentDto createDepartmentDto = new CreateDepartmentDto(departmentData.getDepartmentName(), departmentData.getDepartmentDescription());
        return DepartmentRepository.createDepartment(createDepartmentDto);
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
