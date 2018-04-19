package com.pokidin.a.stepiks2coursproject;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected Fragment getFragment() {
        return StartFragment.newInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.project_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting_case:
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, SettingFragment.newInstance())
                        .addToBackStack(SettingFragment.class.getName())
                        .commit();
                Toast.makeText(this, R.string.setting, Toast.LENGTH_SHORT).show();
                break;
            case R.id.search_case:
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, SearchFragment.newInstance())
                        .addToBackStack(SearchFragment.class.getName())
                        .commit();
                Toast.makeText(this, R.string.search, Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit_case:
                Toast.makeText(this, R.string.exit, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
