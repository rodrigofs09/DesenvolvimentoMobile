package com.example.victo.acorde.FormularioNutricionista.ListaFormulariosNutricionista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

import com.example.victo.acorde.FormularioNutricionista.FormularioNutricionista;
import com.example.victo.acorde.R;

public class ListaFormulariosNutricionistaAdapter extends BaseAdapter {

    private final List<FormularioNutricionista> formularioNutricionista;
    private final Context context;

    public ListaFormulariosNutricionistaAdapter(Context context, List<FormularioNutricionista> formularioNutricionista) {
        this.context = context;
        this.formularioNutricionista = formularioNutricionista;
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

        TextView campoNome = (TextView) tela.findViewById(R.id.item_nome);
        campoNome.setText(formulariosNutricionista.getNomeAssistido());

        return tela;
    }
}
