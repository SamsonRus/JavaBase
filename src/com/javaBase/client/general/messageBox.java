package com.javaBase.client.general;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

/**
 * A panel that can "pop up" over other widgets. It overlays the browser's
 * client area (and any previously-created popups).
*/
public class messageBox extends PopupPanel{

    /**
     * Creates a messageBox with no caption.
     */
    private messageBox() {
        addStyleName("messageBox");
        //center();
    }

    /**
     * Creates a messageBox with the given text message.
     *
     * @param textMessage the String.
     */
    public messageBox(String textMessage) {
        this();
        Label messageText = new Label(textMessage);
        add(messageText);
        show();
        Timer t = new Timer() {
            public void run() {
                hide();
            }
        };
        t.schedule(3000);
    }

    /**
     * Creates a messageBox with the given text message and timer.
     *
     * @param textMessage the String.
     * @param timer the integer.
     */
    public messageBox(String textMessage, int timer) {
        this();
        Label messageText = new Label(textMessage);
        add(messageText);
        show();
        Timer t = new Timer() {
            public void run() {
                hide();
            }
        };
        t.schedule(timer);
    }
}
