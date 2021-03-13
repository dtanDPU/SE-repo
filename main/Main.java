package main;

import controller.IJPaintController;
import controller.JPaintController;
import view.gui.MouseHandler;
import model.persistence.ShapeList;
import model.persistence.ShapeProperties;
import model.persistence.ApplicationState;
import model.persistence.DrawShape;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
        PaintCanvasBase paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        ShapeProperties shapeProperties = new ShapeProperties();

        ShapeList shapeList = new ShapeList();

        DrawShape drawShape = new DrawShape(paintCanvas,shapeList);
        shapeList.register(drawShape);

        IJPaintController controller = new JPaintController(uiModule, appState, shapeProperties, shapeList);
        controller.setup();

        paintCanvas.addMouseListener(new MouseHandler(paintCanvas, shapeList, appState));

    }
}
