package com.example.myapplication;


import java.sql.Time;
import java.util.Date;

public class Session {
    private int num;
    private Date date;
    private Time time;

    public Session(int num, Date date) {
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
