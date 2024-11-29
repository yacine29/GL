package com.example.myapplication;


import java.util.ArrayList;

public class Etudiant {
    private int num;
    private String nom;
    private String prenom;
    private Note note;

    public Etudiant(int num, String nom, String prenom) {
        this.num = num;
        this.nom = nom;
        this.prenom = prenom;
        this.note = new Note();
    }

    // Getters et setters
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Note getNote() {
        return note;
    }
}

