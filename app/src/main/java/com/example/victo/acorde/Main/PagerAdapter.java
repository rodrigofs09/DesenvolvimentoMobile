package com.example.victo.acorde.Main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    PagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0:
                return new CriaRelatorioPPFragment();
            case 1:
                return new BuscaRelatorioPPFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {

        return numberOfTabs;
    }
}
