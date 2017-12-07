package com.javaBase.client.listPersons;

import com.google.gwt.user.client.ui.*;
import com.javaBase.client.general.Button;
import com.javaBase.shared.Resources;

public class CardPersonTelDetail extends DialogBox {
    private VerticalPanel dataPanel         = new VerticalPanel();
    /*    Inputs    */
    private TextBox telTypeBox    = new TextBox();
    private TextBox telNumberBox    = new TextBox();
    /*    Buttons    */
    private HorizontalPanel buttonPanel = new HorizontalPanel();
    private Image imgSave       = new Image(Resources.INSTANCE.save());
    private Button saveButton   = new Button("Сохранить", imgSave);

    CardPersonTelDetail(){
        setText("Добавление телефона");
        setStyleName("contact-edit");
        setAnimationEnabled(true);
        setModal(true);

        addDetailForCardPersonTelDetail();
        addHandlerForSaveButton(new PersonTelDetail());
        addButtons();

        setWidget(dataPanel);
        center();
    }

    CardPersonTelDetail(PersonTelDetail personTelDetail){
        this();
        setText("Изменение телефона");

        telTypeBox.setText(personTelDetail.getTelType());
        telNumberBox.setText(personTelDetail.getTelNumber());

        addHandlerForSaveButton(personTelDetail);
    }

    private void addDetailForCardPersonTelDetail() {
        HorizontalPanel telTypePanel  = new HorizontalPanel();
        Label telTypeLabel = new Label("Номер телефона:");
        telTypePanel.setStyleName("detail-info");
        telTypePanel.add(telTypeLabel);
        telTypePanel.add(telTypeBox);
        dataPanel.add(telTypePanel);

        HorizontalPanel telNumberPanel  = new HorizontalPanel();
        Label telNumberLabel = new Label("Номер телефона:");
        telNumberPanel.setStyleName("detail-info");
        telNumberPanel.add(telNumberLabel);
        telNumberPanel.add(telNumberBox);
        dataPanel.add(telNumberPanel);

    }

    /**
     * fills with fields a form in CardPersonTelDetail
     */
    private void addButtons(){
        /*add buttons*/
        buttonPanel.add(saveButton);
        Button cancelButton = new Button("Отмена", event -> CardPersonTelDetail.this.hide());
        buttonPanel.add(cancelButton);

        dataPanel.add(buttonPanel);

    }

    /**
     * add ClickHandler for button "Save".
     * @param selectedPersonTelDetail the selected personTelDetail in CardPerson
     */
    private void addHandlerForSaveButton(PersonTelDetail selectedPersonTelDetail){
        saveButton.addClickHandler(event ->{
            selectedPersonTelDetail.setTelType(telTypeBox.getText());
            selectedPersonTelDetail.setTelNumber(telNumberBox.getText());

        });
    }

}
