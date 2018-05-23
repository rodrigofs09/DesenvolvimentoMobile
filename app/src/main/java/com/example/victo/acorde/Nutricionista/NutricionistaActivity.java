package com.example.victo.acorde.Nutricionista;

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

public class NutricionistaActivity extends AppCompatActivity {

    @BindView(R.id.editTextNome)
    EditText nome;
    @BindView(R.id.editTextMotivo)
    EditText motivo;
    @BindView(R.id.editTextEncaminhamento)
    EditText encaminhamento;
    @BindView(R.id.editTextAltura)
    EditText altura;
    @BindView(R.id.editTextPeso)
    EditText peso;
    @BindView(R.id.editTextCintura)
    EditText cintura;
    @BindView(R.id.editTextQuadril)
    EditText quadril;
    @BindView(R.id.editTextBraços)
    EditText bracos;

    @BindView(R.id.RadioGroup01)
    RadioGroup alimentaSozinho;
    @BindView(R.id.r1sim)
    RadioButton alimentaSozinhoSim;
    @BindView(R.id.r1nao)
    RadioButton alimentaSozinhoNao;

    @BindView(R.id.RadioGroup02)
    RadioGroup serveSozinho;
    @BindView(R.id.r2sim)
    RadioButton serveSozinhoSim;
    @BindView(R.id.r2nao)
    RadioButton serveSozinhoNao;

    @BindView(R.id.RadioGroup03)
    RadioGroup sabeQtdAlimento;
    @BindView(R.id.r3sim)
    RadioButton sabeQtdAlimentoSim;
    @BindView(R.id.r3nao)
    RadioButton sabeQtdAlimentoNao;

    @BindView(R.id.RadioGroup04)
    RadioGroup preparaAlimento;
    @BindView(R.id.r4sim)
    RadioButton preparaAlimentoSim;
    @BindView(R.id.r4nao)
    RadioButton preparaAlimentoNao;

    @BindView(R.id.RadioGroup05)
    RadioGroup habitoIntestinal;
    @BindView(R.id.r5abaixo)
    RadioButton habitoIntestinalAbaixo;
    @BindView(R.id.r5regular)
    RadioButton habitoIntestinalRegular;
    @BindView(R.id.r5bom)
    RadioButton habitoIntestinalBom;

    @BindView(R.id.RadioGroup06)
    RadioGroup mastigacao;
    @BindView(R.id.r6rapida)
    RadioButton mastigacaoRapida;
    @BindView(R.id.r6moderada)
    RadioButton mastigacaoModerada;
    @BindView(R.id.r6devagar)
    RadioButton mastigacaoDevagar;

    @BindView(R.id.RadioGroup07)
    RadioGroup patologia;
    @BindView(R.id.r7sim)
    RadioButton patologiaSim;
    @BindView(R.id.r7nao)
    RadioButton patologiaNao;

    @BindView(R.id.editTextPatologia)
    EditText editTextPatologia;

    @BindView(R.id.RadioGroup08)
    RadioGroup intolerancia;
    @BindView(R.id.r8sim)
    RadioButton intoleranciaSim;
    @BindView(R.id.r8nao)
    RadioButton intoleranciaNao;

    @BindView(R.id.RadioGroup09)
    RadioGroup alergia;
    @BindView(R.id.r9sim)
    RadioButton alergiaSim;
    @BindView(R.id.r9nao)
    RadioButton alergiaNao;

    @BindView(R.id.editTextAlergia)
    EditText editTextAlergia;

    @BindView(R.id.RadioGroup10)
    RadioGroup alimentosPreferidos;
    @BindView(R.id.r10sim)
    RadioButton alimentosPreferidosSim;
    @BindView(R.id.r10nao)
    RadioButton alimentosPreferidosNao;

    @BindView(R.id.editTextAlimentosPreferidos)
    EditText editTextAlimentosPreferidos;

    @BindView(R.id.RadioGroup11)
    RadioGroup naoConsomeAlimento;
    @BindView(R.id.r11sim)
    RadioButton naoConsomeAlimentoSim;
    @BindView(R.id.r11nao)
    RadioButton naoConsomeAlimentoNao;

    @BindView(R.id.editTextNaoConsomeAlimento)
    EditText editTextNaoConsomeAlimento;

    @BindView(R.id.editTextObservacao)
    EditText observacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutricionista);

        ButterKnife.bind(this);
    }



    public void enviarDados(View view) {
        int selecao1 = alimentaSozinho.getCheckedRadioButtonId();
        int selecao2 = serveSozinho.getCheckedRadioButtonId();
        int selecao3 = sabeQtdAlimento.getCheckedRadioButtonId();
        int selecao4 = preparaAlimento.getCheckedRadioButtonId();
        int selecao5 = habitoIntestinal.getCheckedRadioButtonId();
        int selecao6 = mastigacao.getCheckedRadioButtonId();
        int selecao7 = patologia.getCheckedRadioButtonId();
        int selecao8 = intolerancia.getCheckedRadioButtonId();
        int selecao9 = alergia.getCheckedRadioButtonId();
        int selecao10 = alimentosPreferidos.getCheckedRadioButtonId();
        int selecao11 = naoConsomeAlimento.getCheckedRadioButtonId();

        // Verifica o botao selecionado
        if (selecao1 == alimentaSozinhoSim.getId()) {
        }
        if (selecao1 == alimentaSozinhoNao.getId()) {
        }
        if (selecao2 == serveSozinhoSim.getId()) {
        }
        if (selecao2 == serveSozinhoNao.getId()) {
        }
        if (selecao3 == sabeQtdAlimentoSim.getId()) {
        }
        if (selecao3 == sabeQtdAlimentoNao.getId()) {
        }
        if (selecao4 == preparaAlimentoSim.getId()) {
        }
        if (selecao4 == preparaAlimentoNao.getId()) {
        }
        if (selecao5 == habitoIntestinalAbaixo.getId()) {
            Toast.makeText(view.getContext(),
                    habitoIntestinalAbaixo.getText(),
                    Toast.LENGTH_SHORT).show();
        }
        if (selecao5 == habitoIntestinalBom.getId()) {
            Toast.makeText(view.getContext(),
                    habitoIntestinalBom.getText(),
                    Toast.LENGTH_SHORT).show();
        }
        if (selecao5 == habitoIntestinalRegular.getId()) {
            Toast.makeText(view.getContext(),
                    habitoIntestinalRegular.getText(),
                    Toast.LENGTH_SHORT).show();
        }
        if (selecao6 == mastigacaoDevagar.getId()) {
        }
        if (selecao6 == mastigacaoModerada.getId()) {
        }
        if (selecao6 == mastigacaoRapida.getId()) {
        }
        if (selecao7 == patologiaSim.getId()) {
        }
        if (selecao7 == patologiaNao.getId()) {
        }
        if (selecao8 == intoleranciaSim.getId()) {
        }
        if (selecao8 == intoleranciaNao.getId()) {
        }
        if (selecao9 == alergiaSim.getId()) {
        }
        if (selecao9 == alergiaNao.getId()) {
        }
        if (selecao10 == alimentosPreferidosSim.getId()) {
        }
        if (selecao10 == alimentosPreferidosNao.getId()) {
        }
        if (selecao11 == naoConsomeAlimentoSim.getId()) {
        }
        if (selecao11 == naoConsomeAlimentoNao.getId()) {
        }
    }
}
