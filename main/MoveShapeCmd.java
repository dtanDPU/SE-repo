package main;

import StaticShapeFactory.ShapeList;
import StaticShapeFactory.ShapeProperties;
import model.interfaces.IApplicationState;
import model.interfaces.IDraw;
import view.interfaces.ISubject;

import java.util.ArrayList;

public class MoveShapeCmd implements ICommand, IUndoable{

    public ShapeProperties shapeProps;
    public IApplicationState applicationState;
    IDraw oldS;
    IDraw newS;
    ArrayList<IDraw> moveShapeList;
    ISubject selectShapeList;
    int width, height;

    public MoveShapeCmd(ShapeProperties shapeProps, IApplicationState applicationState, ISubject selectShapeList) {

        this.shapeProps = shapeProps;
        this.applicationState = applicationState;
        this.selectShapeList = selectShapeList;
        this.width = shapeProps.getEndPoint().getX() - shapeProps.getStartPoint().getX();
        this.height = shapeProps.getEndPoint().getY() - shapeProps.getStartPoint().getY();
        this.moveShapeList = new ArrayList<>();

    }

    @Override
    public void run() {
        for(IDraw collision : selectShapeList.getSelectedShapeList()){
            oldS = collision;
            moveShapeList.add(oldS);
            selectShapeList.removeShape(oldS);

            for(IDraw shapeStore : moveShapeList){
                shapeStore.addDX(width);
                shapeStore.addDY(height);
                newS = shapeStore;
                selectShapeList.addShape(newS);
            }
        }
        CommandHistory.add(this);
        System.out.println("# Moved " + selectShapeList.getSelectedShapeList().size());

    }

    @Override
    public void undo() {

    //  inverse of moving from above code
        for(IDraw shapeStore : moveShapeList) {
            shapeStore.addDX(-width);
            shapeStore.addDY(-height);
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
