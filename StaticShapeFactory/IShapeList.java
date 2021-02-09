package StaticShapeFactory;

import main.CreateShapeCmd;

import java.util.ArrayList;

public interface IShapeList {
    void addShape(IShapeProperties shape);
    void removeShape(IShapeProperties shape);
//    ArrayList<CreateShapeCmd> getShapeList();
}

