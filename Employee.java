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
            boolean b = true;
            System.out.println("hey");
            return b;
        }

}
