package com.example.victo.acorde.Main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.victo.acorde.FormularioEducadoraFisica.ListaFormulariosEducadoraFisica.ListaFormulariosEducadoraFisicaActivity;
import com.example.victo.acorde.FormularioNutricionista.ListaFormulariosNutricionista.ListaFormulariosNutricionistaActivity;
import com.example.victo.acorde.R;

public class BuscaRelatorioPPFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private View view;
    private Button proximo;
    private Spinner mySpinner;
    private Context context;

    private String mParam1;
    private String mParam2;

    private int tipoFuncionaria;
    private String selectedItemText;

    private OnFragmentInteractionListener mListener;

    public BuscaRelatorioPPFragment() {

    }

    public void setTipoFuncionaria(int tipoFuncionaria) {
        this.tipoFuncionaria = tipoFuncionaria;
    }

    public int getTipoFuncionaria() {
        return tipoFuncionaria;
    }

    public static BuscaRelatorioPPFragment newInstance(String param1, String param2) {
        BuscaRelatorioPPFragment fragment = new BuscaRelatorioPPFragment();
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

        view = inflater.inflate(R.layout.fragment_busca_relatorio_p, container, false);
        proximo = view.findViewById(R.id.proximo);
        mySpinner = view.findViewById(R.id.funcionariaBuscaSpinner);

        proximo.setOnClickListener(this);

        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                setTipoFuncionaria(position);
                selectedItemText = (String) adapterView.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }

    @Override
    public void onAttach(final Context context) {
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
                if(getTipoFuncionaria() == 0){ //Abre a lista da nutricionista
                    Intent vaiPraLista = new Intent(getActivity() , ListaFormulariosNutricionistaActivity.class);
                    startActivity(vaiPraLista);
                }
                /*if(getTipoFuncionaria() == 1){ //Abre a lista da educadora fisica
                    Intent vaiPraLista = new Intent(getActivity() , ListaFormulariosEducadoraFisicaActivity.this);
                    startActivity(vaiPraLista);
                }*/
                /*if(getTipoFuncionaria() == 2){ //Abre a lista da educadora especial
                    Intent vaiPraLista = new Intent(getActivity() , EducadoraEspecialLista.class);
                    startActivity(vaiPraLista);
                }*/
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

