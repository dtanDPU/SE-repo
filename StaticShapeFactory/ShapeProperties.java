package StaticShapeFactory;

import main.Points;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IDraw;
import view.interfaces.PaintCanvasBase;

import java.awt.*;


public class ShapeProperties implements IShapeProperties{
    private ShapeType shapeType;
    private ShapeColor primary, secondary;
    private ShapeShadingType shadeType;
    private Points startPoint, endPoint;
    private int width, height;
    PaintCanvasBase paintCanvasBase;


    public Points getStartPoint() {
        return startPoint;
    }
    public Points getEndPoint() {
        return endPoint;
    }

    public int getStartX() {

        return startPoint.getX();
    }

    public int getStartY() {
        return startPoint.getY();
    }

    public int getEndX() {
        return endPoint.getX();
    }
    public int getEndY() {
        return endPoint.getY();
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public ShapeColor getPrimary() {
        return primary;
    }
    public ShapeColor getSecondary() {
        return secondary;
    }
    public ShapeShadingType getShadeType() {
        return shadeType;
    }
    public ShapeType getShapeType() {
        return shapeType;
    }
    public PaintCanvasBase getPaintCanvasBase() {
        return paintCanvasBase;
    }
    public void setPrimary(ShapeColor primary) {
        this.primary = primary;
    }
    public void setSecondary(ShapeColor secondary) {
        this.secondary = secondary;
    }
    public void setShadeType(ShapeShadingType shadeType) {
        this.shadeType = shadeType;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }
    public void setStartPoint(Points startPoint) {
        this.startPoint = startPoint;
    }
    public void setEndPoint(Points endPoint) {
        this.endPoint = endPoint;
    }
    public void setStartX(Points x){
        this.startPoint = x;
    }
    public void setStartY(Points y){
        this.startPoint = y;
    }

    public Points getNewStartPoint() {
        int startX = Math.min(startPoint.getX(), endPoint.getX());
        int startY = Math.min(startPoint.getY(), endPoint.getY());
        return new Points(startX, startY);
    }


    public Points getNewEndPoint() {
        int endX = Math.max(startPoint.getX(), endPoint.getX());
        int endY = Math.max(startPoint.getY(), endPoint.getY());
        return new Points(endX, endY);
    }
    @Override
    public void draw(Graphics2D graphics2D){

    }



}