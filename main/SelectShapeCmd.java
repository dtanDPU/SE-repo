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
    ISubject selectedShapeList;
    IDraw selectedShape;
    Boolean ifShapeSelected = false;
    Points newStart;



    public SelectShapeCmd(ShapeProperties shapeProps, IApplicationState applicationState, ISubject selectList) {

        this.shapeProps = shapeProps;
        this.applicationState = applicationState;
        this.selectedShapeList = selectList;
        this.newStart = shapeProps.getNewStartPoint();
//        this.start = start;
//        this.end = end;


    }

    @Override
    public void run() {
        selectedShapeList.clearSelectedList();

        for(IDraw shapes : selectedShapeList.getShapeList()) {
            System.out.println("select test");

            if(shapeCollision((shapeProps.getNewEndPoint()))) {
                ifShapeSelected = true;
                selectedShape = shapes;
                selectedShapeList.addSelectedList(selectedShape);

                System.out.println("Selected shape test: " + selectedShapeList.getSelectedShapeList());
            }
            else {
                ifShapeSelected = false;
            }
        }
//        if(!ifShapeSelected) {
//            selectedShapeList.clearSelectedList();
//        }

    }

    //shape collision from link and discussion board
    // https://tutorialedge.net/gamedev/aabb-collision-detection-tutorial/#implementing-aabb-collision-detection-in-java
    public boolean shapeCollision(Points points) {
        return (points.getX() + shapeProps.getWidth() > newStart.getX() &&
                points.getY() + shapeProps.getHeight() > newStart.getY() &&
                points.getX() > newStart.getX() + shapeProps.getWidth() &&
                points.getY() > newStart.getY() + shapeProps.getHeight());
    }
}

