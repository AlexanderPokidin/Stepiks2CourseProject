package com.pokidin.a.stepiks2coursproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

public class SettingFragment extends android.app.Fragment {
    private static final String TAG = "SettingFragment";
    public static String SEARCH_KEY;

    private RadioGroup mRadioGroup;
    private SharedPreferencesHelper mSharedPreferencesHelper;


    public static Fragment newInstance() {
        Bundle args = new Bundle();
        SettingFragment fragment = new SettingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_setting, container, false);

        mSharedPreferencesHelper = new SharedPreferencesHelper(getActivity());

        mRadioGroup = view.findViewById(R.id.rgSearch);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbGoogle:
                        SEARCH_KEY = "http://www.google.com/#q=";
                        Log.d(TAG, "SEARCH_KEY = google");
                        mSharedPreferencesHelper.addToPreferences("http://www.google.com/#q=");

                        // todo
                        break;
                    case R.id.rbYandex:
                        SEARCH_KEY = "yandex";
                        Log.d(TAG, "SEARCH_KEY = yandex");
                        mSharedPreferencesHelper.addToPreferences("https://www.yandex.ua/search/?text=");
                        // todo
                        break;
                    case R.id.rbBing:
                        SEARCH_KEY = "http://www.bing.com/search?q=";
                        Log.d(TAG, "SEARCH_KEY = bing");
                        mSharedPreferencesHelper.addToPreferences("http://www.bing.com/search?q=");
                        // todo
                        break;
                    default:
                        break;
                        // todo
                }
            }
        });

        return view;
    }
}
