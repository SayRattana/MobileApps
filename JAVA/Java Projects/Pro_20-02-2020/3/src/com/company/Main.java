package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        List<Person> myList = new ArrayList<Person>();
        myList.add(new Person("Say   ", "Rattana", 40));
        myList.add(new Person("Robert", "Stalling", 22));
        myList.add(new Person("Andrew", "Anderson", 19));
        myList.add(new Person("Harish", "Samtani", 45));

        System.out.println("\n>> Before sort:");
        for (Person person : myList) {
            System.out.println("\tFirstname: " + person.getfName() + "\tLastname: " + person.getlName() +
                    "\tAge: " + person.getAge());
        }

        System.out.println("\n>> After sort by first name:");
        Collections.sort(myList);
        for (Person person : myList) {
            System.out.println("\tFirstname: " + person.getfName() + "\tLastname: " + person.getlName() +
                    "\tAge: " + person.getAge());
        }


    }
}
















