package com.company;


import java.util.Objects;

//this is our parent class or base class
//we have collected information from each character that are basically the same and compiled them under this class

public class VideoGameCharacters {

    //we declare variables/properties down here
    private String name;
    private int strength;
    private int health;
    private int stamina;
    private int speed;
    private int attackPower;

//we then create a construction.. #command n... creating a constructor turns a class into an object that we can then later use.
    //in this case because its different classes we will be extending this parent class to the children class
    public VideoGameCharacters(String name, int strength, int health, int stamina, int speed, int attackPower) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.stamina = stamina;
        this.speed = speed;
        this.attackPower = attackPower;
    }

    //these are our getters and setters.
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    //we then write methods or attributes that describe what the object does
    public void run() {
        System.out.println("run!");
    }

    public void attack() {
        System.out.println("attack!");
    }

    public void heal() {
        System.out.println("heal");
    }

    public int decreaseHealth() {
        return this.health--;
    }

    public int increaseStamina() {
        return this.stamina++;
    }

    public int decreaseStamina() {
        return this.stamina--;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //these allow us to compare objects of these types
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoGameCharacters that = (VideoGameCharacters) o;
        return strength == that.strength && health == that.health && stamina == that.stamina && speed == that.speed && attackPower == that.attackPower && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, strength, health, stamina, speed, attackPower);
    }

    @Override
    public String toString() {
        return "VideoGameCharacters{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", health=" + health +
                ", stamina=" + stamina +
                ", speed=" + speed +
                ", attackPower=" + attackPower +
                '}';
    }
}
