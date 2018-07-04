package com.example.victo.acorde.FormularioNutricionista.ListaFormulariosNutricionista;

import com.example.victo.acorde.FormularioNutricionista.FormularioNutricionista;

public interface ListaFormulariosNutricionistaContract {

    interface View {
        void atualizaLista(ListaFormulariosNutricionistaAdapter adapter);
    }

    interface Presenter {
        void deletaFormularioNutricionista(FormularioNutricionista formularioNutricionista);
        void carregaLista();
    }
}