package Factory;

import main.Points;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;
import java.awt.*;

public interface IShapeProperties {

    ShapeType getShapeType();
    ShapeColor getPrimary();
    ShapeColor getSecondary();
    ShapeShadingType getShadeType();
    int getHeight();
    int getWidth();
    int getStartX();
    int getStartY();
    int getEndX();
    int getEndY();
    Points getStartPoint();
    Points getEndPoint();
    PaintCanvasBase getPaintCanvasBase();
    void setPrimary(ShapeColor secondary);
    void setSecondary(ShapeColor secondary);
    void setShadeType(ShapeShadingType shadeType);
    void setHeight(int height);
    void setWidth(int width);
    void setStartX(Points x);
    void setStartY(Points Y);
    void setShapeType(ShapeType shapeType);
    void setStartPoint(Points startPoint);
    void setEndPoint(Points endPoint);
    void draw(Graphics2D graphics2D);

    Points getNewStartPoint();
    Points getNewEndPoint();
    void selected();
    void notSelected();
    boolean ifSelected();
    boolean isGrouped();


}
