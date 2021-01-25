package main;

import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {
    PaintCanvasBase canvas;
    Point startPoint;
    Point endPoint;

    public MouseHandler (PaintCanvasBase canvas) {
        this.canvas = canvas;

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int startPointX = e.getX();
        int startPointY = e.getY();
        startPoint = new Point(startPointX, startPointY);
        System.out.println("Start: " + "(" + startPoint.getX() + "," + startPoint.getY() + ")");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int endPointX = e.getX();
        int endPointY = e.getY();
        endPoint = new Point(endPointX, endPointY);
        System.out.println("End: " + "(" + endPoint.getX() + "," + endPoint.getY() + ")");

        int width = Math.abs(endPoint.getX() - startPoint.getX());
        int height = Math.abs(endPoint.getY() - startPoint.getY());

        Graphics2D graphics2d = canvas.getGraphics2D();
        graphics2d.setColor(Color.GREEN);
        graphics2d.fillRect(startPoint.getX(), startPoint.getY(), width, height);
    }
}
