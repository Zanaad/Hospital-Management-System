package model.dto.RecDto;

import java.sql.Date;

public class CreatePatientDto
{
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

    public CreatePatientDto(String PfirstName, String PlastName, Date Pbirthdate, String Pphone, String Pemail,String Pdepartment,String Pdoctor,String Pnurse, String Paddress, java.sql.Date Pdate, String Ppayment) {
        this.PfirstName = PfirstName;
        this.PlastName = PlastName;
        this.Pbirthdate = Pbirthdate;
        this.Pphone = Pphone;
        this.Pemail = Pemail;
        this.Pdepartment=Pdepartment;
        this.Pdoctor=Pdoctor;
        this.Pnurse=Pnurse;
        this.Paddress = Paddress;
        this.Pdate = Pdate;
        this.Ppayment = Ppayment;
    }
    public String getPFirstName() {
        return PfirstName;
    }

    public String getPLastName() {
        return PlastName;
    }

    public Date getPBirthdate() {
        return Pbirthdate;
    }

    public String getPphone() {
        return Pphone;
    }

    public String getPEmail() {
        return Pemail;
    }

    public String getPdepartment(){return Pdepartment; }
    public String getPdoctor(){return Pdoctor; }
    public String getPnurse(){return Pnurse; }
    public String getPaddress() {
        return Paddress;
    }

    public Date getPdate() {
        return Pdate;
    }
    public String getPpayment() {
        return Ppayment;
    }


}

