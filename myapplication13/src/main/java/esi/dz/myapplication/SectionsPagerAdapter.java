package esi.dz.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by pc on 12/03/2016.
 */
public class SectionsPagerAdapter
        extends FragmentPagerAdapter {


    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "SECTION 1";
            case 1:
                return "SECTION 2";
            case 2:
                return "SECTION 3";
        }
        return null;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fg=null;
        if (position==0) {
            fg = new PlaceholderFragment();
        }
            if (position==1) {
                fg = new PlaceHoldedFragment1();
            }
                if (position == 2) {
                    fg = new PlaceHolderFragment3();
                }
                    return fg;
                }


}