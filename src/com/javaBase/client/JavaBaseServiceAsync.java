package com.javaBase.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.javaBase.client.listPersons.Person;

import java.util.List;

public interface JavaBaseServiceAsync {

    void savePerson(Person person, AsyncCallback<Void> async);

    void updatePerson(Person person, AsyncCallback<Void> async);

    void deletePerson(Person person, AsyncCallback<Void> async);

    void getAllPersons(AsyncCallback<List<Person>> async);
}
