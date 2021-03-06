package org.pokemonrun.util;

public class Point {
    private double x;
    private double y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double distanceFrom(Point p){
        return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
}
