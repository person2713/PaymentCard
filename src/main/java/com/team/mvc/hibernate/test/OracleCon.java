package com.team.mvc.hibernate.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Nick on 15.03.2017.
 */
public class OracleCon {
    public static void main(String args[]) {
        try {
//step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

//step2 create the connection object
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@207.154.210.58:1521:XE", "captain", "captain");

//step3 create the statement object
            Statement stmt = con.createStatement();

//step4 execute query
            ResultSet rs = stmt.executeQuery("SELECT *  FROM  CITIES");

            while (rs.next())
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));

//step5 close the connection object
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
