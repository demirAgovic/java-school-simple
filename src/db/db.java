/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author demir
 */
public class db {
    
    private String Username;
    private String Password;
    private String Server;
    
    public db(String Username, String Password, String Server) {
        this.Username = Username;
        this.Password = Password;
        this.Server = Server;
    }
    
    public void Conn() throws SQLException {
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DriverManager.getConnection(this.Server, this.Username, this.Password);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            System.out.println("Connected");
        } catch (SQLException e) {
            System.err.print(e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}
