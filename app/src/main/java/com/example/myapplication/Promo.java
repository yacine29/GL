package com.example.myapplication;


import java.util.ArrayList;

public class Promo {
    private String nom;
    private String date;
    private ArrayList<Groupe> groupes;
    private String couleur;

    // Constructeur
    public Promo(String nom, String date, String couleur) {
        this.nom = nom;
        this.date = date;
        this.couleur = couleur;
        this.groupes = new ArrayList<>();
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Groupe> getGroupes() {
        return groupes;
    }

    public void addGroupe(Groupe groupe) {
        this.groupes.add(groupe);
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}

