package com.example.victo.acorde.FormularioPsicopedagoga.CriaFormularioPsicopedagoga;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.victo.acorde.FormularioPsicopedagoga.FormularioPsicopedagoga;
import com.example.victo.acorde.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class CriaFormularioPsicopedagogaActivity extends AppCompatActivity implements CriaFormularioPsicopedagogaContract.View {

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
    @BindView(R.id.RadioGroupTipoAtendimento)
    RadioGroup campoTipoAtendimento;
    @BindView(R.id.RadioGroupAspectosTrabalhados)
    RadioGroup campoAspectosTrabalhados;
    @BindView(R.id.RadioGroupAspectosTrabalhadosAcupuntura)
    RadioGroup campoAspectosTrabalhadosAcupuntura;
    @BindView(R.id.RadioGroupAtividadesLudicasLeitura)
    RadioGroup campoAtividadesLudicasLeitura;
    @BindView(R.id.RadioGroupAtividadesCoordenacaoSurtiramEfeito)
    RadioGroup campoAtividadesCoordenacaoSurtiramEfeito;
    @BindView(R.id.RadioGroupAvaliacoesObtiveramResultadosPositivos)
    RadioGroup campoAvaliacoesObtiveramResultadosPositivos;
    @BindView(R.id.RadioGroupPlanejamentoSeguePercursoEsperado)
    RadioGroup campoPlanejamentoSeguePercursoEsperado;
    @BindView(R.id.RadioGroupMateriaisSaoSuficientesParaAtividades)
    RadioGroup campoMateriaisSaoSuficientesParaAtividades;

    @BindView(R.id.editTextObservacao)
    EditText campoObservacao;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    CriaFormularioPsicopedagogaContract.Presenter presenter;

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cria_formulario_psicopedagoga);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(R.string.formularioPsicopedagoga);
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

                DatePickerDialog dialog = new DatePickerDialog(CriaFormularioPsicopedagogaActivity.this,
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

                date = day + "/" + month + "/" + year;
                campoDataAtendimento.setText(date);
            }
        };

        presenter = new CriaFormularioPsicopedagogaPresenter(this, this);

        final Intent intent = getIntent();
        presenter.setFormularioPsicopedagoga((FormularioPsicopedagoga) intent.getSerializableExtra("formularioPsicopedagoga"));
        presenter.getFormularioPsicopedagoga();
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
    public void setInfosFormularioPsicopedagoga(String dataAtendimento, String nomeAssistido, String motivoAtendimento, String encaminhamento, String idade,
                                                int tipoAtendimento, int aspectosTrabalhados, int aspectosTrabalhadosAcupuntura, int atividadesLudicasLeitura, int atividadesCoordenacaoSurtiramEfeito,
                                                int avaliacoesObtiveramResultadosPositivos, int planejamentoSeguePercursoEsperado, int materiaisSaoSuficientesParaAtividades, String observacao){

        campoDataAtendimento.setText(dataAtendimento);
        campoNomeAssistido.setText(nomeAssistido);
        campoMotivoAtendimento.setText(motivoAtendimento);
        campoEncaminhamento.setText(encaminhamento);
        campoIdade.setText(idade);
        campoTipoAtendimento.check(tipoAtendimento);
        campoAspectosTrabalhados.check(aspectosTrabalhados);
        campoAspectosTrabalhadosAcupuntura.check(aspectosTrabalhadosAcupuntura);
        campoAtividadesLudicasLeitura.check(atividadesLudicasLeitura);
        campoAtividadesCoordenacaoSurtiramEfeito.check(atividadesCoordenacaoSurtiramEfeito);
        campoAvaliacoesObtiveramResultadosPositivos.check(avaliacoesObtiveramResultadosPositivos);
        campoPlanejamentoSeguePercursoEsperado.check(planejamentoSeguePercursoEsperado);
        campoMateriaisSaoSuficientesParaAtividades.check(materiaisSaoSuficientesParaAtividades);

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
        presenter.setFormularioPsicopedagoga(campoDataAtendimento.getText().toString(), campoNomeAssistido.getText().toString(), campoMotivoAtendimento.getText().toString(), campoEncaminhamento.getText().toString(),
                campoIdade.getText().toString(), campoTipoAtendimento.getCheckedRadioButtonId(), campoAspectosTrabalhados.getCheckedRadioButtonId(), campoAspectosTrabalhadosAcupuntura.getCheckedRadioButtonId(),
                campoAtividadesLudicasLeitura.getCheckedRadioButtonId(), campoAtividadesCoordenacaoSurtiramEfeito.getCheckedRadioButtonId(), campoAvaliacoesObtiveramResultadosPositivos.getCheckedRadioButtonId(),
                campoPlanejamentoSeguePercursoEsperado.getCheckedRadioButtonId(), campoMateriaisSaoSuficientesParaAtividades.getCheckedRadioButtonId(), campoObservacao.getText().toString());

        Toast.makeText(getApplicationContext(), "Relatório salvo com sucesso", Toast.LENGTH_SHORT).show();
        finish();
    }

}
