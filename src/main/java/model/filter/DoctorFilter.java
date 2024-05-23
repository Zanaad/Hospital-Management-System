package model.filter;

public class DoctorFilter extends UserFilter {
    private String specialty;

    public DoctorFilter(String firstName, String email, String specialty) {
        super(firstName, email);
        this.specialty = specialty;
    }

    @Override
    public String buildQuery() {
        StringBuilder query = new StringBuilder(buildBaseQuery());
        if (specialty != null && !specialty.isEmpty()) {
            if (!query.isEmpty()) {
                query.append(" AND ");
            }
            query.append("specialty like '%").append(specialty).append("%'");
        }
        return !query.isEmpty() ? " AND " + query.toString() : "";
    }
}
