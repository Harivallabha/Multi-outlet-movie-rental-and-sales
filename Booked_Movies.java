import java.sql.Date;
import java.text.SimpleDateFormat;


public class Booked_Movies{

    private String bkmov_id;
    private String movr_id;
    private String movr_name;
    private String cust_id;
    private String cust_name;
    private String cust_surname;
    private Date booking_date;

    public Booked_Movies(){
        this.bkmov_id = "";
        this.movr_id = "";
        this.movr_name = "";
        this.cust_id="";
        this.cust_name="";
        this.cust_surname="";
        this.booking_date=new Date(1998,06,13);

    }

    public Booked_Movies(String bkmov_id, String movr_id, String movr_name,String cust_id,String cust_name,String cust_surname,Date date){
        this.bkmov_id = bkmov_id;
        this.movr_id = movr_id;
        this.movr_name = movr_name;
        this.cust_id= cust_id;
        this.cust_name= cust_name;
        this.cust_surname=cust_surname;
        this.booking_date = date;
    }

    public String getBkmov_id() {
        return bkmov_id;
    }

    public void setBkmov_id(String name) {
        this.bkmov_id = name;
    }

    public String getMovr_id() {
        return movr_id;
    }

    public void setMovr_id(String name) {
        this.movr_id = name;
    }

    public String getMovr_name() {
        return movr_name;
    }

    public void setMovr_name(String name) {
        this.movr_name = name;
    }

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String name) {
        this.cust_id = name;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String name) {
        this.cust_name = name;
    }

    public String getCust_surname() {
        return cust_surname;
    }

    public void setCust_surname(String name) {
        this.cust_surname = name;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date name) {
        this.booking_date = name;
    }






}

