package com.example.treemolo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.treemolo.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnLimpiar, btnIngresar;
    EditText correo, contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnIngresar = findViewById(R.id.btnIngresar);
        correo = findViewById(R.id.editcorreo);
        contraseña = findViewById(R.id.editcontraseña);

    }

    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnLimpiar:
                limpiar();
                break;
            case R.id.btnIngresar:
                ingresar();
                break;
        }
    }

    private void ingresar() {
        if(correo.getText().toString().equals("Carlosbom") && contraseña.getText().toString().equals("123456"))
        {
            Intent intent = new Intent(this, Menu.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"EL usuario o la contraseña están incorrectos.",Toast. LENGTH_SHORT).show();
        }
    }

    private void limpiar() {
        correo.setText("");
        contraseña.setText("");
    }
}
