package com.company;

import java.util.ArrayList;
import java.util.Scanner;

import static com.company.Main.logc;
import static com.company.Main.scan;

public class Player {
    private String name;
    private int hp;
    private int xp = 0;
    private String charClass = null;
    private ArrayList<String> attacksList = new ArrayList<String>();

    public void chooseName(){
        logc("Quel est votre nom ?");
        String str = scan();
        this.name = str;
        logc("Bonjour " + str + " ! Ici commence votre mission");
    }

    public void chooseClass(){
        logc(this.name + ", êtes-vous un Guerrier ou un Mage ?");

        while (this.charClass == null) {
            String str = scan();

            if (str.toLowerCase().equals("guerrier"))
                this.charClass = "warrior";
            else if (str.toLowerCase().equals("mage"))
                this.charClass = "wizard";
            else
                logc("Je n'ai pas compris, veuillez répéter.");
        }
    }

    public void chooseAttacks(){
        //Warrior
        if (this.charClass.equals("warrior")){
            logc("Choisissez 1 attaque parmi ces 3 :\n-Charge\n-Coup de bouclier\n-Tranche");

            while (this.attacksList == null) {
                String str = scan();
                if (str.toLowerCase().equals("charge"))
                    this.attacksList.add("charge");
                else if (str.toLowerCase().equals("coup de bouclier"))
                    this.attacksList.add("shieldslam");
                else if (str.toLowerCase().equals("tranche"))
                    this.attacksList.add("chop");
                else
                    logc("Je n'ai pas compris, veuillez répéter.");
            }
        }

        //Wizard
        else if(this.charClass.equals("wizard")){
            logc("Choisissez 1 attaque parmi ces 3 :\n-Boule de feu\n-Eclair\n-Trait de givre");

            while (this.attacksList.size() < 1) {
                String str = scan();
                if (str.toLowerCase().equals("boule de feu"))
                    this.attacksList.add("fireball");
                else if (str.toLowerCase().equals("eclair"))
                    this.attacksList.add("lightningbolt");
                else if (str.toLowerCase().equals("Trait de givre"))
                    this.attacksList.add("frostbolt");
                else
                    logc("Je n'ai pas compris, veuillez répéter.");
            }
        }
    }

    public void fightNpc(){
        Boolean ennemyDown = false;
        if (this.xp == 0){
            logc("Un mannequin d'entrainement magique approche.\nQuel attaque voulez-vous lancer ?\n" +
                    this.displayAllAttacks());

            while (!ennemyDown) {
                String str = scan();

                if (this.attacksList.contains(str.toLowerCase())) {
                    logc("Vous attaquez avec " + str.toLowerCase() + " !\nVous avez explosé le mannequin " +
                            "d'entrainement !");
                    ennemyDown = true;
                }
                else
                    logc("Je n'ai pas compris, réessayez svp.");
            }
        }

        if (this.xp == 1){
            logc("Un gnome lépreux approche.\nQuel attaque voulez-vous lancer ?\n" +
                    this.displayAllAttacks());

            while (!ennemyDown) {
                String str = scan();

                if (this.attacksList.contains(str.toLowerCase())) {
                    logc("Vous attaquez avec " + str.toLowerCase() + " !\nVous avez battu le gnome lépreux ");
                    ennemyDown = true;
                }
                else
                    logc("Je n'ai pas compris, réessayez svp.");
            }
        }

        this.xp++;
    }

    public String displayAllAttacks(){
        String availableAttacksList = "";
        for (int i=0; i<this.attacksList.size(); i++){
            availableAttacksList = availableAttacksList + "\n" + this.attacksList.get(i);
        }
        return availableAttacksList;
    }

    public Player(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
