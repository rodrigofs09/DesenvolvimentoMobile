package com.example.victo.acorde.FormularioPsicopedagoga.ListaFormulariosPsicopedagoga;

import com.example.victo.acorde.FormularioPsicopedagoga.FormularioPsicopedagoga;

public interface ListaFormulariosPsicopedagogaContract {

    interface View {
        void atualizaLista(ListaFormulariosPsicopedagogaAdapter adapter);
    }

    interface Presenter {
        void deletaFormularioPsicopedagoga(FormularioPsicopedagoga formularioPsicopedagoga);
        void carregaLista();
    }
}