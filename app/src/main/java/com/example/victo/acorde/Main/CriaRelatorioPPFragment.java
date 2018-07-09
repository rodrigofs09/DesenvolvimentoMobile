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

import com.example.victo.acorde.FormularioPsicologa.CriaFormularioPsicologa.CriaFormularioPsicologaActivity;
import com.example.victo.acorde.FormularioPsicopedagoga.CriaFormularioPsicopedagoga.CriaFormularioPsicopedagogaActivity;
import com.example.victo.acorde.FormularioEducadoraEspecial.CriaFormularioEducadoraEspecial.CriaFormularioEducadoraEspecialActivity;
import com.example.victo.acorde.FormularioEducadoraFisica.CriaFormularioEducadoraFisica.CriaFormularioEducadoraFisicaActivity;
import com.example.victo.acorde.FormularioNutricionista.CriaFormularioNutricionista.CriaFormularioNutricionistaActivity;
import com.example.victo.acorde.R;

public class CriaRelatorioPPFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private View view;
    private Button cadastrar;
    private Context context;
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    private RadioGroup funcionario;
    Intent vaiProFormulario;

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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cria_relatorio_p, container, false);
        cadastrar = view.findViewById(R.id.cadastrar);
        funcionario = view.findViewById(R.id.RadioGroupCadastrar);
        cadastrar.setOnClickListener(this);
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
            case R.id.cadastrar:
                switch (funcionario.getCheckedRadioButtonId()) {
                    case R.id.cadastraNutricionista:
                        vaiProFormulario = new Intent(getActivity(), CriaFormularioNutricionistaActivity.class);
                        startActivity(vaiProFormulario);
                        break;
                    case R.id.cadastraEducadoraFisica:
                        vaiProFormulario = new Intent(getActivity(), CriaFormularioEducadoraFisicaActivity.class);
                        startActivity(vaiProFormulario);
                        break;
                    case R.id.cadastraEducadoraEspecial:
                        vaiProFormulario = new Intent(getActivity(), CriaFormularioEducadoraEspecialActivity.class);
                        startActivity(vaiProFormulario);
                        break;
                    case R.id.cadastraPsicopedagoga:
                        vaiProFormulario = new Intent(getActivity(), CriaFormularioPsicopedagogaActivity.class);
                        startActivity(vaiProFormulario);
                        break;
                    case R.id.cadastraPsicologa:
                        vaiProFormulario = new Intent(getActivity(), CriaFormularioPsicologaActivity.class);
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
