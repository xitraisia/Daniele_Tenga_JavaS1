package com.company;


public class VideoGameCharacters {

    private String name;
    private Constable constable;
    private Farmer farmer;
    private Warrior warrior;


    public VideoGameCharacters(String name, Constable constable, Farmer farmer, Warrior warrior){
        this.name = name;
        this.constable = constable;
        this.farmer = farmer;
        this.warrior = warrior;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
