package com.example.victo.acorde.EducadoraEspecial;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.victo.acorde.R;

public class EducadoraEspecialHelper {

    //private final EditText campoData;
    //private final EditText campoTipoAtendimento;
    private final EditText campoNomeAssistido;
    private final EditText campoMotivoAtendimento;
    private final EditText campoEncaminhamento;
    //private final RadioGroup campoComunicacaoVerbal;
    /*
    private final RadioGroup campoSegueInstrucoes;
    private final RadioGroup campoRespondePerguntas;
    private final RadioGroup campoImitaModelos;
    private final RadioGroup campoPermaneceNasTarefas;
    private final RadioGroup campoCompletaTarefas;
    private final RadioGroup campoReconheceAtividades;
    private final RadioGroup campoReconheceTrabalhos;
    private final RadioGroup campoReconheceErros;
    private final RadioGroup campoReconheceNecessidade;
    private final RadioGroup campoCompreendeOrdensSimples;
    private final RadioGroup campoCompreendeOrdensComplexas;
    private final RadioGroup campoRaciocinio;
    private final RadioGroup campoMemoriaRemota;
    private final RadioGroup campoMemoriaRecente;
    private final RadioGroup campoMemoriaImediata;
    private final RadioGroup campoAssimilaAtividades;
    private final RadioGroup campoVerbalizaPensamentos;
    private final RadioGroup campoEscreve;
    private final RadioGroup campoConsegueLer;
    private final RadioGroup campoGestualizaMaos;
    private final RadioGroup campoFazGaratuja;
    private final RadioGroup campoAssinaNome;
    private final RadioGroup campoColoriFiguras;
    private final RadioGroup campoCopiaLinhas;
    private final RadioGroup campoEscreveCaneta;
    private final RadioGroup campoUsaBorracha;
    private final RadioGroup campoReconheceCires;
    private final RadioGroup campoReconheceLetrasAlfabeto;
    private final RadioGroup campoReconheceLetrasNome;
    private final RadioGroup campoFazPareamento;
    private final RadioGroup campoReconheceNumeros;
    private final RadioGroup campoPossuiNocao;
    private final RadioGroup campoPossuiAtencao;*/
    private final EditText campoObservacao;

    private  EducadoraEspecial educadoraEspecial;

    public EducadoraEspecialHelper(EducadoraEspecialActivity activity) {

        campoNomeAssistido = activity.findViewById(R.id.editTextNome);
        campoMotivoAtendimento = activity.findViewById(R.id.editTextMotivo);
        campoEncaminhamento = activity.findViewById(R.id.editTextEncaminhamento);
        //campoComunicacaoVerbal = activity.findViewById(R.id.RadioGroupComunicacaoVerbal);
        /*

        campoSegueInstrucoes = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoRespondePerguntas = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoImitaModelos = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoPermaneceNasTarefas = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoCompletaTarefas = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoReconheceAtividades = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoReconheceTrabalhos = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoReconheceErros = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoReconheceNecessidade = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoCompreendeOrdensSimples = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoCompreendeOrdensComplexas = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoRaciocinio = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoMemoriaRemota = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoMemoriaRecente  = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoMemoriaImediata = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoAssimilaAtividades = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoVerbalizaPensamentos = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoEscreve = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoConsegueLer = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoGestualizaMaos = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoFazGaratuja = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoAssinaNome = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoColoriFiguras = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoCopiaLinhas = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoEscreveCaneta = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoUsaBorracha = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoReconheceCires = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoReconheceLetrasAlfabeto = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoReconheceLetrasNome = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoFazPareamento = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoReconheceNumeros = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoPossuiNocao = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoPossuiAtencao = activity.findViewById(R.id.RadioGroupServirSozinho);*/
        campoObservacao = activity.findViewById(R.id.editTextObservacao);
        educadoraEspecial = new EducadoraEspecial();
    }

    public EducadoraEspecial pegaEducadoraEspecial() {
        educadoraEspecial.setNomeAssistido(campoNomeAssistido.getText().toString());
        educadoraEspecial.setMotivoAtendimento(campoMotivoAtendimento.getText().toString());
        educadoraEspecial.setEncaminhamento(campoEncaminhamento.getText().toString());
        //nutricionista.setAlimentarSozinho(campoAlimentarSozinho.getText().toString());
        /*nutricionista.setServirSozinho(String.valueOf(campoServirSozinho.getCheckedRadioButtonId()));
        nutricionista.setQtdAlimento(String.valueOf(campoQtdAlimento.getCheckedRadioButtonId()));
        nutricionista.setPrepararSozinho(String.valueOf(campoPrepararSozinho.getCheckedRadioButtonId()));
        nutricionista.setHabitoIntestinal(String.valueOf(campoHabitoIntestinal.getCheckedRadioButtonId()));
        nutricionista.setMastigacao(String.valueOf(campoMastigacao.getCheckedRadioButtonId()));
        nutricionista.setPatologia(String.valueOf(campoPatologia.getCheckedRadioButtonId()));
        nutricionista.setIntoleranciAlimentar(campoIntoleranciAlimentar.getC);
        nutricionista.setAlergiaAlimentar(campoAlergiaAlimentar.getText().toString());
        nutricionista.setPreferenciaAlimentar(campoPreferenciaAlimentar.getText().toString());
        nutricionista.setNaoConsome(campoNaoConsome.getText().toString());*/
        educadoraEspecial.setObservacao(campoObservacao.getText().toString());

        return educadoraEspecial;
    }

    public void preencheFormularioEE(EducadoraEspecial educadoraEspecial) {

        campoNomeAssistido.setText(educadoraEspecial.getNomeAssistido());
        campoMotivoAtendimento.setText(educadoraEspecial.getMotivoAtendimento());
        campoEncaminhamento.setText(educadoraEspecial.getEncaminhamento());
        //campoComunicacaoVerbal.setText(educadoraEspecial.getComunicacaoVerbal());
        /*educadoraEspecial.setServirSozinho(String.valueOf(campoServirSozinho.getCheckedRadioButtonId()));
        educadoraEspecial.setQtdAlimento(String.valueOf(campoQtdAlimento.getCheckedRadioButtonId()));*/
        campoObservacao.setText(educadoraEspecial.getObservacao());

        this.educadoraEspecial = educadoraEspecial;
    }

    public int verificaRadioButton(EducadoraEspecialActivity activity, RadioGroup rg){

        int selectedId;
        selectedId = rg.getCheckedRadioButtonId();

        return selectedId;
    }
}
