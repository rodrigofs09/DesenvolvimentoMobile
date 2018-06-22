package com.example.victo.acorde.EducadoraFisica;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

public class EducadoraFisicaFiltro extends Filter {
    List<EducadoraFisica> filterList;
    EducadoraFisicaAdapter adapter;

    public EducadoraFisicaFiltro(List<EducadoraFisica> filterList, EducadoraFisicaAdapter adapter) {
        this.filterList = filterList;
        this.adapter = adapter;
    }

    //FILTERING
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {

        //RESULTS
        FilterResults results=new FilterResults();

        //VALIDATION
        if(constraint != null && constraint.length()>0)
        {

            //CHANGE TO UPPER FOR CONSISTENCY
            constraint=constraint.toString().toUpperCase();

            List<EducadoraFisica> educadoraFisicaFiltro =new ArrayList<>();

            //LOOP THRU FILTER LIST
            for(int i=0;i<filterList.size();i++)
            {
                //FILTER
                if(filterList.get(i).getNomeAssistido().toUpperCase().contains(constraint))
                {
                    educadoraFisicaFiltro.add(filterList.get(i));
                }
            }

            results.count=educadoraFisicaFiltro.size();
            results.values=educadoraFisicaFiltro;
        }else
        {
            results.count=filterList.size();
            results.values=filterList;
        }

        return results;
    }

    //PUBLISH RESULTS

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.educadoraFisicas= (List<EducadoraFisica>) results.values;
        adapter.notifyDataSetChanged();

    }
}
