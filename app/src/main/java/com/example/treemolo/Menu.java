package com.example.treemolo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.treemolo.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Menu extends AppCompatActivity {

    ArrayList<Musico> listaMusicos;
    RecyclerView recyclermusicos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        construirRecycler();

    }

    private void fillMusicos() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        listaMusicos.add(new Musico("Maxim Vengerov", "Violinista", R.mipmap.maxim, false, formatter.parse("1974-08-20"), "Rusia"));
        listaMusicos.add(new Musico("Ray Chen", "Violinista", R.mipmap.ray_chen, false, formatter.parse("1989-03-06"), "Australia"));
        listaMusicos.add(new Musico("Hilary Hahn", "Violinista", R.mipmap.hillary, true, formatter.parse("1979-11-27"), "Estados Unidos"));
        listaMusicos.add(new Musico("Aisha Syed", "Violinista", R.mipmap.aysha, true, formatter.parse("1989-09-15"), "República Dominicana"));
        listaMusicos.add(new Musico("Itzhak Perlman", "Violinista", R.mipmap.itzak, false, formatter.parse("1945-08-31"), "Israel"));
        listaMusicos.add(new Musico("Pablo Ferrández", "Cellista", R.mipmap.pablo, false, formatter.parse("1991-03-19"), "España"));
        listaMusicos.add(new Musico("Sara Ferrández", "Violista", R.mipmap.sara, true, formatter.parse("1995-05-12"), "España"));
        listaMusicos.add(new Musico("Stjepan Hauser", "Cellista", R.mipmap.hauser, false, formatter.parse("1986-06-15"), "Croacia"));
        listaMusicos.add(new Musico("Milena Pajaro-van de Stadt", "Violista", R.mipmap.milena, true, formatter.parse("1987-01-16"), "Estados Unidos"));
        listaMusicos.add(new Musico("Julia Fischer", "Violinista", R.mipmap.julia, true, formatter.parse("1983-06-15"), "Alemania"));
        listaMusicos.add(new Musico("Ron Carter", "Contrabajista", R.mipmap.ron, false, formatter.parse("1937-05-04"), "Estados Unidos"));
        listaMusicos.add(new Musico("Tina Guo", "Cellista", R.mipmap.tina, true, formatter.parse("1985-10-28"), "China"));
        listaMusicos.add(new Musico("David Garrett", "Violinista", R.mipmap.david, false, formatter.parse("1980-11-04"), "Alemania"));
        listaMusicos.add(new Musico("Esperanza Spalding", "Contrabajista", R.mipmap.esperanza, true, formatter.parse("1984-10-18"), "Estados Unidos"));
        listaMusicos.add(new Musico("Balabhaskar Chandran", "Violinista", R.mipmap.balabarska, false, formatter.parse("1978-07-10"), "India"));
    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnlista: Utilidades.vis=Utilidades.LIST;
                break;
            case R.id.btngrid: Utilidades.vis=Utilidades.GRID;
                break;
        }
        construirRecycler();
    }

    private void construirRecycler() {
        listaMusicos = new ArrayList<>();
        recyclermusicos = (RecyclerView) findViewById(R.id.recycler1);

        if(Utilidades.vis == Utilidades.LIST)
        {
            recyclermusicos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        }
        else
        {
            recyclermusicos.setLayoutManager(new GridLayoutManager(this, 3));
        }

        try {
            fillMusicos();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        AdaptadorMusicos adapter = new AdaptadorMusicos(listaMusicos);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilidades.estudiante = listaMusicos.get(recyclermusicos.getChildAdapterPosition(v));
                mostrarDatos();
            }
        });

        recyclermusicos.setAdapter(adapter);
    }

    private void mostrarDatos() {
        Intent intent = new Intent(this, Data.class);
        startActivity(intent);
    }
}
