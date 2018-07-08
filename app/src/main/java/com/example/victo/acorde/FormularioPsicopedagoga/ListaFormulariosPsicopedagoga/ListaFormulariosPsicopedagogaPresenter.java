package com.example.victo.acorde.FormularioPsicopedagoga.ListaFormulariosPsicopedagoga;

import android.content.Context;
import com.example.victo.acorde.FormularioPsicopedagoga.FormularioPsicopedagoga;
import com.example.victo.acorde.FormularioPsicopedagoga.FormularioPsicopedagogaDAO;

import java.util.List;

public class ListaFormulariosPsicopedagogaPresenter implements ListaFormulariosPsicopedagogaContract.Presenter{

    ListaFormulariosPsicopedagogaAdapter adapter;
    ListaFormulariosPsicopedagogaContract.View view;
    Context context;
    List<FormularioPsicopedagoga> formularioPsicopedagogas = null;

    public ListaFormulariosPsicopedagogaPresenter(ListaFormulariosPsicopedagogaContract.View view, Context context) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void deletaFormularioPsicopedagoga(FormularioPsicopedagoga formularioPsicopedagoga) {
        FormularioPsicopedagogaDAO dao = new FormularioPsicopedagogaDAO(context);
        dao.deletaFormularioNU(formularioPsicopedagoga);
        dao.close();
        carregaLista();
    }

    @Override
    public void carregaLista() {
        FormularioPsicopedagogaDAO dao = new FormularioPsicopedagogaDAO(context);
        formularioPsicopedagogas = dao.buscaFormularioNU();
        dao.close();
        adapter = new ListaFormulariosPsicopedagogaAdapter(context, formularioPsicopedagogas);
        view.atualizaLista(adapter);
    }
}
