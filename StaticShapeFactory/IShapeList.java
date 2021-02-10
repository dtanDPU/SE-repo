package StaticShapeFactory;

import main.CreateShapeCmd;
import model.interfaces.IDraw;

import java.util.ArrayList;

public interface IShapeList {
    void addShape(IDraw iDraws);
    void removeShape(IDraw iDraws);
    ArrayList<IDraw> getShapeList();
}

