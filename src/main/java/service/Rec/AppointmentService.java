package service.Rec;

import model.dto.RecDto.AppointmentDto;
import model.dto.RecDto.CreateAppointmentDto;
import repository.Rec.AppointmentRepository;
import repository.Rec.PatientRepository;


public class AppointmentService
{
    public static boolean createAppointment(AppointmentDto appointmentData) {

        CreateAppointmentDto createAppointmentDto = new CreateAppointmentDto(
                appointmentData.getAppID(),
                appointmentData.getPFirstName(),
                appointmentData.getPLastName(),
                appointmentData.getAdescription(),
                appointmentData.getPdepartment(),
                appointmentData.getPdoctor(),
                appointmentData.getPnurse(),
                appointmentData.getPphone(),
                appointmentData.getPaddress(),
                appointmentData.getPdate(),
                appointmentData.getPhour()
        );
        return AppointmentRepository.createAppointment(createAppointmentDto);
    }
}
