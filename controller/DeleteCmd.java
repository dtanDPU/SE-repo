package controller;

import model.persistence.ShapeProperties;
import view.interfaces.IDraw;
import model.interfaces.ISubject;

public class DeleteCmd implements ICommand, IUndoable {
    ISubject selectShapeList;
    ShapeProperties shapeProperties;

    public DeleteCmd(ISubject selectShapeList, ShapeProperties shapeProperties) {

        this.selectShapeList = selectShapeList;
        this.shapeProperties = shapeProperties;

    }

    @Override
    public void run() {

        for(IDraw s : selectShapeList.getSelectedShapeList()) {
            selectShapeList.removeShape(s);
        }
        CommandHistory.add(this);

    }

    @Override
    public void undo() {
        //same as all other undos just reverse the process
        for(IDraw s : selectShapeList.getSelectedShapeList()) {
            selectShapeList.addShape(s);
        }

    }

    @Override
    public void redo() {
        // re-run the run() function to redo what we undid
        run();

    }
}
