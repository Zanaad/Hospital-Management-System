package model.dto;

public class DepartmentDto {
    private String departmentName;
    private String departmentDescription;

    public DepartmentDto(String departmentName, String departmentDescription) {
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }
}
