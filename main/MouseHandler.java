package main;

import StaticShapeFactory.IShapeList;
import StaticShapeFactory.IShapeProperties;
import StaticShapeFactory.ShapeList;
import StaticShapeFactory.ShapeProperties;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {
    PaintCanvasBase canvasBase;
    Points startPoint, endPoint;
    ShapeList shapeList;
    ShapeProperties shapeProps;

    int x, y;
    int height, width;
    public static ApplicationState appState;
//    IShapeList iShapeList;


    public MouseHandler(PaintCanvasBase canvasBase) {
        this.canvasBase = canvasBase;


    }

    @Override
    public void mousePressed(MouseEvent e) {
//        int startPointX = e.getX();
//        int startPointY = e.getY();
        startPoint = new Points(e.getX(), e.getY());
        System.out.println("Start: " + "(" + startPoint.getX() + "," + startPoint.getY() + ")");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        int endPointX = e.getX();
//        int endPointY = e.getY();
        endPoint = new Points(e.getX(), e.getY());
        System.out.println("End: " + "(" + endPoint.getX() + "," + endPoint.getY() + ")");

        // calculates width/height of the rectangle
        x = Math.min(startPoint.getX(), endPoint.getX());
        y = Math.min(startPoint.getY(), endPoint.getY());
//        width = Math.abs(endPoint.getX() - startPoint.getX());
//        height = Math.abs(endPoint.getY() - startPoint.getY());
        // this draws the actual rectangle out using the mouse click and drag
//        Graphics2D graphics2d =   canvasBase.getGraphics2D();
//        graphics2d.setColor(Color.GREEN);
//        graphics2d.fillRect(startPoint.getX(), startPoint.getY(), width, height);

        CreateShapeCmd createShapes = new CreateShapeCmd(shapeProps, appState, shapeList);
        createShapes.run();
    }

}