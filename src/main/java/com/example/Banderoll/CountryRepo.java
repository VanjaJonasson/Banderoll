package com.example.Banderoll;

//import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Repository
public class CountryRepo {
    private List<Country> countries;

    public CountryRepo() {
        countries = new ArrayList<>();
    }

    public String getRandomCapital() {
        Random rand = new Random();
        Country randomCountry = countries.get(rand.nextInt(countries.size()));

        return randomCountry.getCapital();
    }

    public CountryRepo(List<Country> countries) {
        this.countries = countries;
    }

    public void add(Country country){
        countries.add(country);
    }



}
