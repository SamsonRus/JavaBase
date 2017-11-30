package com.javaBase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.javaBase.client.listPersons.Person;
import java.util.List;

@RemoteServiceRelativePath("javaBaseServiceImpl")
public interface JavaBaseService extends RemoteService {

    void savePerson(Person person);

    void updatePerson(Person person);

    void deletePerson(Person person);

    List<Person> getAllPersons();

    /**
     * Utility/Convenience class.
     * Use JavaBaseService.App.getInstance() to access static instance of JavaBaseServiceAsync
     */
    class App {
        private static JavaBaseServiceAsync ourInstance = GWT.create(JavaBaseService.class);

        public static synchronized JavaBaseServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
