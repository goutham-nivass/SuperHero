package com.nv.superheroapi;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.nv.superheroapi.Test.APIUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FilterActivity extends AppCompatActivity {
    ListView listView;

    HeroInterface userService;
    List<HerosArray> list = new ArrayList<HerosArray>();
    List<HerosArray> filterlist = new ArrayList<HerosArray>();
    Spinner spinner;
    int spincount = 0;
    Button Filter;
    String Spinn;
    TextView Spintext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        spinner = findViewById(R.id.spinner);
        Filter = findViewById(R.id.filter);
        Spintext = findViewById(R.id.spintext);
        listView = (ListView) findViewById(R.id.listView);
        Spinn = getIntent().getStringExtra("spinner");
        userService = APIUtils.getUserService();

        Filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FilterActivity.this,FilterActivity.class);
                intent.putExtra("spinner",spinner.getSelectedItem().toString().trim());
                startActivity(intent);
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) view).setPadding(25, 0, 20, 0);//remove extra padding
                ((TextView)view) .setCompoundDrawablesWithIntrinsicBounds(null, null, AppCompatResources.getDrawable(FilterActivity.this, R.drawable.ic_arrow_drop_down_black_24dp), null);
                ((TextView) view).setCompoundDrawablePadding(20);// to set drawablePadding
                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(15);




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        if (Spinn != null){
            Spintext.setText("Intelligence is "+Spinn);
            getUsersList();
        }
    }

    public void getUsersList(){


        Call<HeroResponse> call = userService.getJson();
        call.enqueue(new Callback<HeroResponse>() {
            @Override
            public void onResponse(Call<HeroResponse> call, Response<HeroResponse> response) {
                if(response.isSuccessful()){

                    list = response.body().getResults();
                    for (int i = 0 ;i<list.size();i++){
                        int intell = 0;
                        if (!list.get(i).getPowerstats().getIntelligence().equals("null")){
                            intell = Integer.parseInt(list.get(i).getPowerstats().getIntelligence());
                            if (Spinn.equals("Above 50")){
                                if (intell > 50)
                                {
                                    filterlist.add(list.get(i));

                                }

                            }
                            else if (Spinn.equals("Equal to 50")){
                                if (intell == 50)
                                {
                                    filterlist.add(list.get(i));

                                }

                            }
                            else {
                                if (intell < 50)
                                {
                                    filterlist.add(list.get(i));

                                }

                            }

                        }




                    }
                    listView.setAdapter(new HeroAdapter(FilterActivity.this, R.layout.list_user, filterlist));






                }
            }

            @Override
            public void onFailure(Call<HeroResponse> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }



}
