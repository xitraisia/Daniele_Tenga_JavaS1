package com.company;

public class Farmer {

    private int strength;
    private int health;
    private int stamina;
    private int speed;
    private int attackPower;
    private String name;
    public boolean attack1;
    public boolean run1;
    public boolean plow1;
    public boolean heal1;
    public boolean harvest1;



    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = 75;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = 100;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = 75;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = 10;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean run(){
        return run1 = true;
    }
    public boolean plow(){
        return plow1 = true;
    }
    public boolean harvest(){
        return harvest1 = true;
    }
    public boolean attack(){
       return attack1 = true;
    }
    public boolean heal(){
        return heal1 = true;
    }
    public int decreaseHealth(){
        return this.health--;
    }
    public int increaseStamina(){
        return this.stamina++;
    }
    public int decreaseStamina(){
        return this.stamina--;
    }
}
