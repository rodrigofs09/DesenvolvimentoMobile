package com.example.victo.acorde.EducadoraFisica;


import android.widget.EditText;

import com.example.victo.acorde.R;

public class EducadoraFisicaHelper {

    private final EditText campoNomeAssistido;
    private final EditText campoMotivoAtendimento;
    private final EditText campoEncaminhamento;
    private final EditText campoArco;
    private final EditText campoMms;
    private final EditText campoMmii;
    private final EditText campoTronco;
    private final EditText campoMarcha1;
    private final EditText campoMarcha2;
    private final EditText campoMarcha3;
    private final EditText campoPolichinelo;
    private final EditText campoPolichineloObs;
    private final EditText campoLego;
    private final EditText campoLegoObs;
    private final EditText campoPintar;
    private final EditText campoControle;
    private final EditText campoDimensaoC;
    private final EditText campoDimensaoFrente;
    private final EditText campoDimensaoTras;
    private final EditText campoDimensaoDireita;
    private final EditText campoDimensaoEsquerda;
    private final EditText campoDimensaoCima;
    private final EditText campoDimensaoBaixo;
    private final EditText campoObservacao;

    private EducadoraFisica educadoraFisica;

    public EducadoraFisicaHelper(EducadoraFisicaActivity activity) {

        campoNomeAssistido = activity.findViewById(R.id.editTextNome);
        campoMotivoAtendimento = activity.findViewById(R.id.editTextMotivo);
        campoEncaminhamento = activity.findViewById(R.id.editTextEncaminhamento);
        campoArco = activity.findViewById(R.id.editTextArco);
        campoMms = activity.findViewById(R.id.editTextMMS);
        campoMmii = activity.findViewById(R.id.editTextMMII);
        campoTronco = activity.findViewById(R.id.editTextTronco);
        campoMarcha1 = activity.findViewById(R.id.editTextMarcha1);
        campoMarcha2 = activity.findViewById(R.id.editTextMarcha2);
        campoMarcha3 = activity.findViewById(R.id.editTextMarcha3);
        campoPolichinelo = activity.findViewById(R.id.editTextPolichinelo);
        campoPolichineloObs = activity.findViewById(R.id.editTextPolichineloObs);
        campoLego = activity.findViewById(R.id.editTextLego);
        campoLegoObs = activity.findViewById(R.id.editTextLegoObs);
        campoPintar = activity.findViewById(R.id.editTextPintar);
        campoControle = activity.findViewById(R.id.editTextControle);
        campoDimensaoC = activity.findViewById(R.id.editTextDimensaoC);
        campoDimensaoFrente = activity.findViewById(R.id.editTextDimensaoFrente);
        campoDimensaoTras = activity.findViewById(R.id.editTextDimensaoTras);
        campoDimensaoDireita = activity.findViewById(R.id.editTextDimensaoDireito);
        campoDimensaoEsquerda = activity.findViewById(R.id.editTextDimensaoEsquerdo);
        campoDimensaoCima = activity.findViewById(R.id.editTextDimensaoCima);
        campoDimensaoBaixo = activity.findViewById(R.id.editTextDimensaoBaixo);
        campoObservacao = activity.findViewById(R.id.editTextObservacao);

        educadoraFisica = new EducadoraFisica();
    }

    public EducadoraFisica pegaEducadoraFisica() {

        educadoraFisica.setNomeAssistido(campoNomeAssistido.getText().toString());
        educadoraFisica.setMotivoAtendimento(campoMotivoAtendimento.getText().toString());
        educadoraFisica.setEncaminhamento(campoEncaminhamento.getText().toString());
        educadoraFisica.setArco(campoArco.getText().toString());
        educadoraFisica.setMms(campoMms.getText().toString());
        educadoraFisica.setMmii(campoMmii.getText().toString());
        educadoraFisica.setTronco(campoTronco.getText().toString());
        educadoraFisica.setMarcha1(campoMarcha1.getText().toString());
        educadoraFisica.setMarcha2(campoMarcha2.getText().toString());
        educadoraFisica.setMarcha3(campoMarcha3.getText().toString());
        educadoraFisica.setPolichinelo(campoPolichinelo.getText().toString());
        educadoraFisica.setPolichineloObs(campoPolichineloObs.getText().toString());
        educadoraFisica.setLego(campoLego.getText().toString());
        educadoraFisica.setLegoObs(campoLegoObs.getText().toString());
        educadoraFisica.setPintar(campoPintar.getText().toString());
        educadoraFisica.setControle(campoControle.getText().toString());
        educadoraFisica.setDimensaoC(campoDimensaoC.getText().toString());
        educadoraFisica.setDimensaoFrente(campoDimensaoFrente.getText().toString());
        educadoraFisica.setDimensaoTras(campoDimensaoTras.getText().toString());
        educadoraFisica.setDimensaoDireita(campoDimensaoDireita.getText().toString());
        educadoraFisica.setDimensaoEsquerda(campoDimensaoEsquerda.getText().toString());
        educadoraFisica.setDimensaoCima(campoDimensaoCima.getText().toString());
        educadoraFisica.setDimensaoBaixo(campoDimensaoBaixo.getText().toString());
        educadoraFisica.setObservacao(campoObservacao.getText().toString());

        return educadoraFisica;
    }

    public void preencheFormularioEF(EducadoraFisica educadoraFisica) {

        campoNomeAssistido.setText(educadoraFisica.getNomeAssistido());
        campoMotivoAtendimento.setText(educadoraFisica.getMotivoAtendimento());
        campoEncaminhamento.setText(educadoraFisica.getEncaminhamento());
        campoArco.setText(educadoraFisica.getArco());
        campoMms.setText(educadoraFisica.getMms());
        campoMmii.setText(educadoraFisica.getMmii());
        campoTronco.setText(educadoraFisica.getTronco());
        campoMarcha1.setText(educadoraFisica.getMarcha1());
        campoMarcha2.setText(educadoraFisica.getMarcha2());
        campoMarcha3.setText(educadoraFisica.getMarcha3());
        campoPolichinelo.setText(educadoraFisica.getPolichinelo());
        campoPolichineloObs.setText(educadoraFisica.getPolichineloObs());
        campoLego.setText(educadoraFisica.getLego());
        campoLegoObs.setText(educadoraFisica.getLegoObs());
        campoPintar.setText(educadoraFisica.getPintar());
        campoControle.setText(educadoraFisica.getControle());
        campoDimensaoC.setText(educadoraFisica.getDimensaoC());
        campoDimensaoFrente.setText(educadoraFisica.getDimensaoFrente());
        campoDimensaoTras.setText(educadoraFisica.getDimensaoTras());
        campoDimensaoDireita.setText(educadoraFisica.getDimensaoDireita());
        campoDimensaoEsquerda.setText(educadoraFisica.getDimensaoEsquerda());
        campoDimensaoCima.setText(educadoraFisica.getDimensaoCima());
        campoDimensaoBaixo.setText(educadoraFisica.getDimensaoBaixo());
        campoObservacao.setText(educadoraFisica.getObservacao());

        this.educadoraFisica = educadoraFisica;
    }
}
