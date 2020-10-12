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
public class Ucenik {
    
    public int Id;
    public String Ime;
    public String Prezime;
    
    public Ucenik(int id, String Ime, String Prezime) {
        this.Id = id;
        this.Ime = Ime;
        this.Prezime = Prezime;
    }

    public int getId() {
        return Id;
    }

    public String getIme() {
        return Ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setIme(String Ime) {
        this.Ime = Ime;
    }

    public void setPrezime(String Prezime) {
        this.Prezime = Prezime;
    }
}
