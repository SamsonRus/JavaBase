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
 * <dt>.gwt-Button</dt>
 * <dd>the outer element</dd>
 * </dl>
 *
 * <p>
 * <h3>Example</h3>
 * {@example com.google.gwt.examples.ButtonExample}
 * </p>
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
     * @param html the HTML caption
     */
    public Button(SafeHtml html) {
        setHTML(html.asString());
        setStyleName("Button");
    }

    /**
     * Creates a button with the given HTML caption and click handler.
     *
     * @param handler the click handler
     */
    public Button(ClickHandler handler){
        setStyleName("Button");
        addClickHandler(handler);
    }

    /**
     * Creates a button with the given HTML caption and click handler.
     *
     * @param html the html caption.
     * @param handler the click handler.
     */
    public Button(@IsSafeHtml String html, ClickHandler handler){
        setHTML(html);
        setStyleName("Button");
        addClickHandler(handler);
    }

    /**
     * Creates a button with the image.
     *
     * @param image the Image.
     */
    public Button(Image image){
        image.setWidth("15px");
        image.setHeight("15px");
        setHTML("" + image);
        setStyleName("Button");
    }

    /**
     * Creates a button with the given HTML caption and click handler.
     *
     * @param image the Image
     * @param handler the click handler
     */
    public Button(Image image, ClickHandler handler){
        image.setWidth("15px");
        image.setHeight("15px");
        setHTML("" + image);
        setStyleName("Button");
        addClickHandler(handler);
    }

    /**
     * Creates a button with the given HTML caption and image.
     *
     * @param html the html caption.
     * @param image the Image
     */
    public Button(@IsSafeHtml String html, Image image){
        HorizontalPanel htmlButton = new HorizontalPanel();
        image.setWidth("15px");
        image.setHeight("15px");

        htmlButton.add(image);
        htmlButton.add(new Label(html));
        htmlButton.addStyleName("textButton");

        setHTML("" + htmlButton);
        setStyleName("Button");
    }

    /**
     * Creates a button with the given HTML caption, click handler and image.
     *
     * @param html the html caption.
     * @param image the Image
     * @param handler the click handler
     */
    public Button(@IsSafeHtml String html, Image image, ClickHandler handler){
        HorizontalPanel htmlButton = new HorizontalPanel();
        image.setWidth("15px");
        image.setHeight("15px");

        htmlButton.add(image);
        htmlButton.add(new Label(html));
        htmlButton.addStyleName("textButton");

        setHTML("" + htmlButton);
        setStyleName("Button");
        addClickHandler(handler);
    }
}

