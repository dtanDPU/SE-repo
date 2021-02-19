package view.interfaces;

import StaticShapeFactory.IShapeList;
import model.interfaces.IDraw;
import model.interfaces.IObserver;

import javax.swing.*;
import java.awt.*;

public abstract class PaintCanvasBase extends JComponent {
    public abstract Graphics2D getGraphics2D();

}

