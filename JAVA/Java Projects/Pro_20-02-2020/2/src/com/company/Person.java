package com.company;

public class Person {
    String name;
    String addr;

    public Person() {
    }

    public Person(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }

    public String getName() {
        name="Say Rattana";
        return name;
    }

    public String getAddr() {
        addr="N63, Phnom Phen, Cambodia.";
        return addr;
    }

    public void setAddr(String addr) {

        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Person\t[" +
                "name='" + getName() + '\'' +
                ", address='" +getAddr() + '\'' +
                "]";
    }
}

