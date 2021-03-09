package StaticShapeFactory;

import main.CreateShapeCmd;
import main.Points;
import model.ShapeShadingType;
import model.interfaces.IDraw;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class Triangle implements IDraw {

    Color primary, secondary;
    ShapeProperties shapeProperties;
    ShapeShadingType shadingType;
    int width, height;
    Points startPoint, endPoint, newStart, newEnd  ;
    private static ColorMap colorMap = new ColorMap();
    int[] X ;
    int[] Y ;


    public Triangle(ShapeProperties shapeProperties) {
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

    public void draw(Graphics2D graphics) {


        X = new int[]{startPoint.getX(), endPoint.getX(), startPoint.getX()};
        Y = new int[]{startPoint.getY(), endPoint.getY(), endPoint.getY()};

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
                graphics.setColor(secondary);
                graphics.drawPolygon(X,Y,3);
                graphics.setColor(primary);
                graphics.fillPolygon(X,Y,3);
            }
        }
    }
    @Override
    public void addDX(int dx) {
        X = new int[]{startPoint.getX() + dx, endPoint.getX() + dx, startPoint.getX() + dx};
        startPoint.setX(startPoint.getX() + dx);
        endPoint.setX(endPoint.getX() + dx);
    }

    @Override
    public void addDY(int dy) {
        Y = new int[]{startPoint.getY() + dy, endPoint.getY() +dy , endPoint.getY() +dy};
        startPoint.setY(startPoint.getY() + dy);
        endPoint.setY(endPoint.getY() + dy);
    }

//    @Override
//    public void addDX(int dx) {
//        X[0] = newStart.getX() + dx;
//        X[1] = newEnd.getX() + dx;
//        X[2] = newStart.getX() + dx;
//    }
//
//    @Override
//    public void addDY(int dy) {
//        Y[0] = newStart.getY() + dy;
//        Y[1] = newEnd.getY() + dy;
//        Y[2] = newEnd.getY() + dy;
//    }

    //shape collision from link and discussion board
    // https://tutorialedge.net/gamedev/aabb-collision-detection-tutorial/#implementing-aabb-collision-detection-in-java
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

    @Override
    public void outline(Graphics graphics) {

        X = new int[]{startPoint.getX(), endPoint.getX(), startPoint.getX()};
        Y = new int[]{startPoint.getY(), endPoint.getY(), endPoint.getY()};

        Graphics2D graphics2D = (Graphics2D) graphics;

        if(shadingType.equals(ShapeShadingType.OUTLINE) || shadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)){
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                    1, new float[]{9}, 0);
            graphics2D.setStroke(stroke);
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawPolygon(X,Y,3);
        }
        else {
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                    1, new float[]{9}, 0);
            graphics2D.setStroke(stroke);
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawPolygon(X,Y,3);
        }
    }
    }


