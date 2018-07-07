package com.example.victo.acorde.FormularioNutricionista.CriaFormularioNutricionista;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.victo.acorde.FormularioNutricionista.FormularioNutricionista;
import com.example.victo.acorde.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CriaFormularioNutricionistaActivity extends AppCompatActivity implements CriaFormularioNutricionistaContract.View {

    @BindView(R.id.dataFormulario)
    TextView campoDataAtendimento;
    @BindView(R.id.editTextNome)
    EditText campoNomeAssistido;
    @BindView(R.id.editTextMotivo)
    EditText campoMotivoAtendimento;
    @BindView(R.id.editTextEncaminhamento)
    EditText campoEncaminhamento;
    @BindView(R.id.editTextAltura)
    EditText campoAltura;
    @BindView(R.id.editTextPeso)
    EditText campoPeso;
    @BindView(R.id.editTextCintura)
    EditText campoCintura;
    @BindView(R.id.editTextQuadril)
    EditText campoQuadril;
    @BindView(R.id.editTextBracos)
    EditText campoBracos;
    @BindView(R.id.RadioGroupAlimentarSozinho)
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
    RadioGroup campoNaoConsome;
    @BindView(R.id.editTextObservacao)
    EditText campoObservacao;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    CriaFormularioNutricionistaContract.Presenter presenter;

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cria_formulario_nutricionista);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(R.string.formularioNutricionista);
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

                DatePickerDialog dialog = new DatePickerDialog(CriaFormularioNutricionistaActivity.this,
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

        presenter = new CriaFormularioNutricionistaPresenter(this, this);

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

    @OnClick(R.id.buttonFinalizar)
    public void cliqueFinalizar(){
        presenter.setFormularioNutricionista(campoDataAtendimento.getText().toString(), campoNomeAssistido.getText().toString(),campoMotivoAtendimento.getText().toString(),campoEncaminhamento.getText().toString(),campoAltura.getText().toString(),
                campoPeso.getText().toString(),campoCintura.getText().toString(),campoQuadril.getText().toString(),campoBracos.getText().toString(), campoAlimentarSozinho.getCheckedRadioButtonId(), campoServirSozinho.getCheckedRadioButtonId(), campoQtdAlimento.getCheckedRadioButtonId(), campoPrepararSozinho.getCheckedRadioButtonId(), campoHabitoIntestinal.getCheckedRadioButtonId(),
                campoMastigacao.getCheckedRadioButtonId(), campoPatologia.getCheckedRadioButtonId(), campoAlergiaAlimentar.getCheckedRadioButtonId(), campoPreferenciaAlimentar.getCheckedRadioButtonId(), campoNaoConsome.getCheckedRadioButtonId(), campoObservacao.getText().toString());
        Toast.makeText(getApplicationContext(), "Relatório salvo com sucesso", Toast.LENGTH_SHORT).show();
        finish();
    }

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
        campoBracos.setText(bracos);
        campoAlimentarSozinho.check(alimentarSozinho);
        campoServirSozinho.check(servirSozinho);
        campoQtdAlimento.check(qtdAlimento);
        campoPrepararSozinho.check(prepararSozinho);
        campoHabitoIntestinal.check(habitoIntestinal);
        campoMastigacao.check(mastigacao);
        campoPatologia.check(patologia);
        campoAlergiaAlimentar.check(alergiaAlimentar);
        campoPreferenciaAlimentar.check(preferenciaAlimentar);
        campoNaoConsome.check(naoConsome);
        campoObservacao.setText(observacao);
    }
}
