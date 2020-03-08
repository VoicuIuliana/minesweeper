package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game=new Game(5);
        Scanner keyboard=new Scanner(System.in);
        game.printMap();
        while (!game.isOver()){
            int x=keyboard.nextInt();
            int y=keyboard.nextInt();
            game.makeMove(new Point(x,y));
        }
    }

}
