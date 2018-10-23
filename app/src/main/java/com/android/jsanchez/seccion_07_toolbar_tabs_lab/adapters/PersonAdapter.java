package com.android.jsanchez.seccion_07_toolbar_tabs_lab.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.jsanchez.seccion_07_toolbar_tabs_lab.R;
import com.android.jsanchez.seccion_07_toolbar_tabs_lab.models.Person;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PersonAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Person> persons;

    public PersonAdapter(Context context, int layout, List<Person> persons) {
        this.context = context;
        this.layout = layout;
        this.persons = persons;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Person getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, null);
            holder = new ViewHolder();
            holder.name = convertView.findViewById(R.id.textViewPersonName);
            holder.country = convertView.findViewById(R.id.textViewPersonCountry);
            holder.image = convertView.findViewById(R.id.imageViewFlag);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Person currentPerson = getItem(position);

        holder.name.setText(currentPerson.getName());
        holder.country.setText(currentPerson.getCountry().getName());


        String url = currentPerson.getCountry().getFlagURL();
        Picasso.get().load(url).into(holder.image);

        return convertView;
    }

    static class ViewHolder {
        private TextView name;
        private TextView country;
        private ImageView image;
    }
}
