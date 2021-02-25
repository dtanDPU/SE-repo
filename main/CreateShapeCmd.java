package main;

import StaticShapeFactory.*;

import model.interfaces.IApplicationState;
import model.interfaces.IDraw;


public class CreateShapeCmd implements ICommand, IUndoable{
    public ShapeProperties shapeProps;
    public IApplicationState applicationState;
    ShapeList shapeList;
    IDraw iDrawShape;


    public CreateShapeCmd(ShapeProperties shapeProps, IApplicationState applicationState, ShapeList shapeList) {
        this.shapeProps = shapeProps;
        this.applicationState = applicationState;
        this.shapeList = shapeList;

    }

    @Override
    public void run() {
        System.out.println("creating");
        ShapeFactory shapeFactory = new ShapeFactory();
        iDrawShape = shapeFactory.makeShape(shapeProps);
        shapeList.addShape(iDrawShape);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        shapeList.removeShape(iDrawShape);

    }

    @Override
    public void redo() {
        shapeList.addShape(iDrawShape);
    }
}
