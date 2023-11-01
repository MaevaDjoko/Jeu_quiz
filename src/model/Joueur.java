/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Pr NOUBISSIE Samuel
 */
public class Joueur {
    private int id;
    private String pseudo;
    private String choixtheme;
    private int score;

    public Joueur() {
    }

    public Joueur(int id, String pseudo, String choixtheme, int score) {
        this.id = id;
        this.pseudo = pseudo;
        this.choixtheme = choixtheme;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getChoixtheme() {
        return choixtheme;
    }

    public void setChoixtheme(String choixtheme) {
        this.choixtheme = choixtheme;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
}
