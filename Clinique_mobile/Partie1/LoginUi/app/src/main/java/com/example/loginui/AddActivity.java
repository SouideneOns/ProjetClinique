package com.example.loginui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import database.RendezDB;
import entities.Rendez;


public class AddActivity extends AppCompatActivity {

    private Button buttonBack;
    private Button buttonSave;
    private EditText editTextName;
    private EditText editTextDate;
    private EditText editTextDocteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        this.editTextName = (EditText) findViewById(R.id.editTextName);
        this.editTextDate = (EditText) findViewById(R.id.editTextDate);
        this.editTextDocteur = (EditText) findViewById(R.id.editTextDocteur);

        this.buttonBack = (Button) findViewById(R.id.buttonBack);
        this.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(AddActivity.this, RendezvousActivity.class);
                startActivity(intent1);
            }
        });

        this.buttonSave = (Button) findViewById(R.id.buttonSave);
        this.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RendezDB rendezDB = new RendezDB(getBaseContext());
                Rendez rendez = new Rendez();
                rendez.setName(editTextName.getText().toString());
                rendez.setDate(editTextDate.getText().toString());
                rendez.setDocteur(editTextDocteur.getText().toString());

                if (rendezDB.create(rendez)) {
                    Intent intent1 = new Intent(AddActivity.this, RendezvousActivity.class);
                    startActivity(intent1);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setMessage("Fail");
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    builder.create().show();
                }
            }
        });

    }
    }

