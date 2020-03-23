package com.whmct.billCreator;

import java.sql.*;
import java.util.*;

public class DatabaseConnector {
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/billcreator_db";
    private static final String user = "admin";
    private static final String password = "123456";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;


    public DatabaseConnector() {

    }

    public static List<String> connectAndGetInformation(String q) {
        String query = q;
        List<String> name = new LinkedList<>();
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                 name.add(rs.getString(1));
                //System.out.printf("product name: %s %n", name);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {

            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return name;
    }
}
