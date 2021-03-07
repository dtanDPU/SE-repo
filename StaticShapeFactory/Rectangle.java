package StaticShapeFactory;

import main.Points;
import model.ShapeShadingType;
import model.interfaces.IDraw;
import model.persistence.ApplicationState;

import java.awt.*;

public class Rectangle implements IDraw{
    Color primary, secondary;
    ShapeProperties shapeProperties;
    ShapeShadingType shadingType;
    Points startPoint, endPoint, newStart,newEnd;
    int width, height;


    private static final ColorMap colorMap = new ColorMap();

    public Rectangle(ShapeProperties shapeProperties) {
        this.shapeProperties = shapeProperties;
        this.primary = colorMap.getTheColor(shapeProperties.getPrimary());
        this.secondary = colorMap.getTheColor(shapeProperties.getSecondary());
        this.shadingType = shapeProperties.getShadeType();
        this.startPoint = shapeProperties.getStartPoint();
        this.endPoint = shapeProperties.getEndPoint();
        this.width = shapeProperties.getWidth();
        this.height = shapeProperties.getHeight();
        this.newStart = shapeProperties.getNewStartPoint();
        this.newEnd = shapeProperties.getNewEndPoint();

    }


    // finally got this working by searching how the paintComponent works for all shapes
    // http://www.java2s.com/Code/JavaAPI/java.awt/BasicStrokeCAPBUTT.htm
    public void draw(Graphics2D graphics) {

//        Graphics2D graphics2D = (Graphics2D) graphics;

//        if(shadingType.equals(ShapeShadingType.FILLED_IN)) {
//            graphics.setColor(primary);
//            graphics.setStroke(new BasicStroke(5));
//            graphics.fillRect(newStart.getX(), newStart.getY(), width, height);
//        }
//        else if (shadingType.equals(ShapeShadingType.OUTLINE)) {
//            graphics.setColor(primary);
//            graphics.setStroke(new BasicStroke(5));
//            graphics.drawRect(newStart.getX(), newStart.getY(), width, height);
//        }
//        else if (shadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)){
//            graphics.setColor(primary);
//            graphics.setStroke(new BasicStroke(5));
//            graphics.fillRect(newStart.getX(), newStart.getY(), width, height);
//            graphics.setColor(secondary);
//            graphics.drawRect(newStart.getX(), newStart.getY(), width, height);
//        }
//        if (shapeProperties.ifSelected()) {
//            graphics.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
//                    1, new float[]{9}, 0));
//            graphics.setColor(Color.BLACK);
//            graphics.drawRect(newStart.getX()-5, newStart.getY()-5, width+10,height+10 );
//        }

        switch (shadingType.toString()) {
            case "FILLED_IN" -> {
                graphics.setColor(primary);
                graphics.setStroke(new BasicStroke(5));
                graphics.fillRect(newStart.getX(), newStart.getY(), width, height);
            }
            case "OUTLINE" -> {
                graphics.setColor(primary);
                graphics.setStroke(new BasicStroke(5));
                graphics.drawRect(newStart.getX(), newStart.getY(), width, height);
            }
            case "OUTLINE_AND_FILLED_IN" -> {
                graphics.setColor(primary);
                graphics.setStroke(new BasicStroke(5));
                graphics.fillRect(newStart.getX(), newStart.getY(), width, height);
                graphics.setColor(secondary);
                graphics.drawRect(newStart.getX(), newStart.getY(), width, height);
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
        newEnd.setY(newEnd.getY() + dy);

    }


    public boolean shapeCollision(Points points) {
        return (points.getX() + shapeProperties.getNewEndPoint().getX() - shapeProperties.getNewStartPoint().getX() > newStart.getX() &&
                points.getY() + shapeProperties.getNewEndPoint().getY() - shapeProperties.getNewStartPoint().getY() > newStart.getY() &&
                points.getX() > newStart.getX() + shapeProperties.getNewEndPoint().getX() - shapeProperties.getNewStartPoint().getX() &&
                points.getY() > newStart.getY() + shapeProperties.getNewEndPoint().getY() - shapeProperties.getNewStartPoint().getY());
    }

    public ShapeProperties getShapeProps() {
        return shapeProperties;
    }






}
