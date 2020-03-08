package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
* In this class we have the logic for our game.
* You can initialize a minesweeper game of any length
*
* @author VoicuIuliana
*
* */

public class Game {
    private int length;

    private char[][] mat;

    private List<Point> mines;

    private boolean over;

    public Game(int length) {
        this.length = length;
        mat = new char[length][length];
        over = false;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                mat[i][j] = 'E';
            }
        }
        mines = new ArrayList<>();
        Random rnd = new Random();
        //generate random mines
        for (int i = 0; i <= length; i++) {
            mines.add(new Point(Math.abs(rnd.nextInt() % length), Math.abs(rnd.nextInt() % length)));
        }
    }

    public void printMap() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isOver() {
        return over;
    }

    public void makeMove(Point p) {
        if (isMine(p)) {
            System.out.println("Game over");
            for (Point mine : mines) {
                mat[mine.x][mine.y] = 'M';
            }
            printMap();
            over = true;
            return;
        }
        mat[p.x][p.y]=(char) (getNumberOfMines(p)+48);
        printMap();
    }

    private boolean isMine(Point p) {
        for(Point mine : mines){
            if(mine.equals(p)){
                return true;
            }
        }
        return false;
    }

    private int getNumberOfMines(Point p){
        int count=0;
        if(p.x>0&& isMine(new Point(p.x-1,p.y))) count++;
        if(p.y>0 && isMine(new Point(p.x,p.y-1))) count++;
        if(p.x<length -1&& isMine(new Point(p.x+1,p.y))) count++;
        if(p.y <length-1&& isMine(new Point(p.x,p.y+1))) count++;

        if(p.x>0&& isMine(new Point(p.x-1,p.y-1))) count++;
        if(p.y>0 && p.y <length-1 && isMine(new Point(p.x-1,p.y+1))) count++;
        if(p.x<length -1 && p.y > 0 && isMine(new Point(p.x+1,p.y-1))) count++;
        if(p.x <length-1 && p.y <length-1 && isMine(new Point(p.x+1,p.y+1))) count++;

        return count;
    }
}
