package com.example.victo.acorde.FormularioPsicologa.CriaFormularioPsicologa;

import android.content.Context;
import android.text.TextUtils;

import com.example.victo.acorde.FormularioPsicologa.FormularioPsicologa;
import com.example.victo.acorde.FormularioPsicologa.FormularioPsicologaDAO;

public class CriaFormularioPsicologaPresenter implements CriaFormularioPsicologaContract.Presenter {

    private FormularioPsicologa formularioPsicologa;
    private CriaFormularioPsicologaContract.View view;
    private Context context;

    CriaFormularioPsicologaPresenter(CriaFormularioPsicologaContract.View view, Context context) {
        this.view = view;
        this.context = context;
        this.formularioPsicologa = new FormularioPsicologa();
    }

    @Override
    public void setFormularioPsicologa(FormularioPsicologa formularioPsicologa) {
        if(null != formularioPsicologa)
            this.formularioPsicologa = formularioPsicologa;
    }

    public void setFormularioPsicologa(String dataAtendimento, String nomeAssistido, String Idade,int tipoAtendimento, int tipoIndividual, int tipoEmocional, int tipoAcupuntura,
                                       int grupalTema, int encaminhamentoAcorde, int encaminhamentoExterno, int atendimentoResponsavel, int visitaDomiciliar, String observacao){

        formularioPsicologa.setDataAtendimento(dataAtendimento);
        formularioPsicologa.setNomeAssistido(nomeAssistido);
        formularioPsicologa.setCategoriaAtendimento(tipoAtendimento);
        formularioPsicologa.setIndividualTipo(tipoIndividual);
        formularioPsicologa.setTipoEmocionalAspectos(tipoEmocional);
        formularioPsicologa.setTipoAcupunturaAspectos(tipoAcupuntura);
        formularioPsicologa.setTemaGrupal(grupalTema);
        formularioPsicologa.setEncaminhamentoAcorde(encaminhamentoAcorde);
        formularioPsicologa.setEncaminhamentoExterno(encaminhamentoExterno);
        formularioPsicologa.setAtendimentoFamiliaCuidadores(atendimentoResponsavel);
        formularioPsicologa.setVisitasDomiciliares(visitaDomiciliar);
        formularioPsicologa.setObservacao(observacao);

        insereFormularioPsicologa(formularioPsicologa);
    }

    public void getFormularioPsicologa() {
        if (formularioPsicologa != null){
            view.setInfosFormularioPsicologa(formularioPsicologa.getDataAtendimento(), formularioPsicologa.getNomeAssistido(), formularioPsicologa.getIdadeAssistido(),formularioPsicologa.getCategoriaAtendimento(), formularioPsicologa.getIndividualTipo(), formularioPsicologa.getTipoEmocionalAspectos(),
                    formularioPsicologa.getTipoAcupunturaAspectos(), formularioPsicologa.getTemaGrupal(), formularioPsicologa.getEncaminhamentoAcorde(), formularioPsicologa.getEncaminhamentoExterno(), formularioPsicologa.getAtendimentoFamiliaCuidadores(), formularioPsicologa.getVisitasDomiciliares(), formularioPsicologa.getObservacao());
        }

    }

    public void insereFormularioPsicologa(FormularioPsicologa formularioPsicologa) {

        FormularioPsicologaDAO dao = new FormularioPsicologaDAO(context);
        if (formularioPsicologa.getId() != null) {
            dao.alteraFormularioPSI(formularioPsicologa);
        } else {
            dao.insereFormularioPSI(formularioPsicologa);
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