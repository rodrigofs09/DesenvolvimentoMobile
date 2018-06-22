package com.example.victo.acorde.EducadoraEspecial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.victo.acorde.R;

import java.util.List;

public class EducadoraEspecialAdapter extends BaseAdapter implements Filterable {
    List<EducadoraEspecial> educadoraEspecials;
    private List<EducadoraEspecial> filterList;

    EducadoraEspecialFiltro filter;

    private final Context context;

    public EducadoraEspecialAdapter(Context context, List<EducadoraEspecial> educadoraEspecials) {
        this.context = context;
        this.educadoraEspecials = educadoraEspecials;
        this.filterList=educadoraEspecials;
    }

    @Override
    public Filter getFilter() {

        if(filter==null)
        {
            filter=new EducadoraEspecialFiltro(filterList,this);
        }

        return filter;
    }

    @Override
    public int getCount() {
        return educadoraEspecials.size();
    }

    @Override
    public Object getItem(int position) {
        return educadoraEspecials.get(position);
    }

    @Override
    public long getItemId(int position) {
        return educadoraEspecials.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        EducadoraEspecial educadoraEspecial = educadoraEspecials.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View tela = view;

        if(tela == null){
            tela = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView campoNome = tela.findViewById(R.id.item_nome);
        campoNome.setText(educadoraEspecial.getNomeAssistido());

        return tela;
    }
}
