package com.pokidin.a.stepiks2coursproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fr_start);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, getFragment())
                    .commit();
        }
    }

    protected abstract Fragment getFragment();
}
