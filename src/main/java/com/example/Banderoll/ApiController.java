package com.example.Banderoll;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.lang.Long.getLong;
@Service
public class ApiController {
    //Get the CountryAPI
    private RequestSpecification httpRequest;
    List<HashMap> listCountryNames = new ArrayList<>();
    List<ArrayList> listCapitalNames = new ArrayList<>();
    List<HashMap> listFlags = new ArrayList<>();
    List<ArrayList> listRegions = new ArrayList<>();

    String[] countries;
    String[] capitals;
    String[] flags;
    String[] regions;

    @Autowired
    CountryRepository repository;

    //Start a method to get api, instead of api call in constructor
    public void innit() throws Exception {

        RestAssured.baseURI = "https://restcountries.com/v3.1";
        httpRequest = RestAssured.given();
        //Get all countries
        Response response = httpRequest.get("/all");

        listCountryNames = response.jsonPath().getList("name");
        listCapitalNames = response.jsonPath().getList("capital");
        listFlags = response.jsonPath().getList("flags");
        listRegions = response.jsonPath().getList("region");
        countries = new String[listCountryNames.size()];
        capitals = new String[listCountryNames.size()];
        flags = new String[listCountryNames.size()];
        regions = new String[listRegions.size()];


        List<Country> countries = new ArrayList<>();
        for (int i=0; i<listCountryNames.size();i++) {
            if(listCountryNames.get(i)!=null && listCapitalNames.get(i)!=null && listFlags.get(i)!=null) {
                Country country = new Country();
                country.setName(listCountryNames.get(i).get("common").toString());
                country.setCapital(listCapitalNames.get(i).get(0).toString());
                country.setFlag(listFlags.get(i).get("png").toString());
                countries.add(country);

                /*countries[i] = listCountryNames.get(i).get("common").toString();
                capitals[i] = listCapitalNames.get(i).get(0).toString();
                flags[i] = listFlags.get(i).get("png").toString();
                //regions[i] = listRegions.get(i).get(0).toString();*/
            }
        }
        //JPA spara all country-object
        repository.saveAll(countries);
    }
    /*Getters
    public String[] getCountries(){
        return countries;
    }
    public String[] getCapitals(){
        return capitals;
    }
    public String[] getFlags(){
        return flags;
    }
    public String[] getRegions() { return regions; }*/
}
