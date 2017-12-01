package com.javaBase.client.general;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.Button;
import com.javaBase.shared.Resources;

/**
 * DataInput consists from TextBox and Button for opening calendar.
 * TextBox
 */
public class DataInput extends HorizontalPanel{
    private TextBox dataBox = new TextBox();
    private com.google.gwt.user.client.ui.Button openCalendar = new Button();

    /**
     * Create DataInput.
     */
    public DataInput(){
        dataBox.setWidth("152px");
        setStyleName("dataInput");
        dataBox.setStyleName("dataBox");

        Image imgCalendar = new Image(Resources.INSTANCE.calendar());
        openCalendar.setHTML("" + imgCalendar);

        addHandlers();
        addButtonHandler();
        add(dataBox);
        add(openCalendar);
    }

    /**
     * add handlers for DataInput.
     */
    private void addHandlers() {
        dataBox.addKeyPressHandler(event-> addMask());
        dataBox.addBlurHandler(event -> reformatDate());
        dataBox.addKeyUpHandler(event -> {
            if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                reformatDate();
            }
        });
    }

    /**
     * add masks for DataInput.
     */
    private void addMask() {
        String text = dataBox.getText();
        text = text.replaceAll("\\D+", "");
        if (text.length() >= 2 & text.length() < 4) {
            dataBox.setText("" + text.substring(0, 2) + "." + text.substring(2, text.length()));
        }else if (text.length() >= 4 & text.length() < 6) {
            dataBox.setText("" + text.substring(0, 2) + "." + text.substring(2, 4) + "." + text.substring(4, text.length()));
        }
    }

    /**
     * reformat date.
     */
    private void reformatDate() {
        String text = dataBox.getText();
        text = text.replaceAll("\\D+", "");
        if (text.length() >= 2 & text.length() < 4) {
            dataBox.setText("" + text.substring(0, 2) + "." + text.substring(2, text.length()));
        }else if (text.length() >= 4 & text.length() < 6) {
            dataBox.setText("" + text.substring(0, 2) + "." + text.substring(2, 4) + "." + text.substring(4, text.length()) );
        }else if (text.length() == 6) {
            String year;
            if(Integer.parseInt(text.substring(4, 6))>50){
                year = "19" + text.substring(4, 6);
            }else{
                year = "20" + text.substring(4, 6);
            }
            dataBox.setText("" + text.substring(0, 2) + "." + text.substring(2, 4) + "." + year);
        }else if(text.length() == 8) {
            dataBox.setText("" + text.substring(0, 2) + "." + text.substring(2, 4) + "." + text.substring(4, 8));
        }
    }

    /**
     * add handler for open calendar.
     */
    private void addButtonHandler() {
        openCalendar.getAbsoluteLeft();
        openCalendar.setStyleName("calendarButton");
        openCalendar.addClickHandler(event -> {
            final Calendar calendar = new Calendar(openCalendar.getAbsoluteLeft(), openCalendar.getAbsoluteTop(), dataBox);
            calendar.show();
        });
    }

    public String getText() {
        return dataBox.getText();
    }

    public void setText(String text) {
        this.dataBox.setText(text);
    }
}
