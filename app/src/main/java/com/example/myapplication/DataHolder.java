package com.example.myapplication;

public class DataHolder {
    private static final DataHolder instance = new DataHolder();
    private Data myData;

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