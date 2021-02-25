package main;

import StaticShapeFactory.IShapeList;
import StaticShapeFactory.IShapeProperties;
import StaticShapeFactory.ShapeList;
import StaticShapeFactory.ShapeProperties;
import model.MouseMode;
import model.dialogs.ChooseStartAndEndPointModeDialog;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import model.persistence.StartEndPoints;
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
    public IApplicationState applicationState;
    ICommand cmd;


    public MouseHandler(PaintCanvasBase canvasBase, ShapeList shapeList, IApplicationState applicationState) {
        this.canvasBase = canvasBase;
        this.shapeList = shapeList;
        this.applicationState = applicationState;

    }

    @Override
    public void mousePressed(MouseEvent e) {
//        int startPointX = e.getX();
//        int startPointY = e.getY();
        shapeProps = applicationState.getShapeProps();

        startPoint = new Points(e.getX(), e.getY());
        shapeProps.setStartPoint(startPoint);
        System.out.println("Start: " + "(" + startPoint.getX() + "," + startPoint.getY() + ")");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        int endPointX = e.getX();
//        int endPointY = e.getY();
        endPoint = new Points(e.getX(), e.getY());
        shapeProps.setEndPoint(endPoint);
        System.out.println("End: " + "(" + endPoint.getX() + "," + endPoint.getY() + ")");

        // calculates width/height of the rectangle
        x = Math.min(startPoint.getX(), endPoint.getX());
        y = Math.min(startPoint.getY(), endPoint.getY());

        shapeProps.setWidth(x);
        shapeProps.setHeight(y);
//        width = Math.abs(endPoint.getX() - startPoint.getX());
//        height = Math.abs(endPoint.getY() - startPoint.getY());
        // this draws the actual rectangle out using the mouse click and drag
//        Graphics2D graphics2d =   canvasBase.getGraphics2D();
//        graphics2d.setColor(Color.GREEN);
//        graphics2d.fillRect(startPoint.getX(), startPoint.getY(), width, height);

        MouseMode mouseMode = applicationState.getActiveMouseMode();
        switch (mouseMode.toString()) {
            case "DRAW" -> {
                CreateShapeCmd createShapes = new CreateShapeCmd(shapeProps, applicationState, shapeList);
                createShapes.run();
            }
            case "SELECT" -> {
                SelectShapeCmd selectShapeCmd = new SelectShapeCmd(shapeProps, applicationState, shapeList);
                selectShapeCmd.run();
            }
            case "MOVE" -> {
                MoveShapeCmd moveShapeCmd = new MoveShapeCmd(shapeProps, applicationState, shapeList);
                moveShapeCmd.run();
            }
        }


        // original implementation to only draw shape
//        CreateShapeCmd createShapes = new CreateShapeCmd(shapeProps, applicationState, shapeList);
//        createShapes.run();
    }

}