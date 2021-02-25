package StaticShapeFactory;

import main.CreateShapeCmd;
import model.interfaces.IDraw;
import model.interfaces.IObserver;

import java.awt.*;
import java.util.ArrayList;

public interface IShapeList {
    void addShape(IDraw iDraws);
    void removeShape(IDraw iDraws);
    ArrayList<IDraw> getShapeList();

    void register(IObserver observer);
    void notifyObserver();

}

