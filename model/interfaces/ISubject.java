package model.interfaces;

import view.interfaces.IDraw;

import java.util.ArrayList;

public interface ISubject {

    void addShape(IDraw drawShape);
    void register(IObserver observer);
    void notifyObserver();
    ArrayList<IDraw> getSelectedShapeList();
    ArrayList<IDraw> getShapeList();
    void addSelectedList(IDraw drawShape);
    void clearSelectedList();
    void removeShape(IDraw drawShape);
    ArrayList<IDraw> getCopy();
    void getCopiedShapeList (IDraw shape);
    ArrayList<IDraw> getGroupList();
    void addGroupList(IDraw shape);
    int getGroupListSize();



}
