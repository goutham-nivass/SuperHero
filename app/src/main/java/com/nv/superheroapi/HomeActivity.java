package com.nv.superheroapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void dashboard(View view)
    {
        Intent intent = new Intent(HomeActivity.this,DashboardActivity.class);
        startActivity(intent);
    }

    public void search(View view)
    {
        Intent intent = new Intent(HomeActivity.this,SearchActivity.class);
        startActivity(intent);

    }

    public void filter(View view)
    {
        Intent intent = new Intent(HomeActivity.this,FilterActivity.class);
        startActivity(intent);
    }
}
