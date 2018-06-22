package com.example.victo.acorde.FormularioEducadoraFisica.ListaFormulariosEducadoraFisica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import com.example.victo.acorde.FormularioEducadoraFisica.FormularioEducadoraFisica;
import com.example.victo.acorde.R;

public class ListaFormulariosEducadoraFisicaAdapter extends BaseAdapter {

    private final List<FormularioEducadoraFisica> formularioEducadoraFisicas;
    private final Context context;

    public ListaFormulariosEducadoraFisicaAdapter(Context context, List<FormularioEducadoraFisica> nutricionistas) {
        this.context = context;
        this.formularioEducadoraFisicas = nutricionistas;
    }

    @Override
    public int getCount() {
        return formularioEducadoraFisicas.size();
    }

    @Override
    public Object getItem(int position) {
        return formularioEducadoraFisicas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return formularioEducadoraFisicas.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        FormularioEducadoraFisica formularioEducadoraFisica = formularioEducadoraFisicas.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View tela = view;

        if(tela == null){
            tela = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView campoNome = tela.findViewById(R.id.item_nome);
        campoNome.setText(formularioEducadoraFisica.getNomeAssistido());

        return tela;
    }
}
