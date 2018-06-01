package com.example.victo.acorde.Nutricionista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;

import com.example.victo.acorde.Main.MainActivity;
import com.example.victo.acorde.R;


public class NutricionistaActivity extends AppCompatActivity {

    NutricionistaHelper helper;
    Nutricionista nutricionista = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutricionista);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(R.string.nutricionista);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        helper = new NutricionistaHelper(this);

        final Intent intent = getIntent();
        nutricionista = (Nutricionista) intent.getSerializableExtra("nutricionista");

        if(nutricionista != null){
            helper.preencheFormularioNU(nutricionista);
        }

        Button enviarDados = findViewById(R.id.buttonFinalizar);
        enviarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nutricionista = helper.pegaNutricionista();
                NutricionistaDAO dao = new NutricionistaDAO(getApplicationContext());

                if(nutricionista.getId()!=null){
                    dao.alteraRelatorioNU(nutricionista);
                }else{
                    dao.insereRelatorioNU(nutricionista);
                }
                dao.close();
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}