package com.example.victo.acorde.Main;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.victo.acorde.FormularioEducadoraFisica.CriaFormularioEducadoraFisica.CriaFormularioEducadoraFisicaActivity;
import com.example.victo.acorde.FormularioNutricionista.CriaFormularioNutricionista.CriaFormularioNutricionistaActivity;
import com.example.victo.acorde.R;

import java.util.Calendar;

public class CriaRelatorioPPFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private View view;
    private Button proximo;
    private Spinner mySpinner;
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Context context;

    private String mParam1;
    private String mParam2;

    private int tipoAtividade;
    private String selectedItemText;
    private String date;

    private OnFragmentInteractionListener mListener;

    public CriaRelatorioPPFragment() {

    }

    public void setTipoAtividade(int i){
        tipoAtividade = i;
    }

    public int getTipoAtividade(){
        return tipoAtividade;
    }

    public static CriaRelatorioPPFragment newInstance(String param1, String param2) {
        CriaRelatorioPPFragment fragment = new CriaRelatorioPPFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_cria_relatorio_p, container, false);
        proximo = view.findViewById(R.id.proximo);
        mySpinner = view.findViewById(R.id.tipo);
        mDisplayDate = view.findViewById(R.id.formulario_data);

        proximo.setOnClickListener(this);

        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.names));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                setTipoAtividade(position);
                selectedItemText = (String) adapterView.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mDisplayDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(context,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                //Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                date = day + "/" + month + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        return view;
    }

    @Override
    public void onAttach(final Context context) {
        this.context = context;
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.proximo:
                if(getTipoAtividade() == 0){ //Abre o formulario da nutricionista
                    Intent vaiProFormulario = new Intent(getActivity() , CriaFormularioNutricionistaActivity.class);
                    vaiProFormulario.putExtra("tipo", selectedItemText);
                    vaiProFormulario.putExtra("data", date);
                    startActivity(vaiProFormulario);
                }
                /*if(getTipoAtividade() == 1){ //Abre o formulario da educadora fisica
                    Intent vaiProFormulario = new Intent(getActivity() , CriaFormularioEducadoraFisicaActivity.this);
                    vaiProFormulario.putExtra("tipo", selectedItemText);
                    vaiProFormulario.putExtra("data", date);
                    startActivity(vaiProFormulario);
                }*/
                /*if(getTipoAtividade() == 2){ //Abre o formulario da educadora especial
                    Intent vaiProFormulario = new Intent(getActivity() , EducadoraEspecialActivity.class);
                    vaiProFormulario.putExtra("tipo", selectedItemText);
                    vaiProFormulario.putExtra("data", date);
                    startActivity(vaiProFormulario);
                }*/
                //Toast.makeText(getContext(), "Calendario", Toast.LENGTH_SHORT).show();
                break;
            case R.id.calendario:
                Toast.makeText(getContext(), "Calendario", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tipo:
                Toast.makeText(getContext(), "Calendario", Toast.LENGTH_SHORT).show();
                /*ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(),
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));

                myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                tipo.setAdapter(myAdapter);*/
                break;
            default:
                break;
        }

    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
