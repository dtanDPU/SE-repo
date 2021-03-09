package main;

import StaticShapeFactory.ShapeList;
import StaticShapeFactory.ShapeProperties;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IDraw;
import model.interfaces.IObserver;
import model.persistence.DrawShape;
import view.interfaces.ISubject;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class SelectShapeCmd implements ICommand {

    public ShapeProperties shapeProps;
    ShapeList shapeList;
    ISubject selectedShapeList;
    IDraw selectedShape;
    Points newStart;
    int width, height;
    PaintCanvasBase paintCanvasBase;


    public SelectShapeCmd(ShapeProperties shapeProps, ISubject selectedShapeList, PaintCanvasBase paintCanvasBase) {

        this.shapeProps = shapeProps;
        this.selectedShapeList = selectedShapeList;
        this.newStart = shapeProps.getNewStartPoint();
        this.width = shapeProps.getNewEndPoint().getX() - shapeProps.getNewStartPoint().getX();
        this.height = shapeProps.getNewEndPoint().getY() - shapeProps.getNewStartPoint().getY();
        this.paintCanvasBase = paintCanvasBase;
    }

    @Override
    public void run() {
        selectedShapeList.clearSelectedList();

        for (IDraw shapes : selectedShapeList.getShapeList()) {
            System.out.println("select test");

            if (shapes.shapeCollision((shapeProps.getEndPoint()))) {
                shapeProps.selected();
                selectedShape = shapes;
                selectedShapeList.addSelectedList(selectedShape);
                shapes.outline(paintCanvasBase.getGraphics2D());


                System.out.println("Selected shape test: " + selectedShapeList.getSelectedShapeList());
            }
            else {
                shapeProps.notSelected();
            }
        }
        if(!shapeProps.ifSelected()) {
            selectedShapeList.clearSelectedList();
            selectedShapeList.notifyObserver();
        }

    }
}





