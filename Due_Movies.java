import java.sql.Date;

public class Due_Movies {

    String cust_id,cust_name,cust_surname,cust_cellno,movr_id,movr_name,renttxn_site_id;
    Date rent_date;

    public void setRenttxn_site_id(String renttxn_site_id) {
        this.renttxn_site_id = renttxn_site_id;
    }

    public void setRent_date(Date rent_date) {
        this.rent_date = rent_date;
    }

    public void setMovr_name(String movr_name) {
        this.movr_name = movr_name;
    }

    public void setMovr_id(String movr_id) {
        this.movr_id = movr_id;
    }

    public String getRenttxn_site_id() {
        return renttxn_site_id;
    }

    public String getMovr_name() {
        return movr_name;
    }

    public String getMovr_id() {
        return movr_id;
    }

    public Date getRent_date() {
        return rent_date;
    }

    public String getCust_cellno() {
        return cust_cellno;
    }

    public String getCust_id() {
        return cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public String getCust_surname() {
        return cust_surname;
    }

    public void setCust_cellno(String cust_cellno) {
        this.cust_cellno = cust_cellno;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public void setCust_surname(String cust_surname) {
        this.cust_surname = cust_surname;
    }

}
