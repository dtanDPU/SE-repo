package controller;

import model.persistence.ShapeProperties;
import view.interfaces.IDraw;
import model.interfaces.ISubject;
import view.interfaces.PaintCanvasBase;

public class SelectShapeCmd implements ICommand {

    public ShapeProperties shapeProps;
    ISubject selectedShapeList;
    IDraw selectedShape;

    int width, height;
    PaintCanvasBase paintCanvasBase;


    public SelectShapeCmd( ShapeProperties shapeProps, ISubject selectedShapeList, PaintCanvasBase paintCanvasBase) {

        this.shapeProps = shapeProps;
        this.selectedShapeList = selectedShapeList;
        this.width = shapeProps.getNewEndPoint().getX() - shapeProps.getNewStartPoint().getX();
        this.height = shapeProps.getNewEndPoint().getY() - shapeProps.getNewStartPoint().getY();
        this.paintCanvasBase = paintCanvasBase;
    }

    @Override
    public void run() {
        selectedShapeList.clearSelectedList();

        for (IDraw shapes : selectedShapeList.getShapeList()) {
            System.out.println("select test");

            if (shapes.shapeCollision((shapeProps.getNewEndPoint()))) {
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
        // deselects shapes
        if(!shapeProps.ifSelected()) {
            selectedShapeList.clearSelectedList();
            selectedShapeList.notifyObserver();
        }

    }
}





