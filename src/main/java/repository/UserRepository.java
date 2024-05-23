///*package repository;
//
//import database.DatabaseUtil;
//import model.User;
//import model.dto.CreateUserDto;
//import model.filter.UserFilter;
//import service.DatabaseUtil;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserRepository {
//
//    public static boolean create(CreateUserDto userData) {
//        String query = """
//                INSERT INTO USER (firstName, lastName, email, salt, passwordHash)
//                VALUES (?, ?, ?, ?, ?)
//                """;
//        try (Connection conn = DatabaseUtil.getConnection();
//             PreparedStatement pst = conn.prepareStatement(query)) {
//            pst.setString(1, userData.getFirstName());
//            pst.setString(2, userData.getLastName());
//            pst.setString(3, userData.getEmail());
//            pst.setString(4, userData.getSalt());
//            pst.setString(5, userData.getPasswordHash());
//            pst.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();  // Ideally, use a logging framework
//            return false;
//        }
//    }
//
//    public static User getByEmail(String email) {
//        String query = "SELECT * FROM USER WHERE email = ? LIMIT 1";
//        try (Connection connection = DBConnector.getConnection();
//             PreparedStatement pst = connection.prepareStatement(query)) {
//            pst.setString(1, email);
//            try (ResultSet result = pst.executeQuery()) {
//                if (result.next()) {
//                    return getFromResultSet(result);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();  // Ideally, use a logging framework
//        }
//        return null;
//    }
//
//    public static List<User> getByFilter(UserFilter filter) {
//        StringBuilder query = new StringBuilder("SELECT * FROM USER WHERE 1 = 1");
//        String filterQuery = filter.buildQuery();
//        query.append(filterQuery);
//
//        List<User> users = new ArrayList<>();
//        try (Connection connection = DBConnector.getConnection();
//             PreparedStatement pst = connection.prepareStatement(query.toString());
//             ResultSet result = pst.executeQuery()) {
//            while (result.next()) {
//                users.add(getFromResultSet(result));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();  // Ideally, use a logging framework
//        }
//        return users;
//    }
//
//    private static User getFromResultSet(ResultSet result) {
//        try {
//            int id = result.getInt("id");
//            String firstName = result.getString("firstName");
//            String lastName = result.getString("lastName");
//            String email = result.getString("email");
//            String salt = result.getString("salt");
//            String passwordHash = result.getString("passwordHash");
//            return new User(id, firstName, lastName, email, salt, passwordHash);
//        } catch (SQLException e) {
//            e.printStackTrace();  // Ideally, use a logging framework
//            return null;
//        }
//    }
//}
//*/
//
//package repository;
//
//import database.DatabaseUtil;
//import model.User;
//
//
//import model.dto.UserDto;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserRepository {
//
//    public static boolean createUser(UserDto userData) {
//        String query = """
//                INSERT INTO users (firstName, lastName, email, password)
//                VALUES (?, ?, ?, ?)
//                """;
//        try (Connection conn = DatabaseUtil.getConnection();
//             PreparedStatement pst = conn.prepareStatement(query)) {
//
//            pst.setString(1, userData.getEmail());
//            pst.setString(2, userData.getPassword());
//
//            int rowsAffected = pst.executeUpdate();
//            return rowsAffected > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();  // Ideally, use a logging framework
//            return false;
//        }
//    }
//
//    public static User getUserByEmail(String email) {
//        String query = "SELECT * FROM users WHERE email = ?";
//        try (Connection connection = DatabaseUtil.getConnection();
//             PreparedStatement pst = connection.prepareStatement(query)) {
//            pst.setString(1, email);
//            try (ResultSet rs = pst.executeQuery()) {
//                if (rs.next()) {
//                    return extractUserFromResultSet(rs);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();  // Ideally, use a logging framework
//        }
//        return null;
//    }
//
//
//    private static User extractUserFromResultSet(ResultSet rs) throws SQLException {
//
//        String email = rs.getString("email");
//        String password = rs.getString("password");
//
//        // You may extract other user attributes from the ResultSet here
//        return new User( email, password);
//    }
//
//    // Add other methods as needed, e.g., updateUser, deleteUser, getUsersByFilter, etc.
//}
