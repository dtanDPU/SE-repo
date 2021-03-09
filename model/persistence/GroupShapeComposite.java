package model.persistence;

import model.ShapeType;

public class GroupShapeComposite implements IGroupComponent{


    @Override
    public ShapeType getShapeType() {
        return ShapeType.RECTANGLE;
    }
}
