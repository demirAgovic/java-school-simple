/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db {
    private static String url = "jdbc:mysql://localhost:3306/";    
    private static String driverName = "com.mysql.jdbc.Driver";   
    private static String username = "root";   
    private static String password = "agovic6693";
    private static Connection con;
    private static String urlstring;
    
    public db() {}
    
    public static Connection getConnection() {
        boolean checkDb = false;
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
                ResultSet resultSet = con.getMetaData().getCatalogs();
                
                while (resultSet.next()) {
                    // Get the database name, which is at position 1
                    String databaseName = resultSet.getString(1);
                    if (databaseName.equals("School")) {
                        checkDb = true;
                    }
                }
                
                if (!checkDb) {
                    CreateDb(con);
                }
                
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println(ex);
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }
    
    private static boolean CreateDb(Connection conn) throws SQLException {
        
        String queryDb = "CREATE DATABASE `School`;";
        
        String queryUse = "USE School;";
        
        String queryUcenik = "CREATE TABLE `Ucenik` (\n" +
"	`Id` INT(10) NOT NULL AUTO_INCREMENT,\n" +
"	`Ime` VARCHAR(255),\n" +
"	`Prezime` VARCHAR(255),\n" +
"	PRIMARY KEY (`Id`)\n" +
");";
        
        String queryPredmet = "CREATE TABLE `Predmet` (\n" +
"	`Id` INT(10) NOT NULL AUTO_INCREMENT,\n" +
"	`Predmet` VARCHAR(255),\n" +
"	PRIMARY KEY (`Id`)\n" +
");";
        String queryOcena = "CREATE TABLE `Ocena` (\n" +
"	`Id` INT(10) NOT NULL AUTO_INCREMENT,\n" +
"	`Ocena` INT(2),\n" +
"	`PredmetId` INT(10),\n" +
"	`UcenikId` INT(10),\n" +
"	PRIMARY KEY (`Id`)\n" +
");";
   
        try {
            Statement st = conn.createStatement();
            int result = st.executeUpdate(queryDb);
            if (result > 0) {
                System.out.println("Db created");
                
                st.executeUpdate(queryUse);
                
               int resUcenik = st.executeUpdate(queryUcenik);
                
               if (resUcenik > 0) {
                   System.out.println("UcenikDb created");
               }
               
               int resPredmet = st.executeUpdate(queryPredmet);
                
               if (resPredmet > 0) {
                   System.out.println("Predmet created");
               }
               
               int resOcena = st.executeUpdate(queryOcena);
               
               if (resOcena > 0) {
                System.out.println("Ocena created");   
               }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            conn.close();
        }
        
        return true;
    }
}
