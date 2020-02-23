package com.company;

public class Student extends Person {
    String program;
    int year;
    double fee;

    public Student(String name, String addr, String program, int year, double fee) {
        super(name, addr);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public Student() {

    }

    public String getProgram() {
        program="Java Language";
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        year=2020;
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFee() {
        fee=1250.99;
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student\t[" + super.toString()+
                ",\nprogram='" + getProgram()+ '\'' +
                ", year=" + getYear() +
                ", fee= $" + getFee() +
                "]";
    }
}
