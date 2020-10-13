/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.db;
import java.sql.Connection;
import shcoolapp.model.Ucenik;

/**
 *
 * @author demir
 */
public class service {
    
    public service() {
        
    }
    
    public Ucenik insertUcenik(Ucenik ucenik) {
        db d = new db();
        Connection conn = db.getConnection();
        
        
        
        
        return ucenik;
    }
}
