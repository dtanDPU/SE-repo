package StaticShapeFactory;

import main.CreateShapeCmd;
import main.Points;
import model.ShapeShadingType;
import model.interfaces.IDraw;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class Rectangle implements IDraw {
    Color primary, secondary;
    IShapeProperties shapeProperties;
    ShapeShadingType shadingType;
    Points startPoint, endPoint;
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
    }

    public void draw(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics;

        switch (shadingType.toString()) {
            case "FILLED_IN" -> {
                graphics2D.setColor(primary);
                graphics2D.fillRect(startPoint.getX(), startPoint.getY(), width, height);
            }
            case "OUTLINE" -> {
                graphics2D.setColor(primary);
                graphics2D.drawRect(startPoint.getX(), startPoint.getY(), width, height);
            }
            case "OUTLINE_AND_FILLED_IN" -> {
                graphics2D.setColor(primary);
                graphics2D.fillRect(startPoint.getX(), startPoint.getY(), width, height);
                graphics2D.setColor(secondary);
                graphics2D.drawRect(startPoint.getX(), startPoint.getY(), width, height);
            }
        }
    }
}
