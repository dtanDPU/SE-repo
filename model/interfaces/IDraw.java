package model.interfaces;

import StaticShapeFactory.IShapeProperties;
import StaticShapeFactory.ShapeProperties;
import main.CreateShapeCmd;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public interface IDraw {
    void draw(Graphics graphics);


}