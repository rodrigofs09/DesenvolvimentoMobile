package com.example.victo.acorde.FormularioNutricionista.CriaFormularioNutricionista;

import com.example.victo.acorde.FormularioNutricionista.FormularioNutricionista;

public interface CriaFormularioNutricionistaContract {

    interface View {
        void setInfosFormularioNutricionista(String nomeAssistido, String motivoAtendimento, String encaminhamento,
                                String altura, String peso, String cintura, String quadril,
                                String bracos, String observacao);
    }

    interface Presenter {
        void setFormularioNutricionista(FormularioNutricionista formularioNutricionista);
        void setFormularioNutricionista(String nomeAssistido, String motivoAtendimento, String encaminhamento,
                                   String altura, String peso, String cintura, String quadril, String bracos,
                                   String observacao);
        void getFormularioNutricionista();
        void insereFormularioNutricionista(FormularioNutricionista formularioNutricionista);
    }
}

/*String alimentarSozinho, String servirSozinho, String qtdAlimento, String prepararSozinho, String habitoIntestinal, String mastigacao, String patologia,
                                   String intoleranciAlimentar, String alergiaAlimentar, String preferenciaAlimentar, String naoConsome,*/