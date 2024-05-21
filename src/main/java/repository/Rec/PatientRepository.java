package repository.Rec;

import database.DatabaseUtil;
import model.dto.CreateDepartmentDto;
import model.dto.RecDto.CreatePatientDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;


public class PatientRepository {
    public static boolean createPatient(CreatePatientDto patientData) {
        Connection conn = DatabaseUtil.getConnection();
        String query = """
                INSERT INTO patients(patient_firstName,
                                         patient_lastName,
                                         patient_birthdate,
                                         patient_phone,
                                         patient_email,
                                         patient_address,
                                         patient_department,
                                         patient_doctor,
                                         patient_nurse,
                                         patient_date,
                                         patient_payment)
                value(?,?,?,?,?,?,?,?,?,?,?)
                """;
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, patientData.getPFirstName());
            pst.setString(2, patientData.getPLastName());
            pst.setDate(3, patientData.getPBirthdate());
            pst.setString(4, patientData.getPphone());
            pst.setString(5, patientData.getPEmail());
            pst.setString(6, patientData.getPaddress());
            pst.setString(7, patientData.getPdepartment());
            pst.setString(8, patientData.getPdoctor());
            pst.setString(9, patientData.getPnurse());
            pst.setDate(10, patientData.getPdate());
            pst.setInt(11, patientData.getPpayment());

            pst.execute();
            pst.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}

