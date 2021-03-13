package view.gui;


import controller.CreateShapeCmd;
import controller.MoveShapeCmd;
import controller.SelectShapeCmd;
import model.persistence.ShapeList;
import model.persistence.ShapeProperties;
import model.interfaces.IApplicationState;
import controller.ICommand;
import view.interfaces.PaintCanvasBase;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {
    PaintCanvasBase canvasBase;
    Points startPoint, endPoint;
    ShapeList shapeList, selectedShapeList;
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
        shapeProps = applicationState.getShapeProps();
        startPoint = new Points(e.getX(), e.getY());
        shapeProps.setStartPoint(startPoint);
        System.out.println("Start: " + "(" + startPoint.getX() + "," + startPoint.getY() + ")");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint = new Points(e.getX(), e.getY());
        shapeProps.setEndPoint(endPoint);
        System.out.println("End: " + "(" + endPoint.getX() + "," + endPoint.getY() + ")");


        // calculates width/height of the rectangle
        x = shapeProps.getNewEndPoint().getX() - shapeProps.getNewStartPoint().getX();
        y = shapeProps.getNewEndPoint().getY() - shapeProps.getNewStartPoint().getY();

        shapeProps.setWidth(x);
        shapeProps.setHeight(y);


        switch (applicationState.getActiveMouseMode()) {
            case DRAW -> {
                cmd = new CreateShapeCmd(shapeProps, shapeList);
                cmd.run();
            }
            case SELECT -> {
                shapeProps.getNewEndPoint();
                cmd = new SelectShapeCmd(shapeProps, shapeList, canvasBase);
                cmd.run();
            }
            case MOVE -> {
                cmd = new MoveShapeCmd(shapeProps, selectedShapeList, shapeList );
                cmd.run();
            }
        }

        // original implementation to only draw shape
//        CreateShapeCmd createShapes = new CreateShapeCmd(shapeProps, applicationState, shapeList);
//        createShapes.run();
    }

}