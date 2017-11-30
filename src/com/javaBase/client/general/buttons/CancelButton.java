package com.javaBase.client.general.buttons;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class CancelButton extends Button{

    /**
     * Creates a button.
     */
    public CancelButton(){
        setHTML("Отмена");
        setStyleName("Button");
    }

    /**
     * Creates a button with the given HTML caption and click handler.
     *
     * @param handler the click handler
     */
    public CancelButton(ClickHandler handler){
        setHTML("Отмена");
        setStyleName("Button");
        addClickHandler(handler);
    }
}
