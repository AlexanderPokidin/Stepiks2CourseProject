package com.pokidin.a.stepiks2coursproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

public class SettingFragment extends android.app.Fragment {
    private static final String TAG = "SettingFragment";

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

        RadioGroup radioGroup = view.findViewById(R.id.rgSearch);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbGoogle:
                        mSharedPreferencesHelper.addToPreferences("http://www.google.com/#q=");
                        break;
                    case R.id.rbYandex:
                        mSharedPreferencesHelper.addToPreferences("https://www.yandex.ua/search/?text=");
                        break;
                    case R.id.rbBing:
                        mSharedPreferencesHelper.addToPreferences("http://www.bing.com/search?q=");
                        break;
                    default:
                        break;
                }
            }
        });

        return view;
    }
}
