package com.example.victo.acorde.FormularioPsicopedagoga.ListaFormulariosPsicopedagoga;

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

import com.example.victo.acorde.FormularioPsicopedagoga.CriaFormularioPsicopedagoga.CriaFormularioPsicopedagogaActivity;
import com.example.victo.acorde.FormularioPsicopedagoga.FormularioPsicopedagoga;
import com.example.victo.acorde.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class ListaFormulariosPsicopedagogaActivity extends AppCompatActivity implements ListaFormulariosPsicopedagogaContract.View {

    @BindView(R.id.searchViewPsicopedagoga)
    SearchView filtroBusca;

    @BindView(R.id.vazio)
    TextView vazio;

    @BindView(R.id.lista_formulario_psicopedagoga)
    ListView listaFormulariosPsicopedagoga;

    ListaFormulariosPsicopedagogaContract.Presenter presenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_formularios_psicopedagoga);

        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.formularioPsicopedagoga);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        presenter = new ListaFormulariosPsicopedagogaPresenter(ListaFormulariosPsicopedagogaActivity.this, getApplicationContext());
        listaFormulariosPsicopedagoga.setEmptyView(vazio);

        registerForContextMenu(listaFormulariosPsicopedagoga);

    }

    @OnItemClick(R.id.lista_formulario_psicopedagoga)
    public void selecionaFicha(int position) {

        Intent intentVaiProFormulario = new Intent(getApplicationContext(), CriaFormularioPsicopedagogaActivity.class);
        intentVaiProFormulario.putExtra("formularioPsicopedagoga", (FormularioPsicopedagoga) listaFormulariosPsicopedagoga.getItemAtPosition(position));
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
                presenter.deletaFormularioPsicopedagoga((FormularioPsicopedagoga) listaFormulariosPsicopedagoga.getItemAtPosition(info.position));
                return false;
            }
        });
    }

    @Override
    public void atualizaLista(ListaFormulariosPsicopedagogaAdapter adapter) {
        listaFormulariosPsicopedagoga.setAdapter(adapter);

        final ListaFormulariosPsicopedagogaAdapter adapterPsicopedagoga = (ListaFormulariosPsicopedagogaAdapter) listaFormulariosPsicopedagoga.getAdapter();

        filtroBusca.setOnQueryTextListener(
                new SearchView.OnQueryTextListener(){

                    @Override
                    public boolean onQueryTextSubmit(String s) {
                        return false;
                    }
                    @Override
                    public boolean onQueryTextChange(String s) {
                        if (TextUtils.isEmpty(s)){
                            adapterPsicopedagoga.filter("");
                            listaFormulariosPsicopedagoga.clearTextFilter();
                        }
                        else {
                            adapterPsicopedagoga.filter(s);
                        }
                        return true;
                    }
                }
        );
    }

}

