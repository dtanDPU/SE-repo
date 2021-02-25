package main;

import StaticShapeFactory.ShapeList;
import StaticShapeFactory.ShapeProperties;
import model.interfaces.IApplicationState;
import model.interfaces.IDraw;

public class MoveShapeCmd implements ICommand{

    public ShapeProperties shapeProps;
    public IApplicationState applicationState;
    ShapeList shapeList;
    IDraw iDrawShape;

    public MoveShapeCmd(ShapeProperties shapeProps, IApplicationState applicationState, ShapeList shapeList) {

        this.shapeProps = shapeProps;
        this.applicationState = applicationState;
        this.shapeList = shapeList;

    }

    @Override
    public void run() {
        System.out.println("move test");
    }
}
