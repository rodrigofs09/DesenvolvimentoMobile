package com.example.victo.acorde.MainActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.victo.acorde.EducadoraEspecial.EducadoraEspecialActivity;
import com.example.victo.acorde.EmGrupo.AtvGrupoActivity;
import com.example.victo.acorde.Nutricionista.NutricionistaActivity;
import com.example.victo.acorde.R;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    private int tipoAtividade; //Variável para selecionar o tipo de atividade

    public MainActivity(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                setTipoAtividade(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        final Button button = findViewById(R.id.buttonProximo);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(getTipoAtividade() == 0){ //Caso o tipo de atividade seja "Individual"
                    Intent abrirIndividualActivity = new Intent(MainActivity.this , EducadoraEspecialActivity.class);
                    startActivity(abrirIndividualActivity);
                }
                if(getTipoAtividade() == 1){ //Caso o tipo de atividade seja "Em Grupo"
                    Intent abrirEmGrupoActivity = new Intent(MainActivity.this , NutricionistaActivity.class);
                    startActivity(abrirEmGrupoActivity);
                }
            }
        });

        mDisplayDate = (TextView) findViewById(R.id.textView); //Declaração da TextView
        //Setar o ClickListener para o TextView
        mDisplayDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        //Inicializar o OnDateSetListener
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                //Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = day + "/" + month + "/" + year;
                mDisplayDate.setText(date);
            }
        };
    }

    public void setTipoAtividade(int i){
        tipoAtividade = i;
    }

    public int getTipoAtividade(){
        return tipoAtividade;
    }
}