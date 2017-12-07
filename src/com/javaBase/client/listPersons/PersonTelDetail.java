package com.javaBase.client.listPersons;

import com.javaBase.server.pojo.PersonEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class PersonTelDetail {

    private int id;
    private String telType;
    private String telNumber;
    private int personByPersonId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelType() {
        return telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public int getPersonByPersonId() {
        return personByPersonId;
    }

    public void setPersonByPersonId(Person person) {
        this.personByPersonId = person.getID();
    }

    public void setPersonByPersonId(int personId) {
        this.personByPersonId = personId;
    }
}
