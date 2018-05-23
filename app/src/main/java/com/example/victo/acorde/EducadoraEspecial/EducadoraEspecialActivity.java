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
    @BindView(R.id.r1sim)
    RadioButton comunicacaoVerbalSim;
    @BindView(R.id.r1nao)
    RadioButton comunicacaoVerbalNao;

    @BindView(R.id.RadioGroup02)
    RadioGroup segueInstrucoes;
    @BindView(R.id.r2sim)
    RadioButton segueInstrucoesSim;
    @BindView(R.id.r2nao)
    RadioButton segueInstrucoesNao;

    @BindView(R.id.RadioGroup03)
    RadioGroup respondePerguntas;
    @BindView(R.id.r3sim)
    RadioButton respondePerguntasSim;
    @BindView(R.id.r3nao)
    RadioButton respondePerguntasNao;

    @BindView(R.id.RadioGroup04)
    RadioGroup imitaModelos;
    @BindView(R.id.r4sim)
    RadioButton imitaModelosSim;
    @BindView(R.id.r4nao)
    RadioButton imitaModelosNao;

    @BindView(R.id.RadioGroup05)
    RadioGroup permaneceTarefas;
    @BindView(R.id.r5sim)
    RadioButton permaneceTarefasSim;
    @BindView(R.id.r5nao)
    RadioButton permaneceTarefasNao;

    @BindView(R.id.RadioGroup06)
    RadioGroup completaTarefas;
    @BindView(R.id.r6sim)
    RadioButton completaTarefasSim;
    @BindView(R.id.r6nao)
    RadioButton completaTarefasNao;

    @BindView(R.id.RadioGroup07)
    RadioGroup reconheceAtividades;
    @BindView(R.id.r7sim)
    RadioButton reconheceAtividadesSim;
    @BindView(R.id.r7nao)
    RadioButton reconheceAtividadesNao;

    @BindView(R.id.RadioGroup08)
    RadioGroup reconheceTrabalho;
    @BindView(R.id.r8sim)
    RadioButton reconheceTrabalhoSim;
    @BindView(R.id.r8nao)
    RadioButton reconheceTrabalhoNao;

    @BindView(R.id.RadioGroup09)
    RadioGroup reconheceErro;
    @BindView(R.id.r9sim)
    RadioButton reconheceErroSim;
    @BindView(R.id.r9nao)
    RadioButton reconheceErroNao;

    @BindView(R.id.RadioGroup10)
    RadioGroup reconheceAlgo;
    @BindView(R.id.r10sim)
    RadioButton reconheceAlgoSim;
    @BindView(R.id.r10nao)
    RadioButton reconheceAlgoNao;

    @BindView(R.id.RadioGroup11)
    RadioGroup compreendeOrdemSimples;
    @BindView(R.id.r11sim)
    RadioButton compreendeOrdemSimplesSim;
    @BindView(R.id.r11nao)
    RadioButton compreendeOrdemSimplesNao;

    @BindView(R.id.RadioGroup12)
    RadioGroup compreendeOrdensComplexas;
    @BindView(R.id.r12sim)
    RadioButton compreendeOrdensComplexasSim;
    @BindView(R.id.r12nao)
    RadioButton compreendeOrdensComplexasNao;

    @BindView(R.id.RadioGroup13)
    RadioGroup raciocinio;
    @BindView(R.id.r13sim)
    RadioButton raciocinioSim;
    @BindView(R.id.r13nao)
    RadioButton raciocinioNao;

    @BindView(R.id.RadioGroup14)
    RadioGroup memRemota;
    @BindView(R.id.r14sim)
    RadioButton memRemotaSim;
    @BindView(R.id.r14nao)
    RadioButton memRemotaNao;

    @BindView(R.id.RadioGroup15)
    RadioGroup memRecente;
    @BindView(R.id.r15sim)
    RadioButton memRecenteSim;
    @BindView(R.id.r15nao)
    RadioButton memRecenteNao;

    @BindView(R.id.RadioGroup16)
    RadioGroup memImediata;
    @BindView(R.id.r16sim)
    RadioButton memImediataSim;
    @BindView(R.id.r16nao)
    RadioButton memImediataNao;

    @BindView(R.id.RadioGroup17)
    RadioGroup assimilaAtividades;
    @BindView(R.id.r17sim)
    RadioButton assimilaAtividadesSim;
    @BindView(R.id.r17nao)
    RadioButton assimilaAtividadesNao;

    @BindView(R.id.RadioGroup18)
    RadioGroup verbalizaPensamentos;
    @BindView(R.id.r18sim)
    RadioButton verbalizaPensamentosSim;
    @BindView(R.id.r18nao)
    RadioButton verbalizaPensamentosNao;

    @BindView(R.id.RadioGroup19)
    RadioGroup escreve;
    @BindView(R.id.r19sim)
    RadioButton escreveSim;
    @BindView(R.id.r19nao)
    RadioButton escreveNao;

    @BindView(R.id.RadioGroup20)
    RadioGroup consegueLer;
    @BindView(R.id.r20sim)
    RadioButton consegueLerSim;
    @BindView(R.id.r20nao)
    RadioButton consegueLerNao;

    @BindView(R.id.RadioGroup21)
    RadioGroup gestualizaMaos;
    @BindView(R.id.r21sim)
    RadioButton gestualizaMaosSim;
    @BindView(R.id.r21nao)
    RadioButton gestualizaMaosNao;

    @BindView(R.id.RadioGroup22)
    RadioGroup garatuja;
    @BindView(R.id.r22sim)
    RadioButton garatujaSim;
    @BindView(R.id.r22nao)
    RadioButton garatujaNao;

    @BindView(R.id.RadioGroup23)
    RadioGroup assinaNome;
    @BindView(R.id.r23sim)
    RadioButton assinaNomeSim;
    @BindView(R.id.r23nao)
    RadioButton assinaNomeNao;

    @BindView(R.id.RadioGroup24)
    RadioGroup coloriFiguras;
    @BindView(R.id.r24sim)
    RadioButton coloriFigurasSim;
    @BindView(R.id.r24nao)
    RadioButton coloriFigurasNao;

    @BindView(R.id.RadioGroup25)
    RadioGroup copiaLinhas;
    @BindView(R.id.r25sim)
    RadioButton copiaLinhasSim;
    @BindView(R.id.r25nao)
    RadioButton copiaLinhasNao;

    @BindView(R.id.RadioGroup26)
    RadioGroup escreveCaneta;
    @BindView(R.id.r26sim)
    RadioButton escreveCanetaSim;
    @BindView(R.id.r26nao)
    RadioButton escreveCanetaNao;

    @BindView(R.id.RadioGroup27)
    RadioGroup borracha;
    @BindView(R.id.r27sim)
    RadioButton borrachaSim;
    @BindView(R.id.r27nao)
    RadioButton borrachaNao;

    @BindView(R.id.RadioGroup28)
    RadioGroup reconheceCores;
    @BindView(R.id.r28sim)
    RadioButton reconheceCoresSim;
    @BindView(R.id.r28nao)
    RadioButton reconheceCoresNao;

    @BindView(R.id.RadioGroup29)
    RadioGroup reconheceAlfabeto;
    @BindView(R.id.r29sim)
    RadioButton reconheceAlfabetoSim;
    @BindView(R.id.r29nao)
    RadioButton reconheceAlfabetoNao;

    @BindView(R.id.RadioGroup30)
    RadioGroup reconheceLetras;
    @BindView(R.id.r30sim)
    RadioButton reconheceLetrasSim;
    @BindView(R.id.r30nao)
    RadioButton reconheceLetrasNao;

    @BindView(R.id.RadioGroup31)
    RadioGroup fazPareamento;
    @BindView(R.id.r31sim)
    RadioButton fazPareamentoSim;
    @BindView(R.id.r31nao)
    RadioButton fazPareamentoNao;

    @BindView(R.id.RadioGroup32)
    RadioGroup reconheceNumeros;
    @BindView(R.id.r32sim)
    RadioButton reconheceNumerosSim;
    @BindView(R.id.r32nao)
    RadioButton reconheceNumerosNao;

    @BindView(R.id.RadioGroup33)
    RadioGroup nocaoTempo;
    @BindView(R.id.r33sim)
    RadioButton nocaoTempoSim;
    @BindView(R.id.r33nao)
    RadioButton nocaoTempoNao;

    @BindView(R.id.RadioGroup34)
    RadioGroup possuiAtencao;
    @BindView(R.id.r34sim)
    RadioButton possuiAtencaoSim;
    @BindView(R.id.r34nao)
    RadioButton possuiAtencaoNao;

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

        // Verifica o botao selecionado
        if (selecao1 == comunicacaoVerbalSim.getId()) {
            Toast.makeText(view.getContext(),
                    comunicacaoVerbalSim.getText(),
                    Toast.LENGTH_SHORT).show();
        }
        if (selecao1 == comunicacaoVerbalNao.getId()) {
            Toast.makeText(view.getContext(),
                    comunicacaoVerbalNao.getText(),
                    Toast.LENGTH_SHORT).show();
        }
        if (selecao2 == segueInstrucoesSim.getId()) {
        }
        if (selecao2 == segueInstrucoesNao.getId()) {
        }
        if (selecao3 == respondePerguntasSim.getId()) {
        }
        if (selecao3 == respondePerguntasNao.getId()) {
        }
        if (selecao4 == imitaModelosSim.getId()) {
        }
        if (selecao4 == imitaModelosNao.getId()) {
        }
        if (selecao5 == permaneceTarefasSim.getId()) {
        }
        if (selecao5 == permaneceTarefasNao.getId()) {
        }
        if (selecao6 == completaTarefasSim.getId()) {
        }
        if (selecao6 == completaTarefasNao.getId()) {
        }
        if (selecao7 == reconheceAtividadesSim.getId()) {
        }
        if (selecao7 == reconheceAtividadesNao.getId()) {
        }
        if (selecao8 == reconheceTrabalhoSim.getId()) {
        }
        if (selecao8 == reconheceTrabalhoNao.getId()) {
        }
        if (selecao9 == reconheceErroSim.getId()) {
        }
        if (selecao9 == reconheceErroNao.getId()) {
        }
        if (selecao10 == reconheceAlgoSim.getId()) {
        }
        if (selecao10 == reconheceAlgoNao.getId()) {
        }
        if (selecao11 == compreendeOrdemSimplesSim.getId()) {
        }
        if (selecao11 == compreendeOrdemSimplesNao.getId()) {
        }
        if (selecao12 == compreendeOrdensComplexasSim.getId()) {
        }
        if (selecao12 == compreendeOrdensComplexasNao.getId()) {
        }
        if (selecao13 == raciocinioSim.getId()) {
        }
        if (selecao13 == raciocinioNao.getId()) {
        }
        if (selecao14 == memRemotaSim.getId()) {
        }
        if (selecao14 == memRemotaNao.getId()) {
        }
        if (selecao15 == memRecenteSim.getId()) {
        }
        if (selecao15 == memRecenteNao.getId()) {
        }
        if (selecao16 == memImediataSim.getId()) {
        }
        if (selecao16 == memImediataNao.getId()) {
        }
        if (selecao17 == assimilaAtividadesSim.getId()) {
        }
        if (selecao17 == assimilaAtividadesNao.getId()) {
        }
        if (selecao18 == verbalizaPensamentosSim.getId()) {
        }
        if (selecao18 == verbalizaPensamentosNao.getId()) {
        }
        if (selecao19 == escreveSim.getId()) {
        }
        if (selecao19 == escreveNao.getId()) {
        }
        if (selecao20 == consegueLerSim.getId()) {
        }
        if (selecao20 == consegueLerNao.getId()) {
        }
        if (selecao21 == gestualizaMaosSim.getId()) {
        }
        if (selecao21 == gestualizaMaosNao.getId()) {
        }
        if (selecao22 == garatujaSim.getId()) {
        }
        if (selecao22 == garatujaNao.getId()) {
        }
        if (selecao23 == assinaNomeSim.getId()) {
        }
        if (selecao23 == assinaNomeNao.getId()) {
        }
        if (selecao24 == coloriFigurasSim.getId()) {
        }
        if (selecao24 == coloriFigurasNao.getId()) {
        }
        if (selecao25 == copiaLinhasSim.getId()) {
        }
        if (selecao25 == copiaLinhasNao.getId()) {
        }
        if (selecao26 == escreveCanetaSim.getId()) {
        }
        if (selecao26 == escreveCanetaNao.getId()) {
        }
        if (selecao27 == borrachaSim.getId()) {
        }
        if (selecao27 == borrachaNao.getId()) {
        }
        if (selecao28 == reconheceCoresSim.getId()) {
        }
        if (selecao28 == reconheceCoresNao.getId()) {
        }
        if (selecao29 == reconheceAlfabetoSim.getId()) {
        }
        if (selecao29 == reconheceAlfabetoNao.getId()) {
        }
        if (selecao30 == reconheceLetrasSim.getId()) {
        }
        if (selecao30 == reconheceLetrasNao.getId()) {
        }
        if (selecao31 == fazPareamentoSim.getId()) {
        }
        if (selecao31 == fazPareamentoNao.getId()) {
        }
        if (selecao32 == reconheceNumerosSim.getId()) {
        }
        if (selecao32 == reconheceNumerosNao.getId()) {
        }
        if (selecao33 == nocaoTempoSim.getId()) {
        }
        if (selecao33 == nocaoTempoNao.getId()) {
        }
        if (selecao34 == possuiAtencaoSim.getId()) {
        }
        if (selecao34 == possuiAtencaoNao.getId()) {
        }
    }

}
