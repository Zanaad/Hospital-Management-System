package repository.Rec;

import database.DatabaseUtil;
import model.Patient;
import model.dto.CreateDepartmentDto;
import model.dto.RecDto.CreatePatientDto;
import model.dto.StaffDto.DoctorDto;
import model.filter.DoctorFilter;
import model.filter.PatientFilter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


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
            pst.setString(11, patientData.getPpayment());
            pst.execute();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static List<Patient> getByFilter(PatientFilter filter) {
        String filterQuery = "SELECT * FROM patients WHERE 1=1" + filter.buildQuery();
        return fetchPatient(filterQuery);
    }

    public static List<Patient> fetchPatient(String query) {
        List<Patient> patients = new ArrayList<>();
        try {
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet result = pst.executeQuery();

            while (result.next()) {
                Patient patient = new Patient(result.getInt("patient_id"),
                        result.getString("patient_firstName"),
                        result.getString("patient_lastName"),
                        result.getString("patient_department"),
                        result.getString("patient_doctor"),
                        result.getString("patient_nurse"),
                        result.getString("patient_phone"),
                        result.getString("patient_email"),
                        result.getString("patient_address"),
                        result.getString("patient_payment"));
                patients.add(patient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patients;
    }

}

