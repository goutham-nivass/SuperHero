package com.nv.superheroapi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroAdapter extends ArrayAdapter<HerosArray> {

    private Context context;
    private List<HerosArray> users;

    public HeroAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<HerosArray> objects) {
        super(context, resource, objects);
        this.context = context;
        this.users = objects;
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_user, parent, false);

        final TextView txtUserId = (TextView) rowView.findViewById(R.id.txtUserId);
        final TextView txtUsername = (TextView) rowView.findViewById(R.id.txtUsername);
        final TextView intelligence = (TextView) rowView.findViewById(R.id.intelligence);
        final ImageView imageView = (ImageView) rowView.findViewById(R.id.image);




        txtUserId.setText("Hero ID : "+String.valueOf(users.get(pos).getId()));
        txtUsername.setText(String.format("HERO NAME: %s", users.get(pos).getName()));
        intelligence.setText("Intelligence : "+users.get(pos).getPowerstats().getIntelligence());
        Picasso.get().load(users.get(pos).getImage().getUrl()).into(imageView);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start Activity User Form
                /**
                Intent intent = new Intent(context, UserActivity.class);
                intent.putExtra("user_id", String.valueOf(users.get(pos).getId()));
                intent.putExtra("user_name", users.get(pos).getName());
                context.startActivity(intent);
                 **/
            }
        });

        return rowView;
    }


}
