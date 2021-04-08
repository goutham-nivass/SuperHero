package com.nv.superheroapi;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONObject;

import java.util.List;

public class HeroDetailsActivity extends AppCompatActivity {
    TextView Intelligence,Speed,Strength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_details);
        Intelligence = findViewById(R.id.intelligence);
        Speed = findViewById(R.id.speed);
        Strength = findViewById(R.id.strength);



        getretro();





    }

    private void getretro() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.superheroapi.com/api.php/1931148220375954/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HeroInterface jsonPlaceHolderApi = retrofit.create(HeroInterface.class);
        Call<Powerstats> call = jsonPlaceHolderApi.getPowerstats("1");

        call.enqueue(new Callback<Powerstats>() {
            @Override
            public void onResponse(Call<Powerstats> call, Response<Powerstats> response) {
                if (!response.isSuccessful())
                {
                    Toast.makeText(HeroDetailsActivity.this, String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                    return;
                }
                Intelligence.setText(response.body().getIntelligence());
                Strength.setText(response.body().getStrength());
                Speed.setText(response.body().getSpeed());



            }
            @Override
            public void onFailure(Call<Powerstats> call, Throwable t) {
                Toast.makeText(HeroDetailsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
