package com.example.myapplication;

public class Data {
    private String name;
    private int value;

    public Data() {

    }
    public Data(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }
}