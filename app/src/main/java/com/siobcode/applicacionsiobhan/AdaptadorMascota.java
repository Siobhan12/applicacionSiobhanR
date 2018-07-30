package com.siobcode.applicacionsiobhan;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdaptadorMascota extends RecyclerView.Adapter<AdaptadorMascota.MascotasViewHolder> {
    private ArrayList<mascota> mascotaLista;
    Activity activity;

    public AdaptadorMascota(ArrayList<mascota> mascotaLista, Activity activity){
        this.mascotaLista = mascotaLista;
        this.activity = activity;
    }

    //Inflar el layout y lo pasaráa al viewholder para que obtenga los wiews
    @Override
    public MascotasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        MascotasViewHolder mascota = new MascotasViewHolder(v);
        return mascota;
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(MascotasViewHolder mascotasViewHolder,int position) {
        final mascota mascota = mascotaLista.get(position);
        mascotasViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotasViewHolder.tvnombrecv.setText(mascota.getNombre());
        mascotasViewHolder.tvfavoritocv.setText(String.valueOf(mascota.getFavorito()));

        mascotasViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        mascotasViewHolder.btnLikeCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "te gusta " + mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
    //Cantidad de elemntos que contiene mi lista
    @Override
    public int getItemCount() {
        return mascotaLista.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private ImageButton btnLikeCV;
        private TextView tvnombrecv;
        private TextView tvfavoritocv;

        public MascotasViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            btnLikeCV = (ImageButton) itemView.findViewById(R.id.cvbtnLike);
            tvnombrecv = (TextView) itemView.findViewById(R.id.tvnombrecv);
            tvfavoritocv = (TextView) itemView.findViewById(R.id.tvfavoritocv);
        }
    }
}
