package com.javaBase.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.javaBase.client.listPersons.TablePersons;

public class AppMain implements EntryPoint {

    public void onModuleLoad() {

        TablePersons startPanel = new TablePersons();

        RootPanel.get().add(startPanel);
    }

}
