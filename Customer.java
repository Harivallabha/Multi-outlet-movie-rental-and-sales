import java.sql.Date;

public class Customer {

    String cust_id,cust_siteid,cust_name,cust_surname,cust_idno,cust_address,cust_telno,cust_cellno,cust_email;

    Date dob;

    Customer(String id,String site_id)
    {
        this.cust_id=id;
        this.cust_siteid=site_id;
    }
    Customer(String name,String surname,Date dob,String idno,String address,String telno,String cellno,String email)
    {
        this.cust_name=name;
    }

    public boolean Check_Credentials()
    {
        System.out.println("hey");
    }
    public void Add_Customer()
    {

    }


}
