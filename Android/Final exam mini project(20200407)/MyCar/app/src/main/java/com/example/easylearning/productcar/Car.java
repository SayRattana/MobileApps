package com.example.easylearning.productcar;

public class Car {
    private String iD;
    private int carYear;
    private String CarName;
    private String carCompany;
    private String kindOfCar;
    private String ImageUrl;



    public Car() {
    }

    public Car(int carYear) {
        this.carYear = carYear;
    }

    public Car(int carYear, String carName) {
        this.carYear = carYear;
        CarName = carName;
    }

    public Car(int carYear, String carName, String imageUrl) {
        this.carYear = carYear;
        CarName = carName;
        ImageUrl = imageUrl;
    }

    public Car(String iD, int carYear,String carName, String imageUrl) {
        this.iD = iD;
        this.carYear= carYear;
        this.CarName = carName;
        this.ImageUrl = imageUrl;
    }

    public Car(int carYear, String carName, String carCompany, String kindOfCar) {
        this.carYear = carYear;
        CarName = carName;
        this.carCompany = carCompany;
        this.kindOfCar = kindOfCar;
    }

    public Car(int carYear, String carName, String carCompany, String kindOfCar, String imageUrl) {
        this.carYear = carYear;
        CarName = carName;
        this.carCompany = carCompany;
        this.kindOfCar = kindOfCar;
        ImageUrl = imageUrl;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public String getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    public String getKindOfCar() {
        return kindOfCar;
    }

    public void setKindOfCar(String kindOfCar) {
        this.kindOfCar = kindOfCar;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
