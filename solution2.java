//package com.mkyong.jdbc;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oracle.jdbc.OracleTypes;

public class solution2{

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
    public ObservableList<Rent_Item> callOracleStoredProcCURSORParameter(Date x1, Date x2)
            throws SQLException {
        //boolean b=false;
        ObservableList<Rent_Item> list = FXCollections.observableArrayList();
        Connection dbConnection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;

        String getDBUSERCursorSql = "{call rent_txn_history(?,?,?)}";

        try {
            dbConnection =DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl","project","aceit");

            callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);

            callableStatement.setDate(1, x1);

            callableStatement.setDate(2, x2);

            callableStatement.registerOutParameter(3, OracleTypes.CURSOR);

            // execute getDBUSERCursor store procedure
            callableStatement.executeUpdate();

            // get cursor and cast it to ResultSet
            rs = (ResultSet) callableStatement.getObject(3);

            Rent_Item temp = null;

            while(rs.next())
            {
                temp.renttxn_id = rs.getString("renttxn_id");
                temp.rent_date = rs.getDate("rent_date");
                temp.rent_returndate = rs.getDate("rent_returndate");
                temp.movr_id = rs.getString("movr_id");
                temp.movr_reg_siteid = rs.getString("movr_reg_siteid");
                temp.movr_name = rs.getString("movr_name");
                temp.renttxn_site_id = rs.getString("renttxn_site_id");
                temp.emp_id = rs.getString("emp_id");
                temp.emp_name = rs.getString("emp_name");
                temp.emp_siteid = rs.getString("emp_siteid");
                temp.cost = rs.getString("cost");

                list.add(temp);
                System.out.print(temp);
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

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
        return list;

    }



}