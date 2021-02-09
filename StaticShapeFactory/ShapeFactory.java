package StaticShapeFactory;

import model.ShapeType;
import model.interfaces.IDraw;


public class ShapeFactory {

    public IDraw makeShape(ShapeProperties shapeProperties) {
        IDraw iDraw = null;

        ShapeType shapeType = shapeProperties.getShapeType();

        if(shapeType.toString().equals("RECTANGLE")) {
            iDraw = new Rectangle(shapeProperties);
        }
        else if(shapeType.toString().equals("Ellipse")) {
            iDraw = new Ellipse(shapeProperties);
        }
        else if(shapeType.toString().equals("Triangle")) {
            iDraw = new Triangle(shapeProperties);
        }
        else {
            System.out.println("Null Shape");
        }

        return iDraw;
    }
}
