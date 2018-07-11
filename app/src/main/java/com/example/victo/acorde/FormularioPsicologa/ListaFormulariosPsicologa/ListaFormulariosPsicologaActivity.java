package com.example.victo.acorde.FormularioPsicologa.ListaFormulariosPsicologa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.victo.acorde.FormularioPsicologa.CriaFormularioPsicologa.CriaFormularioPsicologaActivity;
import com.example.victo.acorde.FormularioPsicologa.FormularioPsicologa;
import com.example.victo.acorde.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class ListaFormulariosPsicologaActivity extends AppCompatActivity implements ListaFormulariosPsicologaContract.View {

    @BindView(R.id.searchViewPsicologa)
    SearchView filtroBusca;

    @BindView(R.id.vazio)
    TextView vazio;

    @BindView(R.id.lista_formulario_psicologa)
    ListView listaFormulariosPsicologa;

    ListaFormulariosPsicologaContract.Presenter presenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_formularios_psicologa);

        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.formularioPsicologa);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        presenter = new ListaFormulariosPsicologaPresenter(ListaFormulariosPsicologaActivity.this, getApplicationContext());
        listaFormulariosPsicologa.setEmptyView(vazio);

        registerForContextMenu(listaFormulariosPsicologa);

    }

    @OnItemClick(R.id.lista_formulario_psicologa)
    public void selecionaFicha(int position) {

        Intent intentVaiProFormulario = new Intent(getApplicationContext(), CriaFormularioPsicologaActivity.class);
        intentVaiProFormulario.putExtra("formularioPsicologa", (FormularioPsicologa) listaFormulariosPsicologa.getItemAtPosition(position));
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
                presenter.deletaFormularioPsicologa((FormularioPsicologa) listaFormulariosPsicologa.getItemAtPosition(info.position));
                return false;
            }
        });
    }

    @Override
    public void atualizaLista(ListaFormulariosPsicologaAdapter adapter) {
        listaFormulariosPsicologa.setAdapter(adapter);

        final ListaFormulariosPsicologaAdapter adapterPsicologa = (ListaFormulariosPsicologaAdapter) listaFormulariosPsicologa.getAdapter();

        filtroBusca.setOnQueryTextListener(
                new SearchView.OnQueryTextListener(){

                    @Override
                    public boolean onQueryTextSubmit(String s) {
                        return false;
                    }
                    @Override
                    public boolean onQueryTextChange(String s) {
                        if (TextUtils.isEmpty(s)){
                            adapterPsicologa.filter("");
                            listaFormulariosPsicologa.clearTextFilter();
                        }
                        else {
                            adapterPsicologa.filter(s);
                        }
                        return true;
                    }
                }
        );
    }

}

