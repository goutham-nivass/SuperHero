package com.nv.superheroapi;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class MainActivity extends AppCompatActivity {
    Button btnGetUsersList;
    ListView listView;

    HeroInterface userService;
    List<HerosArray> list = new ArrayList<HerosArray>();
    List<HerosArray> filterlist = new ArrayList<HerosArray>();
    EditText Search;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Search = findViewById(R.id.etSearch);
        btnGetUsersList = (Button) findViewById(R.id.btnGetUsersList);
        listView = (ListView) findViewById(R.id.listView);
        userService = APIUtils.getUserService();

        btnGetUsersList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get users list
                getUsersList();
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
                    for (int i = 0 ;i<list.size();i++){
                        int intell = 0;
                        if (!list.get(i).getPowerstats().getIntelligence().equals("null")){
                            intell = Integer.parseInt(list.get(i).getPowerstats().getIntelligence());
                            if (intell <= 50)
                            {
                                filterlist.add(list.get(i));

                            }

                        }




                    }
                    listView.setAdapter(new HeroAdapter(MainActivity.this, R.layout.list_user, filterlist));






                    /*for (i=0;i<list.size();i++){
                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("https://www.superheroapi.com/api.php/1931148220375954/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
                        HeroInterface jsonPlaceHolderApi = retrofit.create(HeroInterface.class);
                        Call<Powerstats> call2 = jsonPlaceHolderApi.getPowerstats(String.valueOf(list.get(i).getId()));

                        call2.enqueue(new Callback<Powerstats>() {
                            @Override
                            public void onResponse(Call<Powerstats> call, Response<Powerstats> response) {
                                if (!response.isSuccessful())
                                {
                                    Toast.makeText(MainActivity.this, String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                int intell = Integer.parseInt(response.body().getIntelligence());
                                if (intell <= 50)
                                {
                                    filterlist.add(list.get(i));

                                }

                            }
                            @Override
                            public void onFailure(Call<Powerstats> call, Throwable t) {
                                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });


                    }*/


                }
            }

            @Override
            public void onFailure(Call<HeroResponse> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }



}
