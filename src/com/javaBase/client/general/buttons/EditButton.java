package com.javaBase.client.general.buttons;

import com.google.gwt.event.dom.client.ClickHandler;
import com.javaBase.client.general.Button;
import com.google.gwt.user.client.ui.Image;
import com.javaBase.shared.Resources;

public class EditButton{

    /**
     * Creates a button with the given HTML caption and click handler.
     *
     * @param handler the click handler
     */
    public EditButton(ClickHandler handler){
        Image imgEdit = new Image(Resources.INSTANCE.edit_button());
        new Button("Изменить", imgEdit , handler);
    }

}
