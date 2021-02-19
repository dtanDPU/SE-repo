package main;

import StaticShapeFactory.ShapeList;
import StaticShapeFactory.ShapeProperties;
import controller.IJPaintController;
import controller.JPaintController;
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
//        ShapeProperties shapeProperties = new ShapeProperties();

        ShapeList shapeList = new ShapeList();

        DrawShape drawShape = new DrawShape(paintCanvas,shapeList);
        shapeList.register(drawShape);


        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();


        paintCanvas.addMouseListener(new MouseHandler(paintCanvas, shapeList, appState));
//        MouseHandler.getState(appState);



        // For example purposes only; remove all lines below from your final project.


        // Filled in rectangle
//        Graphics2D graphics2d = paintCanvas.getGraphics2D();
//        graphics2d.setColor(Color.GREEN);
//        graphics2d.fillRect(12, 13, 200, 400);
//
//        // Outlined rectangle
//        graphics2d.setStroke(new BasicStroke(5));
//        graphics2d.setColor(Color.BLUE);
//        graphics2d.drawRect(12, 13, 200, 400);
//
//        // Selected Shape
//        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
//        graphics2d.setStroke(stroke);
//        graphics2d.setColor(Color.BLACK);
//        graphics2d.drawRect(7, 8, 210, 410);
    }
}
