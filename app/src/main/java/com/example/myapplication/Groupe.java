package com.example.myapplication;


import java.util.ArrayList;
import java.util.List;


public class Groupe {

    private int num;
    private ArrayList<Student> students;
    private ArrayList<Session> sessions;


    public Groupe(int num) {
        this.num = num;
        this.students = new ArrayList<>();
        this.sessions = new ArrayList<>();
    }

    // Getters et setters
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Student> getEtudiants() {
        return students;
    }

    public void addEtudiant(Student student) {
        this.students.add(student);
    }

    public List<Session> getSeances() {
        return sessions;
    }

    public void addSeance(Session session) {
        this.sessions.add(session);

    }
}
