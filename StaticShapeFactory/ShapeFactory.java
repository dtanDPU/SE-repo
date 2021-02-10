package StaticShapeFactory;

import model.ShapeType;
import model.interfaces.IDraw;


public class ShapeFactory {

    public IDraw makeShape(ShapeProperties shapeProperties) {
        IDraw iDraw = null;

        ShapeType shapeType = shapeProperties.getShapeType();

        switch (shapeType.toString()) {
            case "RECTANGLE" -> {
                iDraw = new Rectangle(shapeProperties);
                System.out.println("reaches rect");
            }
            case "ELLIPSE" -> {
                iDraw = new Ellipse(shapeProperties);
                System.out.println("reaches ellipse");
            }
            case "TRIANGLE" -> {
                iDraw = new Triangle(shapeProperties);
                System.out.println("reaches triangle");
            }
            default -> System.out.println("Null Shape");
        }

        return iDraw;
    }
}
