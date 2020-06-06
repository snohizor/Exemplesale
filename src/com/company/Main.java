package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Player player = new Player("tempName", 100);
        player.chooseName();
        player.chooseClass();
        player.chooseAttacks();
        player.fightNpc();
        player.fightNpc();

    }

    public static void logc(String text){
        System.out.println(text);
    }

    public static String scan() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
