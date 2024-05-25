package model.filter;

public class NurseFilter extends Filter {
    private String department;

    public NurseFilter(String firstName, String email, String department) {
        super(firstName, email);
        this.department = department;
    }

    @Override
    public String buildQuery() {
        StringBuilder query = new StringBuilder(super.buildBaseQuery());
        if (department != null && !department.isEmpty()) {
            if (!query.isEmpty()) {
                query.append(" AND ");
            }
            query.append("department like '%").append(department).append("%'");
        }
        return !query.isEmpty() ? " AND " + query.toString() : "";
    }
}
