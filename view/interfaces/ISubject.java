package view.interfaces;

import model.interfaces.IDraw;
import model.interfaces.IObserver;

import java.util.ArrayList;

public interface ISubject {

    void addShape(IDraw drawShape);
    void register(IObserver observer);
    void notifyObserver();
    ArrayList<IDraw> getSelectedShapeList();
    ArrayList<IDraw> getShapeList();
    void setSelectedList(IDraw drawShape);


}
