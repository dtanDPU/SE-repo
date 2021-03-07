package StaticShapeFactory;

import model.interfaces.IDraw;
import model.interfaces.IObserver;
import view.interfaces.ISubject;
import java.util.ArrayList;
import java.util.List;

public class ShapeList implements ISubject {
    ArrayList<IDraw> shapeListArray ;
    ArrayList<IObserver> observersList ;
    ArrayList<IDraw> selectedListArray;
    ArrayList<IDraw> copyList;
    ArrayList<IDraw> groupList;


    public ShapeList() {
        shapeListArray = new ArrayList<>();
        observersList = new ArrayList<>();
        selectedListArray = new ArrayList<>();
        copyList = new ArrayList<>();
        groupList = new ArrayList<>();
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
        shapeListArray.add(drawShape);
        notifyObserver();

    }
    public void removeShape(IDraw drawShape) {
        shapeListArray.remove(drawShape);
        notifyObserver();
    }

    public ArrayList<IDraw> getShapeList() {
        return shapeListArray;
    }

    public ArrayList<IDraw> getSelectedShapeList() {
        return selectedListArray;
    }

    public void addSelectedList(IDraw shapes){
        selectedListArray.add(shapes);
    }

    public void clearSelectedList(){
        selectedListArray.clear();
    }

    public ArrayList<IDraw> getCopy() {
        return copyList;
    }
    public void copyRemove() {
        copyList.clear();
    }

    public void getCopiedShapeList (IDraw shape) {
        copyList.add(shape);
    }

    public ArrayList<IDraw> getGroupList() {
        return groupList;
    }

    public void addGroupList(IDraw shape) {
        groupList.add(shape);
    }


}





