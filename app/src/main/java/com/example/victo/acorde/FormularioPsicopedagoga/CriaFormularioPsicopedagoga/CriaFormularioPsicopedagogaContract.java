package com.example.victo.acorde.FormularioPsicopedagoga.CriaFormularioPsicopedagoga;

import com.example.victo.acorde.FormularioPsicopedagoga.FormularioPsicopedagoga;

public interface CriaFormularioPsicopedagogaContract {

    interface View {
        void setInfosFormularioPsicopedagoga(String dataAtendimento, String nomeAssistido, String motivoAtendimento, String encaminhamento, String idade,
                                             int tipoAtendimento, int aspectosTrabalhados, int aspectosTrabalhadosAcupuntura, int atividadesLudicasLeitura, int atividadesCoordenacaoSurtiramEfeito,
                                             int avaliacoesObtiveramResultadosPositivos, int planejamentoSeguePercursoEsperado, int materiaisSaoSuficientesParaAtividades, String observacao);
        void erroNome ();
        void erroData ();
        void registroComSucesso();
    }

    interface Presenter {
        void setFormularioPsicopedagoga(FormularioPsicopedagoga formularioPsicopedagoga);
        void setFormularioPsicopedagoga(String dataAtendimento, String nomeAssistido, String motivoAtendimento, String encaminhamento, String idade,
                                        int tipoAtendimento, int aspectosTrabalhados, int aspectosTrabalhadosAcupuntura, int atividadesLudicasLeitura, int atividadesCoordenacaoSurtiramEfeito,
                                        int avaliacoesObtiveramResultadosPositivos, int planejamentoSeguePercursoEsperado, int materiaisSaoSuficientesParaAtividades, String observacao);
        void getFormularioPsicopedagoga();
        void insereFormularioPsicopedagoga(FormularioPsicopedagoga formularioPsicopedagoga);

        void registrar(String nome, String data);
    }


}