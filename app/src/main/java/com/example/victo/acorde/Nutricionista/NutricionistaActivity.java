package com.example.victo.acorde.Nutricionista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.victo.acorde.R;


public class NutricionistaActivity extends AppCompatActivity {

    NutricionistaHelper helper;
    Nutricionista nutricionista = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutricionista);

        Toolbar toolbar = findViewById(R.id.toolbarNutricionista);
        setSupportActionBar(toolbar);

        helper = new NutricionistaHelper(this);

        Button enviarDados = findViewById(R.id.buttonFinalizar);
        enviarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nutricionista = helper.pegaNutricionista();
                NutricionistaDAO dao = new NutricionistaDAO(getApplicationContext());
                dao.insereRelatorioNU(nutricionista);
                dao.close();
                //Toast.makeText(getApplicationContext(),nutricionista.getAlimentarSozinho(), Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

}
