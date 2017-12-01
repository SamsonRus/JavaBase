package com.javaBase.client.general;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DatePicker;

import java.util.Date;
import java.util.Objects;

class Calendar extends PopupPanel {

    private DatePicker calendar = new DatePicker();

     private Calendar(){
        super(false,true);

        calendar.setYearAndMonthDropdownVisible(true);
        setWidget(calendar);
        show();
    }

    Calendar(int leftPositionWidget, int topPositionWidget, TextBox textBox){
        this();
        setPopupPosition(leftPositionWidget, topPositionWidget+20);
        calendar.addValueChangeHandler(event -> {
            Date date = event.getValue();

            DateTimeFormat fmt = DateTimeFormat.getFormat("dd.MM.yyyy");
            String dateString = fmt.format(date);

            //String dateString = DateTimeFormat.getMediumDateFormat().format(date);
            textBox.setText(dateString);
            hide();
        });
        if(textBox.getText()!=null & !Objects.equals(textBox.getText(), "")){
            DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("dd.MM.yyyy");
            Date dateBirth = dateTimeFormat.parse(textBox.getText());

            calendar.setValue(dateBirth, true);
        }


    }
}
