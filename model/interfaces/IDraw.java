package model.interfaces;

import StaticShapeFactory.IShapeProperties;
import StaticShapeFactory.ShapeProperties;
import main.CreateShapeCmd;
import main.Points;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public interface IDraw {
    void draw(Graphics graphics);
    boolean shapeCollision(Points points);


}