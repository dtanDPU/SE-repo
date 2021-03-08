package StaticShapeFactory;

import main.Points;
import model.interfaces.IDraw;

import java.awt.*;

public class NullObject implements IDraw {
    @Override
    public void draw(Graphics2D graphics) {
        System.out.println("Select one of the available options. Shape does not exist.");
    }

    @Override
    public void addDX(int dx) {

    }

    @Override
    public void addDY(int dy) {

    }

    @Override
    public boolean shapeCollision(Points points) {
        return false;
    }

    @Override
    public ShapeProperties getShapeProps() {
        return null;
    }

    @Override
    public void outline(Graphics graphics) {

    }
}
