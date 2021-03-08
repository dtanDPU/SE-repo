package main;

import StaticShapeFactory.ShapeProperties;
import model.interfaces.IDraw;
import view.interfaces.ISubject;

public class GroupShapeCmd implements ICommand, IUndoable{
    ISubject selectShapeList;
    ShapeProperties shapeProperties;

    public GroupShapeCmd(ISubject selectShapeList, ShapeProperties shapeProperties) {
        this.selectShapeList = selectShapeList;
        this.shapeProperties = shapeProperties;

    }

    @Override
    public void run() {

        if(selectShapeList.getShapeList().size() <1) {
            return;
        }

        for(IDraw s : selectShapeList.getShapeList()){
            selectShapeList.addGroupList(s);
        }
        CommandHistory.add(this);
        System.out.println("test grouped: " + selectShapeList.getGroupList().size());


    }

    @Override
    public void undo() {

        for(IDraw s : selectShapeList.getSelectedShapeList()) {
            selectShapeList.removeShape(s);
        }
        System.out.println("test undo group: " + selectShapeList.getGroupList().size());


    }

    @Override
    public void redo() {
        run();

    }
}
