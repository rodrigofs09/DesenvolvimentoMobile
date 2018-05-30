package com.example.victo.acorde.Nutricionista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
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

        //cria a toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //adiciona titulo e define o botao <- na toolbar
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(R.string.nutricionista);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(NutricionistaActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
