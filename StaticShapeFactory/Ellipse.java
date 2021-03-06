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
                graphics2D.setColor(primary);
                graphics2D.fillOval(newStart.getX(), newStart.getY(), width, height);
            }
            case "OUTLINE" -> {
                graphics2D.setColor(primary);
                graphics2D.drawOval(newStart.getX(), newStart.getY(), width, height);
            }
            case "OUTLINE_AND_FILLED_IN" -> {
                graphics2D.setColor(secondary);
                graphics2D.drawOval(newStart.getX(), newStart.getY(), width, height);
                graphics2D.setColor(primary);
                graphics2D.fillOval(newStart.getX(), newStart.getY(), width, height);
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
        newStart.setY(newStart.getY() + dy);

    }

}
