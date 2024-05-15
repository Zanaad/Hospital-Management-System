package model.dto;

public class CreateDepartmentDto {
    private String departmentName;
    private String departmentDescription;

    public CreateDepartmentDto(String departmentName, String departmentDescription) {
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

