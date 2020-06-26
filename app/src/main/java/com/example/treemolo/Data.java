package com.example.treemolo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Data extends AppCompatActivity {

    TextView nombre;
    ImageView foto;
    TextView desc;
    TextView sexo;
    TextView direccion;
    TextView fecha;
    TextView edad;

    Musico estudiante = Utilidades.estudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        nombre = (TextView) findViewById(R.id.nombrePerfil);
        desc = (TextView) findViewById(R.id.descPerfil);
        sexo = (TextView) findViewById(R.id.sexoPerfil);
        direccion = (TextView) findViewById(R.id.dirPerfil);
        fecha = (TextView) findViewById(R.id.fechaPerfil);
        foto = (ImageView) findViewById(R.id.fotoPerfil);
        edad = (TextView) findViewById(R.id.edadPerfil);

        nombre.setText(estudiante.getNombre());
        foto.setImageResource(estudiante.getImage());
        desc.setText(estudiante.getDesc());
        setDate(fecha);
        direccion.setText(estudiante.getDireccion());
        if(estudiante.isSexo())
        {
            sexo.setText("Sexo: Femenino");
        }
        else
        {
            sexo.setText("Sexo: Masculino");
        }
        edad.setText("Edad: " + calculateAge(Utilidades.estudiante.getFecha_nac()));

    }

    public void setDate (TextView view){

        Date born = estudiante.getFecha_nac();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");//formating according to my need
        String date = formatter.format(born);
        view.setText(date);
    }

    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btnAtras:
                finish();
                break;
            case R.id.btnMaps:
                String uri = "geo:0,0?q=" + Utilidades.estudiante.getDireccion();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
                break;
            case R.id.btnAgendar:
                Date cumpleaños = Utilidades.estudiante.getFecha_nac();
                Date target = new Date((new Date()).getYear(), cumpleaños.getMonth(), cumpleaños.getDate());
                Intent calIntent = new Intent(Intent.ACTION_INSERT);
                calIntent.setType("vnd.android.cursor.item/event");
                calIntent.putExtra(CalendarContract.Events.TITLE, "Birthday");
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, target.getTime());
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
                startActivity(calIntent);
                break;
        }
    }

    public static int calculateAge(Date birthDate) {
        Date currDate = new Date();
        if(currDate.getMonth()> birthDate.getMonth() && currDate.getDay() > birthDate.getDay())
        {
            return currDate.getYear() - birthDate.getYear();
        }
        else
        {
            return currDate.getYear() - birthDate.getYear() - 1;
        }
    }
}
