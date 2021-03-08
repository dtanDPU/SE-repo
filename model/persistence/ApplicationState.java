package model.persistence;

import StaticShapeFactory.ShapeList;
import StaticShapeFactory.ShapeProperties;
import main.Points;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.MouseMode;
import model.dialogs.DialogProvider;
import model.interfaces.IApplicationState;
import model.interfaces.IDialogProvider;
import view.interfaces.IUiModule;
import view.interfaces.PaintCanvasBase;

public class ApplicationState implements IApplicationState {
    private final IUiModule uiModule;
    private final IDialogProvider dialogProvider;

    private ShapeType activeShapeType;
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private MouseMode activeMouseMode;
    int height, width;
    Points startPoint, endPoint, newStartPoint, newEndPoint;

    public ApplicationState(IUiModule uiModule) {
        this.uiModule = uiModule;
        this.dialogProvider = new DialogProvider(this);
        setDefaults();
    }

    @Override
    public void setActiveShape() {
        activeShapeType = uiModule.getDialogResponse(dialogProvider.getChooseShapeDialog());
    }

    @Override
    public void setActivePrimaryColor() {
        activePrimaryColor = uiModule.getDialogResponse(dialogProvider.getChoosePrimaryColorDialog());
    }

    @Override
    public void setActiveSecondaryColor() {
        activeSecondaryColor = uiModule.getDialogResponse(dialogProvider.getChooseSecondaryColorDialog());
    }

    @Override
    public void setActiveShadingType() {
        activeShapeShadingType = uiModule.getDialogResponse(dialogProvider.getChooseShadingTypeDialog());
    }

    @Override
    public void setActiveStartAndEndPointMode() {
        activeMouseMode = uiModule.getDialogResponse(dialogProvider.getChooseStartAndEndPointModeDialog());

    }

    @Override
    public ShapeType getActiveShapeType() {
        return activeShapeType;
    }

    @Override
    public ShapeColor getActivePrimaryColor() {
        return activePrimaryColor;
    }

    @Override
    public ShapeColor getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    @Override
    public ShapeShadingType getActiveShapeShadingType() {
        return activeShapeShadingType;
    }


    @Override
    public MouseMode getActiveMouseMode() {
        return activeMouseMode;
    }


    private void setDefaults() {
        activeShapeType = ShapeType.RECTANGLE;
        activePrimaryColor = ShapeColor.BLUE;
        activeSecondaryColor = ShapeColor.GREEN;
        activeShapeShadingType = ShapeShadingType.FILLED_IN;
        activeMouseMode = MouseMode.DRAW;
    }

//    public Points getNewStartPoint() {
//        int startX = Math.min(startPoint.getX(), endPoint.getX());
//        int startY = Math.min(startPoint.getY(), endPoint.getY());
//        newStartPoint = new Points(startX, startY);
//        return newStartPoint;
//    }
//    public Points getNewEndPoint() {
//        int endX = Math.max(startPoint.getX(), endPoint.getX());
//        int endY = Math.max(startPoint.getY(), endPoint.getY());
//        newEndPoint = new Points(endX, endY);
//        return newEndPoint;
//    }
    public Points getStartPoint() {
        return startPoint;
    }

    public Points getEndPoint() {
        return endPoint;
    }

//    public void setNewStartPoint(Points newStartPoint){
//        this.newStartPoint = newStartPoint;
//    }
//    public void setNewEndPoint(Points newEndPoint){
//        this.newEndPoint = newEndPoint;
//    }

    public ShapeProperties getShapeProps() {
        ShapeProperties shapeProperties = new ShapeProperties();
        shapeProperties.setPrimary(activePrimaryColor);
        shapeProperties.setShapeType(activeShapeType);
        shapeProperties.setSecondary(activeSecondaryColor);
        shapeProperties.setShadeType(activeShapeShadingType);
        shapeProperties.setHeight(height);
        shapeProperties.setWidth(width);
//        shapeProperties.setStartPoint(startPoint);
//        shapeProperties.setEndPoint(endPoint);
//        shapeProperties.setNewEndPoint();
//        shapeProperties.setNewStartPoint();
        return shapeProperties;
    }

//    @Override
//    public Points getNewEndPoint() {
//        return null;
//    }
//
//    @Override
//    public Points getNewStartPoint() {
//        return null;
//    }


}
