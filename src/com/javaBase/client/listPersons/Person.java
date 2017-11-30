package com.javaBase.client.listPersons;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Person implements Serializable{

    private int ID;
    private String firstName;
    private String lastName;
    private Date birthDate;

    public int getID(){
        return ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public Date getBirthDate(){
        return birthDate;
    }

    public void setBirthDate(Date birthDate){
        this.birthDate = birthDate;
    }

}
