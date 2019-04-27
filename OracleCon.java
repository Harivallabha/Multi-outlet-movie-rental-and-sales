import java.sql.*;
public class OracleCon{
    public static Connection connect(){
        Connection con=null;
        try{
//step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

//step2 create  the connection object
            con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl","project","aceit");

//step3 create the statement object
            //Statement stmt=con.createStatement();

//step4 execute query
            //ResultSet rs=stmt.executeQuery("select * from GRADE");
            //while(rs.next())
              //  System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

//step5 close the connection object
            //con.close();

        }catch(Exception e){ System.out.println(e);e.printStackTrace();}
        return con;
        }
}
