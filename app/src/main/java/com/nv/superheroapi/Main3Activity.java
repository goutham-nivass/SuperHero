package com.nv.superheroapi;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Main3Activity extends AppCompatActivity {
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textViewResult = findViewById(R.id.text_view_result);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.superheroapi.com/api.php/1931148220375954/search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HeroInterface jsonPlaceHolderApi = retrofit.create(HeroInterface.class);
        Call<HeroResponse> call = jsonPlaceHolderApi.getJson();
        call.enqueue(new Callback<HeroResponse>() {
            @Override
            public void onResponse(Call<HeroResponse> call, Response<HeroResponse> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                List<HerosArray> heroesList = response.body().getResults();
                for (HerosArray post : heroesList) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "Name: " + post.getName() + "\n";
                    textViewResult.append(content);
                }
            }
            @Override
            public void onFailure(Call<HeroResponse> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}
