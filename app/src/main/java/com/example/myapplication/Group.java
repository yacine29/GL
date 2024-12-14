package com.example.myapplication;


import java.util.ArrayList;


public class Group {

    private int num;
    private ArrayList<Student> students;
    private ArrayList<Session> sessions;
    private int indexType;
    public Group(int num) {
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

    public void addSession(Session session) {
        this.sessions.add(session);

    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public int getIndexType() {
        return indexType;
    }

    public void setIndexType(int indexType) {
        this.indexType = indexType;
    }
}
