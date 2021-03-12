package controller;

import Factory.ShapeProperties;
import model.interfaces.IDraw;
import view.interfaces.ISubject;

public class UngroupCmd implements ICommand{
    ShapeProperties shapeProperties;
    ISubject selectedShapeList;


    public UngroupCmd(ISubject selectedShapeList, ShapeProperties shapeProperties) {
        this.selectedShapeList = selectedShapeList;
        this.shapeProperties = shapeProperties;
    }

    @Override
    public void run() {

        selectedShapeList.removeShape(selectedShapeList.getShapeList().get(selectedShapeList.getSelectedShapeList().size()-1));
        selectedShapeList.notifyObserver();

        // iterate over selected shape list if it contains the shape then remove it from the list
//        for(IDraw shape : selectedShapeList.getSelectedShapeList()){
//            if(selectedShapeList.getSelectedShapeList().contains(shape))
//                selectedShapeList.removeGroupedShapes(shape);
//        }
//        selectedShapeList.notifyObserver();

//        System.out.println("ungrouped shapes: " + selectedShapeList.getGroupListSize());

    }
}
