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
    Points newStart;
    int width, height;



    public SelectShapeCmd(ShapeProperties shapeProps, IApplicationState applicationState, ISubject selectList) {

        this.shapeProps = shapeProps;
        this.applicationState = applicationState;
        this.selectedShapeList = selectList;
        this.newStart = shapeProps.getNewStartPoint();
        this.width = shapeProps.getNewEndPoint().getX() - shapeProps.getNewStartPoint().getX();
        this.height = shapeProps.getNewEndPoint().getY() - shapeProps.getNewStartPoint().getY();


    }


    @Override
    public void run() {
        for(IDraw shapes : selectedShapeList.getShapeList()) {
            System.out.println("select test");

            if(shapes.shapeCollision((shapeProps.getEndPoint()))) {
                shapeProps.selected();
                selectedShape = shapes;

                selectedShapeList.addSelectedList(selectedShape);


                System.out.println("Selected shape test: " + selectedShapeList.getSelectedShapeList());
            }
            else {
                shapeProps.notSelected();
                selectedShapeList.clearSelectedList();
            }
        }
    }

    //shape collision from link and discussion board
    // https://tutorialedge.net/gamedev/aabb-collision-detection-tutorial/#implementing-aabb-collision-detection-in-java
//    public boolean shapeCollision(Points points) {
//        return (points.getX() + shapeProps.getWidth() > newStart.getX() &&
//                points.getY() + shapeProps.getHeight() > newStart.getY() &&
//                points.getX() > newStart.getX() + shapeProps.getWidth() &&
//                points.getY() > newStart.getY() + shapeProps.getHeight());
//    }

//    public boolean shapeCollision(Points points) {
//        return (points.getX() + shapeProps.getNewEndPoint().getX() - shapeProps.getNewStartPoint().getX() > newStart.getX() &&
//                points.getY() + shapeProps.getNewEndPoint().getY() - shapeProps.getNewStartPoint().getY() > newStart.getY() &&
//                points.getX() > newStart.getX() + shapeProps.getNewEndPoint().getX() - shapeProps.getNewStartPoint().getX() &&
//                points.getY() > newStart.getY() + shapeProps.getNewEndPoint().getY() - shapeProps.getNewStartPoint().getY());
//    }


}

