package com.company;

public class Staff extends Person {
    String scholl;
    double pay;

    public Staff(String name, String addr, String scholl, double pay) {
        super(name, addr);
        this.scholl = scholl;
        this.pay = pay;
    }

    public Staff() {
    }

    public String getScholl() {
            scholl="Aptech Center";
        return scholl;
    }

    public void setScholl(String scholl) {
        this.scholl = scholl;
    }

    public double getPay() {
        pay =1250.00;
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Staff\t["+ super.toString()+
                ",\nscholl='" + getScholl() + '\'' +
                ", pay=" + getPay() +
                "]";
    }
}
