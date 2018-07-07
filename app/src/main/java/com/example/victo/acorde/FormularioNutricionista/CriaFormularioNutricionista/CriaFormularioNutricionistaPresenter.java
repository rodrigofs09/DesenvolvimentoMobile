package com.example.victo.acorde.FormularioNutricionista.CriaFormularioNutricionista;

import android.content.Context;
import android.text.TextUtils;

import com.example.victo.acorde.FormularioNutricionista.FormularioNutricionista;
import com.example.victo.acorde.FormularioNutricionista.FormularioNutricionistaDAO;

public class CriaFormularioNutricionistaPresenter implements CriaFormularioNutricionistaContract.Presenter {

    private FormularioNutricionista formularioNutricionista;
    private CriaFormularioNutricionistaContract.View view;
    private Context context;

    CriaFormularioNutricionistaPresenter(CriaFormularioNutricionistaContract.View view, Context context) {
        this.view = view;
        this.context = context;
        this.formularioNutricionista = new FormularioNutricionista();
    }

    @Override
    public void setFormularioNutricionista(FormularioNutricionista formularioNutricionista) {
        if(null != formularioNutricionista)
            this.formularioNutricionista = formularioNutricionista;
    }

    public void setFormularioNutricionista(String dataAtendimento, String nomeAssistido, String motivoAtendimento,
                                           String encaminhamento, String altura, String peso, String cintura, String quadril,
                                           String bracos, int alimentarSozinho, int servirSozinho, int qtdAlimento,
            int prepararSozinho, int habitoIntestinal, int mastigacao, int patologia, int alergiaAlimentar, int preferenciaAlimentar, int naoConsome, String observacao) {

        formularioNutricionista.setDataAtendimento(dataAtendimento);
        formularioNutricionista.setNomeAssistido(nomeAssistido);
        formularioNutricionista.setMotivoAtendimento(motivoAtendimento);
        formularioNutricionista.setEncaminhamento(encaminhamento);
        formularioNutricionista.setAltura(altura);
        formularioNutricionista.setPeso(peso);
        formularioNutricionista.setCintura(cintura);
        formularioNutricionista.setQuadril(quadril);
        formularioNutricionista.setBracos(bracos);
        formularioNutricionista.setAlimentarSozinho(alimentarSozinho);
        formularioNutricionista.setServirSozinho(servirSozinho);
        formularioNutricionista.setQtdAlimento(qtdAlimento);
        formularioNutricionista.setPrepararSozinho(prepararSozinho);
        formularioNutricionista.setHabitoIntestinal(habitoIntestinal);
        formularioNutricionista.setMastigacao(mastigacao);
        formularioNutricionista.setPatologia(patologia);
        formularioNutricionista.setAlergiaAlimentar(alergiaAlimentar);
        formularioNutricionista.setPreferenciaAlimentar(preferenciaAlimentar);
        formularioNutricionista.setNaoConsome(naoConsome);
        formularioNutricionista.setObservacao(observacao);

        insereFormularioNutricionista(formularioNutricionista);
    }

    public void getFormularioNutricionista() {
        if (formularioNutricionista != null){
            view.setInfosFormularioNutricionista(formularioNutricionista.getDataAtendimento(), formularioNutricionista.getNomeAssistido(), formularioNutricionista.getMotivoAtendimento(), formularioNutricionista.getEncaminhamento(), formularioNutricionista.getAltura(),
                    formularioNutricionista.getPeso(), formularioNutricionista.getCintura(), formularioNutricionista.getQuadril(), formularioNutricionista.getBracos(), formularioNutricionista.getAlimentarSozinho(), formularioNutricionista.getServirSozinho(), formularioNutricionista.getQtdAlimento(), formularioNutricionista.getPrepararSozinho(), formularioNutricionista.getHabitoIntestinal(),
                    formularioNutricionista.getMastigacao(), formularioNutricionista.getPatologia(), formularioNutricionista.getAlergiaAlimentar(), formularioNutricionista.getPreferenciaAlimentar(), formularioNutricionista.getNaoConsome(), formularioNutricionista.getObservacao());
        }

    }

    public void insereFormularioNutricionista(FormularioNutricionista formularioNutricionista) {

        FormularioNutricionistaDAO dao = new FormularioNutricionistaDAO(context);
        if (formularioNutricionista.getId() != null) {
            dao.alteraFormularioNU(formularioNutricionista);
        } else {
            dao.insereFormularioNU(formularioNutricionista);
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