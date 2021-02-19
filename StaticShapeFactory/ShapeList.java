package StaticShapeFactory;

import model.interfaces.IDraw;
import model.interfaces.IObserver;
import model.persistence.DrawShape;
import view.interfaces.ISubject;
import view.interfaces.PaintCanvasBase;
import java.util.ArrayList;
import java.util.List;

public class ShapeList implements ISubject {
    ArrayList<IDraw> shapeList ;
    List<IObserver> observers ;

    public ShapeList() {
        shapeList = new ArrayList<>();
        observers = new ArrayList<>();
    }

    @Override
    public void register(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        for (IObserver newObserver : observers) {
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


}





