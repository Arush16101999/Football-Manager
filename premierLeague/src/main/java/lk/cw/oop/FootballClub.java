package lk.cw.oop;

import java.util.Objects;


public class FootballClub extends SportsClub {

    private int noOfWin=0;
    private int noOfDraw=0;
    private int noOfDefeat=0;
    private int numberOfGoalsReceived=0;
    private int numberOfGoalsScored=0;
    private int numberOfPoints=0;
    private int numberOFMatches=0;
    private int goalDifference=0;

    //
    public FootballClub(String nameOfTheClub, String locationOfTheClub, int registrationNumber, int noOfWin, int goalDifference, int noOfDraw, int noOfDefeat, int numberOfGoalsReceived, int numberOfGoalsScored, int numberOfPoints, int numberOFMatches) {
        super(nameOfTheClub, locationOfTheClub, registrationNumber);
        this.noOfWin = noOfWin;
        this.goalDifference=goalDifference;
        this.noOfDraw = noOfDraw;
        this.noOfDefeat = noOfDefeat;
        this.numberOfGoalsReceived = numberOfGoalsReceived;
        this.numberOfGoalsScored = numberOfGoalsScored;
        this.numberOfPoints = numberOfPoints;
        this.numberOFMatches = numberOFMatches;
    }

    //
    public FootballClub() {
        super();
    }

    public int getGoalDifference() {
        return getNumberOfGoalsScored()-getNumberOfGoalsReceived();
    }

    public int getNoOfWin() {
        return noOfWin;
    }

    public int getNoOfDraw() {
        return noOfDraw;
    }

    public int getNoOfDefeat() {
        return noOfDefeat;
    }

    public int getNumberOfGoalsReceived() {
        return numberOfGoalsReceived;
    }

    public int getNumberOfGoalsScored() {
        return numberOfGoalsScored;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public int getNumberOFMatches() {
        return numberOFMatches;
    }

    public void setNoOfWin(int noOfWin) {
        this.noOfWin = noOfWin;
    }

    public void setNoOfDraw(int noOfDraw) {
        this.noOfDraw = noOfDraw;
    }

    public void setNoOfDefeat(int noOfDefeat) {
        this.noOfDefeat = noOfDefeat;
    }

    public void setNumberOfGoalsReceived(int numberOfGoalsReceived) {
        this.numberOfGoalsReceived = numberOfGoalsReceived;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }

    public void setNumberOfGoalsScored(int numberOfGoalsScored) {
        this.numberOfGoalsScored = numberOfGoalsScored;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public void setNumberOFMatches(int numberOFMatches) {
        this.numberOFMatches = numberOFMatches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FootballClub)) return false;
        FootballClub that = (FootballClub) o;
        return getNameOfTheClub().equals(that.getNameOfTheClub());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameOfTheClub());
    }


    @Override
    public String toString() {
        return  super.toString()+
                " Won =" + noOfWin +
                " Goal Difference ="+goalDifference+
                " Draw =" + noOfDraw +
                " Defeat =" + noOfDefeat +
                " GoalsReceived =" + numberOfGoalsReceived +
                " GoalsScored =" + numberOfGoalsScored +
                " Points =" + numberOfPoints +
                " Matches =" + numberOFMatches +"\n";
    }
}
