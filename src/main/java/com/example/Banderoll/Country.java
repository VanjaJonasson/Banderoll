package com.example.Banderoll;

import org.springframework.stereotype.Service;

@Service
public class Country {

    public String name;
    public String capital;

    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    public Country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
