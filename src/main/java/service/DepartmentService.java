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


}
