package com.company;

import java.util.Objects;

public class Warrior extends VideoGameCharacters{
    private int shieldStrength;

    public Warrior(String name, int shieldStrength) {
        super(name, 75,100,100,50,10);
        this.shieldStrength = 100;
    }

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }
    public void decreaseShieldStrength(int decreaseShieldStrength){
        System.out.println(decreaseShieldStrength--);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Warrior warrior = (Warrior) o;
        return shieldStrength == warrior.shieldStrength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shieldStrength);
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "shieldStrength=" + shieldStrength +
                '}';
    }
}
