package com.pokidin.a.stepiks2coursproject;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SearchFragment extends Fragment {

    EditText mSearchText;
    Button mSearchButton;
    SharedPreferencesHelper mSharedPreferencesHelper;

    public static Fragment newInstance() {
        Bundle args = new Bundle();
        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    View.OnClickListener onSearchClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String searchWord = mSharedPreferencesHelper.getFromPreferences();
            String uriWord = searchWord + mSearchText.getText().toString();

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uriWord));
            startActivity(intent);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_search, container, false);
        mSharedPreferencesHelper = new SharedPreferencesHelper(getActivity());

        mSearchText = view.findViewById(R.id.etSearch);
        mSearchButton = view.findViewById(R.id.btnSearch);
        mSearchButton.setOnClickListener(onSearchClickListener);
        return view;
    }
}
