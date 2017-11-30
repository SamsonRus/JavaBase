package com.javaBase.client.general.buttons;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.javaBase.shared.Resources;

public class AddButton extends Button {

    private Image imgAdd  = new Image(Resources.INSTANCE.add_button());

    /**
     * Creates a button.
     */
    public AddButton() {
        imgAdd.setWidth("20px");
        imgAdd.setHeight("20px");
        setHTML("<div>" + imgAdd + "Добавить</div>");
        setStyleName("Button");

    }

    /**
     * Creates a button with the given HTML caption.
     *
     * @param html the HTML caption
     */
    public AddButton(SafeHtml html) {
        imgAdd.setWidth("20px");
        imgAdd.setHeight("20px");
        setHTML(imgAdd + html.asString());
        setStyleName("Button");
        Image addImage = new Image(GWT.getModuleBaseURL()+ "WEB-INF/img/add_button.png");
        getElement().appendChild(addImage.getElement());
    }

    /**
     * Creates a button with the given HTML caption and click handler.
     *
     * @param handler the click handler
     */
    public AddButton(ClickHandler handler){
        imgAdd.setWidth("10px");
        imgAdd.setHeight("10px");
        setHTML(imgAdd + "Добавить");
        setStyleName("Button");
        Image addImage = new Image(GWT.getModuleBaseURL()+ "WEB-INF/img/add_button.png");
        getElement().appendChild(addImage.getElement());
        addClickHandler(handler);
    }

    /**
     * Creates a button with the given HTML caption and click handler.
     *
     * @param html the html caption.
     * @param handler the click handler.
     */
    public AddButton(SafeHtml html, ClickHandler handler){
        imgAdd.setWidth("20px");
        imgAdd.setHeight("20px");
        setHTML(imgAdd + html.asString());
        setStyleName("Button");
        Image addImage = new Image(GWT.getModuleBaseURL()+ "WEB-INF/img/add_button.png");
        getElement().appendChild(addImage.getElement());
        addClickHandler(handler);
    }
}
