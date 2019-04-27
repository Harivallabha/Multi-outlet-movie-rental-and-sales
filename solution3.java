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

public class solution3{

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
    public ObservableList<Available_Movies> callOracleStoredProcCURSORParameter()
            throws SQLException {
        //boolean b=false;
        ObservableList<Available_Movies> list = FXCollections.observableArrayList();
        Connection dbConnection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;

        String getDBUSERCursorSql = "{call AVAILABLE_MOVIES(?)}";

        try {
            dbConnection =DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl","project","aceit");

            callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);

            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);

            // execute getDBUSERCursor store procedure
            callableStatement.executeUpdate();

            // get cursor and cast it to ResultSet
            rs = (ResultSet) callableStatement.getObject(1);

            while(rs.next())
            {
                Available_Movies temp = new Available_Movies();

                temp.movr_id = rs.getString("movr_id");
                temp.movr_name = rs.getString("movr_name");
                temp.movr_type = rs.getString("movr_type");
                temp.movr_reg_siteid = rs.getString("movr_reg_siteid");

                list.add(temp);

                //System.out.println(temp.movr_id);
                //System.out.println(temp.movr_name);
                //System.out.println(temp.movr_type);
                //System.out.println(temp.movr_reg_siteid);

                //System.out.print(temp);
            }
            //System.out.print(list);
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