package main;

import StaticShapeFactory.*;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IDraw;
import model.persistence.ApplicationState;

import java.awt.*;

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

        ShapeFactory shapeFactory = new ShapeFactory();
        iDrawShape = shapeFactory.makeShape(shapeProps);
        shapeList.addShape(shapeProps);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        shapeList.removeShape(shapeProps);

    }

    @Override
    public void redo() {
        shapeList.addShape(shapeProps);
    }
}
