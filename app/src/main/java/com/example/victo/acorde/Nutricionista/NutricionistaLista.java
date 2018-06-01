package com.example.victo.acorde.Nutricionista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
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

    ListView listaNutricionistas;

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

        listaNutricionistas = findViewById(R.id.lista_nutricionista);
        listaNutricionistas.setEmptyView(vazio);

        listaNutricionistas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Nutricionista nutricionista = (Nutricionista)listaNutricionistas.getItemAtPosition(position);

                Intent intentVaiProFormulario = new Intent(getApplicationContext(), NutricionistaActivity.class);
                intentVaiProFormulario.putExtra("nutricionista", nutricionista);
                startActivity(intentVaiProFormulario);
            }
        });

        registerForContextMenu(listaNutricionistas);

    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Nutricionista nutricionista = (Nutricionista) listaNutricionistas.getItemAtPosition(info.position);

        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                NutricionistaDAO dao = new NutricionistaDAO(NutricionistaLista.this);
                dao.deletaRelatorioNU(nutricionista);
                dao.close();
                carregaLista();

                return false;
            }
        });
    }

    private void carregaLista() {
        NutricionistaDAO dao = new NutricionistaDAO(this);
        List<Nutricionista> nutricionistas = dao.buscaRelatorioNU();
        dao.close();

        NutricionistaAdapter adapter = new NutricionistaAdapter(NutricionistaLista.this,nutricionistas);
        listaNutricionistas.setAdapter(adapter);
    }
}
