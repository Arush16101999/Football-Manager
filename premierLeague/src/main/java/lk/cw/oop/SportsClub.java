package lk.cw.oop;

import java.io.Serializable;

public abstract class SportsClub implements Serializable {
    private String nameOfTheClub;
    private String locationOfTheClub;
    private int registrationNumber;

    //
    public SportsClub(String nameOfTheClub, String locationOfTheClub, int registrationNumber) {
        this.nameOfTheClub = nameOfTheClub;
        this.locationOfTheClub = locationOfTheClub;
        this.registrationNumber = registrationNumber;
    }
    //
    public SportsClub() {

    }

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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        SportsClub that = (SportsClub) o;
//        return registrationNumber == that.registrationNumber &&
//                Objects.equals(nameOfTheClub, that.nameOfTheClub) &&
//                Objects.equals(locationOfTheClub, that.locationOfTheClub);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(nameOfTheClub, locationOfTheClub, registrationNumber);
//    }

    @Override
    public String toString() {
        return
                " Club Name    =" + nameOfTheClub + '\'' +
                " Club Location =" + locationOfTheClub + '\'' +
                " Registration Number =" + registrationNumber;
    }


}
