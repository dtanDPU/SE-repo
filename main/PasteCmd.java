package main;

import StaticShapeFactory.ShapeList;
import StaticShapeFactory.ShapeProperties;
import model.interfaces.IApplicationState;
import model.interfaces.IDraw;
import view.interfaces.ISubject;

public class PasteCmd implements ICommand, IUndoable{
    ISubject selectShapeList;
    ShapeProperties shapeProperties;
    IDraw newS;
    ShapeList shapeList;

    public PasteCmd(ISubject selectShapeList, ShapeProperties shapeProperties) {
        this.selectShapeList = selectShapeList;
        this.shapeProperties = shapeProperties;

    }

    @Override
    public void run() {

        for(IDraw s : selectShapeList.getCopy()) {
            newS = s;
            newS.addDX(100);
            newS.addDY(100);
            selectShapeList.addShape(s);
            CommandHistory.add(this);

            System.out.println("Paste test: " + selectShapeList.getSelectedShapeList());

        }

    }


    @Override
    public void undo() {
        shapeList.removeShape(newS);

    }

    @Override
    public void redo() {
        shapeList.addShape(newS);

    }
}
