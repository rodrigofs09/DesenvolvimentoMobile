package com.example.victo.acorde.FormularioEducadoraFisica.ListaFormulariosEducadoraFisica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.victo.acorde.FormularioEducadoraFisica.CriaFormularioEducadoraFisica.CriaFormularioEducadoraFisicaActivity;
import com.example.victo.acorde.FormularioEducadoraFisica.FormularioEducadoraFisica;
import com.example.victo.acorde.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class ListaFormulariosEducadoraFisicaActivity extends AppCompatActivity implements ListaFormulariosEducadoraFisicaContract.View {

    @BindView(R.id.searchViewEducadoraFisica)
    SearchView filtroBusca;

    @BindView(R.id.vazio)
    TextView vazio;

    @BindView(R.id.lista_formulario_EducadoraFisica)
    ListView listaFormulariosEducadoraFisica;

    ListaFormulariosEducadoraFisicaContract.Presenter presenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_formularios_educadora_fisica);

        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.formularioEducadoraFisica);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        presenter = new ListaFormulariosEducadoraFisicaPresenter(ListaFormulariosEducadoraFisicaActivity.this, getApplicationContext());
        listaFormulariosEducadoraFisica.setEmptyView(vazio);

        registerForContextMenu(listaFormulariosEducadoraFisica);

    }

    @OnItemClick(R.id.lista_formulario_EducadoraFisica)
    public void selecionaFicha(int position) {

        Intent intentVaiProFormulario = new Intent(getApplicationContext(), CriaFormularioEducadoraFisicaActivity.class);
        intentVaiProFormulario.putExtra("formularioEducadoraFisica", (FormularioEducadoraFisica) listaFormulariosEducadoraFisica.getItemAtPosition(position));
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
                presenter.deletaFormularioEducadoraFisica((FormularioEducadoraFisica) listaFormulariosEducadoraFisica.getItemAtPosition(info.position));
                return false;
            }
        });
    }

    @Override
    public void atualizaLista(ListaFormulariosEducadoraFisicaAdapter adapter) {
        listaFormulariosEducadoraFisica.setAdapter(adapter);

        final ListaFormulariosEducadoraFisicaAdapter adapterEducadoraFisica = (ListaFormulariosEducadoraFisicaAdapter) listaFormulariosEducadoraFisica.getAdapter();

        filtroBusca.setOnQueryTextListener(
                new SearchView.OnQueryTextListener(){

                    @Override
                    public boolean onQueryTextSubmit(String s) {
                        return false;
                    }
                    @Override
                    public boolean onQueryTextChange(String s) {
                        if (TextUtils.isEmpty(s)){
                            adapterEducadoraFisica.filter("");
                            listaFormulariosEducadoraFisica.clearTextFilter();
                        }
                        else {
                            adapterEducadoraFisica.filter(s);
                        }
                        return true;
                    }
                }
        );
    }

}

