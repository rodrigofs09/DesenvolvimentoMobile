package com.example.victo.acorde.FormularioEducadoraFisica.CriaFormularioEducadoraFisica;

import com.example.victo.acorde.FormularioEducadoraFisica.FormularioEducadoraFisica;

public interface CriaFormularioEducadoraFisica {

    interface View {
        void setInfosFormularioEducadoraFisica(String dataAtendimento, String nomeAssistido, String motivoAtendimento, String encaminhamento, String idade, String peso, String altura
                , String bracoDireito, String bracoEsquerdo, String pernaDireita, String pernaEsquerda, String cintura, String quadril, int desempenhoGeral, int desempenhoEspecifico, int aspectosMotrizes
                , int aspectosCognitivos, int aspectosSociais, String observacao);
        void erroNome ();
        void erroData ();
        void registroComSucesso();
    }

    interface Presenter {
        void setFormularioEducadoraFisica(FormularioEducadoraFisica formularioEducadoraFisica);
        void setFormularioEducadoraFisica(String dataAtendimento, String nomeAssistido, String motivoAtendimento, String encaminhamento, String idade, String peso, String altura
                , String bracoDireito, String bracoEsquerdo, String pernaDireita, String pernaEsquerda, String cintura, String quadril, int desempenhoGeral, int desempenhoEspecifico, int aspectosMotrizes
                , int aspectosCognitivos, int aspectosSociais, String observacao);
        void getFormularioEducadoraFisica();
        void insereFormularioEducadoraFisica(FormularioEducadoraFisica formularioEducadoraFisica);
        void registrar(String nome, String data);
    }
}
