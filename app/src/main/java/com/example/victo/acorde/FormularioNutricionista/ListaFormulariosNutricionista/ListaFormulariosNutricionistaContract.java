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

/*String alimentarSozinho, String servirSozinho, String qtdAlimento, String prepararSozinho, String habitoIntestinal, String mastigacao, String patologia,
                                String intoleranciAlimentar, String alergiaAlimentar, String preferenciaAlimentar, String naoConsome*/