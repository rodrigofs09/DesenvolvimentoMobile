package com.example.victo.acorde.EducadoraFisica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.victo.acorde.Main.MainActivity;
import com.example.victo.acorde.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EducadoraFisicaLista extends AppCompatActivity {

    @BindView(R.id.vazio)
    TextView vazio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educadora_fisica_lista);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //adiciona titulo e define o botao <- na toolbar
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(R.string.educadoraFisica);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        EducadoraFisicaDAO dao = new EducadoraFisicaDAO(getApplicationContext());
        List<EducadoraFisica> educadoraFisicas = dao.buscaRelatorioEF();
        dao.close();

        final ListView listaEducadoraFisica = (ListView) findViewById(R.id.lista_educadoraFisica);

        listaEducadoraFisica.setEmptyView(vazio);

        EducadoraFisicaAdapter adapter = new EducadoraFisicaAdapter(this, educadoraFisicas);
        listaEducadoraFisica.setAdapter(adapter);

        listaEducadoraFisica.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EducadoraFisica educadoraFisica = (EducadoraFisica)listaEducadoraFisica.getItemAtPosition(position);

                Intent intentVaiProFormulario = new Intent(getApplicationContext(), EducadoraFisicaActivity.class);
                intentVaiProFormulario.putExtra("educadoraFisica", educadoraFisica);
                startActivity(intentVaiProFormulario);
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
