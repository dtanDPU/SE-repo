package main;

import StaticShapeFactory.ShapeList;
import StaticShapeFactory.ShapeProperties;
import model.interfaces.IDraw;
import view.interfaces.ISubject;

import java.util.ArrayList;

public class GroupShapeCmd implements ICommand, IUndoable{
    ISubject selectShapeList, groupList, shapeList;
    ShapeProperties shapeProperties;

    public GroupShapeCmd(ISubject selectShapeList, ShapeProperties shapeProperties) {
        this.selectShapeList = selectShapeList;
        this.shapeProperties = shapeProperties;


    }

    @Override
    public void run() {
        selectShapeList.getGroupList().clear();

        for(IDraw s : selectShapeList.getSelectedShapeList()){
            selectShapeList.addGroupList(s);
        }
//        CommandHistory.add(this);
        System.out.println("test grouped: " + selectShapeList.getGroupList().size());


    }

    @Override
    public void undo() {


        for (IDraw s : selectShapeList.getSelectedShapeList()) {
            selectShapeList.removeGroupedShapes(s);
        }
//        CommandHistory.add(this);
        System.out.println("test undo group: " + selectShapeList.getGroupList().size());

    }


    @Override
    public void redo() {
        run();

    }
}
