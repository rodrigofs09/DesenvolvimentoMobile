package com.example.victo.acorde.FormularioNutricionista.ListaFormulariosNutricionista;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.example.victo.acorde.FormularioNutricionista.FormularioNutricionista;
import com.example.victo.acorde.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListaFormulariosNutricionistaAdapter extends BaseAdapter {

    private List<FormularioNutricionista> formularioNutricionista;
    private final Context context;

    private ArrayList<FormularioNutricionista> listaNutricionistaFiltrada;

    ListaFormulariosNutricionistaAdapter(Context context, List<FormularioNutricionista> formularioNutricionista) {
        this.context = context;
        this.formularioNutricionista = formularioNutricionista;
        this.listaNutricionistaFiltrada = new ArrayList<>();
        this.listaNutricionistaFiltrada.addAll(formularioNutricionista);
    }

    @Override
    public int getCount() {
        return formularioNutricionista.size();
    }

    @Override
    public Object getItem(int position) {
        return formularioNutricionista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return formularioNutricionista.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        FormularioNutricionista formulariosNutricionista = formularioNutricionista.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View tela = view;

        if(tela == null){
            tela = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView campoNome = tela.findViewById(R.id.item_nome);
        campoNome.setText(formulariosNutricionista.getNomeAssistido());
        TextView campoData = tela.findViewById(R.id.item_data);
        campoData.setText(formulariosNutricionista.getDataAtendimento());

        return tela;
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        formularioNutricionista.clear();
        if (charText.length()==0){
            formularioNutricionista.addAll(listaNutricionistaFiltrada);
        }
        else {
            for (FormularioNutricionista formularioNutricionista1 : listaNutricionistaFiltrada){
                if (formularioNutricionista1.getNomeAssistido().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    formularioNutricionista.add(formularioNutricionista1);
                }
                if (formularioNutricionista1.getDataAtendimento().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    formularioNutricionista.add(formularioNutricionista1);
                }
            }
        }
        notifyDataSetChanged();
    }

}
