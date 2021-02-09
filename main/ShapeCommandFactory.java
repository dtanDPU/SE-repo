//package main;
//
//import StaticShapeFactory.ShapeProperties;
//import model.persistence.ApplicationState;
//import model.persistence.StartEndPoints;
//
//public class ShapeCommandFactory {
//    private static ICommand cmd;
//    ApplicationState appState;
//
//
//    public static void runCommands(int x, int y, Points startPoint, Points endPoint,
//                                   int height, int width, ShapeProperties shapeProps){
//
//        cmd = CommandFactory.drawCmd(x, y, startPoint, endPoint, height, width, shapeProps);
//        cmd.run();
//
//
//    }
//}
