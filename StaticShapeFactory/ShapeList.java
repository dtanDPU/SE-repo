package StaticShapeFactory;

import model.interfaces.IDraw;
import model.interfaces.IObserver;
import model.persistence.DrawShape;
import view.interfaces.ISubject;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeList implements ISubject {
    ArrayList<IDraw> shapeList ;
    List<IObserver> observersList ;
    ArrayList<IDraw> selectedList;

    public ShapeList() {
        shapeList = new ArrayList<>();
        observersList = new ArrayList<>();
        selectedList = new ArrayList<>();
    }

    @Override
    public void register(IObserver observer) {
        observersList.add(observer);
    }

    @Override
    public void notifyObserver() {
        for (IObserver newObserver : observersList) {
            newObserver.update();
        }
    }

    public void addShape(IDraw drawShape){
        shapeList.add(drawShape);
        notifyObserver();

    }
    public void removeShape(IDraw drawShape) {
        shapeList.remove(drawShape);
        notifyObserver();

    }
    public ArrayList<IDraw> getShapeList() {
        return shapeList;
    }

    public ArrayList<IDraw> getSelectedShapeList() {
        return selectedList;
    }

    public void setSelectedList(IDraw drawShape){
        selectedList.add(drawShape);
    }


}





