package com.example.myapplication;

public class DataHolder {
    private static final DataHolder instance = new DataHolder();
    private Data myData;
    private Promo targetPromo;
    private Groupe targetGroup;
    private Student targetStudent;

    public Promo getTargetPromo() {
        return targetPromo;
    }

    public void setTargetPromo(Promo targetPromo) {
        this.targetPromo = targetPromo;
    }

    public Groupe getTargetGroup() {
        return targetGroup;
    }

    public void setTargetGroup(Groupe targetGroup) {
        this.targetGroup = targetGroup;
    }

    public Student getTargetStudent() {
        return targetStudent;
    }

    public void setTargetStudent(Student targetStudent) {
        this.targetStudent = targetStudent;
    }

    public static DataHolder getInstance() {
        return instance;
    }

    public Data getMyData() {
        return myData;
    }

    public void setMyData(Data myData) {
        this.myData = myData;
    }
}