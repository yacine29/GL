package com.example.myapplication;


import java.sql.Time;
import java.util.Date;

public class Session {
    private int num;
    private Date date;
    private Time timeStart ,timeEnd;

    public Session(int num, Date date , Time timeStart , Time timeEnd) {
        this.num = num;
        this.date = date;
        this.timeStart=timeStart;
        this.timeEnd=timeEnd;
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

    public Time getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Time timeStart) {
        this.timeStart = timeStart;
    }

    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }
}
