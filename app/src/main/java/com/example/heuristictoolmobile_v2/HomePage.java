package com.example.heuristictoolmobile_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    ImageView btn_crearEV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        btn_crearEV = findViewById(R.id.imageViewCrearEv);

        btn_crearEV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CrearEvaluacion.class);
                startActivity(intent);
            }
        });
    }
}