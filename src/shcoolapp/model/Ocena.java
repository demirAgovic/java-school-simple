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
public class Ocena {
    
    public int Id;
    public int Ocena;
    public int PredmetId;
    public Predmet Predmet;
    
    public Ocena (int Id, int Ocena, int PredmetId, Predmet Predmet) {
        this.Id = Id;
        this.Ocena = Ocena;
        this.PredmetId = PredmetId;
        this.Predmet = Predmet;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getOcena() {
        return Ocena;
    }

    public void setOcena(int Ocena) {
        this.Ocena = Ocena;
    }

    public int getPredmetId() {
        return PredmetId;
    }

    public void setPredmetId(int PredmetId) {
        this.PredmetId = PredmetId;
    }

    public Predmet getPredmet() {
        return Predmet;
    }

    public void setPredmet(Predmet Predmet) {
        this.Predmet = Predmet;
    }
    
    
}
