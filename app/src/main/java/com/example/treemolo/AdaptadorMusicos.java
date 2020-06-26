package com.example.treemolo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.treemolo.R;

import java.util.ArrayList;

public class AdaptadorMusicos extends RecyclerView.Adapter<AdaptadorMusicos.ViewHolderMusicos>
implements View.OnClickListener {

    ArrayList<Musico> listaMusico;
    private View.OnClickListener listener;

    public AdaptadorMusicos(ArrayList<Musico> listaMusico) {
        this.listaMusico = listaMusico;
    }

    @NonNull
    @Override
    public ViewHolderMusicos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = 0;
        if(Utilidades.vis == Utilidades.LIST)
        {
            layout = R.layout.esquema_lista;
        }
        else
        {
            layout = R.layout.esquema_grid;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, null, false);
        view.setOnClickListener(this);
        return new ViewHolderMusicos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMusicos holder, int position) {
        holder.aNombre.setText(listaMusico.get(position).getNombre());
        holder.aImagen.setImageResource(listaMusico.get(position).getImage());
        if(Utilidades.vis == Utilidades.LIST)
        {
            holder.aDesc.setText(listaMusico.get(position).getDesc());
        }
    }

    @Override
    public int getItemCount() {
        return listaMusico.size();
    }

    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null)
        {
            listener.onClick(v);
        }
    }

    public class ViewHolderMusicos extends RecyclerView.ViewHolder {

        TextView aNombre, aDesc;
        ImageView aImagen;

        public ViewHolderMusicos(@NonNull View itemView) {
            super(itemView);
            aNombre = (TextView) itemView.findViewById(R.id.nombrePerfil);
            aImagen = (ImageView) itemView.findViewById(R.id.fotoPerfil);
            if(Utilidades.vis == Utilidades.LIST) {
                aDesc = (TextView) itemView.findViewById(R.id.descPerfil);
            }
        }
    }
}
