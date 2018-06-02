package com.example.victo.acorde.EducadoraEspecial;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

public class EducadoraEspecialFiltro extends Filter{
    List<EducadoraEspecial> filterList;
    EducadoraEspecialAdapter adapter;

    public EducadoraEspecialFiltro(List<EducadoraEspecial> filterList, EducadoraEspecialAdapter adapter) {
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

            List<EducadoraEspecial> educadoraEspecialFiltro =new ArrayList<>();

            //LOOP THRU FILTER LIST
            for(int i=0;i<filterList.size();i++)
            {
                //FILTER
                if(filterList.get(i).getNomeAssistido().toUpperCase().contains(constraint))
                {
                    educadoraEspecialFiltro.add(filterList.get(i));
                }
            }

            results.count=educadoraEspecialFiltro.size();
            results.values=educadoraEspecialFiltro;
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

        adapter.educadoraEspecials= (List<EducadoraEspecial>) results.values;
        adapter.notifyDataSetChanged();

    }
}
