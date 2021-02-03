package com.example.loginui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText username, password, email, country, dob;
    RadioGroup gender;
    Button register, cancel;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        dob = (EditText) findViewById(R.id.dob);
        country = (EditText) findViewById(R.id.country);
        gender = (RadioGroup) findViewById(R.id.gender);
        register = (Button) findViewById(R.id.register);
        cancel = (Button) findViewById(R.id.cancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        databaseHelper = new DatabaseHelper(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                String emailValue = email.getText().toString();
                String countryValue = country.getText().toString();
                String dobValue = dob.getText().toString();
                RadioButton checkbtn = findViewById(gender.getCheckedRadioButtonId());
                String genderValue = checkbtn.getText().toString();


                if (usernameValue.length() > 1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("username", usernameValue);
                    contentValues.put("password", passwordValue);
                    contentValues.put("email", emailValue);
                    contentValues.put("country", countryValue);
                    contentValues.put("dob", dobValue);
                    contentValues.put("gender", genderValue);


                    databaseHelper.insertUser(contentValues);
                    Toast.makeText(RegisterActivity.this, "User Registred!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(RegisterActivity.this, "Enter the values!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

