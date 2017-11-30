package com.javaBase.client.general.buttons;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.annotations.IsSafeHtml;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.javaBase.shared.Resources;

public class DeleteButton extends Button{

    private Image imgDelete  = new Image(Resources.INSTANCE.delete_button());

    /**
     * Creates a button.
     */
    public DeleteButton(){
        imgDelete.setWidth("20px");
        imgDelete.setHeight("20px");
        setHTML(imgDelete + "Удалить");
        setStyleName("Button");
    }

    /**
     * Creates a button with the given HTML caption and click handler.
     *
     * @param handler the click handler.
     */
    public DeleteButton(ClickHandler handler){
        imgDelete.setWidth("20px");
        imgDelete.setHeight("20px");
        setHTML(imgDelete + "Удалить");
        setStyleName("Button");
        addClickHandler(handler);
    }

    /**
     * Creates a button with the given HTML caption and click handler.
     *
     * @param html the html caption.
     * @param handler the click handler.
     */
    public DeleteButton(@IsSafeHtml String html, ClickHandler handler){
        imgDelete.setWidth("20px");
        imgDelete.setHeight("20px");
        setHTML(imgDelete + html);
        setStyleName("Button");
        addClickHandler(handler);
    }

}
