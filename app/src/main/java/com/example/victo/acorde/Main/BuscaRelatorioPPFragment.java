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
import android.widget.ListView;

import com.example.victo.acorde.Nutricionista.Nutricionista;
import com.example.victo.acorde.Nutricionista.NutricionistaActivity;
import com.example.victo.acorde.Nutricionista.NutricionistaAdapter;
import com.example.victo.acorde.Nutricionista.NutricionistaDAO;
import com.example.victo.acorde.R;

import java.util.List;

public class BuscaRelatorioPPFragment extends Fragment{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    View view;
    private ListView listaNutricionistas;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_busca_relatorio_p, container, false);

        listaNutricionistas = view.findViewById(R.id.lista_nutricionista);

        listaNutricionistas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Nutricionista nutricionista = (Nutricionista)listaNutricionistas.getItemAtPosition(position);

                Intent intentVaiProFormulario = new Intent(getContext(), NutricionistaActivity.class);
                intentVaiProFormulario.putExtra("nutricionista", nutricionista);
                startActivity(intentVaiProFormulario);
            }
        });

        carregaListaNutricionista();

        registerForContextMenu(listaNutricionistas);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        carregaListaNutricionista();
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    private void carregaListaNutricionista() {
        NutricionistaDAO dao = new NutricionistaDAO(getContext());
        List<Nutricionista> nutricionistas = dao.buscaRelatorioNU();
        dao.close();

        NutricionistaAdapter adapter = new NutricionistaAdapter(getContext(), nutricionistas);
        listaNutricionistas.setAdapter(adapter);
    }
}

