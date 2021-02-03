package com.example.loginui;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AndroidPage extends AppCompatActivity implements View.OnClickListener{

    private AndroidObject ao;

    private final int name =0 ;
    private final int maladie=1;
    private final int etat=2;
    private final int phone1=3;
    private final int phone2=4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_page);
        TextView nom = (TextView) findViewById(R.id.name);
        TextView maladie = (TextView) findViewById(R.id.specialty);
        TextView etat = (TextView) findViewById(R.id.mail);
        TextView phone1 = (TextView) findViewById(R.id.phone1);
        TextView phone2 = (TextView) findViewById(R.id.phone2);



        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        ao = (AndroidObject) getIntent().getSerializableExtra("Object");

        nom.setText(ao.getName());
        maladie.setText( ao.getMaladie());
        etat.setText( ao.getEtat());
        phone1.setText(ao.getPhone1());
        phone2.setText( ao.getPhone2());



        nom.setOnClickListener(this);
        maladie.setOnClickListener(this);
        etat.setOnClickListener(this);
        phone1.setOnClickListener(this);
        phone2.setOnClickListener(this);

        Button cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AndroidPage.this,DoctorActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.name:
                Toast.makeText(this,"Nom" ,Toast.LENGTH_LONG).show();
                break;
            case R.id.specialty:
                Toast.makeText(this,"Specialty", Toast.LENGTH_LONG).show();
                break;

            case R.id.mail:
                Toast.makeText(this,"Etat", Toast.LENGTH_LONG).show();
                break;
            case R.id.phone1:
                Toast.makeText(this,"Phone1", Toast.LENGTH_LONG).show();
                break;
            case R.id.phone2:
                Toast.makeText(this,"Phone2" ,Toast.LENGTH_LONG).show();
                break;




        }
    }
}

