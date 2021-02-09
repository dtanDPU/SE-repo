package StaticShapeFactory;

import model.interfaces.IDraw;
import java.util.ArrayList;

public class ShapeList implements IShapeList{
    ArrayList<IDraw> shapeList;


    public ShapeList() {
        shapeList = new ArrayList<>();
    }


    @Override
    public void addShape(IDraw iDraws){
        shapeList.add(iDraws);


    }
    @Override
    public void removeShape(IDraw iDraws) {
        shapeList.remove(iDraws);

    }
//    @Override
//    public ArrayList<CreateShapeCmd> getShapeList() {
//        return shapeList;
//    }


}





