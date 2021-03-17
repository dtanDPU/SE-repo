package model.persistence;

import model.ShapeColor;

import java.awt.*;
import java.util.EnumMap;

public class ColorMap {
    private static ColorMap instance = new ColorMap();
    private static EnumMap<ShapeColor, Color> map;

    private ColorMap() {
        map = new EnumMap<>(ShapeColor.class);
        map.put(ShapeColor.BLUE, Color.BLUE);
        map.put(ShapeColor.BLACK, Color.BLACK);
        map.put(ShapeColor.CYAN, Color.CYAN);
        map.put(ShapeColor.DARK_GRAY, Color.DARK_GRAY);
        map.put(ShapeColor.GRAY, Color.GRAY);
        map.put(ShapeColor.GREEN, Color.GREEN);
        map.put(ShapeColor.LIGHT_GRAY, Color.LIGHT_GRAY);
        map.put(ShapeColor.MAGENTA, Color.MAGENTA);
        map.put(ShapeColor.ORANGE, Color.ORANGE);
        map.put(ShapeColor.PINK, Color.PINK);
        map.put(ShapeColor.RED, Color.RED);
        map.put(ShapeColor.WHITE, Color.WHITE);
        map.put(ShapeColor.YELLOW, Color.YELLOW);

    }

    public Color getColor(ShapeColor colorMap) {
        return map.get(colorMap);
    }
    public static ColorMap getInstance(){
        return instance;
    }




}
