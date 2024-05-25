package model.dto.ReportDto;

public class createBedDto {

    private String patient;
    private String bed;

    public createBedDto(String patient, String bed) {

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
