package model.dto.RecDto;

import java.sql.Date;

public class CreatePatientDto {
    private String PfirstName;
    private String PlastName;
    private Date Pbirthdate;
    private String Pphone;
    private String Pemail;
    private String Paddress;
    private String Pdepartment;
    private String Pdoctor;
    private String Pnurse;
    private Date Pdate;
    private String Ppayment;

    public CreatePatientDto(String pfirstName, String plastName, Date pbirthdate, String pphone, String pemail, String paddress, String pdepartment, String pdoctor, String pnurse, Date pdate, String ppayment) {
        PfirstName = pfirstName;
        PlastName = plastName;
        Pbirthdate = pbirthdate;
        Pphone = pphone;
        Pemail = pemail;
        Paddress = paddress;
        Pdepartment = pdepartment;
        Pdoctor = pdoctor;
        Pnurse = pnurse;
        Pdate = pdate;
        Ppayment = ppayment;
    }

    public String getPfirstName() {
        return PfirstName;
    }

    public String getPlastName() {
        return PlastName;
    }

    public Date getPbirthdate() {
        return Pbirthdate;
    }

    public String getPphone() {
        return Pphone;
    }

    public String getPemail() {
        return Pemail;
    }

    public String getPaddress() {
        return Paddress;
    }

    public String getPdepartment() {
        return Pdepartment;
    }

    public String getPdoctor() {
        return Pdoctor;
    }

    public String getPnurse() {
        return Pnurse;
    }

    public Date getPdate() {
        return Pdate;
    }

    public String getPpayment() {
        return Ppayment;
    }
}

