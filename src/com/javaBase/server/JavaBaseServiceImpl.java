package com.javaBase.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.javaBase.client.listPersons.Person;
import com.javaBase.client.JavaBaseService;
import com.javaBase.server.pojo.PersonEntity;
import com.javaBase.server.utils.HibernateSessionFactory;
import org.hibernate.Session;
import java.util.ArrayList;
import java.util.List;

public class JavaBaseServiceImpl extends RemoteServiceServlet implements JavaBaseService {

    @Override
    public void savePerson(Person person) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        PersonEntity personEntity = new PersonEntity();

        personEntity.setBirthDate(person.getBirthDate());
        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());

        session.save(personEntity);
        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void updatePerson(Person person) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        PersonEntity personEntity = session.get(PersonEntity.class, person.getID());

        personEntity.setBirthDate(person.getBirthDate());
        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());

        session.merge(personEntity);
        session.update(personEntity);

        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void deletePerson(Person person) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        PersonEntity personEntity = session.load(PersonEntity.class, person.getID());
        session.merge(personEntity);
        session.delete(personEntity);
        session.getTransaction().commit();

        session.close();
    }

    @Override
    public List<Person> getAllPersons(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        List<PersonEntity> personEntityList = new ArrayList<PersonEntity>(session.createCriteria(PersonEntity.class).list());

        session.getTransaction().commit();

        List<Person> personList = new ArrayList<>();

        for (PersonEntity personEntity:personEntityList){
            Person person = new Person();
            person.setID(personEntity.getId());
            person.setFirstName(personEntity.getFirstName());
            person.setLastName(personEntity.getLastName());
            person.setBirthDate(personEntity.getBirthDate());
            personList.add(person);
        }

        return personList;

    }

}
