package com.company;

import java.util.List;

public class Person implements Comparable<Person> {
    public String fName;
     String lName;
     int age;
    public Person(String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
       this.age = age;
    }

    public Person() {

    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int compareTo(Person obj) {
        Person e = (Person) obj;

        if (this.fName.equals(e.getfName())) {
            return this.lName.compareTo(e.getfName());
        } else {
            return this.fName.compareTo(e.getfName());
        }
    }



}
