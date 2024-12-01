package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Data {
    private ArrayList<Promo> promos;



    public Data(){
        promos=new ArrayList<>();
    }

    public ArrayList<Promo> getPromos() {
        return promos;
    }


    public void addPromo (Promo promo){
        promos.add(promo);
    }
    public void removePromo (Promo promo){
        promos.remove(promo);
    }

    public Promo getPromo (int num){
        return promos.get(num);
    }

}