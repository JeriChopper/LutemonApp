package org.gpiste.lutemon;

import java.util.ArrayList;

public class Lutemon {
    private String name;
    private String color;
    private static ArrayList<Lutemon> lutemonList = new ArrayList<>();
    private int attack;
    private int defense;
    private int experience;
    private int health;
    private int maxHealth;
    private int id;


    //constructor for Lutemon Object
    public Lutemon(String name, String color, int attack, int defense, int experience, int maxHealth, int health, int id) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.experience = experience;
        this.maxHealth = maxHealth;
        this.health = health;
        this.id = id;
    }

    //getters for each parameter
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getId() {
        return id;
    }

    //levelUp method to train lutemons in TrainLutemonActivity..
    public void levelUp(String stat) {
        switch (stat) {
            case "attack":
                this.attack += 1;
                this.experience += 1;
                break;
            case "defense":
                this.defense += 1;
                this.experience += 1;
                break;
            case "max health":
                this.maxHealth += 5;
                this.experience += 1;
                this.health += 5; // increase health aswell in order to have health and MaxHealth be same at the start of the fight
                break;
            default:
                break;
        }
    }

    // method to provide lutemonlist with objects...
    public static ArrayList<Lutemon> getLutemonList() {
        return lutemonList;
    }

    // method to encounter the fight between two Lutemons
    public void takeDamage(int damage) {
        if (damage > 0) {
            this.health -= damage;
            if (this.health < 0) {
                this.health = 0;
            }
        }
    }

    //when a fight has been won, you gain one experience point.
    public void addExperience(){
        this.experience++;
    }
}


