package controller;

import Factory.ShapeList;
import Factory.ShapeProperties;
import model.interfaces.IDraw;
import view.interfaces.ISubject;

public class PasteCmd implements ICommand, IUndoable{
    ISubject copiedList;
    ShapeProperties shapeProperties;
    IDraw tempS;
    ShapeList shapeList;


    public PasteCmd(ISubject copiedList, ShapeProperties shapeProperties) {
        this.copiedList = copiedList;
        this.shapeProperties = shapeProperties;

    }

    @Override
    public void run() {
        // video notes: iterate over each copied shape and use create shape cmd
        // only pastes one time though

        for(IDraw copyShape : copiedList.getCopy()) {
            tempS = copyShape;
            tempS.addDX(30);
            tempS.addDY(30);

            CreateShapeCmd shape = new CreateShapeCmd(shapeProperties, shapeList);

            copiedList.addShape(shape.shapeFactory.makeShape(tempS.getShapeProps()));

            System.out.println("Paste test: " + copiedList.getSelectedShapeList());
        }

        CommandHistory.add(this);



    }


    @Override
    public void undo() {
        copiedList.removeShape(tempS);

    }

    @Override
    public void redo() {
        copiedList.addShape(tempS);

    }
}
