package com.example.victo.acorde.FormularioNutricionista.CriaFormularioNutricionista;

import com.example.victo.acorde.FormularioNutricionista.FormularioNutricionista;

public interface CriaFormularioNutricionistaContract {

    interface View {
        void setInfosFormularioNutricionista(String dataAtendimento, String nomeAssistido, String motivoAtendimento, String encaminhamento,
                                String altura, String peso, String cintura, String quadril,
                                String bracos, int alimentarSozinho, int servirSozinho, int qtdAlimento, int prepararSozinho, int habitoIntestinal, int mastigacao, int patologia,
                                             int alergiaAlimentar, int preferenciaAlimentar, int naoConsome, String observacao);
        void erroNome ();
        void erroData ();
        void registroComSucesso();
    }

    interface Presenter {
        void setFormularioNutricionista(FormularioNutricionista formularioNutricionista);
        void setFormularioNutricionista(String dataAtendimento, String nomeAssistido, String motivoAtendimento, String encaminhamento,
                                   String altura, String peso, String cintura, String quadril, String bracos, int alimentarSozinho, int servirSozinho, int qtdAlimento, int prepararSozinho, int habitoIntestinal, int mastigacao, int patologia,
                                        int alergiaAlimentar, int preferenciaAlimentar, int naoConsome, String observacao);
        void getFormularioNutricionista();
        void insereFormularioNutricionista(FormularioNutricionista formularioNutricionista);

        void registrar(String nome, String data);
    }


}