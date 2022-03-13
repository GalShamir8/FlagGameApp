package com.example.gameapp_rc1;

public class Country {
    private String name;
    private String code;
    private boolean peace = true;

    public Country() { }

    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Country setCode(String code) {
        this.code = code;
        return this;
    }

    public boolean isPeace() {
        return peace;
    }

    public Country setPeace(boolean peace) {
        this.peace = peace;
        return this;
    }
}
