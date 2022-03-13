package com.example.gameapp_rc1;

import java.util.ArrayList;

public class GameManager {
    private int currentCountryIndex = 0;
    private int score = 0;
    private int lives = 3;
    private ArrayList<Country> countries;

    public GameManager() {
        countries = GameDataManager.generateCountries();
    }

    public Country getCurrentCountry() throws Exception {
        if (currentCountryIndex < countries.size())
            return countries.get(currentCountryIndex);
       throw new Exception("Win Game!");
    }

    public void addCurrentCountry() {
        currentCountryIndex++;
    }

    public int getScore() {
        return score;
    }

    public void addScore() {
        score++;
    }

    public int getLives() {
        return lives;
    }

    public void reduceLives() throws Exception {
        if (lives > 1){
            lives--;
        }else {
            throw new Exception("Looser");
        }
    }
}
