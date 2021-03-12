package controller;

import Factory.ShapeList;
import Factory.ShapeProperties;
import model.interfaces.IDraw;
import view.interfaces.ISubject;

public class MoveShapeCmd implements ICommand, IUndoable{

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
//        selectShapeList.notifyObserver();
    }

    @Override
    public void redo() {
        //doing run() seems to make it worse than doing this way

        for(IDraw selectedShapes : shapeList.getSelectedShapeList()){
            selectedShapes.addDX(X);
            selectedShapes.addDY(Y);
            shapeList.addShape(selectedShapes);
        }
//        for (IDraw shapeStore : shapeList.getSelectedShapeList()) {
//            shapeStore.addDX(X);
//            shapeStore.addDY(Y);
//            newS = shapeStore;
//            selectShapeList.addShape(newS);
        }
//        selectShapeList.notifyObserver();



}
