package model.persistence;

import StaticShapeFactory.ColorMap;
import StaticShapeFactory.IShapeProperties;
import StaticShapeFactory.ShapeList;
import StaticShapeFactory.ShapeProperties;
import model.ShapeColor;
import model.interfaces.IDraw;
import model.interfaces.IObserver;
import view.gui.PaintCanvas;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawShape implements IObserver {

    PaintCanvasBase paintCanvas;
    ShapeList shapeList;
    ShapeProperties shapeProperties;

    public DrawShape(PaintCanvasBase paintCanvas, ShapeList shapeList) {
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
    }

    public void update(){
        Graphics2D g = paintCanvas.getGraphics2D();
        g.setColor(ColorMap.getTheColor(ShapeColor.WHITE));
        g.fillRect(0,0,paintCanvas.getWidth(),paintCanvas.getHeight());
        for(IDraw shape : shapeList.getShapeList()){
            shape.draw(g);

        }
    }
}
