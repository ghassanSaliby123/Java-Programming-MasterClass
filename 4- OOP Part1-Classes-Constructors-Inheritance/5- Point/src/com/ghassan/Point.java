package com.ghassan;

public class Point {
    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public double distance(){
        return  (double) Math.sqrt(Math.pow(this.getX(),2) + Math.pow(this.getY(),2));
    }
    public double distance(int x , int y){
        Point p = new Point(x,y);
        return distance(p);
    }
    public double distance(Point point){
        return (double) Math.sqrt(Math.pow(Math.abs(this.getX() - point.getX()),2) +
                Math.pow(Math.abs(this.getY() - point.getY()),2));
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
