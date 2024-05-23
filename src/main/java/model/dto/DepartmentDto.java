package model.dto;

public class DepartmentDto {
    private String id;
    private String departmentName;
    private String departmentDescription;
    private int nrDoctors;
    private int nrNurses;

    public DepartmentDto(String id, String departmentName, String departmentDescription, int nrDoctors, int nrNurses) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
        this.nrDoctors = nrDoctors;
        this.nrNurses = nrNurses;
    }

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

    public int getNrDoctors() {
        return nrDoctors;
    }

    public int getNrNurses() {
        return nrNurses;
    }
}
