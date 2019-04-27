//package com.mkyong.jdbc;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

public class solution{

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
    public static boolean callOracleStoredProcCURSORParameter(String x1,String x2,String x3)
            throws SQLException {
            boolean b=false;
        Connection dbConnection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;

        String getDBUSERCursorSql = "{call empcheck(?,?,?,?)}";

        try {
            dbConnection =DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl","project","aceit");

            callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);

            //callableStatement.setString(1, "'"+ x2 +"'");

            //callableStatement.setString(2, "'"+ x1 +"'");

            callableStatement.setString(1,x1);

            callableStatement.setString(2,x2);

            callableStatement.setString(3,x3);

            callableStatement.registerOutParameter(4, OracleTypes.CURSOR);


            // execute getDBUSERCursor store procedure
            callableStatement.executeUpdate();

            // get cursor and cast it to ResultSet
            rs = (ResultSet) callableStatement.getObject(4);

            if (rs.next()) {
                b=true;

                //System.out.println("TESTNIK");

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
        return b;

    }



}