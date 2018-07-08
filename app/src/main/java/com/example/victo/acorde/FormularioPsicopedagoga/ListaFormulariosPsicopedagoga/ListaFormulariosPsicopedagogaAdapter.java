package com.example.victo.acorde.FormularioPsicopedagoga.ListaFormulariosPsicopedagoga;

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

import com.example.victo.acorde.FormularioPsicopedagoga.FormularioPsicopedagoga;
import com.example.victo.acorde.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListaFormulariosPsicopedagogaAdapter extends BaseAdapter {

    private List<FormularioPsicopedagoga> formularioPsicopedagoga;
    private final Context context;

    private ArrayList<FormularioPsicopedagoga> listaPsicopedagogaFiltrada;

    ListaFormulariosPsicopedagogaAdapter(Context context, List<FormularioPsicopedagoga> formularioPsicopedagoga) {
        this.context = context;
        this.formularioPsicopedagoga = formularioPsicopedagoga;
        this.listaPsicopedagogaFiltrada = new ArrayList<>();
        this.listaPsicopedagogaFiltrada.addAll(formularioPsicopedagoga);
    }

    @Override
    public int getCount() {
        return formularioPsicopedagoga.size();
    }

    @Override
    public Object getItem(int position) {
        return formularioPsicopedagoga.get(position);
    }

    @Override
    public long getItemId(int position) {
        return formularioPsicopedagoga.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        FormularioPsicopedagoga formulariosPsicopedagoga = formularioPsicopedagoga.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View tela = view;

        if(tela == null){
            tela = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView campoNome = tela.findViewById(R.id.item_nome);
        campoNome.setText(formulariosPsicopedagoga.getNomeAssistido());
        TextView campoData = tela.findViewById(R.id.item_data);
        campoData.setText(formulariosPsicopedagoga.getDataAtendimento());

        return tela;
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        formularioPsicopedagoga.clear();
        if (charText.length()==0){
            formularioPsicopedagoga.addAll(listaPsicopedagogaFiltrada);
        }
        else {
            for (FormularioPsicopedagoga formularioPsicopedagoga1 : listaPsicopedagogaFiltrada){
                if (formularioPsicopedagoga1.getNomeAssistido().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    formularioPsicopedagoga.add(formularioPsicopedagoga1);
                }
                if (formularioPsicopedagoga1.getDataAtendimento().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    formularioPsicopedagoga.add(formularioPsicopedagoga1);
                }
            }
        }
        notifyDataSetChanged();
    }

}
