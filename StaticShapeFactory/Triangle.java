package StaticShapeFactory;

import main.CreateShapeCmd;
import main.Points;
import model.ShapeShadingType;
import model.interfaces.IDraw;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class Triangle implements IDraw {

    Color primary, secondary;
    IShapeProperties shapeProperties;
    ShapeShadingType shadingType;
    int width, height;
    Points startPoint, endPoint, newStart, newEnd  ;
    private static ColorMap colorMap = new ColorMap();


    public Triangle(IShapeProperties shapeProperties) {
        this.primary = colorMap.getTheColor(shapeProperties.getPrimary());
        this.secondary = colorMap.getTheColor(shapeProperties.getSecondary());
        this.shapeProperties = shapeProperties;
        this.shadingType = shapeProperties.getShadeType();
        this.width = shapeProperties.getWidth();
        this.height = shapeProperties.getHeight();
        this.startPoint = shapeProperties.getStartPoint();
        this.endPoint = shapeProperties.getEndPoint();
        this.newEnd = shapeProperties.getNewEndPoint();
        this.newStart = shapeProperties.getNewStartPoint();


    }

    public void draw(Graphics graphics) {

        int[] X = {startPoint.getX(), endPoint.getX(), startPoint.getX()};
        int[] Y = {startPoint.getY(), endPoint.getY(), endPoint.getY()};

        Graphics2D graphics2D = (Graphics2D) graphics;

        switch (shadingType.toString()) {
            case "FILLED_IN" -> {
                graphics.setColor(primary);
                graphics.fillPolygon(X,Y, 3);
            }
            case "OUTLINE" -> {
                graphics.setColor(primary);
                graphics.drawPolygon(X,Y,3);
            }
            case "OUTLINE_AND_FILLED_IN" -> {
                graphics.setColor(primary);
                graphics.drawPolygon(X,Y,3);
                graphics.setColor(secondary);
                graphics.fillPolygon(X,Y,3);
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
