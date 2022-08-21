package com.axceldev.model;

public class Person {

    private int idPerson;
    private String namePerson;
    private Integer agePerson;

    public Person(int idPerson, String namePerson, Integer agePerson) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.agePerson = agePerson;
    }

    public int getIdPerson() {
        return idPerson;
    }
    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }
    public String getNamePerson() {
        return namePerson;
    }
    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }
    public Integer getAgePerson() {
        return agePerson;
    }
    public void setAgePerson(Integer agePerson) {
        this.agePerson = agePerson;
    }

    @Override
    public String toString() {
        return "Person [agePerson=" + agePerson + ", idPerson=" + idPerson + ", namePerson=" + namePerson + "]";
    }
      
}
