package StaticShapeFactory;

import main.CreateShapeCmd;
import main.Points;
import model.ShapeShadingType;
import model.interfaces.IDraw;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class Triangle implements IDraw {

    Color primary, secondary;
    PaintCanvasBase paintCanvasBase;
    IShapeProperties shapeProperties;
    ShapeShadingType shadingType;
    int width, height;
    Points startPoint, endPoint;
    int[] X, Y;


    public Triangle( IShapeProperties shapeProperties) {
        this.primary = ColorMap.getTheColor(shapeProperties.getPrimary());
        this.secondary = ColorMap.getTheColor(shapeProperties.getSecondary());
        this.shapeProperties = shapeProperties;
        this.shadingType = shapeProperties.getShadeType();
        this.width = shapeProperties.getWidth();
        this.height = shapeProperties.getHeight();
        this.startPoint = shapeProperties.getStartPoint();
        this.endPoint = shapeProperties.getEndPoint();


        X = new int[]{shapeProperties.getStartX(), shapeProperties.getEndX(), shapeProperties.getStartX()};
        Y = new int[]{shapeProperties.getStartY(), shapeProperties.getEndY(), shapeProperties.getEndY()};

    }

    public void draw(Graphics2D graphics2D) {
        graphics2D = paintCanvasBase.getGraphics2D();

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
    public IShapeProperties getProps() {
        return shapeProperties;
    }


}
