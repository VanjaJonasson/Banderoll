package com.example.Banderoll;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.*;

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

    public ApiController() throws Exception {

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

        for (int i=0; i<listCountryNames.size();i++) {
            if(listCapitalNames.get(i)!=null) {
                countries[i] = listCountryNames.get(i).get("common").toString();
                capitals[i] = listCapitalNames.get(i).get(0).toString();
                flags[i] = listFlags.get(i).get("png").toString();
                regions[i] = listRegions.get(i).get(0).toString();
            }
        }
    }
    //Getters
    public String[] getCountries(){
        return countries;
    }
    public String[] getCapitals(){
        return capitals;
    }
    public String[] getFlags(){
        return flags;
    }
    public String[] getRegions() { return regions; }
}
