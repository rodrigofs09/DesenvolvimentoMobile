package com.example.victo.acorde.FormularioEducadoraFisica.ListaFormulariosEducadoraFisica;

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

import com.example.victo.acorde.FormularioEducadoraFisica.FormularioEducadoraFisica;
import com.example.victo.acorde.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListaFormulariosEducadoraFisicaAdapter extends BaseAdapter {

    private List<FormularioEducadoraFisica> formularioEducadoraFisica;
    private final Context context;

    private ArrayList<FormularioEducadoraFisica> listaEducadoraFisicaFiltrada;

    ListaFormulariosEducadoraFisicaAdapter(Context context, List<FormularioEducadoraFisica> formularioEducadoraFisica) {
        this.context = context;
        this.formularioEducadoraFisica = formularioEducadoraFisica;
        this.listaEducadoraFisicaFiltrada = new ArrayList<>();
        this.listaEducadoraFisicaFiltrada.addAll(formularioEducadoraFisica);
    }

    @Override
    public int getCount() {
        return formularioEducadoraFisica.size();
    }

    @Override
    public Object getItem(int position) {
        return formularioEducadoraFisica.get(position);
    }

    @Override
    public long getItemId(int position) {
        return formularioEducadoraFisica.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        FormularioEducadoraFisica formulariosEducadoraFisica = formularioEducadoraFisica.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View tela = view;

        if(tela == null){
            tela = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView campoNome = tela.findViewById(R.id.item_nome);
        campoNome.setText(formulariosEducadoraFisica.getNomeAssistido());
        TextView campoData = tela.findViewById(R.id.item_data);
        campoData.setText(formulariosEducadoraFisica.getDataAtendimento());

        return tela;
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        formularioEducadoraFisica.clear();
        if (charText.length()==0){
            formularioEducadoraFisica.addAll(listaEducadoraFisicaFiltrada);
        }
        else {
            for (FormularioEducadoraFisica formularioEducadoraFisica1 : listaEducadoraFisicaFiltrada){
                if (formularioEducadoraFisica1.getNomeAssistido().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    formularioEducadoraFisica.add(formularioEducadoraFisica1);
                }
                if (formularioEducadoraFisica1.getDataAtendimento().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    formularioEducadoraFisica.add(formularioEducadoraFisica1);
                }
            }
        }
        notifyDataSetChanged();
    }

}
