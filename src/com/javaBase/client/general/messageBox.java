package com.javaBase.client.general;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

public class messageBox extends PopupPanel{

    private PopupPanel messageBox = new PopupPanel();

    public messageBox(String textMessage) {

        Label messageText = new Label(textMessage);
        messageBox.addStyleName("messageBox");
        messageBox.add(messageText);
        messageBox.center();
        messageBox.show();
        Timer t = new Timer() {
            public void run() {
                messageBox.hide();
            }
        };

        t.schedule(3000);
    }

    public messageBox(String textMessage, int timer) {
        Label messageText = new Label(textMessage);
        messageBox.addStyleName("messageBox");
        messageBox.add(messageText);
        messageBox.center();
        messageBox.show();
        Timer t = new Timer() {
            public void run() {
                messageBox.hide();
            }
        };

        t.schedule(timer);
    }
}
