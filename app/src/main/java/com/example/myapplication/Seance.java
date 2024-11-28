package com.example.myapplication;


import java.util.Date;

public class Seance {
    private int num;
    private Date date;

    public Seance(int num, Date date) {
        this.num = num;
        this.date = date;
    }

    // Getters et setters
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    }
