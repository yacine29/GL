package com.example.myapplication;


import java.util.ArrayList;

public class Promo {
    private String nameClass;
    private String speciality;
    String Level;
    private int year;
    private ArrayList<Group> groups;


    public Promo(String nameClass, String speciality, String level, int year) {
        this.nameClass = nameClass;
        this.speciality = speciality;
        Level = level;
        this.year = year;
        groups =new ArrayList<>();
    }

    // Getters et setters
    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<Group> getGroupes() {
        return groups;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }

    public void addGroupe(Group group) {
        this.groups.add(group);
    }
}

