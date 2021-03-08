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


                System.out.println("Selected shape test: " + selectedShapeList.getSelectedShapeList());
            }
            else {
                shapeProps.notSelected();
            }
        }
        if(!shapeProps.ifSelected()) {
            selectedShapeList.clearSelectedList();
            selectedShapeList.getCopy().clear();
        }

        for (IDraw shapes : selectedShapeList.getSelectedShapeList()) {
            if (shapes.getShapeProps().getShapeType().equals(ShapeType.RECTANGLE)) {
                Graphics2D graphics2D = paintCanvasBase.getGraphics2D();
                Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                graphics2D.setStroke(dashed);
                graphics2D.setColor(Color.BLACK);
                graphics2D.drawRect(shapes.getShapeProps().getStartX() - 10, shapes.getShapeProps().getStartY() -10,
                        shapes.getShapeProps().getWidth()+20, shapes.getShapeProps().getHeight()+20);
            } else if (shapes.getShapeProps().getShapeType().equals(ShapeType.ELLIPSE)) {
                Graphics2D graphics2D = paintCanvasBase.getGraphics2D();
                Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                graphics2D.setStroke(dashed);
                graphics2D.setColor(Color.BLACK);
                graphics2D.drawOval(shapes.getShapeProps().getStartX()-10, shapes.getShapeProps().getStartY()-10,
                        shapes.getShapeProps().getWidth()+20, shapes.getShapeProps().getHeight()+20);
            } else if (shapes.getShapeProps().getShapeType().equals(ShapeType.TRIANGLE)) {

                int[] X;
                int[] Y;

                X = new int[]{shapeProps.getStartPoint().getX(), shapeProps.getEndPoint().getX(), shapeProps.getStartPoint().getX()};
                Y = new int[]{shapeProps.getStartPoint().getY(), shapeProps.getEndPoint().getY(), shapeProps.getEndPoint().getY()};

                Graphics2D graphics2D = paintCanvasBase.getGraphics2D();
                Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                graphics2D.setStroke(dashed);
                graphics2D.setColor(Color.BLACK);
                graphics2D.drawPolygon(X,Y,3);
            }
        }

    }
}





