package lk.cw.oop;

public class SchoolFootballClub extends FootballClub {
    int grade;


    //
    public SchoolFootballClub(String nameOfTheClub, String locationOfTheClub, int registrationNumber, int noOfWin,int goalDifference, int noOfDraw, int noOfDefeat, int numberOfGoalsReceived, int numberOfGoalsScored, int numberOfPoints, int numberOFMatches, int grade) {
        super(nameOfTheClub, locationOfTheClub, registrationNumber, noOfWin,goalDifference, noOfDraw, noOfDefeat, numberOfGoalsReceived, numberOfGoalsScored, numberOfPoints, numberOFMatches);
        this.grade = grade;
    }
    //
    public SchoolFootballClub() {

    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return  super.toString()+
                " Grade =" + grade+"\n";
    }
}
