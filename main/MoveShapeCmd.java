package main;

import StaticShapeFactory.ShapeList;
import StaticShapeFactory.ShapeProperties;
import model.interfaces.IApplicationState;
import model.interfaces.IDraw;
import view.interfaces.ISubject;

import java.util.ArrayList;

public class MoveShapeCmd implements ICommand, IUndoable{

    public ShapeProperties shapeProps;
    IDraw OGshape;
    IDraw newS;
    ArrayList<IDraw> moveShapeList;
    ISubject selectShapeList;
    int X, Y;

    public MoveShapeCmd(ShapeProperties shapeProps, ISubject selectShapeList) {

        this.shapeProps = shapeProps;
        this.selectShapeList = selectShapeList;
        this.moveShapeList = new ArrayList<>();
        this.X = shapeProps.getEndPoint().getX() - shapeProps.getStartPoint().getX();
        this.Y = shapeProps.getEndPoint().getY() - shapeProps.getStartPoint().getY();

    }

    @Override
    public void run() {

        for(IDraw shape : selectShapeList.getSelectedShapeList()){
            OGshape = shape;
            moveShapeList.add(OGshape);
            selectShapeList.removeShape(OGshape);

            for(IDraw shapeStore : moveShapeList){
                shapeStore.addDX(X);
                shapeStore.addDY(Y);
                newS = shapeStore;
                selectShapeList.addShape(newS);
            }
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {

    //  inverse of moving from above code
        for(IDraw shapeStore : selectShapeList.getSelectedShapeList()) {
            shapeStore.addDX(-X);
            shapeStore.addDY(-Y);
            newS = shapeStore;
            selectShapeList.addShape(newS);
        }
    }

    @Override
    public void redo() {
//        selectShapeList.addShape(newS);
        run();

    }
}
