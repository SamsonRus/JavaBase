package com.javaBase.client.general;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.annotations.IsSafeHtml;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

/**
 * A standard push-button widget.
 *
 * <p>
 * <img class='gallery' src='doc-files/Button.png'/>
 * </p>
 *
 * <h3>CSS Style Rules</h3>
 * <dl>
 * <dt>.Button</dt>
 * <dd>the outer element</dd>
 * </dl>
 */
public class Button extends com.google.gwt.user.client.ui.Button {

    /**
     * Creates a button.
     */
    public Button() {
        setStyleName("Button");
    }

    /**
     * Creates a button with the given HTML caption.
     *
     * @param html the html caption.
     */
    public Button(@IsSafeHtml String html){
        this();
        setHTML(html);
   }

    /**
     * Creates a button with the given HTML caption.
     *
     * @param html the HTML caption
     */
    public Button(SafeHtml html) {
        this();
        setHTML(html.asString());
    }

    /**
     * Creates a button with the given click handler.
     *
     * @param handler the click handler
     */
    public Button(ClickHandler handler){
        this();
        addClickHandler(handler);
    }

    /**
     * Creates a button with the given HTML caption and click handler.
     *
     * @param html the html caption.
     * @param handler the click handler.
     */
    public Button(@IsSafeHtml String html, ClickHandler handler){
        this();
        setHTML(html);
        addClickHandler(handler);
    }

    /**
     * Creates a button with the given image.
     *
     * @param image the Image.
     */
    public Button(Image image){
        this();
        image.setWidth("15px");
        image.setHeight("15px");
        setHTML("" + image);
    }

    /**
     * Creates a button with the given image and click handler.
     *
     * @param image the Image
     * @param handler the click handler
     */
    public Button(Image image, ClickHandler handler){
        this();
        image.setWidth("15px");
        image.setHeight("15px");
        setHTML("" + image);
        addClickHandler(handler);
    }

    /**
     * Creates a button with the given HTML caption and image.
     *
     * @param html the html caption.
     * @param image the Image
     */
    public Button(@IsSafeHtml String html, Image image){
        this();
        HorizontalPanel htmlButton = new HorizontalPanel();
        image.setWidth("15px");
        image.setHeight("15px");

        htmlButton.add(image);
        htmlButton.add(new Label(html));
        htmlButton.addStyleName("textButton");

        setHTML("" + htmlButton);
    }

    /**
     * Creates a button with the given HTML caption, click handler and image.
     *
     * @param html the html caption.
     * @param image the Image
     * @param handler the click handler
     */
    public Button(@IsSafeHtml String html, Image image, ClickHandler handler){
        this();
        HorizontalPanel htmlButton = new HorizontalPanel();
        image.setWidth("15px");
        image.setHeight("15px");

        htmlButton.add(image);
        htmlButton.add(new Label(html));
        htmlButton.addStyleName("textButton");

        setHTML("" + htmlButton);
        addClickHandler(handler);
    }
}

