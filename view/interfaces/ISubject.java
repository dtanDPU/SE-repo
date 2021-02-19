package view.interfaces;

import model.interfaces.IDraw;
import model.interfaces.IObserver;

public interface ISubject {

    void addShape(IDraw drawShape);
    void register(IObserver observer);
    void notifyObserver();


}
