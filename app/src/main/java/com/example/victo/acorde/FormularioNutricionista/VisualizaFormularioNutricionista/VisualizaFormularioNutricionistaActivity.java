package com.example.victo.acorde.FormularioNutricionista.VisualizaFormularioNutricionista;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.victo.acorde.FormularioNutricionista.FormularioNutricionista;
import com.example.victo.acorde.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class VisualizaFormularioNutricionistaActivity extends AppCompatActivity implements VisualizaFormularioNutricionistaContract.View {

    @BindView(R.id.text_input_layout_nome)
    TextInputLayout nomeInputLayout;
    @BindView(R.id.text_input_layout_data)
    TextInputLayout dataInputLayout;
    @BindView(R.id.dataFormulario)
    TextView campoDataAtendimento;
    @BindView(R.id.nome_assistido)
    TextView campoNomeAssistido;
    @BindView(R.id.assistido_motivo)
    TextView campoMotivoAtendimento;
    @BindView(R.id.assistido_encaminhamento)
    TextView campoEncaminhamento;
    @BindView(R.id.assistido_altura)
    TextView campoAltura;
    @BindView(R.id.assistido_peso)
    TextView campoPeso;
    @BindView(R.id.assistido_cintura)
    TextView campoCintura;
    @BindView(R.id.assistido_quadril)
    TextView campoQuadril;
    @BindView(R.id.assistido_bracos)
    TextView campoBracos;
    /*@BindView(R.id.RadioGroupAlimentarSozinho)
    RadioGroup campoAlimentarSozinho;
    @BindView(R.id.RadioGroupServirSozinho)
    RadioGroup campoServirSozinho;
    @BindView(R.id.RadioGroupQtdAlimento)
    RadioGroup campoQtdAlimento;
    @BindView(R.id.RadioGroupPrepararAlimento)
    RadioGroup campoPrepararSozinho;
    @BindView(R.id.RadioGroupHabitoIntestinal)
    RadioGroup campoHabitoIntestinal;
    @BindView(R.id.RadioGroupMastigacao)
    RadioGroup campoMastigacao;
    @BindView(R.id.RadioGroupPatologia)
    RadioGroup campoPatologia;
    @BindView(R.id.RadioGroupAlergiaAlimentar)
    RadioGroup campoAlergiaAlimentar;
    @BindView(R.id.RadioGroupPreferenciaAlimentar)
    RadioGroup campoPreferenciaAlimentar;
    @BindView(R.id.RadioGroupNaoConsome)
    RadioGroup campoNaoConsome;*/
    @BindView(R.id.assistido_observacoes)
    TextView campoObservacao;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    VisualizaFormularioNutricionistaContract.Presenter presenter;

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualiza_formulario_nutricionista);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(R.string.formularioNutricionista);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
/*
        campoDataAtendimento.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(VisualizaFormularioNutricionistaActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);
                if(dialog.getWindow()!=null) {
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                }
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                //Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                date = day + "/" + month + "/" + year;
                campoDataAtendimento.setText(date);
            }
        };*/

        presenter = new VisualizaFormularioNutricionistaPresenter(this, this);

        final Intent intent = getIntent();
        presenter.setFormularioNutricionista((FormularioNutricionista) intent.getSerializableExtra("formularioNutricionista"));
        presenter.getFormularioNutricionista();
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

    /*
    @OnClick(R.id.buttonFinalizar)
    public void cliqueFinalizar(){
        presenter.registrar(campoNomeAssistido.getText().toString(), campoDataAtendimento.getText().toString());
    }
    */
    @Override
    public void setInfosFormularioNutricionista(String dataAtendimento, String nomeAssistido, String motivoAtendimento, String encaminhamento, String altura, String peso, String cintura, String quadril, String bracos, int alimentarSozinho, int servirSozinho, int qtdAlimento, int prepararSozinho, int habitoIntestinal, int mastigacao, int patologia,
                                                int alergiaAlimentar, int preferenciaAlimentar, int naoConsome, String observacao){
        campoDataAtendimento.setText(dataAtendimento);
        campoNomeAssistido.setText(nomeAssistido);
        campoMotivoAtendimento.setText(motivoAtendimento);
        campoEncaminhamento.setText(encaminhamento);
        campoAltura.setText(altura);
        campoPeso.setText(peso);
        campoCintura.setText(cintura);
        campoQuadril.setText(quadril);
        campoBracos.setText(bracos);/*
        campoAlimentarSozinho.check(alimentarSozinho);
        campoServirSozinho.check(servirSozinho);
        campoQtdAlimento.check(qtdAlimento);
        campoPrepararSozinho.check(prepararSozinho);
        campoHabitoIntestinal.check(habitoIntestinal);
        campoMastigacao.check(mastigacao);
        campoPatologia.check(patologia);
        campoAlergiaAlimentar.check(alergiaAlimentar);
        campoPreferenciaAlimentar.check(preferenciaAlimentar);
        campoNaoConsome.check(naoConsome);*/
        campoObservacao.setText(observacao);
    }
    /*

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
        presenter.setFormularioNutricionista(campoDataAtendimento.getText().toString(), campoNomeAssistido.getText().toString(),campoMotivoAtendimento.getText().toString(),campoEncaminhamento.getText().toString(),campoAltura.getText().toString(),
                campoPeso.getText().toString(),campoCintura.getText().toString(),campoQuadril.getText().toString(),campoBracos.getText().toString(), campoAlimentarSozinho.getCheckedRadioButtonId(), campoServirSozinho.getCheckedRadioButtonId(), campoQtdAlimento.getCheckedRadioButtonId(), campoPrepararSozinho.getCheckedRadioButtonId(), campoHabitoIntestinal.getCheckedRadioButtonId(),
                campoMastigacao.getCheckedRadioButtonId(), campoPatologia.getCheckedRadioButtonId(), campoAlergiaAlimentar.getCheckedRadioButtonId(), campoPreferenciaAlimentar.getCheckedRadioButtonId(), campoNaoConsome.getCheckedRadioButtonId(), campoObservacao.getText().toString());
        Toast.makeText(getApplicationContext(), "Relatório salvo com sucesso", Toast.LENGTH_SHORT).show();
        finish();
    }

*/
}
