package model;

public class Staff {
    private int id;
    private String firstName;
    private String department;
    private String phone;
    private String email;
    private String university;
    private String address;

    public Staff(int id, String firstName, String department, String phone, String email, String university, String address) {
        this.id = id;
        this.firstName = firstName;
        this.department = department;
        this.phone = phone;
        this.email = email;
        this.university = university;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getDepartment() {
        return department;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getUniversity() {
        return university;
    }

    public String getAddress() {
        return address;
    }
}
