package com.example.victo.acorde.FormularioPsicologa.ListaFormulariosPsicologa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.victo.acorde.FormularioPsicologa.FormularioPsicologa;
import com.example.victo.acorde.FormularioPsicologa.FormularioPsicologa;
import com.example.victo.acorde.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListaFormulariosPsicologaAdapter extends BaseAdapter {

    List<FormularioPsicologa> formularioPsicologa;
    final Context context;

    ArrayList<FormularioPsicologa> listaPsicologaFiltrada;

    public ListaFormulariosPsicologaAdapter(Context context, List<FormularioPsicologa> formularioPsicologa) {
        this.context = context;
        this.formularioPsicologa = formularioPsicologa;
        this.listaPsicologaFiltrada = new ArrayList<>();
        this.listaPsicologaFiltrada.addAll(formularioPsicologa);
    }

    @Override
    public int getCount() {
        return formularioPsicologa.size();
    }

    @Override
    public Object getItem(int position) {
        return formularioPsicologa.get(position);
    }

    @Override
    public long getItemId(int position) {
        return formularioPsicologa.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        FormularioPsicologa formulariosNutricionista = formularioPsicologa.get(position);
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
        formularioPsicologa.clear();
        if (charText.length()==0){
            formularioPsicologa.addAll(listaPsicologaFiltrada);
        }
        else {
            for (FormularioPsicologa formularioPsicologa1 : listaPsicologaFiltrada){
                if (formularioPsicologa1.getNomeAssistido().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    formularioPsicologa.add(formularioPsicologa1);
                }
                if (formularioPsicologa1.getDataAtendimento().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    formularioPsicologa.add(formularioPsicologa1);
                }
            }
        }
        notifyDataSetChanged();
    }

}
