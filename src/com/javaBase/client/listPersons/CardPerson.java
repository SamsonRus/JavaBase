package com.javaBase.client.listPersons;

import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.SingleSelectionModel;
import com.javaBase.client.JavaBaseService;
import com.javaBase.client.general.Button;
import com.javaBase.client.general.DataInput;
import com.javaBase.client.general.messageBox;
import com.javaBase.shared.Resources;
import java.util.Date;

class CardPerson extends DialogBox{
    private VerticalPanel dataPanel         = new VerticalPanel();
    /*    Inputs    */
    private TextBox firstNameBox    = new TextBox();
    private TextBox lastNameBox     = new TextBox();
    private DataInput birthDateBox  = new DataInput();
    /*    Buttons    */
    private HorizontalPanel buttonPanel = new HorizontalPanel();
    private Image imgSave       = new Image(Resources.INSTANCE.save());
    private Button saveButton   = new Button("Сохранить", imgSave);
    /*    Panel PersonTelDetails     */
    private VerticalPanel TelDetailBox = new VerticalPanel();
    private CellTable<PersonTelDetail> tablePersonTelDetails = new CellTable<>();
    private SingleSelectionModel<PersonTelDetail> selectionModel = new SingleSelectionModel<>();

    /**
     * Creates a form for filling of the Person
     */
    CardPerson(){
        setText("Создание клиента");
        setStyleName("contact-edit");
        setAnimationEnabled(true);
        setModal(true);

        addDetailForCardPerson();
        addDetailForTelDetailBox();
        addHandlerForSaveButton(new Person());
        addButtons();

        setWidget(dataPanel);
        center();

    }

    /**
     * Creates a form for filling of the Person
     *
     * @param selectedPerson the Person
     */
    CardPerson(Person selectedPerson){
        this();
        setText("Изменение клиента");

        fillPersonData(selectedPerson);
        addHandlerForSaveButton(selectedPerson);

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
        buttonPanel.add(deleteButton);

    }

    /**
     * add inputs in CardPerson
     */
    private void addDetailForCardPerson() {
        HorizontalPanel firstNamePanel  = new HorizontalPanel();
        Label firstNameLabel = new Label("Имя:");
        firstNamePanel.setStyleName("detail-info");
        firstNamePanel.add(firstNameLabel);
        firstNamePanel.add(firstNameBox);
        dataPanel.add(firstNamePanel);

        HorizontalPanel lastNamePanel   = new HorizontalPanel();
        Label lastNameLabel = new Label("Фамилия:");
        lastNamePanel.setStyleName("detail-info");
        lastNamePanel.add(lastNameLabel);
        lastNamePanel.add(lastNameBox);
        dataPanel.add(lastNamePanel);

        HorizontalPanel birthDatePanel  = new HorizontalPanel();
        Label birthDateLabel = new Label("Дата рождения");
        birthDatePanel.setStyleName("detail-info");
        birthDatePanel.add(birthDateLabel);
        birthDatePanel.add(birthDateBox);
        dataPanel.add(birthDatePanel);
    }

    /**
     * add buttons and table in CardPerson
     */
    private void addDetailForTelDetailBox(){
        TelDetailBox.setStyleName("formObjects");
        tablePersonTelDetails.addStyleName("cellTable");
        tablePersonTelDetails.setSelectionModel(selectionModel);

        addButtonsForTable();
        /*fill TelDetailBox*/
        addColumnsForTablePersonTelDetails();
        addSelectionModel();
        TelDetailBox.add(tablePersonTelDetails);
        dataPanel.add(TelDetailBox);
    }
    /**
     * add buttons for tablePersonTelDetails
     */
    private void addButtonsForTable() {
        Image addRowImg = new Image(Resources.INSTANCE.add_button());
        Button addRowButton = new Button("Добавить", addRowImg, event -> new CardPersonTelDetail().show());
        HorizontalPanel buttonPanelTelDetails = new HorizontalPanel();
        buttonPanelTelDetails.add(addRowButton);
        Image deleteRowImg = new Image(Resources.INSTANCE.delete_button());
        Button deleteRowButton = new Button("Удалить", deleteRowImg, event -> tablePersonTelDetails.setRowCount(0));
        buttonPanelTelDetails.add(deleteRowButton);
        Image refreshImg = new Image(Resources.INSTANCE.refresh());
        Button refreshButton = new Button("Обновить", refreshImg);
        buttonPanelTelDetails.add(refreshButton);
        TelDetailBox.add(buttonPanelTelDetails);
    }
    /**
     * add columns in tablePersonTelDetails
     */
    private void addColumnsForTablePersonTelDetails() {
        TextColumn<PersonTelDetail> telType = new TextColumn<PersonTelDetail>() {
            @Override
            public String getValue(PersonTelDetail object) {
                return object.getTelType();
            }
        };
        telType.setSortable(true);
        tablePersonTelDetails.addColumn(telType, "Тип");

        TextColumn<PersonTelDetail> telNumber = new TextColumn<PersonTelDetail>() {
            @Override
            public String getValue(PersonTelDetail object) {
                return object.getTelNumber();
            }
        };
        telNumber.setSortable(true);
        tablePersonTelDetails.addColumn(telNumber, "Номер");
    }
    private void addSelectionModel() {
        tablePersonTelDetails.setSelectionModel(selectionModel);
        tablePersonTelDetails.addDomHandler(event -> {
            PersonTelDetail selected = selectionModel.getSelectedObject();
            if (selected != null) {
                new CardPersonTelDetail(selected).show();
            } else {
                Window.alert("Не выбрана ни одна строка");
            }
        }, DoubleClickEvent.getType());

    }

    /**
     * add ClickHandler for button "Save".
     * @param selectedPerson the selected person in TablePersons
     */
    private void addHandlerForSaveButton(Person selectedPerson) {
        saveButton.addClickHandler(event -> {

            selectedPerson.setFirstName(firstNameBox.getText());
            selectedPerson.setLastName(lastNameBox.getText());

            /*Парсим дату*/
            DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("dd.MM.yyyy");
            Date dateBirth = dateTimeFormat.parse(birthDateBox.getText());

            selectedPerson.setBirthDate(dateBirth);

            JavaBaseService.App.getInstance().savePerson(selectedPerson, new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    new messageBox("Не удалось сохранить!", 2000);
                    CardPerson.super.hide();
                }

                @Override
                public void onSuccess(Void result) {
                    new messageBox("Контакт сохранен.", 2000);
                    CardPerson.super.hide();
                }
            });
        });
    }

    /**
     * fills with fields a form in CardPerson
     */
    private void addButtons() {
        /*add buttons*/
        buttonPanel.add(saveButton);
        Button cancelButton = new Button("Отмена", event -> CardPerson.this.hide());
        buttonPanel.add(cancelButton);

        dataPanel.add(buttonPanel);
    }

    /**
     * fills with data CardPerson
     * @param person the selected person
     */
    private void fillPersonData(Person person){
        firstNameBox.setText(person.getFirstName());
        lastNameBox.setText(person.getLastName());
        DateTimeFormat fmt = DateTimeFormat.getFormat("dd.MM.yyyy");
        String dateString = fmt.format(person.getBirthDate());
        birthDateBox.setText(dateString);
    }

}
