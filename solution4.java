//package com.mkyong.jdbc;

import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oracle.jdbc.OracleTypes;

public class solution4{

    //private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    // private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:MKYONG";
    //private static final String DB_USER = "user";
    //private static final String DB_PASSWORD = "password";

    /* public static void main(String[] argv) {

         try {

             callOracleStoredProcCURSORParameter();

         } catch (SQLException e) {

             System.out.println(e.getMessage());

         }

     }
 */
    public void callOracleStoredProcCURSORParameter(ObservableList<Available_Movies> am, Date curr_date,Date end_date,Customer c,Employee e)
            throws SQLException {
        //boolean b=false;
        Connection dbConnection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;

        String getDBUSERCursorSql = "{call RENTITEM(?,?,?,?,?,?,?,?)}";

        try {
            dbConnection =DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl","project","aceit");

            callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);

            for(Available_Movies curram : am) {
                callableStatement.setString(1, curram.movr_id);
                callableStatement.setString(2, curram.movr_reg_siteid);
                callableStatement.setDate(3, curr_date);
                callableStatement.setDate(4, end_date);
                callableStatement.setString(5, c.cust_id);
                callableStatement.setString(6, c.cust_siteid);
                callableStatement.setString(7, e.emp_id);
                callableStatement.setString(8, e.emp_siteid);
                // execute getDBUSERCursor store procedure
                callableStatement.executeUpdate();

                // get cursor and cast it to ResultSet
                rs = (ResultSet) callableStatement.getObject(1);
            }






        } catch (SQLException e1) {

            System.out.println(e1.getMessage());

        } finally {

            if (rs != null) {
                rs.close();
            }

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }


    }



}