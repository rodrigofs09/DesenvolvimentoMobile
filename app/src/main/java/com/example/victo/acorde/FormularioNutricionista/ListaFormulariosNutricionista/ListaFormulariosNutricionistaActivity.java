package com.example.victo.acorde.FormularioNutricionista.ListaFormulariosNutricionista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.victo.acorde.FormularioNutricionista.CriaFormularioNutricionista.CriaFormularioNutricionistaActivity;
import com.example.victo.acorde.FormularioNutricionista.FormularioNutricionista;
import com.example.victo.acorde.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class ListaFormulariosNutricionistaActivity extends AppCompatActivity implements ListaFormulariosNutricionistaContract.View {

    @BindView(R.id.vazio)
    TextView vazio;

    @BindView(R.id.lista_formulario_nutricionista)
    ListView listaFormulariosNutricionista;

    ListaFormulariosNutricionistaContract.Presenter presenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_formularios_nutricionista);

        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.formularioNutricionista);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        presenter = new ListaFormulariosNutricionistaPresenter(ListaFormulariosNutricionistaActivity.this, getApplicationContext());
        listaFormulariosNutricionista.setEmptyView(vazio);

        registerForContextMenu(listaFormulariosNutricionista);

    }

    @OnItemClick(R.id.lista_formulario_nutricionista)
    public void selecionaFicha(int position) {

        Intent intentVaiProFormulario = new Intent(getApplicationContext(), CriaFormularioNutricionistaActivity.class);
        intentVaiProFormulario.putExtra("formularioNutricionista", (FormularioNutricionista) listaFormulariosNutricionista.getItemAtPosition(position));
        startActivity(intentVaiProFormulario);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.carregaLista();
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

        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                presenter.deletaFormularioNutricionista((FormularioNutricionista) listaFormulariosNutricionista.getItemAtPosition(info.position));
                return false;
            }
        });
    }

    @Override
    public void atualizaLista(ListaFormulariosNutricionistaAdapter adapter) {
        listaFormulariosNutricionista.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        final ListaFormulariosNutricionistaAdapter adapterNutricionista = (ListaFormulariosNutricionistaAdapter) listaFormulariosNutricionista.getAdapter();

        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem myActionMenuItem = menu.findItem(R.id.menuSearch);

        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    adapterNutricionista.filter("");
                    listaFormulariosNutricionista.clearTextFilter();
                }
                else {
                    adapterNutricionista.filter(s);
                }
                return true;
            }
        });
        return true;
    }
}

