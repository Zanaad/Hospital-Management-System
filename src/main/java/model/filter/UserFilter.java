package model.filter;

public class UserFilter extends Filter {
    private String firstName;
    private String email;

    public UserFilter(String firstName, String email) {
        this.firstName = firstName;
        this.email = email;
    }

    public String buildQuery() {
        StringBuilder query = new StringBuilder();
        if (firstName != null && !firstName.isEmpty()) {
            query.append(" AND doctor_firstName LIKE '%").append(firstName).append("%'");
        }
        if (email != null && !email.isEmpty()) {
            query.append(" AND doctor_email LIKE '%").append(email).append("%'");
        }
        return query.toString();
    }
}
