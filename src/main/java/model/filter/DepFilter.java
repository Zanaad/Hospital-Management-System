package model.filter;

public class DepFilter extends Filter {
    private String departmentName;

    public DepFilter(String firstName, String email, String departmentName) {
        super(firstName, email);
        this.departmentName = departmentName;
    }

    @Override
    public String buildQuery() {
        StringBuilder query = new StringBuilder(buildBaseQuery());
        if (departmentName != null && !departmentName.isEmpty()) {
            if (!query.isEmpty()) {
                query.append(" AND ");
            }
            query.append("department_name LIKE '%").append(departmentName).append("%'");
        }
        return !query.isEmpty() ? " AND " + query.toString() : "";
    }
}
