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
    int[] X = new int [3];
    int[] Y = new int [3];



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
//        Points newP = new Points(shapeProperties.getNewStartPoint().x, shapeProperties.getNewEndPoint().y);
//
//
//        X[0] = shapeProperties.getStartPoint().getX();
//        X[1] = shapeProperties.getEndPoint().getX();
//        X[2] = newP.getX();
//
//        Y[0] = shapeProperties.getStartPoint().getY();
//        Y[1] = shapeProperties.getEndPoint().getY();
//        Y[2] = newP.getY();

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

//    @Override
//    public void move(int dx, int dy) {
//        Points newStart = new Points(startPoint.getX() +dx, startPoint.getY()+dy);
//        Points newEnd = new Points(endPoint.getX()+dx, endPoint.getY()+dy);
//        startPoint = newStart;
//        endPoint = newEnd;
//
//    }

    @Override
    public void addDX(int dx) {
        X[0] = newStart.getX() + dx;
        X[1] = newEnd.getX() + dx;
        X[2] = newStart.getX() + dx;
    }

    @Override
    public void addDY(int dy) {
        Y[0] = newStart.getY() + dy;
        Y[1] = newEnd.getY() + dy;
        Y[2] = newEnd.getY() + dy;

    }

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


