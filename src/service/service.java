/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import shcoolapp.Ocene;
import shcoolapp.model.Ocena;
import shcoolapp.model.Predmet;
import shcoolapp.model.Ucenik;

/**
 *
 * @author demir
 */
public class service {
    
    public service() {
        
    }
    
    public Ucenik insertUcenik(Ucenik ucenik) throws SQLException {
        db d = new db();
        Connection conn = null;
        
        try {
            conn = db.getConnection();
            Statement stmt = conn.createStatement();
            
            String query = "INSERT INTO Ucenik(Ime, Prezime) VALUES('"+ucenik.Ime+"', '"+ucenik.Prezime+"')";
            int result = stmt.executeUpdate(query);
            if (result <= 0) {
                ucenik = null;
            }
            
        } catch(SQLException e) {
            System.err.print(e);
        } finally {
            conn.close();
        }
        
        
        return ucenik;
    }
    
    public List<Ucenik> getUcenici() throws SQLException {
        
        db d = new db();
        Connection conn = null;
        List<Ucenik> ucenici = new ArrayList<Ucenik>();  
        
        try {
            conn = db.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String query = "SELECT * FROM Ucenik";
            
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Ucenik u = new Ucenik(Integer.parseInt(rs.getString("Id")), rs.getString("Ime"), rs.getString("Prezime"));
                ucenici.add(u);
            }
            
        } catch(SQLException e) {
            System.err.print(e);
        } finally {
            conn.close();
        }
 
        return ucenici;
    }
    
    public List<Predmet> getPredmeti() throws SQLException {
        
        db d = new db();
        Connection conn = null;
        List<Predmet> predmeti = new ArrayList<Predmet>();  
        
        try {
            conn = db.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String query = "SELECT * FROM Predmet;";
            
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Predmet u = new Predmet(Integer.parseInt(rs.getString("Id")), rs.getString("Predmet"));
                predmeti.add(u);
            }
            
        } catch(SQLException e) {
            System.err.print(e);
        } finally {
            conn.close();
        }
 
        return predmeti;
    }
    
    public Ucenik getUcenik(int id) throws SQLException {
        db d = new db();
        Connection conn = null;
        Ucenik ucenik = null;
        
        try {
            conn = db.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String query = "SELECT * FROM Ucenik WHERE id = " +id+ ";";
            
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                ucenik = new Ucenik(Integer.parseInt(rs.getString("Id")), rs.getString("Ime"), rs.getString("Prezime"));
            }
            
        } catch(SQLException e) {
            System.err.print(e);
        } finally {
            conn.close();
        }
 
        return ucenik;
    }
    
    public void InsertOcene (List<Ocena> ocene) throws SQLException {
        
        db d = new db();
        Connection conn = null;
        
        try {
            conn = db.getConnection();
            Statement stmt = conn.createStatement();
            
            for(int i = 0; i < ocene.size(); i++) {
                int check = CheckIfOcenaExist(ocene.get(i).getUcenikId(), ocene.get(i).getPredmetId());
                if (check != 0) {
                    UpdateOcena(check, ocene.get(i).getOcena());
                } else {
                    String query = "INSERT INTO Ocena(Ocena, PredmetId, UcenikId) VALUES("+ocene.get(i).getOcena()+", "+ocene.get(i).getPredmetId()+", "+ocene.get(i).getUcenikId()+")";
                    stmt.executeUpdate(query);
                }
            }

        } catch(SQLException e) {
            System.err.print(e);
        } finally {
            conn.close();
        }
    }
    
    
    public void UpdateOcena(int OcenaId, int Ocena) throws SQLException {
        db d = new db();
        Connection conn = null;

        try {
            conn = db.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String query = "UPDATE Ocena SET Ocena="+Ocena+";";
            
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
        } catch(SQLException e) {
            System.err.print(e);
        } finally {
            conn.close();
        }
    }
            
    public int CheckIfOcenaExist(int UcenikId, int PredmetId) throws SQLException {
        
        db d = new db();
        Connection conn = null;
        
        try {
            conn = db.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String query = "SELECT * FROM Ocena WHERE UcenikId = " +UcenikId+ " AND PredmetId = " +PredmetId+ ";";
            
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                return Integer.parseInt(rs.getString("Id"));
            }
            
        } catch(SQLException e) {
            System.err.print(e);
        } finally {
            conn.close();
        }
        
        return 0;
    }
    
    public List<Ocena> GetOcene(int UcenikId) throws SQLException {
        db d = new db();
        Connection conn = null;
        List<Ocena> ocene = new ArrayList<Ocena>();
        
        try {
            conn = db.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String query = "SELECT * FROM Ocena WHERE UcenikId = " +UcenikId+ ";";
            
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Ocena o = new Ocena(Integer.parseInt(rs.getString("Ocena")), Integer.parseInt(rs.getString("PredmetId")), Integer.parseInt(rs.getString("UcenikId")));
                ocene.add(o);
            }
            
        } catch(SQLException e) {
            System.err.print(e);
        } finally {
            conn.close();
        }
 
        return ocene;
    }
}
