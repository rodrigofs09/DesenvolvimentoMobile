package com.example.victo.acorde.Main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int numberOfTabs;

    public PagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0:
                CriaRelatorioPPFragment ppCria = new CriaRelatorioPPFragment();
                return ppCria;
            case 1:
                BuscaRelatorioPPFragment ppBusca = new BuscaRelatorioPPFragment();
                return ppBusca;
            case 2:
                MensagensPPFragment ppMsg = new MensagensPPFragment();
                return ppMsg;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {

        return numberOfTabs;
    }
}
