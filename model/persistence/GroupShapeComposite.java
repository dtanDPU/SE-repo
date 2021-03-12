package model.persistence;

import Factory.ShapeProperties;
import main.Points;
import model.ShapeShadingType;
import model.interfaces.IDraw;
import view.interfaces.ISubject;

import java.awt.*;
import java.util.ArrayList;

public class GroupShapeComposite implements IDraw {

    ShapeProperties shapeProperties;
    Points startPoint, endPoint, newStart,newEnd;
    ShapeShadingType shadingType;
    int width, height, x, y;
    ISubject selectedShapeList;
    ArrayList<IDraw> children;


    public GroupShapeComposite(Points compositeStart, Points compositeEnd, ShapeProperties shapeProperties, ArrayList<IDraw> groupList) {
        this.shapeProperties = shapeProperties;
        this.shapeProperties.setStartPoint(compositeStart);
        this.shapeProperties.setEndPoint(compositeEnd);
        this.shadingType = this.shapeProperties.getShadeType();
        this.startPoint = compositeStart;
        this.endPoint = compositeEnd;
        this.width = shapeProperties.getNewEndPoint().getX() - shapeProperties.getNewStartPoint().getX();
        this.height = shapeProperties.getNewEndPoint().getY() - shapeProperties.getNewStartPoint().getY();
        this.x = shapeProperties.getEndPoint().getX() - shapeProperties.getStartPoint().getX();
        this.y = shapeProperties.getEndPoint().getY() - shapeProperties.getStartPoint().getY();
        this.children = new ArrayList<>();
    }
    @Override
    public void draw(Graphics2D graphics) {
        this.outline(graphics);
    }

    @Override
    public void addDX(int dx) {
        startPoint.setX(startPoint.getX() + dx);
        endPoint.setX(endPoint.getX() + dx);
    }

    @Override
    public void addDY(int dy) {
        startPoint.setY(startPoint.getY() + dy);
        endPoint.setY(endPoint.getY() + dy);
    }

    //shape collision from link and discussion board
    // https://tutorialedge.net/gamedev/aabb-collision-detection-tutorial/#implementing-aabb-collision-detection-in-java
//    public boolean shapeCollision(Points points) {
//        return (points.getX() + shapeProperties.getNewEndPoint().getX() - shapeProperties.getNewStartPoint().getX() > newStart.getX() &&
//                points.getY() + shapeProperties.getNewEndPoint().getY() - shapeProperties.getNewStartPoint().getY() > newStart.getY() &&
//                points.getX() > newStart.getX() + shapeProperties.getNewEndPoint().getX() - shapeProperties.getNewStartPoint().getX() &&
//                points.getY() > newStart.getY() + shapeProperties.getNewEndPoint().getY() - shapeProperties.getNewStartPoint().getY());
//    }

    public boolean shapeCollision(Points points) {
        return (points.getX() + shapeProperties.getWidth() > newStart.getX() &&
                points.getY() + shapeProperties.getHeight() > newStart.getY() &&
                points.getX() > newStart.getX() + shapeProperties.getWidth() &&
                points.getY() > newStart.getY() + shapeProperties.getHeight());
    }

    @Override
    public ShapeProperties getShapeProps() {
        return shapeProperties;
    }

    @Override
    public void outline(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                1, new float[]{9}, 0);
        graphics2D.setStroke(stroke);
        graphics2D.setColor(Color.RED);
        graphics2D.drawRect(startPoint.getX()-20, startPoint.getY()-20, width+40, height+40);

    }


}
