package com.example.Banderoll;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryRepository {

    private List<Country> countries;

    /*
    public CountryRepository() {
        countries = new ArrayList<>();
        countries.add(new Country("Sweden", "Stockholm"));
        countries.add(new Country("Norway", "Oslo"));
        countries.add(new Country("Denmark", "Copenhagen"));
        countries.add(new Country("France", "Paris"));
    }

     */


    public List<Country> getCountries() {
        return countries;

    }
}
