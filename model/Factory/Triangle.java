package model.Factory;

import view.gui.Points;
import model.ShapeColor;
import model.ShapeShadingType;
import view.interfaces.IDraw;
import model.persistence.ColorMap;
import model.persistence.ShapeProperties;

import java.awt.*;

public class Triangle implements IDraw {

    ShapeColor primary, secondary;
    ShapeProperties shapeProperties;
    ShapeShadingType shadingType;
    int width, height;
    Points startPoint, endPoint, newStart, newEnd  ;
    int[] X ;
    int[] Y ;


    public Triangle(ShapeProperties shapeProperties) {

        this.shapeProperties = shapeProperties;
        this.shadingType = shapeProperties.getShadeType();
        this.width = shapeProperties.getWidth();
        this.height = shapeProperties.getHeight();
        this.startPoint = shapeProperties.getStartPoint();
        this.endPoint = shapeProperties.getEndPoint();
        this.newEnd = shapeProperties.getNewEndPoint();
        this.newStart = shapeProperties.getNewStartPoint();
        this.primary = shapeProperties.getPrimary();
        this.secondary = shapeProperties.getSecondary();

    }

    public void draw(Graphics2D graphics) {

        X = new int[]{startPoint.getX(), endPoint.getX(), startPoint.getX()};
        Y = new int[]{startPoint.getY(), endPoint.getY(), endPoint.getY()};

        switch (shadingType.toString()) {
            case "FILLED_IN" -> {
                graphics.setColor(ColorMap.getInstance().getColor(primary));
                graphics.fillPolygon(X,Y, 3);
            }
            case "OUTLINE" -> {
                graphics.setColor(ColorMap.getInstance().getColor(primary));
                graphics.drawPolygon(X,Y,3);
            }
            case "OUTLINE_AND_FILLED_IN" -> {
                graphics.setColor(ColorMap.getInstance().getColor(secondary));
                graphics.drawPolygon(X,Y,3);
                graphics.setColor(ColorMap.getInstance().getColor(primary));
                graphics.fillPolygon(X,Y,3);
            }
        }
    }

    // had to do this differently from rectangle/ellipse need to use
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


    //shape collision from link and discussion board
    // https://tutorialedge.net/gamedev/aabb-collision-detection-tutorial/#implementing-aabb-collision-detection-in-java

    @Override
    public boolean shapeCollision(Points points) {
        return (points.getX() + shapeProperties.getWidth() > newStart.getX() &&
                points.getY() + shapeProperties.getHeight() > newStart.getY() &&
                points.getX() > newStart.getX() + shapeProperties.getWidth() &&
                points.getY() > newStart.getY() + shapeProperties.getHeight());
    }


    public ShapeProperties getShapeProps() {
        return shapeProperties;
    }

    @Override
    public void outline(Graphics graphics) {

        X = new int[]{startPoint.getX() - 5, endPoint.getX() + 20, startPoint.getX() - 9};
        Y = new int[]{startPoint.getY() - 9, endPoint.getY() + 5, endPoint.getY() + 9};

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


