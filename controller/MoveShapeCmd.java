package controller;

import model.persistence.ShapeList;
import model.persistence.ShapeProperties;
import view.interfaces.IDraw;
import model.interfaces.ISubject;

public class MoveShapeCmd implements ICommand, IUndoable {

    public ShapeProperties shapeProps;
    ISubject selectShapeList, groupList;
    int X, Y;
    ShapeList shapeList;


    public MoveShapeCmd(ShapeProperties shapeProps, ISubject selectShapeList, ShapeList shapeList) {
        this.shapeProps = shapeProps;
        this.selectShapeList = selectShapeList;
        this.X = shapeProps.getEndPoint().getX() - shapeProps.getStartPoint().getX();
        this.Y = shapeProps.getEndPoint().getY() - shapeProps.getStartPoint().getY();
        this.shapeList = shapeList;


    }

    @Override
    public void run() {
        // refactored to make the shapes not move randomly now.
        // used 2 loops/temp array before now only 1 loop and no temp array
        for(IDraw selectedShapes : shapeList.getSelectedShapeList()){
            shapeList.removeShape(selectedShapes);
            selectedShapes.addDX(X);
            selectedShapes.addDY(Y);
            shapeList.addShape(selectedShapes);

        }
        shapeList.notifyObserver();
        CommandHistory.add(this);
        System.out.println("# moved shapes: " + shapeList.getSelectedShapeList().size());
    }

    @Override
    public void undo() {

    //  inverse of moving from above code
        for(IDraw selectedShapes : shapeList.getSelectedShapeList()) {
            selectedShapes.addDX(-X);
            selectedShapes.addDY(-Y);
            shapeList.addShape(selectedShapes);
        }
    }

    @Override
    public void redo() {
        //doing run() seems to make it worse than doing this way
        for(IDraw selectedShapes : shapeList.getSelectedShapeList()){
            selectedShapes.addDX(X);
            selectedShapes.addDY(Y);
            shapeList.addShape(selectedShapes);
        }

        }



}
