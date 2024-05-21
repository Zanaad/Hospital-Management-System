package model.dto.RecDto;

import java.util.Date;

public class AppointmentDto
{
    private int AppID;
    private String PfirstName;
    private String PlastName;
    private Date Pbirthdate;
    private String Pphone;
    private String Pemail;
    private String Paddress;
    private Date Pdate;
    private String Phour;

    public AppointmentDto(int AppID,String PfirstName, String PlastName, java.sql.Date Pbirthdate, String Pphone, String Pemail, String Paddress, java.sql.Date Pdate, int Ppayment) {
        this.AppID = AppID;
        this.PfirstName = PfirstName;
        this.PlastName = PlastName;
        this.Pbirthdate = Pbirthdate;
        this.Pphone = Pphone;
        this.Pemail = Pemail;
        this.Paddress = Paddress;
        this.Pdate = Pdate;
        this.Phour = Phour;
    }
    public int getAppID() { return AppID; }
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

    public String getPaddress() {
        return Paddress;
    }

    public String getPhour() {
        return Phour;
    }
}
