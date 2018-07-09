package com.example.victo.acorde.FormularioEducadoraFisica.ListaFormulariosEducadoraFisica;

import com.example.victo.acorde.FormularioEducadoraFisica.FormularioEducadoraFisica;

public interface ListaFormulariosEducadoraFisicaContract {

    interface View {
        void atualizaLista(ListaFormulariosEducadoraFisicaAdapter adapter);
    }

    interface Presenter {
        void deletaFormularioEducadoraFisica(FormularioEducadoraFisica formularioEducadoraFisica);
        void carregaLista();
    }
}