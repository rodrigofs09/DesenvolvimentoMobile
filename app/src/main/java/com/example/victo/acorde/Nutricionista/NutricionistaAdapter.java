package com.example.victo.acorde.Nutricionista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

import com.example.victo.acorde.R;

public class NutricionistaAdapter extends BaseAdapter {

    private final List<Nutricionista> nutricionistas;
    private final Context context;

    public NutricionistaAdapter(Context context, List<Nutricionista> nutricionistas) {
        this.context = context;
        this.nutricionistas = nutricionistas;
    }

    @Override
    public int getCount() {
        return nutricionistas.size();
    }

    @Override
    public Object getItem(int position) {
        return nutricionistas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return nutricionistas.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Nutricionista nutricionista = nutricionistas.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View tela = view;

        if(tela == null){
            tela = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView campoNome = (TextView) tela.findViewById(R.id.item_nome);
        campoNome.setText(nutricionista.getNomeAssistido());

        return tela;
    }
}
