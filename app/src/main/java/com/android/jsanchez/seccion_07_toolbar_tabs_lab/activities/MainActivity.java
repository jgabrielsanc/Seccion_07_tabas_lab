package com.android.jsanchez.seccion_07_toolbar_tabs_lab.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.android.jsanchez.seccion_07_toolbar_tabs_lab.R;
import com.android.jsanchez.seccion_07_toolbar_tabs_lab.adapters.ViewPagerAdapter;
import com.android.jsanchez.seccion_07_toolbar_tabs_lab.fragments.PersonListFragment;
import com.android.jsanchez.seccion_07_toolbar_tabs_lab.interfaces.OnPersonCreated;
import com.android.jsanchez.seccion_07_toolbar_tabs_lab.models.Person;

public class MainActivity extends AppCompatActivity implements OnPersonCreated {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    git add README.md
    public static final int PERSON_FORM_FRAGMENT = 0;
    public static final int PERSON_LIST_FRAGMENT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();
        setTabLayout();
        setViewPager();
        setListenerTabLayout(viewPager);
    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setTabLayout() {
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Form"));
        tabLayout.addTab(tabLayout.newTab().setText("List"));
    }

    private void setViewPager() {
        viewPager = findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), this, tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void setListenerTabLayout(final ViewPager viewPager) {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    @Override
    public void createPerson(Person person) {
        PersonListFragment fragment = (PersonListFragment) getSupportFragmentManager().getFragments().get(PERSON_LIST_FRAGMENT);
        fragment.addPerson(person);
        viewPager.setCurrentItem(PERSON_LIST_FRAGMENT);
    }
}
