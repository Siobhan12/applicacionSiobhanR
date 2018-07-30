package com.siobcode.applicacionsiobhan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FavMacotas extends AppCompatActivity {

    private ArrayList<mascota> mascotas;
    private RecyclerView listaMascotas;
    private RecyclerView.LayoutManager llm;
    private RecyclerView.Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favmascotas);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.coloredbone);

        inicializarListaMascotas();
        inicializarAdaptadorMascotas();
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<mascota>();

        mascotas.add(new mascota(R.drawable.bow, "Bow", 8));
        mascotas.add(new mascota(R.drawable.fluffy, "Fluffy", 20));
        mascotas.add(new mascota(R.drawable.minny, "Minny", 15));
        mascotas.add(new mascota(R.drawable.piper, "Piper", 16));
        mascotas.add(new mascota(R.drawable.shim, "Shim", 7));
        mascotas.add(new mascota(R.drawable.silky, "Silky", 9));

        Collections.sort(mascotas, new Comparator<mascota>() {
            @Override
            public int compare(mascota lhs, mascota rhs) {
                return lhs.getFavorito() - rhs.getFavorito();
            }
        });

        mascotas.remove(0);
        Collections.reverse(mascotas);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    private void inicializarAdaptadorMascotas(){
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);
        llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listaMascotas.setLayoutManager(llm);

        adaptador = new AdaptadorMascota(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

