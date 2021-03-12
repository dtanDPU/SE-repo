package controller;

import Factory.ShapeProperties;
import model.interfaces.IDraw;
import view.interfaces.ISubject;

public class CopyCmd implements ICommand{
    ShapeProperties shapeProperties;
    ISubject selectShapeList;

    public CopyCmd(ISubject selectShapeList, ShapeProperties shapeProperties){
        this.selectShapeList = selectShapeList;
        this.shapeProperties = shapeProperties;
    }


    @Override
    public void run() {
//        selectShapeList.copyRemove();

        for(IDraw shape : selectShapeList.getSelectedShapeList()) {
            selectShapeList.getCopiedShapeList(shape);
            System.out.println("Copy: " + selectShapeList.getSelectedShapeList());
        }



    }
}
