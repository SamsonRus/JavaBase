package com.javaBase.client.listPersons;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.Range;
import com.google.gwt.view.client.SingleSelectionModel;
import com.javaBase.client.JavaBaseService;
import com.javaBase.client.general.Button;
import com.javaBase.shared.Resources;

import java.util.Date;
import java.util.List;

public class TablePersons extends VerticalPanel{

    private CellTable<Person> tablePersons = new CellTable<>();
    private HorizontalPanel buttonsPanel = new HorizontalPanel();
    private SingleSelectionModel<Person> selectionModel = new SingleSelectionModel<>();

    public TablePersons(){

        setStyleName("formObjects");
        addSelectionModel();
        addButtons();
        addColumns();

        tablePersons.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);
        tablePersons.addStyleName("cellTable");

        load();

        tablePersons.addRowCountChangeHandler(event -> tablePersons.setVisibleRange(new Range(1, event.getNewRowCount())));

        add(buttonsPanel);
        add(tablePersons);

    }

    private void addSelectionModel() {
        tablePersons.setSelectionModel(selectionModel);
        tablePersons.addDomHandler(event -> {
            Person selected = selectionModel.getSelectedObject();
            if (selected != null) {
                new CardPerson(selected).show();
            } else {
                Window.alert("Не выбрана ни одна строка");
            }
        },DoubleClickEvent.getType());

    }

    private void addButtons() {
        Image imgAdd  = new Image(Resources.INSTANCE.add());
        Button addButton = new Button("Добавить", imgAdd, event -> new CardPerson().show());
        Image imgEdit = new Image(Resources.INSTANCE.edit());
        Button editButton = new Button("Изменить", imgEdit, event -> {
            Person selected = selectionModel.getSelectedObject();
            if (selected != null) {
                new CardPerson(selected);
            } else {
                Window.alert("Не выбрана ни одна строка");
            }
        });
        Image imgRefresh = new Image(Resources.INSTANCE.refresh());
        Button refreshButton = new Button("Обновить", imgRefresh, event -> refresh());
        buttonsPanel.add(addButton);
        buttonsPanel.add(editButton);
        buttonsPanel.add(refreshButton);
    }

    private void addColumns() {
        TextColumn<Person> firstName = new TextColumn<Person>() {
            @Override
            public String getValue(Person object) {
                return object.getFirstName();
            }
        };
        firstName.setSortable(true);
        tablePersons.addColumn(firstName, "Имя");

        TextColumn<Person> lastName = new TextColumn<Person>() {
            @Override
            public String getValue(Person object) {
                return object.getLastName();
            }
        };
        lastName.setSortable(true);
        tablePersons.addColumn(lastName, "Фамилия");

        DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("dd.MM.yyyy");
        DateCell dateCell = new DateCell(dateTimeFormat);
        Column<Person, Date> birthDate = new Column<Person, Date>(dateCell) {
            @Override
            public Date getValue(Person object) {
                return object.getBirthDate();
            }
        };
        tablePersons.addColumn(birthDate, "Дата рождения");
    }

    private void refresh(){
        tablePersons.redraw();
        load();
    }

    private void load(){
        JavaBaseService.App.getInstance().getAllPersons(new AsyncCallback<List<Person>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Не удалось получить данные");
            }

            @Override
            public void onSuccess(List<Person> result) {
                tablePersons.setRowCount(result.size(), true);
                tablePersons.setRowData(0, result);
            }

        });
    }
}
