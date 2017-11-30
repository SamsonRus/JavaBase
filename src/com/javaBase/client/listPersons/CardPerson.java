package com.javaBase.client.listPersons;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.javaBase.client.JavaBaseService;
import com.javaBase.client.general.Button;
import com.javaBase.client.general.buttons.CancelButton;
import com.javaBase.client.general.messageBox;
import com.javaBase.shared.Resources;

import java.util.Date;
import java.util.Objects;

class CardPerson extends DialogBox{
    private HorizontalPanel firstNamePanel = new HorizontalPanel();
    private HorizontalPanel lastNamePanel = new HorizontalPanel();
    private HorizontalPanel birthDatePanel = new HorizontalPanel();

    private HorizontalPanel buttonPanel = new HorizontalPanel();
    private CancelButton cancelButton = new CancelButton(event -> CardPerson.this.hide());

    private TextBox firstNameBox = new TextBox();
    private TextBox lastNameBox = new TextBox();
    private TextBox birthDateBox = new TextBox();

    /**
     * Creates a form for filling of the Person
     */
    CardPerson(){
        setText("Создание клиента");
        setStyleName("contact-edit");
        setAnimationEnabled(true);

        VerticalPanel dataPanel = new VerticalPanel();

        addRows(new Person());
        Image imgSave = new Image(Resources.INSTANCE.save());
        Button saveButton = new Button("Сохранить", imgSave, event -> {

            Person person = new Person();
            person.setFirstName(firstNameBox.getText());
            person.setLastName(lastNameBox.getText());

            /*Парсим дату*/
            DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("dd.MM.yyyy");
            Date dateBirth = dateTimeFormat.parse(birthDateBox.getText());

            person.setBirthDate(dateBirth);

            JavaBaseService.App.getInstance().savePerson(person, new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    new messageBox("Не удалось записать!",2000);
                    CardPerson.super.hide();
                }
                @Override
                public void onSuccess(Void result) {
                    new messageBox("Контакт сохранен.",2000);
                    CardPerson.super.hide();
                }
            });
        });
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        dataPanel.add(firstNamePanel);
        dataPanel.add(lastNamePanel);
        dataPanel.add(birthDatePanel);
        dataPanel.add(buttonPanel);
        setWidget(dataPanel);
        center();

    }

    /**
     * Creates a form for filling of the Person
     *
     * @param selectedPerson the Person
     */
    CardPerson(Person selectedPerson){
        setText("Создание клиента");
        setStyleName("contact-edit");
        setAnimationEnabled(true);

        VerticalPanel dataPanel = new VerticalPanel();

        addRows(selectedPerson);
        Image imgSave = new Image(Resources.INSTANCE.save());
        Button updateButton = new Button("Перезаписать", imgSave, event -> {

            selectedPerson.setFirstName(firstNameBox.getText());
            selectedPerson.setLastName(lastNameBox.getText());

            /*Парсим дату*/
            DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("dd.MM.yyyy");
            Date dateBirth = dateTimeFormat.parse(birthDateBox.getText());

            selectedPerson.setBirthDate(dateBirth);

            JavaBaseService.App.getInstance().updatePerson(selectedPerson, new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    new messageBox("Не удалось перезаписать!", 2000);
                    CardPerson.super.hide();
                }

                @Override
                public void onSuccess(Void result) {
                    new messageBox("Контакт сохранен.", 2000);
                    CardPerson.super.hide();
                }
            });
        });
        Image imgDelete = new Image(Resources.INSTANCE.delete());
        Button deleteButton = new Button("Удалить", imgDelete, event -> JavaBaseService.App.getInstance().deletePerson(selectedPerson, new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable caught) {
                new messageBox("Не удалось удалить!",2000);
                CardPerson.super.hide();
            }
            @Override
            public void onSuccess(Void result) {
                new messageBox("Контакт удален.",2000);
                CardPerson.super.hide();
            }
        }));
        buttonPanel.add(updateButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(deleteButton);

        dataPanel.add(firstNamePanel);
        dataPanel.add(lastNamePanel);
        dataPanel.add(birthDatePanel);
        dataPanel.add(buttonPanel);
        setWidget(dataPanel);
        center();
    }

    private void addRows(Person person) {
        Label firstNameLabel = new Label("Имя:");
        if (person.getFirstName() != null) {
            firstNameBox.setText(person.getFirstName());
        }
        firstNamePanel.setStyleName("detail-info");
        firstNamePanel.add(firstNameLabel);
        firstNamePanel.add(firstNameBox);

        Label lastNameLabel = new Label("Фамилия:");
        if (person.getLastName() != null) {
            lastNameBox.setText(person.getLastName());
        }
        lastNamePanel.setStyleName("detail-info");
        lastNamePanel.add(lastNameLabel);
        lastNamePanel.add(lastNameBox);

        Label birthDateLabel = new Label("Дата рождения");
        if (person.getBirthDate() != null) {
            DateTimeFormat fmt = DateTimeFormat.getFormat("dd.MM.yyyy");
            String dateString = fmt.format(person.getBirthDate());

            birthDateBox.setText(dateString);
        }
        birthDateBox.addClickHandler(event -> {
            final Calendar calendar = new Calendar(birthDateBox);

            calendar.setPopupPositionAndShow((offsetWidth, offsetHeight) -> {
                int left = (Window.getClientWidth() - offsetWidth) / 2;
                int top = (Window.getClientHeight() - offsetHeight)/2;
                calendar.setPopupPosition(left, top);
            });
            calendar.show();
        });
        birthDatePanel.setStyleName("detail-info");
        birthDatePanel.add(birthDateLabel);
        birthDatePanel.add(birthDateBox);
    }

    private class Calendar extends PopupPanel {

        Calendar(TextBox birthDateBox) {

            super(false,true);

            DatePicker calendar = new DatePicker();
            calendar.setYearAndMonthDropdownVisible(true);
            if(birthDateBox.getText()!=null & !Objects.equals(birthDateBox.getText(), "")){
                DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("dd.MM.yyyy");
                Date dateBirth = dateTimeFormat.parse(birthDateBox.getText());

                calendar.setValue(dateBirth);
            }
            calendar.addValueChangeHandler(event -> {
                Date date = event.getValue();

                DateTimeFormat fmt = DateTimeFormat.getFormat("dd.MM.yyyy");
                String dateString = fmt.format(date);

                //String dateString = DateTimeFormat.getMediumDateFormat().format(date);
                birthDateBox.setText(dateString);
                Calendar.super.hide();
            });



            setWidget(calendar);
        }
    }
}
