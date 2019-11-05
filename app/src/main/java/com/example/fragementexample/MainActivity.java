package com.example.fragementexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected {

    TextView tvDescription;
    String[] description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById(R.id.descriptionView);

        description = getResources().getStringArray(R.array.descriptions);

        // If the phone is in Potrait mode
        if(findViewById(R.id.portrait_mode) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.dcView))
                    .show(manager.findFragmentById(R.id.listView))
                    .commit();
        }

        // If the phone on Landscape Mode
        if(findViewById(R.id.landscape_mode) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.dcView))
                    .show(manager.findFragmentById(R.id.listView))
                    .commit();

        }
    }

    @Override
    public void onItemlSelected(int position) {
        tvDescription.setText(description[position]);

        // If the phone is in Potrait mode
        if(findViewById(R.id.portrait_mode) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.listView))
                    .show(manager.findFragmentById(R.id.dcView))
                    .addToBackStack(null)
                    .commit();
        }


    }
}
