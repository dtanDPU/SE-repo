package model.interfaces;

import StaticShapeFactory.ShapeProperties;
import main.Points;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.MouseMode;

public interface IApplicationState {
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShadingType getActiveShapeShadingType();
    
    ShapeProperties getShapeProps();

//    Points getNewEndPoint();
//
//    Points getNewStartPoint();

    MouseMode getActiveMouseMode();

//    Points getStartPoint();
//    Points getEndPoint();
}
