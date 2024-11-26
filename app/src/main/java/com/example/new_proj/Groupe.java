package com.example.new_proj;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Groupe {

    private int num;
    private ArrayList<Etudiant> etudiants;
    private ArrayList<Seance> seances;


    public Groupe(int num) {
        this.num = num;
        this.etudiants = new ArrayList<>();
        this.seances = new ArrayList<>();
    }

    // Getters et setters
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void addEtudiant(Etudiant etudiant) {
        this.etudiants.add(etudiant);
    }

    public List<Seance> getSeances() {
        return seances;
    }

    public void addSeance(Seance  seance) {
        this.seances.add(seance);

    }
}
