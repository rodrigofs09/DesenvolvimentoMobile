package com.example.victo.acorde.FormularioNutricionista.CriaFormularioNutricionista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.victo.acorde.FormularioNutricionista.FormularioNutricionista;
import com.example.victo.acorde.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CriaFormularioNutricionistaActivity extends AppCompatActivity implements CriaFormularioNutricionistaContract.View {

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
    @BindView(R.id.RadioGroupIntoleranciaAlimentar)
    RadioGroup campoIntoleranciAlimentar;
    @BindView(R.id.RadioGroupAlergiaAlimentar)
    RadioGroup campoAlergiaAlimentar;
    @BindView(R.id.RadioGroupPreferenciaAlimentar)
    RadioGroup campoPreferenciaAlimentar;
    @BindView(R.id.RadioGroupNaoConsome)
    RadioGroup campoNaoConsome;
    @BindView(R.id.editTextObservacao)
    EditText campoObservacao;

    CriaFormularioNutricionistaContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cria_formulario_nutricionista);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(R.string.formularioNutricionista);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

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
        presenter.setFormularioNutricionista(campoNomeAssistido.getText().toString(),campoMotivoAtendimento.getText().toString(),campoEncaminhamento.getText().toString(),campoAltura.getText().toString(),
                campoPeso.getText().toString(),campoCintura.getText().toString(),campoQuadril.getText().toString(),campoBracos.getText().toString(),campoObservacao.getText().toString());
        Toast.makeText(getApplicationContext(), "Cadastrado", Toast.LENGTH_SHORT).show();
        finish();
    }

    RadioButton verificaRadioButton(RadioGroup rg){
        int selectedID = rg.getCheckedRadioButtonId();
        RadioButton rb = findViewById(selectedID);
        return rb;
    }

    @Override
    public void setInfosFormularioNutricionista(String nomeAssistido, String motivoAtendimento, String encaminhamento, String altura, String peso, String cintura, String quadril, String bracos,String observacao){
        campoNomeAssistido.setText(nomeAssistido);
        campoMotivoAtendimento.setText(motivoAtendimento);
        campoEncaminhamento.setText(encaminhamento);
        campoAltura.setText(altura);
        campoPeso.setText(peso);
        campoCintura.setText(cintura);
        campoQuadril.setText(quadril);
        campoBracos.setText(bracos);
        /*campoAlimentarSozinho.set
        campoServirSozinho;
        campoQtdAlimento;
        campoPrepararSozinho;
        campoHabitoIntestinal;
        campoMastigacao;
        campoPatologia;
        campoIntoleranciAlimentar;
        campoAlergiaAlimentar;
        campoPreferenciaAlimentar;
        campoNaoConsome;*/
        campoObservacao.setText(observacao);
    }
}


/*verificaRadioButton(campoAlimentarSozinho).getText().toString(),
                                                verificaRadioButton(campoServirSozinho).getText().toString(),verificaRadioButton(campoQtdAlimento).getText().toString(),verificaRadioButton(campoPrepararSozinho).getText().toString(),
                                                verificaRadioButton(campoHabitoIntestinal).getText().toString(),verificaRadioButton(campoMastigacao).getText().toString(),verificaRadioButton(campoPatologia).getText().toString(),
                                                verificaRadioButton(campoIntoleranciAlimentar).getText().toString(),verificaRadioButton(campoAlergiaAlimentar).getText().toString(),verificaRadioButton(campoPreferenciaAlimentar).getText().toString(),
                                                verificaRadioButton(campoNaoConsome).getText().toString()*/