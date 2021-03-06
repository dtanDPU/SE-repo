package main;

import StaticShapeFactory.ShapeProperties;
import view.interfaces.ISubject;

public class PasteCmd implements ICommand, IUndoable{
    ISubject selectShapeList;
    ShapeProperties shapeProperties;

    public PasteCmd(ISubject selectShapeList, ShapeProperties shapeProperties) {
        this.selectShapeList = selectShapeList;
        this.shapeProperties = shapeProperties;

    }

    @Override
    public void run() {

    }


    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
