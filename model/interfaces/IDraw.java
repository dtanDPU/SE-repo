package model.interfaces;

import StaticShapeFactory.IShapeProperties;
import StaticShapeFactory.ShapeProperties;
import main.CreateShapeCmd;
import main.Points;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public interface IDraw {

    void draw(Graphics2D graphics);
    void addDX(int dx);
    void addDY(int dy);
    boolean shapeCollision(Points target);
    ShapeProperties getShapeProps();
    void outline(Graphics graphics);




}