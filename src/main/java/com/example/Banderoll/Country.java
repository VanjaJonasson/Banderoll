package com.example.Banderoll;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Service
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String capital;
    @Getter
    @Setter
    private String flag;

    public Country() {
    }

    public Country(String name, String capital, String flag) {
        this.name = name;
        this.capital = capital;
        this.flag = flag;

    }
}
