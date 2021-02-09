package model.interfaces;

import StaticShapeFactory.IShapeProperties;
import main.CreateShapeCmd;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public interface IDraw {
    void draw(Graphics2D graphics2D);

    IShapeProperties getProps();

}