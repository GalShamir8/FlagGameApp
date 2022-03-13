package com.example.gameapp_rc1;

import java.util.ArrayList;

public class GameDataManager {

    public static ArrayList<Country> generateCountries;

    public static ArrayList<Country> generateCountries(){
        ArrayList<Country> countries= new ArrayList<>();

        countries.add(new Country().setName("brazil").setCode("").setPeace(true));
        countries.add(new Country().setName("mexico").setCode("").setPeace(true));
        countries.add(new Country().setName("united_arab_emirates").setCode("").setPeace(false));
        countries.add(new Country().setName("united_kingdom").setCode("").setPeace(true));
        return countries;
    }
}