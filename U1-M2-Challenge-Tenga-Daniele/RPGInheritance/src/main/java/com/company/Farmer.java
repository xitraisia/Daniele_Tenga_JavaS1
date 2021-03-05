package com.company;

public class Farmer extends VideoGameCharacters {

    public Farmer(String name) {
        super(name, 75,100,75,10,1);
    }
    public void plow(){
        System.out.println("Plowing");
    }
    public void harvest(){
        System.out.println("harvesting");
    }
    
}
