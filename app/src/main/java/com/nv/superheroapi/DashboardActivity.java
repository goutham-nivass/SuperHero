package com.nv.superheroapi;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.nv.superheroapi.Test.APIUtils;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    ListView listView;

    HeroInterface userService;
    List<HerosArray> list = new ArrayList<HerosArray>();
    List<HerosArray> filterlist = new ArrayList<HerosArray>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        listView = (ListView) findViewById(R.id.listView);
        userService = APIUtils.getUserService();
        getUsersList();




    }
    public void search(View view)
    {
        Intent intent = new Intent(DashboardActivity.this,SearchActivity.class);
        startActivity(intent);

    }

    public void filter(View view)
    {
        Intent intent = new Intent(DashboardActivity.this,FilterActivity.class);
        startActivity(intent);

    }
    public void getUsersList(){

        Call<HeroResponse> call = userService.getJson();
        call.enqueue(new Callback<HeroResponse>() {
            @Override
            public void onResponse(Call<HeroResponse> call, Response<HeroResponse> response) {
                if(response.isSuccessful()){

                    list = response.body().getResults();
                    listView.setAdapter(new HeroAdapter(DashboardActivity.this, R.layout.list_user, list));
                }
            }

            @Override
            public void onFailure(Call<HeroResponse> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }



}
