package model.filter;

public class UserFilter extends Filter {
    private String firstName;
    private String email;
    private String userType;

    public UserFilter(String firstName, String email, String userType) {
        this.firstName = firstName;
        this.email = email;
        this.userType = userType;
    }

    @Override
    public String buildQuery() {
        StringBuilder query = new StringBuilder();
        String prefix = "";
        if (userType != null) {
            switch (userType.toLowerCase()) {
                case "doctor":
                    prefix = "doctor_";
                    break;
                case "nurse":
                    prefix = "nurse_";
                    break;
                case "receptionist":
                    prefix = "receptionist_";
                    break;
                default:
                    throw new IllegalArgumentException("Unknown user type: " + userType);
            }
        }

        if (firstName != null && !firstName.isEmpty()) {
            query.append(" AND ").append(prefix).append("firstName LIKE '%").append(firstName).append("%'");
        }
        if (email != null && !email.isEmpty()) {
            query.append(" AND ").append(prefix).append("email LIKE '%").append(email).append("%'");
        }

        return query.toString();
    }
}
