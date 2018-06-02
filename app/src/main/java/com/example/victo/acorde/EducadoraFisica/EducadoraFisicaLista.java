package com.example.victo.acorde.EducadoraFisica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.victo.acorde.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EducadoraFisicaLista extends AppCompatActivity {

    @BindView(R.id.vazio)
    TextView vazio;

    ListView listaEducadoraFisicas;

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

        listaEducadoraFisicas = findViewById(R.id.lista_educadoraFisica);

        listaEducadoraFisicas.setEmptyView(vazio);

        listaEducadoraFisicas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EducadoraFisica educadoraFisica = (EducadoraFisica)listaEducadoraFisicas.getItemAtPosition(position);

                Intent intentVaiProFormulario = new Intent(getApplicationContext(), EducadoraFisicaActivity.class);
                intentVaiProFormulario.putExtra("educadoraFisica", educadoraFisica);
                startActivity(intentVaiProFormulario);
            }
        });

        registerForContextMenu(listaEducadoraFisicas);
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
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final EducadoraFisica educadoraFisica = (EducadoraFisica) listaEducadoraFisicas.getItemAtPosition(info.position);

        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                EducadoraFisicaDAO dao = new EducadoraFisicaDAO(EducadoraFisicaLista.this);
                dao.deletaRelatorioEF(educadoraFisica);
                dao.close();
                carregaLista();

                return false;
            }
        });
    }

    private void carregaLista() {
        EducadoraFisicaDAO dao = new EducadoraFisicaDAO(this);
        List<EducadoraFisica> educadoraFisicas = dao.buscaRelatorioEF();
        dao.close();

        EducadoraFisicaAdapter adapter = new EducadoraFisicaAdapter(EducadoraFisicaLista.this, educadoraFisicas);
        listaEducadoraFisicas.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView)item.getActionView();

        EducadoraFisicaDAO dao = new EducadoraFisicaDAO(this);
        List<EducadoraFisica> educadoraFisicas = dao.buscaRelatorioEF();
        dao.close();

        final EducadoraFisicaAdapter adapter = new EducadoraFisicaAdapter(EducadoraFisicaLista.this, educadoraFisicas);
        listaEducadoraFisicas.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    adapter.getFilter().filter(null);
                } else {
                    adapter.getFilter().filter(newText);
                }
                adapter.notifyDataSetChanged();
                return false;
            }

        });

        return super.onCreateOptionsMenu(menu);
    }
}
