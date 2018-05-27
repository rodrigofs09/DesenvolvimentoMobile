package com.example.victo.acorde.Nutricionista;

import android.widget.CheckBox;
import android.widget.EditText;

import com.example.victo.acorde.R;

import java.util.Date;

public class NutricionistaHelper {

    private final EditText campoData;
    private final EditText campoTipoAtendimento;
    private final EditText campoMotivo;
    private final EditText campoEncaminhamento;
    private final EditText campoNome;
    private final EditText campoPeso;
    private final EditText campoAltura;
    private final EditText campoCintura;
    private final EditText campoQuadril;
    private final EditText campoBracos;
    /*private final CheckBox campoAlimentar;
    private final CheckBox campoServir;
    private final CheckBox campoQtdAlimento;
    private final CheckBox campoPreparar;
    private final CheckBox campoPtologia;
    private final CheckBox campoHabitoIntestinal;
    private final CheckBox campoIntoleranciAlimentar;
    private final CheckBox campoAlergiaAlimentar;
    private final CheckBox campoPreferenciaAlimentar;*/
    private final EditText campoObservacao;

    private  Nutricionista nutricionista;

    public NutricionistaHelper(NutricionistaActivity activity) {

        campoData = (EditText) activity.findViewById(R.id.editTextData);
        campoTipoAtendimento = (EditText) activity.findViewById(R.id.editTextTipo);
        campoMotivo = (EditText) activity.findViewById(R.id.editTextMotivo);
        campoEncaminhamento = (EditText) activity.findViewById(R.id.editTextEncaminhamento);
        campoNome = (EditText) activity.findViewById(R.id.editTextNome);
        campoPeso = (EditText) activity.findViewById(R.id.editTextPeso);
        campoAltura = (EditText) activity.findViewById(R.id.editTextAltura);
        campoCintura = (EditText) activity.findViewById(R.id.editTextCintura);
        campoQuadril = (EditText) activity.findViewById(R.id.editTextQuadril);
        campoBracos = (EditText) activity.findViewById(R.id.editTextBraços);
        campoObservacao = (EditText) activity.findViewById(R.id.editTextObservacao);
    }

    public Nutricionista pegaNutricionista() {

        //nutricionista.setData(campoData.getText().toString());
        nutricionista.setTipoAtendimento(campoTipoAtendimento.getText().toString());
        nutricionista.setMotivo(campoMotivo.getText().toString());
        nutricionista.setEncaminhamento(campoEncaminhamento.getText().toString());
        nutricionista.setNome(campoNome.getText().toString());
        nutricionista.setPeso(campoPeso.getText().toString());
        nutricionista.setAltura(campoAltura.getText().toString());
        nutricionista.setCintura(campoCintura.getText().toString());
        nutricionista.setQuadril(campoQuadril.getText().toString());
        nutricionista.setBracos(campoBracos.getText().toString());
        nutricionista.setObservacao(campoObservacao.getText().toString());

        return nutricionista;
    }

    public void preencheFormulario(Nutricionista nutricionista) {

        //campoData.setText(nutricionista.getData().toString());
        campoTipoAtendimento.setText(nutricionista.getTipoAtendimento());
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
    }
}
