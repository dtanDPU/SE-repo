package main;

import StaticShapeFactory.ShapeList;
import StaticShapeFactory.ShapeProperties;
import model.interfaces.IApplicationState;
import model.interfaces.IDraw;
import view.interfaces.ISubject;

import java.util.ArrayList;

public class MoveShapeCmd implements ICommand, IUndoable{

    public ShapeProperties shapeProps;
    ArrayList<IDraw> moveShapeList;
    ISubject selectShapeList;
    int X, Y;
    ShapeList OGlist;


    public MoveShapeCmd(ShapeProperties shapeProps, ISubject selectShapeList, ShapeList shapeList) {
        this.shapeProps = shapeProps;
        this.selectShapeList = selectShapeList;
        this.moveShapeList = new ArrayList<>();
        this.X = shapeProps.getEndPoint().getX() - shapeProps.getStartPoint().getX();
        this.Y = shapeProps.getEndPoint().getY() - shapeProps.getStartPoint().getY();
        this.OGlist = shapeList;


    }

    @Override
    public void run() {
        // refactored to make the shapes not move randomly now.
        // used 2 loops/temp array before now only 1 loop and no temp array
        for(IDraw selectedShapes : OGlist.getSelectedShapeList()){
            OGlist.removeShape(selectedShapes);
            selectedShapes.addDX(X);
            selectedShapes.addDY(Y);
            OGlist.addShape(selectedShapes);
//            OGshape = shape;
//            moveShapeList.add(OGshape);
//            selectShapeList.removeShape(OGshape);

//            for(IDraw shapeStore : moveShapeList){
//                shapeStore.addDX(X);
//                shapeStore.addDY(Y);
//                newS = shapeStore;
//                selectShapeList.addShape(newS);
//            }
        }
//        OGlist.notifyObserver();
        CommandHistory.add(this);
        System.out.println("# moved shapes: " + OGlist.getSelectedShapeList().size());
    }

    @Override
    public void undo() {

    //  inverse of moving from above code
        for(IDraw selectedShapes : OGlist.getSelectedShapeList()) {
            selectedShapes.addDX(-X);
            selectedShapes.addDY(-Y);
            OGlist.addShape(selectedShapes);
        }
//        selectShapeList.notifyObserver();
    }

    @Override
    public void redo() {
        //doing run() seems to make it worse than doing this way

        for(IDraw selectedShapes : OGlist.getSelectedShapeList()){
            selectedShapes.addDX(X);
            selectedShapes.addDY(Y);
            OGlist.addShape(selectedShapes);
        }
//        for (IDraw shapeStore : shapeList.getSelectedShapeList()) {
//            shapeStore.addDX(X);
//            shapeStore.addDY(Y);
//            newS = shapeStore;
//            selectShapeList.addShape(newS);
        }
//        selectShapeList.notifyObserver();



}
