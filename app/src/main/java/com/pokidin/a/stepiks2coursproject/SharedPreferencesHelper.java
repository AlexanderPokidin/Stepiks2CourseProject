package com.pokidin.a.stepiks2coursproject;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {

    public static final String PREFERENCES_NAME = "SHARED_PREF_NAME";
    public static final String PREFERENCES_KEY = "PREFERENCES_KEY";


    private SharedPreferences mSharedPreferences;

    public SharedPreferencesHelper(Context context){
        mSharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public void addToPreferences(String string) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(PREFERENCES_KEY, string);
        editor.apply();
    }

    public String getFromPreferences(){
        return mSharedPreferences.getString(PREFERENCES_KEY, "");
    }

}
