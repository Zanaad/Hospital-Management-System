package repository.Rec;

import database.DatabaseUtil;
import model.dto.CreateDepartmentDto;
import model.dto.RecDto.CreateAppointmentDto;
import model.dto.RecDto.CreatePatientDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;


public class AppointmentRepository {
    public static boolean createAppointment(CreateAppointmentDto appointmentData) {
        Connection conn = DatabaseUtil.getConnection();
        String query = """
                INSERT INTO appointments( appointment_id,
                                          appointment_firstName,
                                          appointment_lastName,
                                          appointment_description,
                                          appointment_department,
                                          appointment_doctor,
                                          appointment_nurse,
                                          appointment_phone,
                                          appointment_address,
                                          appointment_date,
                                          appointment_hour 
                
                )
                value(?,?,?,?,?,?,?,?,?,?,?)
                """;
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, appointmentData.getAppID());
            pst.setString(2, appointmentData.getPFirstName());
            pst.setString(3, appointmentData.getPLastName());
            pst.setString(4, appointmentData.getAdescription());
            pst.setString(5, appointmentData.getPdepartment());
            pst.setString(6, appointmentData.getPdoctor());
            pst.setString(7, appointmentData.getPnurse());
            pst.setString(8, appointmentData.getPphone());
            pst.setString(9, appointmentData.getPaddress());
            pst.setDate(10, appointmentData.getPdate());
            pst.setString(11, appointmentData.getPhour());

            pst.execute();
            pst.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}

