package model.dto.RecDto;
import java.sql.Date;

public class AppointmentDto
{
    private String AppID;
    private String PfirstName;
    private String PlastName;
    private String Adescription;
    private String Pdepartment;
    private String Pdoctor;
    private String Pnurse;
    private String Pphone;
    private String Paddress;
    private Date Pdate;
    private String Phour;

    public AppointmentDto(String AppID, String PfirstName, String PlastName, String Adescription, String Pdepartment, String Pdoctor, String Pnurse, String Pphone, String Paddress, Date Pdate, String Phour) {
        this.AppID = AppID;
        this.PfirstName = PfirstName;
        this.PlastName = PlastName;
        this.Adescription=Adescription;
        this.Pdepartment=Pdepartment;
        this.Pdoctor=Pdoctor;
        this.Pnurse=Pnurse;
        this.Pphone = Pphone;
        this.Paddress = Paddress;
        this.Pdate = Pdate;
        this.Phour = Phour;
    }
    public String getAppID() { return AppID; }
    public String getPFirstName() {
        return PfirstName;
    }

    public String getPLastName() {
        return PlastName;
    }

    public String getAdescription(){ return Adescription; }
    public String getPdepartment(){ return Pdepartment; }
    public String getPdoctor(){ return Pdoctor; }
    public String getPnurse(){ return Pnurse; }

    public String getPphone() {
        return Pphone;
    }

    public String getPaddress() {
        return Paddress;
    }
    public Date getPdate() {
        return Pdate;
    }

    public String getPhour() {
        return Phour;
    }
}
