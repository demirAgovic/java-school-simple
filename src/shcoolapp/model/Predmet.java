/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shcoolapp.model;

/**
 *
 * @author demir
 */
public class Predmet {
    
    public int Id;
    public String Predmet;
    
    public Predmet(int Id, String Predmet) {
        this.Id = Id;
        this.Predmet = Predmet;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getPredmet() {
        return Predmet;
    }

    public void setPredmet(String Predmet) {
        this.Predmet = Predmet;
    }
    
    
}
