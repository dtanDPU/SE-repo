package main;


public class Point1 {
    int x;
    int y;
    Point1 point;


    public Point1(int x, int y) {
        this.x = x;
        this.y = y;
//        System.out.println(x + ", " + y);
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point1 getPoint(){
        return point;
    }



}
