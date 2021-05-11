package lk.cw.oop;

import java.io.Serializable;

public abstract class SportsClub implements Serializable {//creating a sports club  class and initialize the common attributes of sub-classes
    private String nameOfTheClub;
    private String locationOfTheClub;
    private int registrationNumber;

    //create the constructor for the attributes inside the sports club class
    public SportsClub(String nameOfTheClub, String locationOfTheClub, int registrationNumber) {
        this.nameOfTheClub = nameOfTheClub;
        this.locationOfTheClub = locationOfTheClub;
        this.registrationNumber = registrationNumber;
    }

    public SportsClub(){//create a default constructor of sports club class
    }
    //defining the getters and setters for sports club class
    public String getNameOfTheClub() {
        return nameOfTheClub;
    }

    public String getLocationOfTheClub() {
        return locationOfTheClub;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setNameOfTheClub(String nameOfTheClub) {
        this.nameOfTheClub = nameOfTheClub;
    }

    public void setLocationOfTheClub(String locationOfTheClub) {
        this.locationOfTheClub = locationOfTheClub;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }


    //adding the to string method to vehicle class
    @Override
    public String toString() {
        return
                " Club Name    =" + nameOfTheClub + '\'' +
                " Club Location =" + locationOfTheClub + '\'' +
                " Registration Number =" + registrationNumber;
    }


}
