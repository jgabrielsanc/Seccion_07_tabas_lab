package com.android.jsanchez.seccion_07_toolbar_tabs_lab.models;

import java.text.MessageFormat;

public class Country {

    private String Name;
    private String CountryCode;


    public Country(String name, String countryCode) {
        Name = name;
        CountryCode = countryCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }


    public String getFlagURL() {
        return MessageFormat.format("http://www.geognos.com/api/en/countries/flag/{0}.png",
                this.getCountryCode());
    }

    @Override
    public String toString() {
        return Name;
    }

}
