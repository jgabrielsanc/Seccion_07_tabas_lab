package com.android.jsanchez.seccion_07_toolbar_tabs_lab.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.jsanchez.seccion_07_toolbar_tabs_lab.R;
import com.android.jsanchez.seccion_07_toolbar_tabs_lab.adapters.PersonAdapter;
import com.android.jsanchez.seccion_07_toolbar_tabs_lab.models.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonListFragment extends Fragment {

    private List<Person> persons;
    private ListView listView;
    private PersonAdapter adapter;

    public PersonListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person_list, container, false);
        persons = new ArrayList<>();
        listView = view.findViewById(R.id.listViewPerson);
        adapter = new PersonAdapter(getContext(), R.layout.list_view_item_person, persons);
        listView.setAdapter(adapter);
        return view;
    }

    public void addPerson(Person person) {
        this.persons.add(person);
        adapter.notifyDataSetChanged();
    }
}
