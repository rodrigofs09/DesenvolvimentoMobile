package com.example.victo.acorde.EducadoraEspecial;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.victo.acorde.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EducadoraEspecialActivity extends AppCompatActivity {

    @BindView(R.id.editTextNome)
    EditText nome;
    @BindView(R.id.editTextMotivo)
    EditText motivo;
    @BindView(R.id.editTextEncaminhamento)
    EditText encaminhamento;

    @BindView(R.id.RadioGroup01)
    RadioGroup comunicacaoVerbal;
    RadioButton rComunicacaoVerbal;

    @BindView(R.id.RadioGroup02)
    RadioGroup segueInstrucoes;
    RadioButton rSegueInstrucoes;

    @BindView(R.id.RadioGroup03)
    RadioGroup respondePerguntas;
    RadioButton rRespondePerguntas;

    @BindView(R.id.RadioGroup04)
    RadioGroup imitaModelos;
    RadioButton rImitaModelos;

    @BindView(R.id.RadioGroup05)
    RadioGroup permaneceTarefas;
    RadioButton rPermaneceTarefas;

    @BindView(R.id.RadioGroup06)
    RadioGroup completaTarefas;
    RadioButton rCompletaTarefas;

    @BindView(R.id.RadioGroup07)
    RadioGroup reconheceAtividades;
    RadioButton rReconheceAtividades;

    @BindView(R.id.RadioGroup08)
    RadioGroup reconheceTrabalho;
    RadioButton rReconheceTrabalho;

    @BindView(R.id.RadioGroup09)
    RadioGroup reconheceErro;
    RadioButton rReconheceErro;

    @BindView(R.id.RadioGroup10)
    RadioGroup reconheceAlgo;
    RadioButton rReconheceAlgo;

    @BindView(R.id.RadioGroup11)
    RadioGroup compreendeOrdemSimples;
    RadioButton rCompreendeOrdemSimples;

    @BindView(R.id.RadioGroup12)
    RadioGroup compreendeOrdensComplexas;
    RadioButton rCompreendeOrdensComplexas;

    @BindView(R.id.RadioGroup13)
    RadioGroup raciocinio;
    RadioButton rRaciocinio;

    @BindView(R.id.RadioGroup14)
    RadioGroup memRemota;
    RadioButton rMemRemota;

    @BindView(R.id.RadioGroup15)
    RadioGroup memRecente;
    RadioButton rMemRecente;

    @BindView(R.id.RadioGroup16)
    RadioGroup memImediata;
    RadioButton rMemImediata;

    @BindView(R.id.RadioGroup17)
    RadioGroup assimilaAtividades;
    RadioButton rAssimilaAtividades;

    @BindView(R.id.RadioGroup18)
    RadioGroup verbalizaPensamentos;
    RadioButton rVerbalizaPensamentos;

    @BindView(R.id.RadioGroup19)
    RadioGroup escreve;
    RadioButton rEscreve;

    @BindView(R.id.RadioGroup20)
    RadioGroup consegueLer;
    RadioButton rConsegueLer;

    @BindView(R.id.RadioGroup21)
    RadioGroup gestualizaMaos;
    RadioButton rGestualizaMaos;

    @BindView(R.id.RadioGroup22)
    RadioGroup garatuja;
    RadioButton rGaratuja;

    @BindView(R.id.RadioGroup23)
    RadioGroup assinaNome;
    RadioButton rAssinaNome;

    @BindView(R.id.RadioGroup24)
    RadioGroup coloriFiguras;
    RadioButton rColoriFiguras;

    @BindView(R.id.RadioGroup25)
    RadioGroup copiaLinhas;
    RadioButton rCopiaLinhas;

    @BindView(R.id.RadioGroup26)
    RadioGroup escreveCaneta;
    RadioButton rEscreveCaneta;

    @BindView(R.id.RadioGroup27)
    RadioGroup borracha;
    RadioButton rBorracha;

    @BindView(R.id.RadioGroup28)
    RadioGroup reconheceCores;
    RadioButton rReconheceCores;

    @BindView(R.id.RadioGroup29)
    RadioGroup reconheceAlfabeto;
    RadioButton rReconheceAlfabeto;

    @BindView(R.id.RadioGroup30)
    RadioGroup reconheceLetras;
    RadioButton rReconheceLetras;

    @BindView(R.id.RadioGroup31)
    RadioGroup fazPareamento;
    RadioButton rFazPareamento;

    @BindView(R.id.RadioGroup32)
    RadioGroup reconheceNumeros;
    RadioButton rReconheceNumeros;

    @BindView(R.id.RadioGroup33)
    RadioGroup nocaoTempo;
    RadioButton rNocaoTempo;

    @BindView(R.id.RadioGroup34)
    RadioGroup possuiAtencao;
    RadioButton rPossuiAtencao;

    @BindView(R.id.editTextObservacao)
    EditText observacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educadora_especial);

        ButterKnife.bind(this);

    }


    public void enviarDados(View view) {
        int selecao1 = comunicacaoVerbal.getCheckedRadioButtonId();
        int selecao2 = segueInstrucoes.getCheckedRadioButtonId();
        int selecao3 = respondePerguntas.getCheckedRadioButtonId();
        int selecao4 = imitaModelos.getCheckedRadioButtonId();
        int selecao5 = permaneceTarefas.getCheckedRadioButtonId();
        int selecao6 = completaTarefas.getCheckedRadioButtonId();
        int selecao7 = reconheceAtividades.getCheckedRadioButtonId();
        int selecao8 = reconheceTrabalho.getCheckedRadioButtonId();
        int selecao9 = reconheceErro.getCheckedRadioButtonId();
        int selecao10 = reconheceAlgo.getCheckedRadioButtonId();
        int selecao11 = compreendeOrdemSimples.getCheckedRadioButtonId();
        int selecao12 = compreendeOrdensComplexas.getCheckedRadioButtonId();
        int selecao13 = raciocinio.getCheckedRadioButtonId();
        int selecao14 = memRemota.getCheckedRadioButtonId();
        int selecao15 = memRecente.getCheckedRadioButtonId();
        int selecao16 = memImediata.getCheckedRadioButtonId();
        int selecao17 = assimilaAtividades.getCheckedRadioButtonId();
        int selecao18 = verbalizaPensamentos.getCheckedRadioButtonId();
        int selecao19 = escreve.getCheckedRadioButtonId();
        int selecao20 = consegueLer.getCheckedRadioButtonId();
        int selecao21 = gestualizaMaos.getCheckedRadioButtonId();
        int selecao22 = garatuja.getCheckedRadioButtonId();
        int selecao23 = assinaNome.getCheckedRadioButtonId();
        int selecao24 = coloriFiguras.getCheckedRadioButtonId();
        int selecao25 = copiaLinhas.getCheckedRadioButtonId();
        int selecao26 = escreveCaneta.getCheckedRadioButtonId();
        int selecao27 = borracha.getCheckedRadioButtonId();
        int selecao28 = reconheceCores.getCheckedRadioButtonId();
        int selecao29 = reconheceAlfabeto.getCheckedRadioButtonId();
        int selecao30 = reconheceLetras.getCheckedRadioButtonId();
        int selecao31 = fazPareamento.getCheckedRadioButtonId();
        int selecao32 = reconheceNumeros.getCheckedRadioButtonId();
        int selecao33 = nocaoTempo.getCheckedRadioButtonId();
        int selecao34 = possuiAtencao.getCheckedRadioButtonId();

        rComunicacaoVerbal = findViewById(selecao1);
        rSegueInstrucoes = findViewById(selecao2);
        rRespondePerguntas = findViewById(selecao3);
        rImitaModelos = findViewById(selecao4);
        rPermaneceTarefas = findViewById(selecao5);
        rCompletaTarefas = findViewById(selecao6);
        rReconheceAtividades = findViewById(selecao7);
        rReconheceTrabalho = findViewById(selecao8);
        rReconheceErro = findViewById(selecao9);
        rReconheceAlgo = findViewById(selecao10);
        rCompreendeOrdemSimples = findViewById(selecao11);
        rCompreendeOrdensComplexas = findViewById(selecao12);
        rRaciocinio = findViewById(selecao13);
        rMemRemota = findViewById(selecao14);
        rMemRecente = findViewById(selecao15);
        rMemImediata = findViewById(selecao16);
        rAssimilaAtividades = findViewById(selecao17);
        rVerbalizaPensamentos = findViewById(selecao18);
        rEscreve = findViewById(selecao19);
        rConsegueLer = findViewById(selecao20);
        rGestualizaMaos = findViewById(selecao21);
        rGaratuja = findViewById(selecao22);
        rAssinaNome = findViewById(selecao23);
        rColoriFiguras = findViewById(selecao24);
        rCopiaLinhas = findViewById(selecao25);
        rEscreveCaneta = findViewById(selecao26);
        rBorracha = findViewById(selecao27);
        rReconheceCores = findViewById(selecao28);
        rReconheceAlfabeto = findViewById(selecao29);
        rReconheceLetras = findViewById(selecao30);
        rFazPareamento = findViewById(selecao31);
        rReconheceNumeros = findViewById(selecao32);
        rNocaoTempo = findViewById(selecao33);
        rPossuiAtencao = findViewById(selecao34);

        // Verifica o botao selecionado
        Toast.makeText(view.getContext(),
                rComunicacaoVerbal.getText(),
                    Toast.LENGTH_SHORT).show();

    }

}
