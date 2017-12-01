package com.javaBase.client.general;

import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.Button;
import com.javaBase.shared.Resources;

public class DataInput extends HorizontalPanel{
    public TextBox dataBox = new TextBox();
    private com.google.gwt.user.client.ui.Button openCalendar = new Button();

    public DataInput(){
        dataBox.setWidth("152px");

        Image imgCalendar = new Image(Resources.INSTANCE.calendar());
        openCalendar.setHTML("" + imgCalendar);

        addBlur();
        addButtonHandler();
        add(dataBox);
        add(openCalendar);
    }

    private void addBlur() {
        dataBox.addBlurHandler(event -> reformatDate());
    }

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
