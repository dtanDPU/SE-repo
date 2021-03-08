package main;

import StaticShapeFactory.ShapeProperties;
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

        // iterate over selected shape list if it contains the shape then remove it from the list
        for(IDraw shape : selectedShapeList.getSelectedShapeList()){
            if(selectedShapeList.getGroupList().contains(shape))
                selectedShapeList.removeGroupedShapes(shape);
        }
        System.out.println("ungrouped shapes: " + selectedShapeList.getGroupListSize());

    }
}
