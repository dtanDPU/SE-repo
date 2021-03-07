package controller;

import StaticShapeFactory.ShapeList;
import StaticShapeFactory.ShapeProperties;
import main.*;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.ISubject;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private final ShapeProperties shapeProperties;
    private final ShapeList selectShapeList;


    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeProperties shapeProperties, ShapeList selectShapeList) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.shapeProperties = shapeProperties;
        this.selectShapeList = selectShapeList;


    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());

        // added additional commmands
        uiModule.addEvent(EventName.UNDO, () -> new UndoCommand().run());
        uiModule.addEvent(EventName.REDO, () -> new RedoCommand().run());

        uiModule.addEvent(EventName.COPY, () -> new CopyCmd(selectShapeList, shapeProperties).run());
        uiModule.addEvent(EventName.PASTE, () -> new PasteCmd(selectShapeList, shapeProperties).run());
//        uiModule.addEvent(EventName.UNGROUP, () -> new RedoCommand().run());
//        uiModule.addEvent(EventName.GROUP, () -> new RedoCommand().run());
        uiModule.addEvent(EventName.DELETE, () -> new DeleteCmd(selectShapeList, shapeProperties).run());


    }
}
