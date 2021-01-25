package main;


public class Point {
    int x;
    int y;
    Point point;


    public Point(int x, int y) {
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

    public Point getPoint(){
        return point;
    }



}
