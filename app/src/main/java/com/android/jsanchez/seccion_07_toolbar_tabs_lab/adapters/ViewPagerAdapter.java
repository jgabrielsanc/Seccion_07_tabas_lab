package com.android.jsanchez.seccion_07_toolbar_tabs_lab.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.jsanchez.seccion_07_toolbar_tabs_lab.fragments.PersonFormFragment;
import com.android.jsanchez.seccion_07_toolbar_tabs_lab.fragments.PersonListFragment;

import static com.android.jsanchez.seccion_07_toolbar_tabs_lab.activities.MainActivity.PERSON_FORM_FRAGMENT;
import static com.android.jsanchez.seccion_07_toolbar_tabs_lab.activities.MainActivity.PERSON_LIST_FRAGMENT;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private int numberOfTabs;

    public ViewPagerAdapter(FragmentManager fm, Context context, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case PERSON_FORM_FRAGMENT:
                return new PersonFormFragment();
            case PERSON_LIST_FRAGMENT:
                return new PersonListFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
