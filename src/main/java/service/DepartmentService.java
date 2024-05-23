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
    public static boolean createDepartment(DepartmentDto depData) {
        int nrDoctors = 0;
        int nrNurses = 0;
        CreateDepartmentDto createDepartmentDto = new CreateDepartmentDto(depData.getId(), depData.getDepartmentName(), depData.getDepartmentDescription(), nrDoctors, nrNurses);
        return DepartmentRepository.createDepartment(createDepartmentDto);
    }
}
