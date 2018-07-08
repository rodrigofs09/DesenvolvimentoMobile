package com.example.victo.acorde.FormularioEducadoraFisica.CriaFormularioEducadoraFisica;

import android.content.Context;
import android.text.TextUtils;

import com.example.victo.acorde.FormularioEducadoraFisica.FormularioEducadoraFisica;
import com.example.victo.acorde.FormularioEducadoraFisica.FormularioEducadoraFisicaDAO;

public class CriaFormularioEducadoraFisicaPresenter implements CriaFormularioEducadoraFisica.Presenter {

    private FormularioEducadoraFisica formularioEducadoraFisica;
    private CriaFormularioEducadoraFisica.View view;
    private Context context;

    CriaFormularioEducadoraFisicaPresenter(CriaFormularioEducadoraFisica.View view, Context context) {
        this.view = view;
        this.context = context;
        this.formularioEducadoraFisica = new FormularioEducadoraFisica();
    }

    @Override
    public void setFormularioEducadoraFisica(FormularioEducadoraFisica formularioEducadoraFisica) {
        if(null != formularioEducadoraFisica)
            this.formularioEducadoraFisica = formularioEducadoraFisica;
    }

    public void setFormularioEducadoraFisica(String dataAtendimento, String nomeAssistido, String motivoAtendimento, String encaminhamento, String idade, String peso, String altura
            , String bracoDireito, String bracoEsquerdo, String pernaDireita, String pernaEsquerda, String cintura, String quadril, int desempenhoGeral, int desempenhoEspecifico, int aspectosMotrizes
            , int aspectosCognitivos, int aspectosSociais, String observacao) {

        formularioEducadoraFisica.setDataAtendimento(dataAtendimento);
        formularioEducadoraFisica.setNomeAssistido(nomeAssistido);
        formularioEducadoraFisica.setMotivoAtendimento(motivoAtendimento);
        formularioEducadoraFisica.setEncaminhamento(encaminhamento);
        formularioEducadoraFisica.setIdade(idade);
        formularioEducadoraFisica.setPeso(peso);
        formularioEducadoraFisica.setAltura(altura);
        formularioEducadoraFisica.setBracoDireito(bracoDireito);
        formularioEducadoraFisica.setBracoEsquerdo(bracoEsquerdo);
        formularioEducadoraFisica.setPernaDireita(pernaDireita);
        formularioEducadoraFisica.setPernaEsquerda(pernaEsquerda);
        formularioEducadoraFisica.setCintura(cintura);
        formularioEducadoraFisica.setQuadril(quadril);
        formularioEducadoraFisica.setDesempenhoGeral(desempenhoGeral);
        formularioEducadoraFisica.setDesempenhoEspecifico(desempenhoEspecifico);
        formularioEducadoraFisica.setAspectosMotrizes(aspectosMotrizes);
        formularioEducadoraFisica.setAspectosCognitivos(aspectosCognitivos);
        formularioEducadoraFisica.setAspectosSociais(aspectosSociais);
        formularioEducadoraFisica.setObservacao(observacao);

        insereFormularioEducadoraFisica(formularioEducadoraFisica);
    }

    public void getFormularioEducadoraFisica() {
        if (formularioEducadoraFisica != null){
            view.setInfosFormularioEducadoraFisica(formularioEducadoraFisica.getDataAtendimento(), formularioEducadoraFisica.getNomeAssistido(), formularioEducadoraFisica.getMotivoAtendimento(), formularioEducadoraFisica.getEncaminhamento(), formularioEducadoraFisica.getIdade(), formularioEducadoraFisica.getPeso(), formularioEducadoraFisica.getAltura(), formularioEducadoraFisica.getBracoDireito(),
                    formularioEducadoraFisica.getBracoEsquerdo(), formularioEducadoraFisica.getPernaDireita(), formularioEducadoraFisica.getPernaEsquerda(), formularioEducadoraFisica.getCintura(), formularioEducadoraFisica.getQuadril(), formularioEducadoraFisica.getDesempenhoGeral(), formularioEducadoraFisica.getDesempenhoEspecifico(), formularioEducadoraFisica.getAspectosMotrizes(), formularioEducadoraFisica.getAspectosCognitivos(), formularioEducadoraFisica.getAspectosSociais(), formularioEducadoraFisica.getObservacao());
        }

    }

    public void insereFormularioEducadoraFisica(FormularioEducadoraFisica formularioEducadoraFisica) {

        FormularioEducadoraFisicaDAO dao = new FormularioEducadoraFisicaDAO(context);
        if (formularioEducadoraFisica.getId() != null) {
            dao.alteraRelatorioEF(formularioEducadoraFisica);
        } else {
            dao.insereRelatorioEF(formularioEducadoraFisica);
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
