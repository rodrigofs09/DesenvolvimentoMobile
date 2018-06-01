package com.example.victo.acorde.EducadoraFisica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.victo.acorde.Main.MainActivity;
import com.example.victo.acorde.R;

public class EducadoraFisicaActivity extends AppCompatActivity {

    EducadoraFisicaHelper helper;
    EducadoraFisica educadoraFisica = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educadora_fisica);

        //cria a toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //adiciona titulo e define o botao <- na toolbar
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(R.string.educadoraFisica);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        helper = new EducadoraFisicaHelper(this);

        final Intent intent = getIntent();
        educadoraFisica = (EducadoraFisica) intent.getSerializableExtra("educadoraFisica");

        if(educadoraFisica != null){
            helper.preencheFormularioEF(educadoraFisica);
        }

        Button enviarDados = findViewById(R.id.buttonFinalizar);
        enviarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                educadoraFisica = helper.pegaEducadoraFisica();
                EducadoraFisicaDAO dao = new EducadoraFisicaDAO(getApplicationContext());

                if(educadoraFisica.getId()!=null){
                    dao.alteraRelatorioEF(educadoraFisica);
                }else{
                    dao.insereRelatorioEF(educadoraFisica);
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
