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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.victo.acorde.EducadoraEspecial.EducadoraEspecialActivity;
import com.example.victo.acorde.Nutricionista.NutricionistaActivity;
import com.example.victo.acorde.R;

import java.util.Calendar;

public class CriaRelatorioPPFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    View view;
    Button proximo, calendario;
    EditText tipo;

    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    private DatePickerDialog.OnDateSetListener mDateSetListener;

    public CriaRelatorioPPFragment() {

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
        calendario = view.findViewById(R.id.calendario);
        tipo = view.findViewById(R.id.formulario_tipo);
        proximo.setOnClickListener(this);
        calendario.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
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
                Intent vaiProFormulario = new Intent(getActivity(), NutricionistaActivity.class);
                vaiProFormulario.putExtra("tipo", tipo.getText().toString());
                startActivity(vaiProFormulario);
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
}
