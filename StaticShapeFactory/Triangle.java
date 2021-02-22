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
    Points startPoint, endPoint;
    int[] X, Y;

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


    }

    public void draw(Graphics graphics) {

        int[] X = {startPoint.getX(), startPoint.getX(), + width, startPoint.getX()};
        int[] Y = {startPoint.getY(), startPoint.getY() + height ,  + height};

        Graphics2D graphics2D = (Graphics2D) graphics;

        switch (shadingType.toString()) {
            case "FILLED_IN" -> {
                graphics2D.setColor(primary);
                graphics2D.fillPolygon(X,Y, 3);
            }
            case "OUTLINE" -> {
                graphics2D.setColor(primary);
                graphics2D.drawPolygon(X,Y,3);
            }
            case "OUTLINE_AND_FILLED_IN" -> {
                graphics2D.setColor(primary);
                graphics2D.fillPolygon(X,Y,3);
                graphics2D.setColor(secondary);
                graphics2D.drawPolygon(X,Y,3);
            }
        }
    }


}
