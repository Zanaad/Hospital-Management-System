package service;

import model.dto.CreateDepartmentDto;
import model.dto.DepartmentDto;
import model.dto.StaffDto;
import repository.DepartmentRepository;

public class DepartmentService {
    public static boolean createDepartment(DepartmentDto departmentData) {
        CreateDepartmentDto createDepartmentDto = new CreateDepartmentDto(departmentData.getDepartmentName(), departmentData.getDepartmentDescription());
        return DepartmentRepository.createDepartment(createDepartmentDto);
    }
}
