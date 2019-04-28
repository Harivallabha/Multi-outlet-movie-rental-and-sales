import java.sql.Date;

public class Rent_Item{
    String renttxn_id;
    Date rent_date;
    Date rent_returndate;
    String movr_id;
    String movr_reg_siteid;
    String movr_name;
    String renttxn_site_id;
    String emp_id,emp_name,emp_siteid,cost,remp_id,remp_siteid,rcust_id,rcust_siteid;

    public Date getRent_date() {
        return rent_date;
    }

    public String getRcust_id() {
        return rcust_id;
    }

    public String getRcust_siteid() {
        return rcust_siteid;
    }

    public void setRcust_id(String rcust_id) {
        this.rcust_id = rcust_id;
    }

    public void setRcust_siteid(String rcust_siteid) {
        this.rcust_siteid = rcust_siteid;
    }

    public String getRemp_id() {
        return remp_id;
    }

    public String getRemp_siteid() {
        return remp_siteid;
    }

    public void setRemp_id(String remp_id) {
        this.remp_id = remp_id;
    }

    public void setRemp_siteid(String remp_siteid) {
        this.remp_siteid = remp_siteid;
    }

    public String getCost() {
        return cost;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public String getEmp_siteid() {
        return emp_siteid;
    }

    public Date getRent_returndate() {
        return rent_returndate;
    }

    public String getMovr_id() {
        return movr_id;
    }

    public String getMovr_name() {
        return movr_name;
    }

    public String getMovr_reg_siteid() {
        return movr_reg_siteid;
    }

    public String getRenttxn_id() {
        return renttxn_id;
    }

    public String getRenttxn_site_id() {
        return renttxn_site_id;
    }

    public void setMovr_reg_siteid(String movr_reg_siteid) {
        this.movr_reg_siteid = movr_reg_siteid;
    }

    public void setMovr_id(String movr_id) {
        this.movr_id = movr_id;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public void setEmp_siteid(String emp_siteid) {
        this.emp_siteid = emp_siteid;
    }

    public void setMovr_name(String movr_name) {
        this.movr_name = movr_name;
    }

    public void setRent_date(Date rent_date) {
        this.rent_date = rent_date;
    }

    public void setRent_returndate(Date rent_returndate) {
        this.rent_returndate = rent_returndate;
    }

    public void setRenttxn_id(String renttxn_id) {
        this.renttxn_id = renttxn_id;
    }

    public void setRenttxn_site_id(String renttxn_site_id) {
        this.renttxn_site_id = renttxn_site_id;
    }
    //public void DeleteRent
}
