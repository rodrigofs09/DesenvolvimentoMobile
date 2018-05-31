package com.example.victo.acorde.EducadoraEspecial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.victo.acorde.Main.MainActivity;
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

    @BindView(R.id.RadioGroupComunicacaoVerbal)
    RadioGroup comunicacaoVerbal;
    RadioButton rComunicacaoVerbal;

    @BindView(R.id.RadioGroupSegueInstrucoes)
    RadioGroup segueInstrucoes;
    RadioButton rSegueInstrucoes;

    @BindView(R.id.RadioGroupRespondePerguntas)
    RadioGroup respondePerguntas;
    RadioButton rRespondePerguntas;

    @BindView(R.id.RadioGroupImitaModelos)
    RadioGroup imitaModelos;
    RadioButton rImitaModelos;

    @BindView(R.id.RadioGroupPermaneceNasTarefas)
    RadioGroup permaneceTarefas;
    RadioButton rPermaneceTarefas;

    @BindView(R.id.RadioGroupCompletaTarefas)
    RadioGroup completaTarefas;
    RadioButton rCompletaTarefas;

    @BindView(R.id.RadioGroupReconheceAtividades)
    RadioGroup reconheceAtividades;
    RadioButton rReconheceAtividades;

    @BindView(R.id.RadioGroupReconheceTrabalhos)
    RadioGroup reconheceTrabalho;
    RadioButton rReconheceTrabalho;

    @BindView(R.id.RadioGroupReconheceErros)
    RadioGroup reconheceErro;
    RadioButton rReconheceErro;

    @BindView(R.id.ReconheceNecessidade)
    RadioGroup reconheceAlgo;
    RadioButton rReconheceAlgo;

    @BindView(R.id.RadioGroupCompreendeOrdensSimples)
    RadioGroup compreendeOrdemSimples;
    RadioButton rCompreendeOrdemSimples;

    @BindView(R.id.RadioGroupCompreendeOrdensComplexas)
    RadioGroup compreendeOrdensComplexas;
    RadioButton rCompreendeOrdensComplexas;

    @BindView(R.id.RadioGroupRaciocinio)
    RadioGroup raciocinio;
    RadioButton rRaciocinio;

    @BindView(R.id.RadioGroupMemoriaRemota)
    RadioGroup memRemota;
    RadioButton rMemRemota;

    @BindView(R.id.RadioGroupMemoriaRecente)
    RadioGroup memRecente;
    RadioButton rMemRecente;

    @BindView(R.id.RadioGroupMemoriaImediata)
    RadioGroup memImediata;
    RadioButton rMemImediata;

    @BindView(R.id.RadioGroupAssimilaAtividades)
    RadioGroup assimilaAtividades;
    RadioButton rAssimilaAtividades;

    @BindView(R.id.RadioGroupVerbalizaPensamentos)
    RadioGroup verbalizaPensamentos;
    RadioButton rVerbalizaPensamentos;

    @BindView(R.id.RadioGroupEscreve)
    RadioGroup escreve;
    RadioButton rEscreve;

    @BindView(R.id.RadioGroupConsegueLer)
    RadioGroup consegueLer;
    RadioButton rConsegueLer;

    @BindView(R.id.RadioGroupGestualizaMaos)
    RadioGroup gestualizaMaos;
    RadioButton rGestualizaMaos;

    @BindView(R.id.RadioGroupFazGaratuja)
    RadioGroup garatuja;
    RadioButton rGaratuja;

    @BindView(R.id.RadioGroupAssinaNome)
    RadioGroup assinaNome;
    RadioButton rAssinaNome;

    @BindView(R.id.RadioGroupColoriFiguras)
    RadioGroup coloriFiguras;
    RadioButton rColoriFiguras;

    @BindView(R.id.RadioGroupCopiaLinhas)
    RadioGroup copiaLinhas;
    RadioButton rCopiaLinhas;

    @BindView(R.id.RadioGroupEscreveCaneta)
    RadioGroup escreveCaneta;
    RadioButton rEscreveCaneta;

    @BindView(R.id.RadioGroupUsaBorracha)
    RadioGroup borracha;
    RadioButton rBorracha;

    @BindView(R.id.ReconheceCores)
    RadioGroup reconheceCores;
    RadioButton rReconheceCores;

    @BindView(R.id.RadioGroupReconhceLetrasAlfabeto)
    RadioGroup reconheceAlfabeto;
    RadioButton rReconheceAlfabeto;

    @BindView(R.id.RadioGroupReconheceLetrasNome)
    RadioGroup reconheceLetras;
    RadioButton rReconheceLetras;

    @BindView(R.id.RadioGroupFazPareamento)
    RadioGroup fazPareamento;
    RadioButton rFazPareamento;

    @BindView(R.id.RadioGroupReconheceNumeros)
    RadioGroup reconheceNumeros;
    RadioButton rReconheceNumeros;

    @BindView(R.id.RadioGroupPossuiNocao)
    RadioGroup nocaoTempo;
    RadioButton rNocaoTempo;

    @BindView(R.id.RadioGroupPossuiAtencao)
    RadioGroup possuiAtencao;
    RadioButton rPossuiAtencao;

    @BindView(R.id.editTextObservacao)
    EditText observacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educadora_especial);

        ButterKnife.bind(this);

        //cria a toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //adiciona titulo e define o botao <- na toolbar
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(R.string.educadoraEspecial);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
