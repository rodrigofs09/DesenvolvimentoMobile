package com.example.victo.acorde.FormularioPsicopedagoga.CriaFormularioPsicopedagoga;

import android.content.Context;
import android.text.TextUtils;

import com.example.victo.acorde.FormularioPsicopedagoga.FormularioPsicopedagoga;
import com.example.victo.acorde.FormularioPsicopedagoga.FormularioPsicopedagogaDAO;

public class CriaFormularioPsicopedagogaPresenter implements CriaFormularioPsicopedagogaContract.Presenter {

    private FormularioPsicopedagoga formularioPsicopedagoga;
    private CriaFormularioPsicopedagogaContract.View view;
    private Context context;

    CriaFormularioPsicopedagogaPresenter(CriaFormularioPsicopedagogaContract.View view, Context context) {
        this.view = view;
        this.context = context;
        this.formularioPsicopedagoga = new FormularioPsicopedagoga();
    }

    @Override
    public void setFormularioPsicopedagoga(FormularioPsicopedagoga formularioPsicopedagoga) {
        if(null != formularioPsicopedagoga)
            this.formularioPsicopedagoga = formularioPsicopedagoga;
    }

    public void setFormularioPsicopedagoga(String dataAtendimento, String nomeAssistido, String motivoAtendimento, String encaminhamento, String idade,
                                           int tipoAtendimento, int aspectosTrabalhados, int aspectosTrabalhadosAcupuntura, int atividadesLudicasLeitura, int atividadesCoordenacaoSurtiramEfeito,
                                           int avaliacoesObtiveramResultadosPositivos, int planejamentoSeguePercursoEsperado, int materiaisSaoSuficientesParaAtividades, String observacao) {

        formularioPsicopedagoga.setDataAtendimento(dataAtendimento);
        formularioPsicopedagoga.setNomeAssistido(nomeAssistido);
        formularioPsicopedagoga.setMotivoAtendimento(motivoAtendimento);
        formularioPsicopedagoga.setEncaminhamento(encaminhamento);
        formularioPsicopedagoga.setIdade(idade);
        formularioPsicopedagoga.setTipoAtendimento(tipoAtendimento);
        formularioPsicopedagoga.setAspectosTrabalhados(aspectosTrabalhados);
        formularioPsicopedagoga.setAspectosTrabalhadosAcupuntura(aspectosTrabalhadosAcupuntura);
        formularioPsicopedagoga.setAtividadesLudicasLeitura(atividadesLudicasLeitura);
        formularioPsicopedagoga.setAtividadesCoordenacaoSurtiramEfeito(atividadesCoordenacaoSurtiramEfeito);
        formularioPsicopedagoga.setAvaliacoesObtiveramResultadosPositivos(avaliacoesObtiveramResultadosPositivos);
        formularioPsicopedagoga.setPlanejamentoSeguePercursoEsperado(planejamentoSeguePercursoEsperado);
        formularioPsicopedagoga.setMateriaisSaoSuficientesParaAtividades(materiaisSaoSuficientesParaAtividades);

        formularioPsicopedagoga.setObservacao(observacao);

        insereFormularioPsicopedagoga(formularioPsicopedagoga);
    }

    public void getFormularioPsicopedagoga() {
        if (formularioPsicopedagoga != null){
            view.setInfosFormularioPsicopedagoga(formularioPsicopedagoga.getDataAtendimento(), formularioPsicopedagoga.getNomeAssistido(), formularioPsicopedagoga.getMotivoAtendimento(), formularioPsicopedagoga.getEncaminhamento(), formularioPsicopedagoga.getIdade(), formularioPsicopedagoga.getTipoAtendimento(),
                    formularioPsicopedagoga.getAspectosTrabalhados(), formularioPsicopedagoga.getAspectosTrabalhadosAcupuntura(), formularioPsicopedagoga.getAtividadesLudicasLeitura(), formularioPsicopedagoga.getAtividadesCoordenacaoSurtiramEfeito(),
                    formularioPsicopedagoga.getAvaliacoesObtiveramResultadosPositivos(), formularioPsicopedagoga.getPlanejamentoSeguePercursoEsperado(), formularioPsicopedagoga.getMateriaisSaoSuficientesParaAtividades(), formularioPsicopedagoga.getObservacao());
        }

    }

    public void insereFormularioPsicopedagoga(FormularioPsicopedagoga formularioPsicopedagoga) {

        FormularioPsicopedagogaDAO dao = new FormularioPsicopedagogaDAO(context);
        if (formularioPsicopedagoga.getId() != null) {
            dao.alteraFormularioNU(formularioPsicopedagoga);
        } else {
            dao.insereFormularioNU(formularioPsicopedagoga);
        }
        dao.close();
    }

    public void registrar(String nome, String data){
        if (TextUtils.isEmpty(nome)) {
            view.erroNome();
        }
        else if (TextUtils.isEmpty(data)) {
            view.erroData();
        }
        else{
            view.registroComSucesso();
        }
    }
}