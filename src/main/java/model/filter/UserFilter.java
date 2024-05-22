package model.filter;

public class UserFilter extends Filter {
    private String firstName;
    private String email;

    public UserFilter(String firstName, String email) {
        this.firstName = firstName;
        this.email = email;
    }

    public String buildQuery() {
        String query = "";
        if (!this.firstName.isEmpty()) {
            query += "firstName like '%" + this.firstName + "%'";
        }
        if (!this.email.isEmpty()) {
            query += "email like '%" + this.email + "%'";
        }
        return query;
    }
}
