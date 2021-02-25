package main;

import StaticShapeFactory.ShapeList;
import StaticShapeFactory.ShapeProperties;
import model.interfaces.IApplicationState;
import model.interfaces.IDraw;
import view.interfaces.ISubject;

public class SelectShapeCmd implements ICommand {

    public ShapeProperties shapeProps;
    public IApplicationState applicationState;
    ShapeList shapeList;
    IDraw selectShape;
    Boolean shapeSelected = false;


    public SelectShapeCmd(ShapeProperties shapeProps, IApplicationState applicationState, ISubject selectList) {

        this.shapeProps = shapeProps;
        this.applicationState = applicationState;

    }

    @Override
    public void run() {
        System.out.println("select test");



        for(IDraw shape : shapeList.getShapeList()){
            if(shape.shapeCollision(shapeProps.getNewEndPoint()) ){
                shapeSelected = true;
                selectShape = shape;
                shapeList.setSelectedList(selectShape);
                break;
            }
            else{
                shapeSelected = false;
            }
        }

    }
}

