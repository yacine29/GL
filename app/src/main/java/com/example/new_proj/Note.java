package com.example.new_proj;

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


    public void setPresences(ArrayList<Type_Presence> presences) {
        this.presences = presences;
    }

    public ArrayList<String> getDescribtions() {
        return describtions;
    }

    public void setDescribtions(ArrayList<String> describtions) {
        this.describtions = describtions;
    }


    public ArrayList<Type_Presence> getPresences () {
        return presences;
    }



    public ArrayList<Double> getTests() {
        return tests;
    }

    public void setTests(ArrayList<Double> tests) {
        this.tests = tests;
    }

    public ArrayList<Double> getParticiaptions() {
        return particiaptions;
    }

    public void setParticiaptions(ArrayList<Double> particiaptions) {
        this.particiaptions = particiaptions;
    }
    public void add_Note_Default_Seance(){
        presences.add(Type_Presence.PRESENT);
        particiaptions.add(0.0);
        describtions.add("");
    }
}


