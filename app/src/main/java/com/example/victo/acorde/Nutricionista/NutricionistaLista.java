package com.example.victo.acorde.Nutricionista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.victo.acorde.Main.MainActivity;
import com.example.victo.acorde.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NutricionistaLista extends AppCompatActivity {

    @BindView(R.id.vazio)
    TextView vazio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutricionista_lista);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //adiciona titulo e define o botao <- na toolbar
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(R.string.nutricionista);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        NutricionistaDAO dao = new NutricionistaDAO(getApplicationContext());
        List<Nutricionista> nutricionistas = dao.buscaRelatorioNU();
        dao.close();

        final ListView listaNutricionistas = (ListView) findViewById(R.id.lista_nutricionista);
        listaNutricionistas.setEmptyView(vazio);

        NutricionistaAdapter adapter = new NutricionistaAdapter(this, nutricionistas);
        listaNutricionistas.setAdapter(adapter);

        listaNutricionistas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Nutricionista nutricionista = (Nutricionista)listaNutricionistas.getItemAtPosition(position);

                Intent intentVaiProFormulario = new Intent(getApplicationContext(), NutricionistaActivity.class);
                intentVaiProFormulario.putExtra("nutricionista", nutricionista);
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
