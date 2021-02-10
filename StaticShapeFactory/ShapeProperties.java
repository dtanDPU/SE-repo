package StaticShapeFactory;

import main.Points;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;


public class ShapeProperties implements IShapeProperties{
    private ShapeType shapeType;
    private ShapeColor primary, secondary;
    private ShapeShadingType shadeType;
    private Points startPoint, endPoint;
    private int width, height;
//    private PaintCanvasBase paintCanvasBase;

//    public ShapeProperties(ShapeType shape_Type, ShapeColor primeColor, ShapeColor secondColor,
//                           ShapeShadingType shadeType, Points startPoint, Points endPoint, IApplicationState applicationState) {
//        shapeType = shape_Type;
//        primary = primeColor;
//        secondary = secondColor;
//        this.shadeType = shadeType;
//        this.startPoint = startPoint;
//        this.endPoint = endPoint;
//        height = Math.abs(startPoint.getY()) - endPoint.getY();
//        width = Math.abs(startPoint.getX() - endPoint.getX());
//        this.applicationState = applicationState;
//
//        setPrimary(applicationState.getActivePrimaryColor());
//        setSecondary(applicationState.getActiveSecondaryColor());
//        setShadeType(applicationState.getActiveShapeShadingType());
//        setShapeType(applicationState.getActiveShapeType());
//        setWidth(width);
//        setHeight(height);
//        setStartPoint(startPoint);
//        setEndPoint(endPoint);


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
//
//    public PaintCanvasBase getPaintCanvasBase() {
//        return paintCanvasBase;
//    }


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

}