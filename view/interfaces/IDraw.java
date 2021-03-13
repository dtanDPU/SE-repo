package view.interfaces;

import model.persistence.ShapeProperties;
import view.gui.Points;

import java.awt.*;

public interface IDraw {

    void draw(Graphics2D graphics);
    void addDX(int dx);
    void addDY(int dy);
    boolean shapeCollision(Points points);
    ShapeProperties getShapeProps();
    void outline(Graphics graphics);




}