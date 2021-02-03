package com.example.loginui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import database.*;
import entities.Rendez;

import android.view.View;
import android.widget.*;
import android.content.*;

public class DetailActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewDate;
    private TextView textViewDocteur;

    private Button buttonBack;
    private Button buttonEdit;
    private Button buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final Intent intent = getIntent();
        final Rendez rendez = (Rendez) intent.getSerializableExtra("rendez");
        this.textViewName = (TextView) findViewById(R.id.textViewName);
        this.textViewName.setText(rendez.getName());
        this.textViewDate = (TextView) findViewById(R.id.textViewDate);
        this.textViewDate.setText(rendez.getDate());
        this.textViewDocteur = (TextView) findViewById(R.id.textViewDocteur);
        this.textViewDocteur.setText(rendez.getDocteur());

        this.buttonBack = (Button) findViewById(R.id.buttonBack);
        this.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DetailActivity.this , RendezvousActivity.class);
                startActivity(intent1);
            }
        });

        this.buttonDelete = (Button) findViewById(R.id.buttonDelete);
        this.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setCancelable(false);
                builder.setTitle("Confirm");
                builder.setMessage("Are you sure ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        RendezDB rendezDB = new RendezDB(getBaseContext());
                        if (rendezDB.delete(rendez.getId())){
                            Intent intent1 = new Intent(DetailActivity.this,RendezvousActivity.class);
                            startActivity(intent1);
                        } else {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(getBaseContext());
                            builder1.setCancelable(false);
                            builder1.setMessage("Fail");
                            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int which) {
                                    dialogInterface.cancel();
                                }
                            });
                            builder1.create().show();
                        }
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.cancel();
                    }
                });
                builder.create().show();
            }
        });

        this.buttonEdit = (Button) findViewById(R.id.buttonEdit);
        this.buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(DetailActivity.this,EditActivity.class);
                intent1.putExtra("rendez", rendez);
                startActivity(intent1);
            }
        });

    }

}

