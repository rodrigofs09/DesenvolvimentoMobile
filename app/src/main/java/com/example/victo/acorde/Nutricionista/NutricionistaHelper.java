package com.example.victo.acorde.Nutricionista;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.victo.acorde.R;

public class NutricionistaHelper {

    //private final EditText campoData;
    //private final EditText campoTipoAtendimento;
    private final EditText campoNomeAssistido;
    private final EditText campoMotivoAtendimento;
    private final EditText campoEncaminhamento;
    //private final EditText campoProfissional;
    private final EditText campoAltura;
    private final EditText campoPeso;
    private final EditText campoCintura;
    private final EditText campoQuadril;
    private final EditText campoBracos;
    private final RadioButton campoAlimentarSozinho;
    /*private final RadioGroup campoServirSozinho;
    private final RadioGroup campoQtdAlimento;
    private final RadioGroup campoPrepararSozinho;
    private final RadioGroup campoHabitoIntestinal;
    private final RadioGroup campoMastigacao;
    private final RadioGroup campoPatologia;
    private final RadioGroup campoIntoleranciAlimentar;
    private final RadioGroup campoAlergiaAlimentar;
    private final RadioGroup campoPreferenciaAlimentar;
    private final RadioGroup campoNaoConsome;*/
    private final EditText campoObservacao;


    private  Nutricionista nutricionista;

    public NutricionistaHelper(NutricionistaActivity activity) {

        campoNomeAssistido = activity.findViewById(R.id.editTextNome);
        campoMotivoAtendimento = activity.findViewById(R.id.editTextMotivo);
        campoEncaminhamento = activity.findViewById(R.id.editTextEncaminhamento);
        campoAltura = activity.findViewById(R.id.editTextAltura);
        campoPeso = activity.findViewById(R.id.editTextPeso);
        campoCintura = activity.findViewById(R.id.editTextCintura);
        campoQuadril = activity.findViewById(R.id.editTextQuadril);
        campoBracos = activity.findViewById(R.id.editTextBraços);
        campoAlimentarSozinho = verificaRadioButton(activity, (RadioGroup) activity.findViewById(R.id.RadioGroupAlimentarSozinho));
        /*campoServirSozinho = activity.findViewById(R.id.RadioGroupServirSozinho);
        campoQtdAlimento = activity.findViewById(R.id.RadioGroupQtdAlimento);
        campoPrepararSozinho = activity.findViewById(R.id.RadioGroupPrepararAlimento);
        campoHabitoIntestinal = activity.findViewById(R.id.RadioGroupHabitoIntestinal);
        campoMastigacao = activity.findViewById(R.id.RadioGroupMastigacao);
        campoPatologia = activity.findViewById(R.id.RadioGroupPatologia);
        campoIntoleranciAlimentar = activity.findViewById(R.id.RadioGroupIntoleranciaAlimentar);
        campoAlergiaAlimentar = activity.findViewById(R.id.RadioGroupAlergiaAlimentar);
        campoPreferenciaAlimentar = activity.findViewById(R.id.RadioGroupPreferenciaAlimentar);
        campoNaoConsome = activity.findViewById(R.id.RadioGroupNaoConsome);*/
        campoObservacao = activity.findViewById(R.id.editTextObservacao);
        nutricionista = new Nutricionista();
    }

    public Nutricionista pegaNutricionista() {

        nutricionista.setNomeAssistido(campoNomeAssistido.getText().toString());
        nutricionista.setMotivoAtendimento(campoMotivoAtendimento.getText().toString());
        nutricionista.setEncaminhamento(campoEncaminhamento.getText().toString());
        nutricionista.setAltura(campoAltura.getText().toString());
        nutricionista.setPeso(campoPeso.getText().toString());
        nutricionista.setCintura(campoCintura.getText().toString());
        nutricionista.setQuadril(campoQuadril.getText().toString());
        nutricionista.setBracos(campoBracos.getText().toString());
        nutricionista.setAlimentarSozinho(campoAlimentarSozinho.getText().toString());
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
        nutricionista.setObservacao(campoObservacao.getText().toString());

        return nutricionista;
    }

    /*public void preencheFormulario(Nutricionista nutricionista) {

        campoMotivo.setText(nutricionista.getMotivo());
        campoEncaminhamento.setText(nutricionista.getEncaminhamento());
        campoNome.setText(nutricionista.getNome());
        campoPeso.setText(nutricionista.getPeso());
        campoAltura.setText(nutricionista.getAltura());
        campoCintura.setText(nutricionista.getCintura());
        campoQuadril.setText(nutricionista.getQuadril());
        campoBracos.setText(nutricionista.getBracos());
        campoObservacao.setText(nutricionista.getObservacao());

        this.nutricionista = nutricionista;
    }*/

    public RadioButton verificaRadioButton(NutricionistaActivity activity, RadioGroup rg){

        int selectedId;
        RadioButton rb;

        selectedId = rg.getCheckedRadioButtonId();
        rb = activity.findViewById(selectedId);

        return rb;
    }
}
