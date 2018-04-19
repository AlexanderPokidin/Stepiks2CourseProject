package com.pokidin.a.stepiks2coursproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SearchFragment extends Fragment {

    EditText mEditText;
    Button mButton;

    public static Fragment newInstance() {
        Bundle args = new Bundle();
        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_search, container, false);
        mEditText = view.findViewById(R.id.etSearch);
        mButton = view.findViewById(R.id.btnSearch);
        return view;
    }
}
