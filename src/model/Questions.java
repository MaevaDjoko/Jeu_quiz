/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Pr NOUBISSIE Samuel
 */
public class Questions {
    private int numquest;
    private String theme;
    private String libelle;
    private String rep;

    public Questions() {
    }

    public Questions(int numquest, String theme, String libelle, String rep) {
        this.numquest = numquest;
        this.theme = theme;
        this.libelle = libelle;
        this.rep = rep;
    }

    public int getNumquest() {
        return numquest;
    }

    public void setNumquest(int numquest) {
        this.numquest = numquest;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }
    
    
}
