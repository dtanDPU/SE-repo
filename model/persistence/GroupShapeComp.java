//package model.persistence;
//
//import StaticShapeFactory.ShapeProperties;
//import main.Points;
//import model.interfaces.IDraw;
//
//import java.awt.*;
//import java.util.ArrayList;
//
//public class GroupShapeComp implements IDraw {
//    ArrayList<IDraw> children;
//    int dx, dy;
//
//    public GroupShapeComp () {
//        children = new ArrayList<>();
//    }
//
//    public ArrayList<IDraw> getChildren() {
//        return children;
//    }
//
//    public void addChildren(IDraw shape) {
//        children.add(shape);
//    }
//
//    public IDraw removeChildren(int n) {
//        IDraw s;
//        s = children.remove(n);
//        return s;
//    }
//
//    public void moveChildren(int dx, int dy) {
//        this.dx = dx;
//        this.dy = dy;
//        for(IDraw c : children) {
//            c.getShapeProps().setStartPoint(c.getShapeProps().getStartPoint().getX(), c.getShapeProps().getStartPoint().getY()+dy);
//        }
//    }
//
//
//
//
//    @Override
//    public void draw(Graphics2D graphics) {
//
//    }
//
//    @Override
//    public void addDX(int dx) {
//
//    }
//
//    @Override
//    public void addDY(int dy) {
//
//    }
//
//    @Override
//    public boolean shapeCollision(Points points) {
//        return false;
//    }
//
//    @Override
//    public ShapeProperties getShapeProps() {
//        return null;
//    }
//
//    @Override
//    public void outline(Graphics graphics) {
//
//    }
//}
//
//
