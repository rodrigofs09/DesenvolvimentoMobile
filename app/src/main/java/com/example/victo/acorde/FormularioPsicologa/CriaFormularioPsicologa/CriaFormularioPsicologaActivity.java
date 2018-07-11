package com.example.victo.acorde.FormularioPsicologa.CriaFormularioPsicologa;

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

import com.example.victo.acorde.FormularioPsicologa.FormularioPsicologa;
import com.example.victo.acorde.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class CriaFormularioPsicologaActivity extends AppCompatActivity implements CriaFormularioPsicologaContract.View {

    @BindView(R.id.text_input_layout_nome)
    TextInputLayout nomeInputLayout;
    @BindView(R.id.text_input_layout_data)
    TextInputLayout dataInputLayout;
    @BindView(R.id.dataFormulario)
    TextView campoDataAtendimento;
    @BindView(R.id.editTextNome)
    EditText campoNomeAssistido;
    @BindView(R.id.editTextIdade)
    EditText campoIdade;
    @BindView(R.id.tipoAtendimento)
    RadioGroup campoTipoAtendimento;
    @BindView(R.id.individualTipo)
    RadioGroup campoTipoIndividual;
    @BindView(R.id.individualTipoEmocional)
    RadioGroup campoIndividualTipoEmocional;
    @BindView(R.id.individualTipoAcupuntura)
    RadioGroup campoIndividualTipoAcupuntura;
    @BindView(R.id.grupalTema)
    RadioGroup campoGrupalTema;
    @BindView(R.id.encaminhamentoAcorde)
    RadioGroup campoEncaminhamentoAcorde;
    @BindView(R.id.encaminhamentoExterno)
    RadioGroup campoEncaminhamentoExterno;
    @BindView(R.id.atendimentoResp)
    RadioGroup campoAtendimentoResponsavel;
    @BindView(R.id.visitaDomiciliar)
    RadioGroup campoVisitaDomiciliar;
    @BindView(R.id.editTextObservacao)
    EditText campoObservacao;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    CriaFormularioPsicologaContract.Presenter presenter;

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cria_formulario_psicologa);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(R.string.formularioPsicologa);
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

                DatePickerDialog dialog = new DatePickerDialog(CriaFormularioPsicologaActivity.this,
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
        };

        presenter = new CriaFormularioPsicologaPresenter(this, this);

        final Intent intent = getIntent();
        presenter.setFormularioPsicologa((FormularioPsicologa) intent.getSerializableExtra("formularioPsicologa"));
        presenter.getFormularioPsicologa();
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
    public void setInfosFormularioPsicologa(String dataAtendimento, String nomeAssistido, String Idade,int tipoAtendimento, int tipoIndividual, int tipoEmocional, int tipoAcupuntura,
                                                int grupalTema, int encaminhamentoAcorde, int encaminhamentoExterno, int atendimentoResponsavel, int visitaDomiciliar, String observacao){
        campoDataAtendimento.setText(dataAtendimento);
        campoNomeAssistido.setText(nomeAssistido);
        campoIdade.setText(Idade);
        campoTipoAtendimento.check(tipoAtendimento);
        campoTipoIndividual.check(tipoIndividual);
        campoIndividualTipoEmocional.check(tipoEmocional);
        campoIndividualTipoAcupuntura.check(tipoAcupuntura);
        campoGrupalTema.check(grupalTema);
        campoEncaminhamentoAcorde.check(encaminhamentoAcorde);
        campoEncaminhamentoExterno.check(encaminhamentoExterno);
        campoAtendimentoResponsavel.check(atendimentoResponsavel);
        campoVisitaDomiciliar.check(visitaDomiciliar);
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
        presenter.setFormularioPsicologa(campoDataAtendimento.getText().toString(), campoNomeAssistido.getText().toString(),campoIdade.getText().toString(), campoTipoAtendimento.getCheckedRadioButtonId() ,campoTipoIndividual.getCheckedRadioButtonId(),
                campoIndividualTipoEmocional.getCheckedRadioButtonId(), campoIndividualTipoAcupuntura.getCheckedRadioButtonId(),campoGrupalTema.getCheckedRadioButtonId(),
                campoEncaminhamentoAcorde.getCheckedRadioButtonId(), campoEncaminhamentoExterno.getCheckedRadioButtonId(), campoAtendimentoResponsavel.getCheckedRadioButtonId(),
                campoVisitaDomiciliar.getCheckedRadioButtonId(), campoObservacao.getText().toString());
        Toast.makeText(getApplicationContext(), "Relatório salvo com sucesso", Toast.LENGTH_SHORT).show();
        finish();
    }

}
