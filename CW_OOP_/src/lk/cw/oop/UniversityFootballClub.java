package lk.cw.oop;

public class UniversityFootballClub extends FootballClub {//creating a subclass of football club class and initialize the variables
    int age;


    //calling the super class constructors inside the subclass and creating the constructor
    public UniversityFootballClub(String nameOfTheClub, String locationOfTheClub, int registrationNumber, int noOfWin,int goalDifference ,int noOfDraw, int noOfDefeat, int numberOfGoalsReceived, int numberOfGoalsScored, int numberOfPoints, int numberOFMatches, int age) {
        super(nameOfTheClub, locationOfTheClub, registrationNumber, noOfWin,goalDifference, noOfDraw, noOfDefeat, numberOfGoalsReceived, numberOfGoalsScored, numberOfPoints, numberOFMatches);
        this.age = age;
    }
    //creating a default constructor
    public UniversityFootballClub() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return  super.toString()+
                " Age =" + age+"\n";
    }
}
