package com.company;

public class Main {

    public static void main(String[] args) {
	    Person person = new Person();
	    Student student = new Student();
	    Staff staff = new Staff();

	    System.out.println("\n"+ person.toString()+".\n"+
				           "\n"+ student.toString()+".\n"+
				           "\n"+ staff.toString()+".");

    }
}
