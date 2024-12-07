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

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public List<Session> getSession() {
        return sessions;
    }

    public void addSession(Session session) {
        this.sessions.add(session);

    }

}
