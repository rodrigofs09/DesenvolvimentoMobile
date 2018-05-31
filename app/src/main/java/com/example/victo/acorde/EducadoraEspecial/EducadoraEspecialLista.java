package com.example.victo.acorde.EducadoraEspecial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.victo.acorde.Main.MainActivity;
import com.example.victo.acorde.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EducadoraEspecialLista extends AppCompatActivity {

    @BindView(R.id.vazio)
    TextView vazio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educadora_especial_lista);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //adiciona titulo e define o botao <- na toolbar
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(R.string.educadoraEspecial);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        final ListView listaEducadoraEspecial = (ListView) findViewById(R.id.lista_educadoraEspecial);
        listaEducadoraEspecial.setEmptyView(vazio);
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
