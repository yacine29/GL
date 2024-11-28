package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SystemSaveLoad {
    private static final String PREF_NAME = "MyAppPrefs";
    private static final String KEY_Data = "saved_Data";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Gson gson;

    public SystemSaveLoad(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gson = new Gson();
    }

    //Save Data
    public void save_Data(Data list) {
        String json = gson.toJson(list);
        Log.d("TestX",json.toString());

        editor.putString(KEY_Data, json);
        editor.apply();

    }
    public Data load_Data() {
        String json = sharedPreferences.getString(KEY_Data, null);
        Data data;
        if (json == null) {
            return data = null;
        } else {
            Type type = new TypeToken<Data>() {}.getType();
            return data = gson.fromJson(json, type);
        }

    }


}
