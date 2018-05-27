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
    RadioButton rAlimentaSozinho;

    @BindView(R.id.RadioGroup02)
    RadioGroup serveSozinho;
    RadioButton rServeSozinho;

    @BindView(R.id.RadioGroup03)
    RadioGroup sabeQtdAlimento;
    RadioButton rSabeQtdAlimento;

    @BindView(R.id.RadioGroup04)
    RadioGroup preparaAlimento;
    RadioButton rPreparaAlimento;

    @BindView(R.id.RadioGroup05)
    RadioGroup habitoIntestinal;
    RadioButton rHabitoIntestinal;

    @BindView(R.id.RadioGroup06)
    RadioGroup mastigacao;
    RadioButton rMastigacao;

    @BindView(R.id.RadioGroup07)
    RadioGroup patologia;
    RadioButton rPatologia;

    @BindView(R.id.editTextPatologia)
    EditText editTextPatologia;

    @BindView(R.id.RadioGroup08)
    RadioGroup intolerancia;
    RadioButton rIntolerancia;

    @BindView(R.id.RadioGroup09)
    RadioGroup alergia;
    RadioButton rAlergia;

    @BindView(R.id.editTextAlergia)
    EditText editTextAlergia;

    @BindView(R.id.RadioGroup10)
    RadioGroup alimentosPreferidos;
    RadioButton rAlimentosPreferidos;

    @BindView(R.id.editTextAlimentosPreferidos)
    EditText editTextAlimentosPreferidos;

    @BindView(R.id.RadioGroup11)
    RadioGroup naoConsomeAlimento;
    RadioButton rNaoConsomeAlimento;

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

        rAlimentaSozinho = findViewById(selecao1);
        rServeSozinho = findViewById(selecao2);
        rSabeQtdAlimento = findViewById(selecao3);
        rPreparaAlimento = findViewById(selecao4);
        rHabitoIntestinal = findViewById(selecao5);
        rMastigacao = findViewById(selecao6);
        rPatologia = findViewById(selecao7);
        rIntolerancia = findViewById(selecao8);
        rAlergia = findViewById(selecao9);
        rAlimentosPreferidos = findViewById(selecao10);
        rNaoConsomeAlimento = findViewById(selecao11);

    }
}
