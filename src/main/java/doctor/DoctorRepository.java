/*package doctor;



import database.DatabaseUtil;
import model.doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorRepository {
    private DatabaseUtil dbHandler;

    public DoctorRepository() {
        this.dbHandler = new DatabaseUtil();
    }

    public doctor getDoctorByUsernameAndPassword(String username, String password) {
        Connection connection = dbHandler.getConnection();
        doctor doctor = null;

        String query = "SELECT * FROM doctors WHERE username = ? AND hashPassword = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                doctor = new doctor(
                        rs.getInt("doctorId"),
                        rs.getString("username"),
                        rs.getString("hashPassword")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doctor;
    }
}
}
*/
