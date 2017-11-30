package com.javaBase.client.general;

import com.google.gwt.user.client.ui.*;
import com.javaBase.client.general.buttons.CancelButton;

public class Question extends PopupPanel{

    enum response{yes,no,cancel};

    private HorizontalPanel buttonsPanel = new HorizontalPanel();
    private Button yes = new Button("Да");
    private Button no = new Button("Нет");
    private CancelButton cancel = new CancelButton(event -> Question.this.hide());

    /**
     * Creates form with a question
     *
     * @param widget the PopupPanel
     */
    public Question(PopupPanel widget){
        Label textQuestionLabel = new Label("Данные не сохраняться. Продолжить?");

        yes.addClickHandler(event -> {
            this.hide();
            widget.hide();
        });
        no.addClickHandler(event -> this.hide());

        buttonsPanel.add(yes);
        buttonsPanel.add(no);

        add(textQuestionLabel);
        add(buttonsPanel);
        center();
    }

    public Question(DialogBox widget){

        Label textQuestionLabel = new Label("Данные не сохраняться. Продолжить?");

        yes.addClickHandler(event -> {
            this.hide();
            widget.hide();
        });
        no.addClickHandler(event -> this.hide());

        buttonsPanel.add(yes);
        buttonsPanel.add(no);

        add(textQuestionLabel);
        add(buttonsPanel);
        center();
    }
}
