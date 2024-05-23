package model.dto;

public class DepartmentDto {
    private String id;
    private String departmentName;
    private String departmentDescription;

    public DepartmentDto(String id, String departmentName, String departmentDescription) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
    }

    public String getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }
}
