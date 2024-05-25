package model.filter;

public class PatientFilter {
    private String firstName;
    private String lastName;

    public PatientFilter(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String buildQuery() {
        StringBuilder query = new StringBuilder();
        if (firstName != null && !firstName.isEmpty()) {
            query.append("patient_firstName like '%").append(firstName).append("%'");
        }
        if (lastName != null && !lastName.isEmpty()) {
            if (query.length() > 0) {
                query.append(" AND ");
            }
            query.append("patient_lastName like '%").append(lastName).append("%'");
        }
        return !query.isEmpty() ? " AND " + query.toString() : "";
    }
}
