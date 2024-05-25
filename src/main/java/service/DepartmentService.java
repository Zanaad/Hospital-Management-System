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

    public static void updateDepTable(String depName) {
        String countDocs = "select count(id) from doctors where department=?";
        String countNurses = "select count(id) from nurses where department=?";
        int nrDoctors = CountStaffService.getCount(countDocs, depName);
        int nrNurses = CountStaffService.getCount(countNurses, depName);

        String query = "UPDATE departments SET nrDoctors=?, nrNurses=? WHERE department_name=?";
        try {
            Connection con = DatabaseUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, nrDoctors);
            ps.setInt(2, nrNurses);
            ps.setString(3, depName);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
