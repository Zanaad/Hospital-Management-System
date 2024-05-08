package repository;

import database.DatabaseUtil;
import model.dto.CreateStaffDto;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StaffRepository {
    public static boolean createStaff(CreateStaffDto staffData) {
        Connection conn = DatabaseUtil.getConnection();
        String query = """
                INSERT INTO doctors(doctor_firstName, doctor_lastName,doctor_birthdate,doctor_phone,doctor_email,doctor_hashPassword,doctor_salt,doctor_address,doctor_department,doctor_specialization,doctor_start,doctor_end,bankName,bankAccount,routingNumber)
                VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?,?)
                """;
        String query1 = """
                INSERT INTO nurses(nurse_firstName, nurse_lastName,nurse_birthdate,nurse_phone,nurse_email,nurse_hashPassword,nurse_salt,nurse_address,nurse_department,nurse_specialization,nurse_start,nurse_end,bankName,bankAccount,routingNumber)
                VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?,?)
                """;
        String query2 = """
                INSERT INTO receptionists(receptionist_firstName, receptionist_lastName,receptionist_birthdate,receptionist_phone,receptionist_email,receptionist_hashPassword,receptionist_salt,receptionist_address,receptionist_department,receptionist_specialization,receptionist_start,receptionist_end,bankName,bankAccount,routingNumber)
                VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?,?)
                """;
        String query3 = """
                INSERT INTO accountants(accountant_firstName, accountant_lastName,accountant_birthdate,accountant_phone,accountant_email,accountant_hashPassword,accountant_salt,accountant_address,accountant_department,accountant_specialization,accountant_start,accountant_end,bankName,bankAccount,routingNumber)
                VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?,?)
                """;

        try {
            PreparedStatement pst = null;
            String position = staffData.getPosition();
            switch (position) {
                case "Doctor":
                    pst = conn.prepareStatement(query);
                    break;
                case "Nurse":
                    pst = conn.prepareStatement(query1);
                    break;
                case "Receptionist":
                    pst = conn.prepareStatement(query2);
                    break;
                case "Accountant":
                    pst = conn.prepareStatement(query3);
                    break;
                default:
                    break;
            }

            pst.setString(1, staffData.getFirstName());
            pst.setString(2, staffData.getLastName());
            pst.setDate(3, staffData.getBirthdate());
            pst.setString(4, staffData.getPhone());
            pst.setString(5, staffData.getEmail());
            pst.setString(6, staffData.getHashPassword());
            pst.setString(7, staffData.getSalt());
            pst.setString(8, staffData.getAddress());
            pst.setString(9, staffData.getDepartment());
            pst.setString(10, staffData.getSpecialization());
            pst.setDate(11, staffData.getStartDate());
            pst.setDate(12, staffData.getEndDate());
            pst.setString(13, staffData.getBankName());
            pst.setString(14, staffData.getBankAccount());
            pst.setString(15, staffData.getRoutingNumber());
            pst.execute();
            pst.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
