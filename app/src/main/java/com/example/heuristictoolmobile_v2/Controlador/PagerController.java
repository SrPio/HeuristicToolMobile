package com.example.heuristictoolmobile_v2.Controlador;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.heuristictoolmobile_v2.fragment_menu_seleccion;

public class PagerController extends FragmentPagerAdapter {
    int numOfTabs;

    public PagerController(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numOfTabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new Login();
            case 1:
                return new EvPublicas();
            case 2:
                return new Info();
            /*case 3:
                return new fragment_menu_seleccion();*/
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
