package main;

import StaticShapeFactory.ShapeFactory;
import StaticShapeFactory.ShapeList;
import StaticShapeFactory.ShapeProperties;
import model.interfaces.IApplicationState;
import model.interfaces.IDraw;
import view.interfaces.ISubject;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
            tempS.addDX(50);
            tempS.addDY(50);
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
