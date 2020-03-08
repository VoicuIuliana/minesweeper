package com.company;

/*
* A simple Point class
*
* @author VoicuIuliana
* */

public class Point {
    public int x;
    public int y;

    public Point (){
        this.x=0;
        this.y=0;
    }
    public Point (int x,int y){
        this.x=x;
        this.y=y;
    }

    public boolean equals(Point p){
        return this.x==p.x && this.y==p.y;
    }
}
