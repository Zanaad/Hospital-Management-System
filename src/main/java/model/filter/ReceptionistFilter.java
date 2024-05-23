package model.filter;

public class ReceptionistFilter extends UserFilter {
    private String id;

    public ReceptionistFilter(String firstName, String email, String id) {
        super(firstName, email);
        this.id = id;
    }

    @Override
    public String buildQuery() {
        StringBuilder query = new StringBuilder(buildBaseQuery());
        if (id != null && !id.isEmpty()) {
            if (!query.isEmpty()) {
                query.append(" AND ");
            }
            query.append("id like '%").append(id).append("%'");
        }
        return !query.isEmpty() ? " AND " + query.toString() : "";
    }
}
