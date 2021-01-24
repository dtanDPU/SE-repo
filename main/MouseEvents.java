package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseEvents extends MouseAdapter {


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int startPointX = e.getX();
        int startPointY = e.getY();
        Point startPoint = new Point(startPointX, startPointY);
//        System.out.println("Start point X: " + startPoint.getX() +  " Start point Y: " + startPoint.getY());

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int endPointX = e.getX();
        int endPointY = e.getY();
        Point endPoint = new Point(endPointX, endPointY);
//        System.out.println("End point X: " + endPoint.getX() +  " End point Y: " + endPoint.getY());

    }

}
