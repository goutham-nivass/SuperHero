package com.nv.superheroapi;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nv.superheroapi.Test.APIUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity {
    ImageView btnGetUsersList;
    ListView listView;

    HeroInterface userService;
    List<HerosArray> list = new ArrayList<HerosArray>();
    List<HerosArray> filterlist = new ArrayList<HerosArray>();
    EditText Search;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Search = findViewById(R.id.etSearch);
        btnGetUsersList = findViewById(R.id.btnGetUsersList);
        listView = (ListView) findViewById(R.id.listView);
        userService = APIUtils.getUserService();

        btnGetUsersList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Search.getText().toString().trim().equals("")){
                    getUsersList();

                }


            }
        });



    }
    public void getUsersList(){

        Call<HeroResponse> call = userService.getName(Search.getText().toString().trim());
        call.enqueue(new Callback<HeroResponse>() {
            @Override
            public void onResponse(Call<HeroResponse> call, Response<HeroResponse> response) {
                if(response.isSuccessful()){

                    list = response.body().getResults();

                    listView.setAdapter(new HeroAdapter(SearchActivity.this, R.layout.list_user, list));

                }
            }

            @Override
            public void onFailure(Call<HeroResponse> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }



}
