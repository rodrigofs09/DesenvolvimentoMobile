package com.example.victo.acorde.FormularioPsicologa.CriaFormularioPsicologa;

import com.example.victo.acorde.FormularioPsicologa.FormularioPsicologa;

public interface CriaFormularioPsicologaContract {

    interface View {
        void setInfosFormularioPsicologa(String dataAtendimento, String nomeAssistido, String Idade,int tipoAtendimento, int tipoIndividual, int tipoEmocional, int tipoAcupuntura,
                                         int grupalTema, int encaminhamentoAcorde, int encaminhamentoExterno, int atendimentoResponsavel, int visitaDomiciliar, String observacao);
        void erroNome();
        void erroData();
        void registroComSucesso();
    }

    interface Presenter {
        void setFormularioPsicologa(FormularioPsicologa formularioPsicologa);
        void setFormularioPsicologa(String dataAtendimento, String nomeAssistido, String Idade,int tipoAtendimento, int tipoIndividual, int tipoEmocional, int tipoAcupuntura,
                                    int grupalTema, int encaminhamentoAcorde, int encaminhamentoExterno, int atendimentoResponsavel, int visitaDomiciliar, String observacao);
        void getFormularioPsicologa();
        void insereFormularioPsicologa(FormularioPsicologa formularioPsicologa);

        void registrar(String nome, String data);
    }


}