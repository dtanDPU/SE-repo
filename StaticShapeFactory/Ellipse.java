package StaticShapeFactory;

import main.CreateShapeCmd;
import main.Points;
import model.ShapeShadingType;
import model.interfaces.IDraw;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class Ellipse implements IDraw {
    Color primary, secondary;
    IShapeProperties shapeProperties;
    ShapeShadingType shadingType;
    Points startPoint, endPoint, newStart, newEnd;
    int width, height;

    private static ColorMap colorMap = new ColorMap();

    public Ellipse(IShapeProperties shapeProperties) {
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



    public void draw(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics;

        switch (shadingType.toString()) {
            case "FILLED_IN" -> {
                graphics.setColor(primary);
                graphics.fillOval(startPoint.getX(), startPoint.getY(), width, height);
            }
            case "OUTLINE" -> {
                graphics.setColor(primary);
                graphics.drawOval(startPoint.getX(), startPoint.getY(), width, height);
            }
            case "OUTLINE_AND_FILLED_IN" -> {
                graphics.setColor(primary);
                graphics.drawOval(startPoint.getX(), startPoint.getY(), width, height);
                graphics.setColor(secondary);
                graphics.fillOval(startPoint.getX(), startPoint.getY(), width, height);
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
