package com.example.Banderoll;

import org.springframework.stereotype.Service;

@Service
public class Country {

    public String country;
    public String capital;
    public String flag;

    public Country(String country, String capital, String flag) {
        this.country = country;
        this.capital = capital;
        this.flag = flag;
    }

    public Country() {
    }

    public String getFlag() {
        return flag;
    }

    public String getName() {
        return country;
    }

    public String getCapital() {
        return capital;
    }

}
