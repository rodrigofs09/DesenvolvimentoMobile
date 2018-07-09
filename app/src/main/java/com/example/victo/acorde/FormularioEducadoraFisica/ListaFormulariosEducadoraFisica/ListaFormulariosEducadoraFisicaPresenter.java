package com.example.victo.acorde.FormularioEducadoraFisica.ListaFormulariosEducadoraFisica;

import android.content.Context;
import com.example.victo.acorde.FormularioEducadoraFisica.FormularioEducadoraFisica;
import com.example.victo.acorde.FormularioEducadoraFisica.FormularioEducadoraFisicaDAO;

import java.util.List;

public class ListaFormulariosEducadoraFisicaPresenter implements ListaFormulariosEducadoraFisicaContract.Presenter{

    ListaFormulariosEducadoraFisicaAdapter adapter;
    ListaFormulariosEducadoraFisicaContract.View view;
    Context context;
    List<FormularioEducadoraFisica> formularioEducadoraFisicas = null;

    public ListaFormulariosEducadoraFisicaPresenter(ListaFormulariosEducadoraFisicaContract.View view, Context context) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void deletaFormularioEducadoraFisica(FormularioEducadoraFisica formularioEducadoraFisica) {
        FormularioEducadoraFisicaDAO dao = new FormularioEducadoraFisicaDAO(context);
        dao.deletaRelatorioEF(formularioEducadoraFisica);
        dao.close();
        carregaLista();
    }

    @Override
    public void carregaLista() {
        FormularioEducadoraFisicaDAO dao = new FormularioEducadoraFisicaDAO(context);
        formularioEducadoraFisicas = dao.buscaRelatorioEF();
        dao.close();
        adapter = new ListaFormulariosEducadoraFisicaAdapter(context, formularioEducadoraFisicas);
        view.atualizaLista(adapter);
    }
}
