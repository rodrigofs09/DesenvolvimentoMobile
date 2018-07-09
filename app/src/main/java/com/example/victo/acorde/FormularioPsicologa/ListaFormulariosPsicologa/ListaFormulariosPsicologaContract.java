package com.example.victo.acorde.FormularioPsicologa.ListaFormulariosPsicologa;

import com.example.victo.acorde.FormularioPsicologa.FormularioPsicologa;

public interface ListaFormulariosPsicologaContract {

    interface View {
        void atualizaLista(ListaFormulariosPsicologaAdapter adapter);
    }

    interface Presenter {
        void deletaFormularioPsicologa(FormularioPsicologa formularioPsicologa);
        void carregaLista();
    }
}