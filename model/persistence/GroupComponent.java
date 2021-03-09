package model.persistence;

import model.ShapeType;

public class GroupComponent implements IGroupComponent {

    @Override
    public ShapeType getShapeType() {
        return ShapeType.RECTANGLE;
    }
}
