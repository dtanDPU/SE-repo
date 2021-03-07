package main;

import StaticShapeFactory.*;

import model.interfaces.IApplicationState;
import model.interfaces.IDraw;


public class CreateShapeCmd implements ICommand, IUndoable{
    public ShapeProperties shapeProps;
    ShapeList shapeList;
    IDraw shape;
    ShapeFactory shapeFactory;


    public CreateShapeCmd(ShapeProperties shapeProps, ShapeList shapeList) {
        this.shapeProps = shapeProps;
        this.shapeList = shapeList;
        this.shapeFactory = new ShapeFactory();
//        this.applicationState = applicationState;

    }

    @Override
    public void run() {
//        ShapeFactory shapeFactory = new ShapeFactory();
//        shapeProps = applicationState.getShapeProps();
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
