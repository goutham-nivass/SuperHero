package com.nv.superheroapi;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Main2Activity extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt = findViewById(R.id.helloworld);

        parseJson();
    }

    private void parseJson()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.superheroapi.com/api.php/1931148220375954/search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HeroInterface request = retrofit.create(HeroInterface.class);
        Call<HeroResponse> call1=request.getJson();
        call1.enqueue(new Callback<HeroResponse>() {
            @Override
            public void onResponse(Call<HeroResponse> call, Response<HeroResponse> response) {


                txt.setText("Success! response for first item >> \n car :" +response.body().getResults().get(0).getName());
                Toast.makeText(Main2Activity.this,"Success! response for first item >> \n car :" +response.body().getResults().get(0).getName(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<HeroResponse> call, Throwable t) {
                Toast.makeText(Main2Activity.this,"Failure",Toast.LENGTH_SHORT).show();
            }

        });
    }
}
