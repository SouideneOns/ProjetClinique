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
    private final int specialty=1;
    private final int phone1=2;
    private final int phone2=3;
    private final int mail=4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_page);
        TextView nom = (TextView) findViewById(R.id.name);
        TextView specialty = (TextView) findViewById(R.id.specialty);
        TextView phone1 = (TextView) findViewById(R.id.phone1);
        TextView phone2 = (TextView) findViewById(R.id.phone2);
        TextView mail = (TextView) findViewById(R.id.mail);
        Button cancel = (Button) findViewById(R.id.cancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AndroidPage.this,DoctorActivity.class);
                startActivity(intent);
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        ao = (AndroidObject) getIntent().getSerializableExtra("Object");

        nom.setText(ao.getName());
        specialty.setText( ao.getSpecialty());
        phone1.setText(ao.getPhone1());
        phone2.setText( ao.getPhone2());
        mail.setText( ao.getMail());


        nom.setOnClickListener(this);
        specialty.setOnClickListener(this);
        phone1.setOnClickListener(this);
        phone2.setOnClickListener(this);
        mail.setOnClickListener(this);


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
            case R.id.phone1:
                Toast.makeText(this,"Phone1", Toast.LENGTH_LONG).show();
                break;
            case R.id.phone2:
                Toast.makeText(this,"Phone2" ,Toast.LENGTH_LONG).show();
                break;
            case R.id.mail:
                Toast.makeText(this,"Email", Toast.LENGTH_LONG).show();
                break;



        }
    }
}

