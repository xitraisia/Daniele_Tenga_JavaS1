package com.company;


import java.util.Objects;

public class Constable extends VideoGameCharacters{ //we have extended the parent class to the child

    private int jurisdiction; //we declare a property that is unique to this object

    public Constable(String name, int jurisdiction) {
        //this is initializing our specific or unique values to their character
        super(name, 60, 100, 60, 20, 5);
        this.jurisdiction = jurisdiction;
    }
//getters and setters
    public int getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(int jurisdiction) {
        this.jurisdiction = jurisdiction;
    }
    //we wrote a new method for the attribute
    public void arrest(){
        System.out.println("You're under arrest!!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Constable constable = (Constable) o;
        return jurisdiction == constable.jurisdiction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), jurisdiction);
    }

    @Override
    public String toString() {
        return "Constable{" +
                "jurisdiction=" + jurisdiction +
                '}';
    }
}
