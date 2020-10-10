package com.example.devtekid.wafi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class SampahBerhargaActivity extends AppCompatActivity {

    LinearLayout pindah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sampah_berharga);

        pindah = (LinearLayout) findViewById(R.id.b_plastik);
        pindah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SampahBerhargaActivity.this,HargaPlastikActivity.class);
                startActivity(intent);
            }
        });

        pindah = (LinearLayout) findViewById(R.id.b_logam);
        pindah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SampahBerhargaActivity.this,HargaLogamActivity.class);
                startActivity(intent);
            }
        });

        pindah = (LinearLayout) findViewById(R.id.b_kaca);
        pindah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SampahBerhargaActivity.this,HargaKacaActivity.class);
                startActivity(intent);
            }
        });

        pindah = (LinearLayout) findViewById(R.id.b_kertas);
        pindah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SampahBerhargaActivity.this,HargaKertasActivity.class);
                startActivity(intent);
            }
        });

        pindah = (LinearLayout) findViewById(R.id.b_lain);
        pindah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SampahBerhargaActivity.this,HargaLainActivity.class);
                startActivity(intent);
            }
        });

    }

}
