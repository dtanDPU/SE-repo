package StaticShapeFactory;

import main.Points;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IDraw;
import view.interfaces.PaintCanvasBase;

public class ShapeFactory {


//    public static IDraw drawRectangle(PaintCanvasBase paintCanvasBase, IShapeProperties shapeProperties){
//        return new Rectangle(paintCanvasBase, shapeProperties);
//
//    }
//
//    public static IDraw drawEllipse(PaintCanvasBase paintCanvasBase, IShapeProperties shapeProperties) {
//        return new Ellipse(paintCanvasBase, shapeProperties);
//    }

//    public IDraw drawTriangle(Points startPoint, Points endPoint, ShapeProperties shapeProperties) {
//        return new Triangle(shapeProperties);
//    }

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
