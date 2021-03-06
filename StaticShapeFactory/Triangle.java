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
    int[] X = new int [3];
    int[] Y = new int [3];


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

        X = new int[]{startPoint.getX(), endPoint.getX(), startPoint.getX()};
        Y = new int[]{startPoint.getY(), endPoint.getY(), endPoint.getY()};

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
                graphics2D.setColor(secondary);
                graphics2D.drawPolygon(X,Y,3);
                graphics2D.setColor(primary);
                graphics2D.fillPolygon(X,Y,3);
            }
        }
    }

    @Override
    public void addDX(int dx) {
        this.X[0] = startPoint.getX() + dx;
        this.X[1] = endPoint.getX() + dx;
        this.X[2] = newStart.getX() + dx;


    }

    @Override
    public void addDY(int dy) {
        this.Y[0] = startPoint.getY() + dy;
        this.Y[1] = endPoint.getY() + dy;
        this.Y[2] = endPoint.getY() + dy;

    }



}
