package com.example.victo.acorde.FormularioPsicologa.ListaFormulariosPsicologa;

import android.content.Context;

import com.example.victo.acorde.FormularioPsicologa.FormularioPsicologa;
import com.example.victo.acorde.FormularioPsicologa.FormularioPsicologaDAO;

import java.util.List;

public class ListaFormulariosPsicologaPresenter implements ListaFormulariosPsicologaContract.Presenter{

    ListaFormulariosPsicologaAdapter adapter;
    ListaFormulariosPsicologaContract.View view;
    Context context;
    List<FormularioPsicologa> formularioPsicologas = null;

    public ListaFormulariosPsicologaPresenter(ListaFormulariosPsicologaContract.View view, Context context) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void deletaFormularioPsicologa(FormularioPsicologa formularioPsicologa) {
        FormularioPsicologaDAO dao = new FormularioPsicologaDAO(context);
        dao.deletaFormularioPSI(formularioPsicologa);
        dao.close();
        carregaLista();
    }

    @Override
    public void carregaLista() {
        FormularioPsicologaDAO dao = new FormularioPsicologaDAO(context);
        formularioPsicologas = dao.buscaFormularioPSI();
        dao.close();
        adapter = new ListaFormulariosPsicologaAdapter(context, formularioPsicologas);
        view.atualizaLista(adapter);
    }
}
