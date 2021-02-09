package StaticShapeFactory;

import main.CreateShapeCmd;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;


public class ShapeList implements IShapeList{
    ArrayList<IShapeProperties> shapeList;



    public ShapeList() {
        shapeList = new ArrayList<>();
    }


    @Override
    public void addShape(IShapeProperties shape){
        shapeList.add(shape);


    }
    @Override
    public void removeShape(IShapeProperties shape) {
        shapeList.remove(shape);

    }
//    @Override
//    public ArrayList<CreateShapeCmd> getShapeList() {
//        return shapeList;
//    }


}





