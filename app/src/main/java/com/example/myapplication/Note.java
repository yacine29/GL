package com.example.myapplication;

import java.util.ArrayList;

public class Note {
    static enum Type_Presence {
        PRESENT , ABCSENT , ABSCENT_JUSTIFIER;
    }
    private ArrayList<String> describtions;
    private ArrayList<Double> tests;
    private ArrayList<Double> particiaptions;
    private ArrayList<Type_Presence>presences;
    public Note() {
     tests = new ArrayList<>();
     particiaptions = new ArrayList<>();
     presences = new ArrayList<>();
     describtions = new ArrayList<>();
    }


    public ArrayList<String> getDescribtions() {
        return describtions;
    }

    public ArrayList<Type_Presence> getPresences () {
        return presences;
    }

    public ArrayList<Double> getTests() {
        return tests;
    }

    public ArrayList<Double> getParticiaptions() {
        return particiaptions;
    }

    public void add_Note_Default_Seance(){
        presences.add(Type_Presence.PRESENT);
        particiaptions.add(0.0);
        describtions.add("");
    }
    public void setParticiaptionsScence(int numScence,double n){
        particiaptions.set(numScence,n);
    }
    public void setPresencesScence(int numScence,Type_Presence type_presence){
        presences.set(numScence,type_presence);
    }
    public void setDescribtionsScence(int numScence,String dsc){
        describtions.set(numScence,dsc);
    }
    public void addTest(double n){
        this.tests.add(n);
    }
    public void removeTest(int numTest){
        this.tests.remove(numTest);
    }
    public void setTests(int numTest,double n){
        this.tests.set(numTest,n);
    }
}


