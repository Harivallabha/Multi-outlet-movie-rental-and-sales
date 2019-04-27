import java.sql.Connection;
import java.sql.*;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

public class Employee {
        String emp_siteid,emp_id,emp_name,emp_surnme,emp_idno,emp_address,emp_telno,emp_status,grd_id,emp_empstatus
                ,emp_working_site,emp_empdate,emp_password;
        Employee(String id,String site_id)
        {
            this.emp_siteid=site_id;
            this.emp_id=id;
        }
        public boolean Check_credentials()
        {
            solution s = new solution();
            boolean ans=false;
           // System.out.println(emp_password);
            try {
                ans = s.callOracleStoredProcCURSORParameter(emp_siteid,emp_id,emp_password);
            }
            catch(Exception e)
            {
                System.out.print(e);
            }

            return ans;
        }

}
