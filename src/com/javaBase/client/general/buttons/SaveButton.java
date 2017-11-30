package com.javaBase.client.general.buttons;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.annotations.IsSafeHtml;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.javaBase.shared.Resources;

public class SaveButton extends Button{

    private Image imgSave  = new Image(Resources.INSTANCE.save_button());

    /**
     * Creates a button.
     */
    public SaveButton(){
        imgSave.setWidth("20px");
        imgSave.setHeight("20px");
        setHTML(imgSave + "Сохранить");
        setStyleName("Button");
    }

    /**
     * Creates a button with the given HTML caption and click handler.
     *
     * @param handler the click handler.
     */
    public SaveButton(ClickHandler handler){
        imgSave.setWidth("20px");
        imgSave.setHeight("20px");
        setHTML(imgSave + "Сохранить");
        setStyleName("Button");
        addClickHandler(handler);
    }

    /**
     * Creates a button with the given HTML caption and click handler.
     *
     * @param html the html caption.
     * @param handler the click handler.
     */
    public SaveButton(@IsSafeHtml String html, ClickHandler handler){
        imgSave.setWidth("20px");
        imgSave.setHeight("20px");
        setHTML(imgSave + html);
        setStyleName("Button");
        addClickHandler(handler);
    }
}
