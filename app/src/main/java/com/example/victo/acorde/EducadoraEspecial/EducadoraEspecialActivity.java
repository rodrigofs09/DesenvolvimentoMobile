package com.example.victo.acorde.EducadoraEspecial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.victo.acorde.Main.MainActivity;
import com.example.victo.acorde.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EducadoraEspecialActivity extends AppCompatActivity {

    EducadoraEspecialHelper helper;
    EducadoraEspecial educadoraEspecial = null;

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

        helper = new EducadoraEspecialHelper(this);

        final Intent intent = getIntent();
        educadoraEspecial = (EducadoraEspecial) intent.getSerializableExtra("educadoraEspecial");

        if(educadoraEspecial != null){
            helper.preencheFormularioEE(educadoraEspecial);
        }

        final Button enviarDados = findViewById(R.id.buttonFinalizar);
        enviarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                educadoraEspecial = helper.pegaEducadoraEspecial();
                EducadoraEspecialDAO dao = new EducadoraEspecialDAO(getApplicationContext());

                if(educadoraEspecial.getId()!=null){
                    dao.alteraRelatorioEE(educadoraEspecial);
                }else{
                    dao.insereRelatorioEE(educadoraEspecial);
                }
                dao.close();
                finish();
            }
        });

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

}
