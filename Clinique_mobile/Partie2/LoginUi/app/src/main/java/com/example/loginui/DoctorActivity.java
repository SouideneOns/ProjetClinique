package com.example.loginui;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;


import java.util.ArrayList;
import java.util.List;

public class DoctorActivity extends AppCompatActivity {
    ListView listView;
    Context context;
    ArrayList<Model> androidData;
    Adaptater Adapter;
    Model androidModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_doctor);


        //getviews
        listView = findViewById(R.id.list1);
        androidData = new ArrayList<>();
        final ArrayList<AndroidObject> list = new ArrayList<>();

        list.add(new AndroidObject("Malade1" , "Diabète" , "consultation" , "phone1" , "phone2"));
        list.add(new AndroidObject("Malade2" , "Tension" , "grave" , "phone1" , "phone2"));
        list.add(new AndroidObject("Malade3" , "cardio" , "moyenne" , "phone1" , "phone2"));
        list.add(new AndroidObject("Malade4" , "cardio" , "consultation" , "phone1" , "phone2"));
        list.add(new AndroidObject("Malade5" , "Tension" , "moyenne" , "phone1" , "phone2"));
        list.add(new AndroidObject("Malade6" , "Tension" , "grave" , "phone1" , "phone2"));

        List<String> listName = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            listName.add(list.get(i).getName());
        }

        //add Countries Data
        AppData();

        Adapter = new Adaptater(context, androidData);
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Intent i = new Intent(DoctorActivity.this, AndroidPage.class);
                i.putExtra("Object", list.get(position));
                startActivityForResult(i, 0);
            }
        });

    }


    private void AppData() {


        //Model1
        androidModel = new Model();
        androidModel.setId(1);
        androidModel.setName("Malade1");
        androidModel.setMaladie("Diabète");
        androidModel.setImage(R.drawable.malade);
        androidData.add(androidModel);

        //Model2
        androidModel = new Model();
        androidModel.setId(1);
        androidModel.setName("Malade2");
        androidModel.setMaladie("Tension");
        androidModel.setImage(R.drawable.malade);
        androidData.add(androidModel);

        //Model3
        androidModel = new Model();
        androidModel.setId(1);
        androidModel.setName("Malade3");
        androidModel.setMaladie("cardio");
        androidModel.setImage(R.drawable.malade);
        androidData.add(androidModel);

        //Model4
        androidModel = new Model();
        androidModel.setId(1);
        androidModel.setName("Malade4");
        androidModel.setMaladie("cardio");
        androidModel.setImage(R.drawable.malade);
        androidData.add(androidModel);

        //Model5
        androidModel = new Model();
        androidModel.setId(1);
        androidModel.setName("Malade5");
        androidModel.setMaladie("Tension");
        androidModel.setImage(R.drawable.malade);
        androidData.add(androidModel);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem1 = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItem1.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.search){
            return true;
        }

        else if(id == R.id.item1){
            Intent i =new Intent(DoctorActivity.this,DoctorActivity.class);
            startActivity(i);
        }
        else if(id == R.id.item2){
            Intent i =new Intent(DoctorActivity.this,RendezvousActivity.class);
            startActivity(i);
        }
        else if(id == R.id.item3){
            Intent i =new Intent(DoctorActivity.this,ProfileActivity.class);
            startActivity(i);
        }

        else if(id == R.id.item4){
            Intent i =new Intent(DoctorActivity.this,HomeActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
