package com.example.loginui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView doctorimg = (ImageView) findViewById(R.id.doctor);
        doctorimg.setClickable(true);
        doctorimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DoctorActivity.class);
                startActivity(intent);

            }
        });

        ImageView rendezvousimg = (ImageView) findViewById(R.id.rendezvous);
        rendezvousimg.setClickable(true);
        rendezvousimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, RendezvousActivity.class);
                startActivity(intent);

            }
        });

        ImageView profileimg = (ImageView) findViewById(R.id.profile);
        profileimg.setClickable(true);
        profileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);

            }
        });
    }
}
