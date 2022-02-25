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

    }

     */


    public List<Country> getCountries() {
        return countries;

    }
}
