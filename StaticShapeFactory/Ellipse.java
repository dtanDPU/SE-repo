package StaticShapeFactory;

import main.CreateShapeCmd;
import main.Points;
import model.ShapeShadingType;
import model.interfaces.IDraw;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class Ellipse implements IDraw {
    Color primary, secondary;
    ShapeProperties shapeProperties;
    ShapeShadingType shadingType;
    Points startPoint, endPoint, newStart, newEnd;
    int width, height;

    private static ColorMap colorMap = new ColorMap();

    public Ellipse(ShapeProperties shapeProperties) {
        this.primary = colorMap.getTheColor(shapeProperties.getPrimary());
        this.secondary = colorMap.getTheColor(shapeProperties.getSecondary());
        this.shapeProperties = shapeProperties;
        this.shadingType = shapeProperties.getShadeType();
        this.startPoint = shapeProperties.getStartPoint();
        this.endPoint = shapeProperties.getEndPoint();
        this.width = shapeProperties.getWidth();
        this.height = shapeProperties.getHeight();
        this.newEnd = shapeProperties.getNewEndPoint();
        this.newStart = shapeProperties.getNewStartPoint();
    }

    public void draw(Graphics2D graphics) {

//        Graphics2D graphics2D = (Graphics2D) graphics;

        switch (shadingType.toString()) {
            case "FILLED_IN" -> {
                graphics.setColor(primary);
                graphics.fillOval(newStart.getX(), newStart.getY(), width, height);
            }
            case "OUTLINE" -> {
                graphics.setColor(primary);
                graphics.drawOval(newStart.getX(), newStart.getY(), width, height);
            }
            case "OUTLINE_AND_FILLED_IN" -> {
                graphics.setColor(secondary);
                graphics.drawOval(newStart.getX(), newStart.getY(), width, height);
                graphics.setColor(primary);
                graphics.fillOval(newStart.getX(), newStart.getY(), width, height);
            }
        }
    }

    @Override
    public void addDX(int dx) {
        newStart.setX(newStart.getX() + dx);
        newEnd.setX(newEnd.getX() + dx);
    }

    @Override
    public void addDY(int dy) {
        newStart.setY(newStart.getY() + dy);
        newEnd.setY(newStart.getY() + dy);

    }

    @Override
    public boolean shapeCollision(Points points) {
        return (points.getX() + shapeProperties.getNewEndPoint().getX() - shapeProperties.getNewStartPoint().getX() > newStart.getX() &&
                points.getY() + shapeProperties.getNewEndPoint().getY() - shapeProperties.getNewStartPoint().getY() > newStart.getY() &&
                points.getX() > newStart.getX() + shapeProperties.getNewEndPoint().getX() - shapeProperties.getNewStartPoint().getX() &&
                points.getY() > newStart.getY() + shapeProperties.getNewEndPoint().getY() - shapeProperties.getNewStartPoint().getY());
    }

    public ShapeProperties getShapeProps() {
        return shapeProperties;
    }

}
