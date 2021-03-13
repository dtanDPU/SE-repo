package model.Factory;

import view.gui.Points;
import model.ShapeColor;
import model.ShapeShadingType;
import view.interfaces.IDraw;
import model.persistence.ColorMap;
import model.persistence.ShapeProperties;

import java.awt.*;

public class Rectangle implements IDraw{
    ShapeColor primary, secondary;
    ShapeProperties shapeProperties;
    ShapeShadingType shadingType;
    Points startPoint, endPoint, newStart,newEnd;
    int width, height;

    public Rectangle(ShapeProperties shapeProperties) {
        this.shapeProperties = shapeProperties;
        this.shadingType = shapeProperties.getShadeType();
        this.startPoint = shapeProperties.getStartPoint();
        this.endPoint = shapeProperties.getEndPoint();
        this.width = shapeProperties.getWidth();
        this.height = shapeProperties.getHeight();
        this.newStart = shapeProperties.getNewStartPoint();
        this.newEnd = shapeProperties.getNewEndPoint();
        this.primary = shapeProperties.getPrimary();
        this.secondary = shapeProperties.getSecondary();
    }
    // finally got this working by searching how the paintComponent works for all shapes
    // http://www.java2s.com/Code/JavaAPI/java.awt/BasicStrokeCAPBUTT.htm
    public void draw(Graphics2D graphics) {

        switch (shadingType.toString()) {
            case "FILLED_IN" -> {
                graphics.setColor(ColorMap.getInstance().getColor(primary));
                graphics.setStroke(new BasicStroke(5));
                graphics.fillRect(newStart.getX(), newStart.getY(), width, height);
            }
            case "OUTLINE" -> {
                graphics.setColor(ColorMap.getInstance().getColor(primary));
                graphics.setStroke(new BasicStroke(5));
                graphics.drawRect(newStart.getX(), newStart.getY(), width, height);
            }
            case "OUTLINE_AND_FILLED_IN" -> {
                graphics.setColor(ColorMap.getInstance().getColor(primary));
                graphics.setStroke(new BasicStroke(5));
                graphics.fillRect(newStart.getX(), newStart.getY(), width, height);
                graphics.setColor(ColorMap.getInstance().getColor(secondary));
                graphics.drawRect(newStart.getX(), newStart.getY(), width, height);
            }
        }
    }

    public void outline(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;

        if(shadingType.equals(ShapeShadingType.OUTLINE) || shadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)){
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                    1, new float[]{9}, 0);
            graphics2D.setStroke(stroke);
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawRect(newStart.getX()-20, newStart.getY()-20, width+40, height+40);
        }
        else {
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                    1, new float[]{9}, 0);
            graphics2D.setStroke(stroke);
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawRect(newStart.getX()-10, newStart.getY()-10, width+20, height+20);
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
        newEnd.setY(newEnd.getY() + dy);
    }



    //shape collision from link and discussion board
    // https://tutorialedge.net/gamedev/aabb-collision-detection-tutorial/#implementing-aabb-collision-detection-in-java
    @Override
    public boolean shapeCollision(Points points) {
        return (points.getX() + shapeProperties.getHeight() > newStart.getX() &&
                points.getY() + shapeProperties.getWidth() > newStart.getY() &&
                points.getX() > newStart.getX() + shapeProperties.getWidth() &&
                points.getY() > newStart.getY() + shapeProperties.getHeight());
    }

    public ShapeProperties getShapeProps() {
        return shapeProperties;
    }






}
