package com.example.victo.acorde.FormularioNutricionista.ListaFormulariosNutricionista;

import android.content.Context;
import com.example.victo.acorde.FormularioNutricionista.FormularioNutricionista;
import com.example.victo.acorde.FormularioNutricionista.FormularioNutricionistaDAO;

import java.util.List;

public class ListaFormulariosNutricionistaPresenter implements ListaFormulariosNutricionistaContract.Presenter{

    ListaFormulariosNutricionistaAdapter adapter;
    ListaFormulariosNutricionistaContract.View view;
    Context context;
    List<FormularioNutricionista> formularioNutricionistas = null;

    public ListaFormulariosNutricionistaPresenter(ListaFormulariosNutricionistaContract.View view, Context context) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void deletaFormularioNutricionista(FormularioNutricionista formularioNutricionista) {
        FormularioNutricionistaDAO dao = new FormularioNutricionistaDAO(context);
        dao.deletaFormularioNU(formularioNutricionista);
        dao.close();
        carregaLista();
    }

    @Override
    public void carregaLista() {
        FormularioNutricionistaDAO dao = new FormularioNutricionistaDAO(context);
        formularioNutricionistas = dao.buscaFormularioNU();
        dao.close();
        adapter = new ListaFormulariosNutricionistaAdapter(context, formularioNutricionistas);
        view.atualizaLista(adapter);
    }
}
