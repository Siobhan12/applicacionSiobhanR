package com.siobcode.applicacionsiobhan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<mascota> mascotas;
    private RecyclerView.LayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setIcon(R.drawable.coloredbone);

        inicializarListaMascotas();
        inicializarAdaptadorMascotas();
    }

    public void inicializarAdaptadorMascotas(){
        RecyclerView listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listaMascotas.setLayoutManager(llm);

        RecyclerView.Adapter adaptador = new AdaptadorMascota(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<mascota>();

        mascotas.add(new mascota(R.drawable.bow, "Bow", 8));
        mascotas.add(new mascota(R.drawable.fluffy, "Fluffy", 20));
        mascotas.add(new mascota(R.drawable.minny, "Minny", 15));
        mascotas.add(new mascota(R.drawable.piper, "Piper", 16));
        mascotas.add(new mascota(R.drawable.shim, "Shim", 7));
        mascotas.add(new mascota(R.drawable.silky, "Silky", 9));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.itmisfavoritos:
            case R.id.itmenu_favorito:
                Intent intent = new Intent(this, FavMacotas.class);
                startActivityForResult(intent, 0);
                return true;
            default:
                return false;
        }
    }
}


