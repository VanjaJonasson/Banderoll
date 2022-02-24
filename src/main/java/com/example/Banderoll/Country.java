package com.example.Banderoll;

import lombok.Getter;
import lombok.Setter;

public class Country {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String capital;
    @Getter
    @Setter
    private String flag;

    public Country(String name, String capital, String flag) {
        this.name = name;
        this.capital = capital;
        this.flag = flag;

    }
}
