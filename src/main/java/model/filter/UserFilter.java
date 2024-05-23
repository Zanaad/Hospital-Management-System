package model.filter;

public abstract class UserFilter {
    private String firstName;
    private String email;

    public UserFilter(String firstName, String email) {
        this.firstName = firstName;
        this.email = email;
    }

    public String buildBaseQuery() {
        StringBuilder query = new StringBuilder();
        if (firstName != null && !firstName.isEmpty()) {
            query.append("firstName like '%").append(firstName).append("%'");
        }
        if (email != null && !email.isEmpty()) {
            if (query.length() > 0) {
                query.append(" AND ");
            }
            query.append("email like '%").append(email).append("%'");
        }
        return query.toString();
    }

    public abstract String buildQuery();
}
