package com.example.myapplication;


import java.util.ArrayList;

public class Promo {
    private String nom;
    private int year;
    private ArrayList<Groupe> groupes;

    // Constructeur
    public Promo(String nom, int year) {
        this.nom = nom;
        this.year = year;
        this.groupes = new ArrayList<>();
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<Groupe> getGroupes() {
        return groupes;
    }

    public void addGroupe(Groupe groupe) {
        this.groupes.add(groupe);
    }
}

