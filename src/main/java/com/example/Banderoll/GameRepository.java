package com.example.Banderoll;

public class GameRepository {
    private static String[] countries;
    private static String[] capitals;
    private static String[] flags;
    private static String[] regions;

    ApiController api = new ApiController();

    public GameRepository() throws Exception {
        this.countries = api.getCountries();
        this.capitals = api.getCapitals();
        this.flags = api.getFlags();
        this.regions = api.getRegions();

    }

    //Get String with country and capital by id
    public static String getCountryWithCapital(int id) {
        if (countries[id] !=null && capitals[id] != null) {
            return countries[id] + "'s captial is: " + capitals[id];
        }
        return "Couldn't find country or capital.";
    }
    //Get String with capital and country by id
    public static String getCapitalWithCountry(int id){
        if (countries[id] !=null && capitals[id] != null) {
            return capitals[id] + " is the capital of: " + countries[id];
        }
        return "Couldn't find capital or country.";
    }
    //Get string with country and flag by id
    public static String getCountryWithFlag(int id){
        if (countries[id] !=null && capitals[id] != null) {
            return countries[id] +"'s flag looks like this: " + flags[id];
        }
        return "Couldn't find country or flag.";
    }
    //Get all info in String by id
    public static String getCountryWithAllInfo(int id){
        if (countries[id] !=null && capitals[id] != null && flags[id] != null && regions[id] !=null) {
            return countries[id] + "'s capital is " + capitals[id] + ", it belongs to the " + regions[id] + " region and their flag looks like this: " + flags[id];
        }
        return "Couldn't find country, capital or flag.";
    }
}
