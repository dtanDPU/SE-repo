package controller;

import Factory.ShapeProperties;
import main.Points;
import model.interfaces.IDraw;
import model.persistence.GroupShapeComposite;
import view.interfaces.ISubject;

import java.util.ArrayList;

public class GroupShapeCmd implements ICommand, IUndoable{
    ISubject selectShapeList;
    ShapeProperties shapeProperties;
    ArrayList<IDraw > undoSL = new ArrayList<>();

    public GroupShapeCmd(ISubject selectShapeList, ShapeProperties shapeProperties) {
        this.selectShapeList = selectShapeList;
        this.shapeProperties = shapeProperties;

    }

    @Override
    public void run() {
        selectShapeList.getGroupList().clear();


        ShapeProperties shapeProps = selectShapeList.getShapeList().get(0).getShapeProps();
        int minX = Math.min(shapeProps.getEndX(), shapeProps.getStartX());
        int maxX = Math.max(shapeProps.getEndX(), shapeProps.getStartX());
        int minY = Math.min(shapeProps.getEndY(), shapeProps.getStartY());
        int maxY = Math.max(shapeProps.getEndY(), shapeProps.getStartY());

        for(IDraw shape: selectShapeList.getSelectedShapeList()) {
            selectShapeList.addGroupList(shape);
            ShapeProperties props = shape.getShapeProps();
            minX = Math.min(minX, Math.min(props.getEndX(), props.getStartX()));
            maxX = Math.max(maxX, Math.max(props.getEndX(), props.getStartX()));
            minY = Math.min(minY, Math.min(props.getEndY(), props.getStartY()));
            maxY = Math.max(maxY, Math.max(props.getEndY(), props.getStartY()));


        }

        Points compositeStart = new Points(minX, minY);
        Points compositeEnd = new Points(maxX, maxY);


        GroupShapeComposite groupShapeComposite = new GroupShapeComposite(compositeStart, compositeEnd, shapeProperties, selectShapeList.getGroupList());
        selectShapeList.addShape(groupShapeComposite);
        selectShapeList.getSelectedShapeList().add(groupShapeComposite);
        selectShapeList.notifyObserver();
        CommandHistory.add(this);

        if(!shapeProperties.ifSelected() ) {
            selectShapeList.clearSelectedList();
            selectShapeList.notifyObserver();
        }


        System.out.println("test grouped: " + selectShapeList.getGroupList().size());

    }

    @Override
    public void undo() {
        undoSL.add(selectShapeList.getShapeList().get(selectShapeList.getSelectedShapeList().size()-1));
        selectShapeList.removeShape(selectShapeList.getShapeList().get(selectShapeList.getSelectedShapeList().size()-1));
        selectShapeList.notifyObserver();


    }


    @Override
    public void redo() {

            for (IDraw shape : undoSL) {
                selectShapeList.addShape(shape);
                selectShapeList.notifyObserver();


        }


    }
}
