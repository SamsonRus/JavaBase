package com.javaBase.client.general;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DatePicker;
import java.util.Date;

class Calendar extends PopupPanel {

    private DatePicker calendar = new DatePicker();

    /**
     * Create Calendar.
     */
    private Calendar(){
        setAutoHideEnabled(true);
        setModal(false);
        setAnimationEnabled(true);

        calendar.setYearAndMonthDropdownVisible(true);
        setWidget(calendar);
        show();
    }

    /**
     * Create Calendar with parameters.
     *
     * @param leftPositionWidget the integer designating left position of the calendar.
     * @param topPositionWidget the integer designating left position of the calendar.
     * @param textBox the input box with String value.
     */
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
        //if(!Objects.equals(textBox.getText(), "")){
            DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("dd.MM.yyyy");
            Date dateBirth = dateTimeFormat.parse(textBox.getText());

            calendar.setValue(dateBirth, true);
        //}


    }
}
