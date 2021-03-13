package controller;

import model.Factory.*;

import view.interfaces.IDraw;
import model.persistence.ShapeList;
import model.persistence.ShapeProperties;


public class CreateShapeCmd implements ICommand, IUndoable {
    public ShapeProperties shapeProps;
    ShapeList shapeList;
    IDraw shape;
    ShapeFactory shapeFactory;


    public CreateShapeCmd(ShapeProperties shapeProps, ShapeList shapeList) {
        this.shapeProps = shapeProps;
        this.shapeList = shapeList;
        this.shapeFactory = new ShapeFactory();

    }

    @Override
    public void run() {
        shape = shapeFactory.makeShape(shapeProps);
        shapeList.addShape(shape);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        shapeList.removeShape(shape);

    }

    @Override
    public void redo() {
        shapeList.addShape(shape);
    }
}
