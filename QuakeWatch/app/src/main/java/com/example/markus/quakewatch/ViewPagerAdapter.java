package com.example.markus.quakewatch;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.style.CharacterStyle;

/**
 * Created by hp1 on 21-01-2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    CharSequence Titles[];
     int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropri ate values in the class
    public ViewPagerAdapter(FragmentManager fm,CharSequence[] mtitles  , int mNumbOfTabsumb) {
        super(fm);
        this.Titles = mtitles;
         this.NumbOfTabs = mNumbOfTabsumb;

     }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {
        if(position == 3)
        {
            Website wv = new Website();
            return wv;

        }
        else
        {
        RecyclerView1 recyclerView1 = new RecyclerView1();
            recyclerView1.setnumber(position);
            return recyclerView1;
        }

    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

     @Override
     public int getCount() {
        return NumbOfTabs;
    }
}