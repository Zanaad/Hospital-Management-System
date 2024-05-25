package model.dto.ReportDto;

public class bedDto {

    private String patient;
    private String bed;

    public bedDto(String patient, String bed) {

        this.patient = patient;
        this.bed = bed;
    }



    public String getPatient() {
        return patient;
    }

    public String getBed() {
        return bed;
    }
}
