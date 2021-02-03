package com.example.loginui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import adapters.RendezListAdapter;
import database.RendezDB;
import entities.Rendez;


public class RendezvousActivity extends AppCompatActivity {

    private Button buttonAdd;
    private ListView listViewRd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendezvous);
        this.buttonAdd = (Button) findViewById(R.id.buttonAdd);

        this.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(RendezvousActivity.this, AddActivity.class);
                startActivity(intent1);
            }
        });

        final RendezDB rendezDB = new RendezDB(this);
        this.listViewRd = (ListView) findViewById(R.id.listViewRendezs);
        this.listViewRd.setAdapter(new RendezListAdapter(this, rendezDB.findAll()));
        this.listViewRd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Rendez rendez = rendezDB.findAll().get(i);
                Intent intent1 = new Intent(RendezvousActivity.this, DetailActivity.class);
                intent1.putExtra("rendez", rendez);
                startActivity(intent1);
            }
        });
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
            Intent i =new Intent(RendezvousActivity.this,DoctorActivity.class);
            startActivity(i);
        }
        else if(id == R.id.item2){
            Intent i =new Intent(RendezvousActivity.this,RendezvousActivity.class);
            startActivity(i);
        }
        else if(id == R.id.item3){
            Intent i =new Intent(RendezvousActivity.this,ProfileActivity.class);
            startActivity(i);
        }
        else if(id == R.id.item4){
            Intent i =new Intent(RendezvousActivity.this,HomeActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
