package model.Factory;

import model.ShapeType;
import view.interfaces.IDraw;
import model.persistence.ShapeProperties;

public class ShapeFactory {


    public IDraw makeShape(ShapeProperties shapeProperties) {


        ShapeType shapeType = shapeProperties.getShapeType();
        IDraw iDraw;

        switch (shapeType.toString()) {
            case "RECTANGLE" -> {
                iDraw = new Rectangle(shapeProperties);
            }
            case "ELLIPSE" -> {
                iDraw = new Ellipse(shapeProperties);
            }
            case "TRIANGLE" -> {
                iDraw = new Triangle(shapeProperties);
            }
            default -> {
                iDraw = new NullObject();
            }

        }

        return iDraw;
    }
}
