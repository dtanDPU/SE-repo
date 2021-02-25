package StaticShapeFactory;

import main.Points;
import model.ShapeShadingType;
import model.interfaces.IDraw;

import java.awt.*;

public class Rectangle implements IDraw {
    Color primary, secondary;
    IShapeProperties shapeProperties;
    ShapeShadingType shadingType;
    Points startPoint, endPoint, newStart,newEnd;
    int width, height;

    private static final ColorMap colorMap = new ColorMap();

    public Rectangle(IShapeProperties shapeProperties) {
        this.shapeProperties = shapeProperties;
        this.primary = colorMap.getTheColor(shapeProperties.getPrimary());
        this.secondary = colorMap.getTheColor(shapeProperties.getSecondary());
        this.shadingType = shapeProperties.getShadeType();
        this.startPoint = shapeProperties.getStartPoint();
        this.endPoint = shapeProperties.getEndPoint();
        this.width = shapeProperties.getWidth();
        this.height = shapeProperties.getHeight();
        this.newStart = shapeProperties.getNewStartPoint();
        this.newEnd = shapeProperties.getNewEndPoint();
    }

    public void draw(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics;

        switch (shadingType.toString()) {
            case "FILLED_IN" -> {
                graphics.setColor(primary);
                graphics.fillRect(startPoint.getX(), startPoint.getY(), width, height);
            }
            case "OUTLINE" -> {
                graphics.setColor(primary);
                graphics.drawRect(startPoint.getX(), startPoint.getY(), width, height);
            }
            case "OUTLINE_AND_FILLED_IN" -> {
                graphics.setColor(primary);
                graphics.fillRect(startPoint.getX(), startPoint.getY(), width, height);
                graphics.setColor(secondary);
                graphics.drawRect(startPoint.getX(), startPoint.getY(), width, height);
            }
        }
    }

    public boolean shapeCollision(Points points) {
        return (points.getX() + shapeProperties.getWidth() > newStart.getX() &&
                points.getY() + shapeProperties.getHeight() > newStart.getY() &&
                points.getX() > newStart.getX() + shapeProperties.getWidth() &&
                points.getY() > newStart.getY() + shapeProperties.getHeight());
    }
}
