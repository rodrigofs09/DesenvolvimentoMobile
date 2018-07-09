package com.example.victo.acorde.Main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import com.example.victo.acorde.FormularioPsicopedagoga.ListaFormulariosPsicopedagoga.ListaFormulariosPsicopedagogaActivity;
import com.example.victo.acorde.FormularioEducadoraEspecial.ListaFormulariosEducadoraEspecial.ListaFormulariosEducadoraEspecialActivity;
import com.example.victo.acorde.FormularioEducadoraFisica.ListaFormulariosEducadoraFisica.ListaFormulariosEducadoraFisicaActivity;
import com.example.victo.acorde.FormularioNutricionista.ListaFormulariosNutricionista.ListaFormulariosNutricionistaActivity;
import com.example.victo.acorde.R;

public class BuscaRelatorioPPFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    private View view;
    private Button buscar;
    private RadioGroup funcionario;
    private Intent vaiProFormulario;

    public BuscaRelatorioPPFragment() {
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_busca_relatorio_p, container, false);
        buscar = view.findViewById(R.id.buscar);
        funcionario = view.findViewById(R.id.RadioGroupBuscar);
        buscar.setOnClickListener(this);
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
            case R.id.buscar:
                switch (funcionario.getCheckedRadioButtonId()) {
                    case R.id.buscaNutricionista:
                        vaiProFormulario = new Intent(getActivity(), ListaFormulariosNutricionistaActivity.class);
                        startActivity(vaiProFormulario);
                        break;
                    case R.id.buscaEducadoraFisica:
                        vaiProFormulario = new Intent(getActivity(), ListaFormulariosEducadoraFisicaActivity.class);
                        startActivity(vaiProFormulario);
                        break;
                    case R.id.buscaPsicopedagoga:
                        vaiProFormulario = new Intent(getActivity(), ListaFormulariosPsicopedagogaActivity.class);
                        startActivity(vaiProFormulario);
                        break;
                    default:
                        break;
                }
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

