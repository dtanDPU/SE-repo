package controller;

import model.persistence.ShapeProperties;
import view.interfaces.IDraw;
import model.interfaces.ISubject;

import java.util.ArrayList;

public class UngroupCmd implements ICommand, IUndoable {
    ShapeProperties shapeProperties;
    ISubject selectedShapeList;
    ArrayList<IDraw> tempList = new ArrayList<>();


    public UngroupCmd(ISubject selectedShapeList, ShapeProperties shapeProperties) {
        this.selectedShapeList = selectedShapeList;
        this.shapeProperties = shapeProperties;
    }

    @Override
    public void run() {

        selectedShapeList.removeShape(selectedShapeList.getSelectedShapeList().get(selectedShapeList.getSelectedShapeList().size()-1));
        selectedShapeList.notifyObserver();

            System.out.println("ungrouped shapes: " + selectedShapeList.getGroupListSize());

        }


    @Override
    public void undo() {
        tempList.add(selectedShapeList.getSelectedShapeList().get(selectedShapeList.getSelectedShapeList().size()-1));
        selectedShapeList.removeShape(selectedShapeList.getSelectedShapeList().get(selectedShapeList.getSelectedShapeList().size()-1));
        selectedShapeList.notifyObserver();
//        selectedShapeList.addShape(tempList.get(0));
//        selectedShapeList.notifyObserver();
//        tempList.remove(selectedShapeList.getSelectedShapeList().get(selectedShapeList.getSelectedShapeList().size() - 1));
        System.out.println(" undo test");

    }



    @Override
    public void redo() {
        for(IDraw shape : tempList) {
            selectedShapeList.addShape(shape);
            selectedShapeList.notifyObserver();
        }

//        tempList.add(selectedShapeList.getSelectedShapeList().get(selectedShapeList.getSelectedShapeList().size()-1));
//        selectedShapeList.removeShape(selectedShapeList.getSelectedShapeList().get(selectedShapeList.getSelectedShapeList().size()-1));
//        selectedShapeList.notifyObserver();
        System.out.println("redo test");

    }
}
