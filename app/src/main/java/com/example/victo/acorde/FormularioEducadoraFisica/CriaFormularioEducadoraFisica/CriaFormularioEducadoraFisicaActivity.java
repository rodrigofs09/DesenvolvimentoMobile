package com.example.victo.acorde.FormularioEducadoraFisica.CriaFormularioEducadoraFisica;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.victo.acorde.FormularioEducadoraFisica.FormularioEducadoraFisica;
import com.example.victo.acorde.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class CriaFormularioEducadoraFisicaActivity extends AppCompatActivity implements CriaFormularioEducadoraFisica.View {

    @BindView(R.id.text_input_layout_nome)
    TextInputLayout nomeInputLayout;
    @BindView(R.id.text_input_layout_data)
    TextInputLayout dataInputLayout;
    @BindView(R.id.dataFormulario)
    TextView campoDataAtendimento;
    @BindView(R.id.editTextNome)
    EditText campoNomeAssistido;
    @BindView(R.id.editTextMotivo)
    EditText campoMotivoAtendimento;
    @BindView(R.id.editTextEncaminhamento)
    EditText campoEncaminhamento;
    @BindView(R.id.editTextIdade)
    EditText campoIdade;
    @BindView(R.id.editTextPeso)
    EditText campoPeso;
    @BindView(R.id.editTextAltura)
    EditText campoAltura;
    @BindView(R.id.editTextBracoDireito)
    EditText campoBracoDireito;
    @BindView(R.id.editTextBracoEsquerdo)
    EditText campoBracoEsquerdo;
    @BindView(R.id.editTextPernaDireita)
    EditText campoPernaDireita;
    @BindView(R.id.editTextPernaEsquerda)
    EditText campoPernaEsquerda;
    @BindView(R.id.editTextCintura)
    EditText campoCintura;
    @BindView(R.id.editTextQuadril)
    EditText campoQuadril;
    @BindView(R.id.RadioGroupDesempenhoGeral)
    RadioGroup campoDesempenhoGeral;
    @BindView(R.id.RadioGroupDesempenhoEspecifico)
    RadioGroup campoDesempenhoEspecifico;
    @BindView(R.id.RadioGroupAspectosMotrizes)
    RadioGroup campoAspectosMotrizes;
    @BindView(R.id.RadioGroupAspectosCognitivos)
    RadioGroup campoAspectosCognitivos;
    @BindView(R.id.RadioGroupAspectosSociais)
    RadioGroup campoAspectosSociais;
    @BindView(R.id.editTextObservacao)
    EditText campoObservacao;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    CriaFormularioEducadoraFisica.Presenter presenter;

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cria_formulario_educadora_fisica);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(R.string.formularioEducadoraFisica);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        campoDataAtendimento.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(CriaFormularioEducadoraFisicaActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);
                if(dialog.getWindow()!=null)
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;

                date = day + "/" + month + "/" + year;
                campoDataAtendimento.setText(date);
            }
        };

        presenter = new CriaFormularioEducadoraFisicaPresenter(this, this);

        final Intent intent = getIntent();
        presenter.setFormularioEducadoraFisica((FormularioEducadoraFisica) intent.getSerializableExtra("formularioEducadoraFisica"));
        presenter.getFormularioEducadoraFisica();
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

    @OnClick(R.id.buttonFinalizar)
    public void cliqueFinalizar(){
        presenter.registrar(campoNomeAssistido.getText().toString(), campoDataAtendimento.getText().toString());
    }

    @Override
    public void setInfosFormularioEducadoraFisica(String dataAtendimento, String nomeAssistido, String motivoAtendimento, String encaminhamento, String idade, String peso, String altura
            , String bracoDireito, String bracoEsquerdo, String pernaDireita, String pernaEsquerda, String cintura, String quadril, int desempenhoGeral, int desempenhoEspecifico, int aspectosMotrizes
            , int aspectosCognitivos, int aspectosSociais, String observacao){
        campoDataAtendimento.setText(dataAtendimento);
        campoNomeAssistido.setText(nomeAssistido);
        campoMotivoAtendimento.setText(motivoAtendimento);
        campoEncaminhamento.setText(encaminhamento);
        campoIdade.setText(idade);
        campoPeso.setText(peso);
        campoAltura.setText(altura);
        campoBracoDireito.setText(bracoDireito);
        campoBracoEsquerdo.setText(bracoEsquerdo);
        campoPernaDireita.setText(pernaDireita);
        campoPernaEsquerda.setText(pernaEsquerda);
        campoCintura.setText(cintura);
        campoQuadril.setText(quadril);
        campoDesempenhoGeral.check(desempenhoGeral);
        campoDesempenhoEspecifico.check(desempenhoEspecifico);
        campoAspectosMotrizes.check(aspectosMotrizes);
        campoAspectosCognitivos.check(aspectosCognitivos);
        campoAspectosSociais.check(aspectosSociais);
        campoObservacao.setText(observacao);
    }

    @OnTextChanged(R.id.editTextNome)
    public void validaNome (){
        nomeInputLayout.setErrorEnabled( false );
        nomeInputLayout.setError( "" );
    }

    @OnTextChanged (R.id.dataFormulario)
    public void validaData (){
        dataInputLayout.setErrorEnabled( false );
        dataInputLayout.setError( "" );
    }

    public void erroNome(){
        nomeInputLayout.setErrorEnabled( true );
        nomeInputLayout.setError(getString(R.string.invalid_name));
        Toast.makeText(getApplicationContext(), "Nome inválido", Toast.LENGTH_SHORT).show();
    }

    public void erroData(){
        dataInputLayout.setErrorEnabled( true );
        dataInputLayout.setError(getString(R.string.invalid_date));
        Toast.makeText(getApplicationContext(), "Data inválida", Toast.LENGTH_SHORT).show();
    }

    public void registroComSucesso(){
        presenter.setFormularioEducadoraFisica(campoDataAtendimento.getText().toString(), campoNomeAssistido.getText().toString(),campoMotivoAtendimento.getText().toString(),campoEncaminhamento.getText().toString(),campoIdade.getText().toString()
                ,campoPeso.getText().toString(),campoAltura.getText().toString(),campoBracoDireito.getText().toString(),campoBracoEsquerdo.getText().toString(),campoPernaDireita.getText().toString()
                ,campoPernaEsquerda.getText().toString(),campoCintura.getText().toString(),campoQuadril.getText().toString(),campoDesempenhoGeral.getCheckedRadioButtonId(), campoDesempenhoEspecifico.getCheckedRadioButtonId()
                ,campoAspectosMotrizes.getCheckedRadioButtonId(),campoAspectosCognitivos.getCheckedRadioButtonId(),campoAspectosSociais.getCheckedRadioButtonId(), campoObservacao.getText().toString());
        Toast.makeText(getApplicationContext(), "Relatório salvo com sucesso", Toast.LENGTH_SHORT).show();
        finish();
    }

}
