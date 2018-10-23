package com.android.jsanchez.seccion_07_toolbar_tabs_lab.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.jsanchez.seccion_07_toolbar_tabs_lab.R;
import com.android.jsanchez.seccion_07_toolbar_tabs_lab.interfaces.OnPersonCreated;
import com.android.jsanchez.seccion_07_toolbar_tabs_lab.models.Country;
import com.android.jsanchez.seccion_07_toolbar_tabs_lab.models.Person;
import com.android.jsanchez.seccion_07_toolbar_tabs_lab.utils.Util;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFormFragment extends Fragment {

    private EditText editTextName;
    private Spinner spinnerCountry;
    private Button btnCreate;

    private List<Country> countries;

    private OnPersonCreated onPersonCreated;

    public PersonFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person_form, container, false);

        editTextName = view.findViewById(R.id.editTextName);
        spinnerCountry = view.findViewById(R.id.spinnerCountry);
        btnCreate = view.findViewById(R.id.buttonCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewPerson();
            }
        });

        countries = Util.getCountries();

        ArrayAdapter<Country> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, countries);
        spinnerCountry.setAdapter(adapter);
        return view;
    }

    private void createNewPerson() {
        if (!editTextName.getText().toString().isEmpty()) {
            Country country = (Country) spinnerCountry.getSelectedItem();
            Person person = new Person(editTextName.getText().toString(), country);
            onPersonCreated.createPerson(person);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPersonCreated) {
            onPersonCreated = (OnPersonCreated) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnPersonCreated");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onPersonCreated = null;
    }

}
