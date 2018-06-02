package com.example.victo.acorde.Nutricionista;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

public class NutricionistaFiltro extends Filter {
    List<Nutricionista> filterList;
    NutricionistaAdapter adapter;

    public NutricionistaFiltro(List<Nutricionista> filterList, NutricionistaAdapter adapter) {
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

            List<Nutricionista> nutricionistaFiltro =new ArrayList<>();

            //LOOP THRU FILTER LIST
            for(int i=0;i<filterList.size();i++)
            {
                //FILTER
                if(filterList.get(i).getNomeAssistido().toUpperCase().contains(constraint))
                {
                    nutricionistaFiltro.add(filterList.get(i));
                }
            }

            results.count=nutricionistaFiltro.size();
            results.values=nutricionistaFiltro;
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

        adapter.nutricionistas= (List<Nutricionista>) results.values;
        adapter.notifyDataSetChanged();

    }
}