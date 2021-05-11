package lk.cw.oop;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;
import java.util.Date;
import java.util.Scanner;

public class PremierLeagueManager implements PremierLeague{//creating the premier league manager class to implement the interface PremierLeague
//creating the array lists and local variables to use inside the class
    private ArrayList<FootballClub> details=new ArrayList<FootballClub>();
    private ArrayList<PlayedMatch> playedMatches=new ArrayList<>();
    public static final int matchCount = 20; //limitation of adding club
    private long available;

    Scanner scanner=new Scanner(System.in);


    @Override
    public void addFootballClub(){//override the add football club method from console menu

        available=matchCount-(details.size());
        System.out.println(" Currently the number of Clubs you can add In Premier League is || "+available+" || ");
        System.out.println();


        if (details.size()<matchCount){//the if condition works until the club count is less than matchCount
            System.out.println("The Football club type you can add \n 1)University \n " +
                    "2)School \n 3)Bach To Menu");

            int choice=read(scanner);
            if (choice==1) {//if choice is 1 can prompt university club details
                System.out.println("Enter University Football club Name: ");
                String uniName = scanner.next();
                FootballClub testName=new UniversityFootballClub();

                testName.setNameOfTheClub(uniName);
                if (details.contains(testName)){//checking whether adding club is already in the list
                    System.out.println(" Entered Club is Already in the league");
                    addFootballClub();
                    return;
                }

                System.out.println("Location of Club: ");
                String uniLocation = scanner.next();

                System.out.println("Enter Registration Number:");
                int regNumber = read(scanner);

                System.out.println("Enter Age (Under 23) : ");
                int uniAge = read(scanner);

                System.out.println("SUCCESSFULLY ADDED "+uniName +" CLUB TO THE LEAGUE");
                System.out.println();

                FootballClub university = new UniversityFootballClub(uniName, uniLocation, regNumber, 0,0, 0, 0, 0, 0, 0, 0, uniAge);
                // University Football Club should contain under 23 Age limits
                if (uniAge < 23 && uniAge > 18) {
                    details.add(university);
                    System.out.println(details);
                } else {
                    System.out.println("your Age " + uniAge + " is not valid for University Football Club");
                    System.out.println();
                    addFootballClub();
                }


            }else if (choice==2){//if choice is 2 prompt for school club details
                System.out.println("Enter School Football club Name: ");
                String schlName=scanner.next();
                FootballClub testName=new SchoolFootballClub();

                testName.setNameOfTheClub(schlName);
                if (details.contains(testName)){//checking whether adding club is already in the list
                    System.out.println("Entered Club is Already in the league");
                    addFootballClub();
                    return;

                }

                System.out.println("Location of Club: ");
                String schlLocation=scanner.next();

                System.out.println("Enter Registration Number:");
                int regNumber=read(scanner);

                System.out.println("Enter Grade (Under 18) : ");
                int schlGrade=read(scanner);

                System.out.println("SUCCESSFULLY ADDED "+schlName +" CLUB TO THE LEAGUE ");
                System.out.println();

                FootballClub school=new SchoolFootballClub(schlName,schlLocation,regNumber,0,0,0,0,0,0,0,0,schlGrade);
                // School Football Club should contain under 18 Age limits
                if (schlGrade<18 && schlGrade>14){
                    details.add(school);
                    System.out.println(details);
                }else{
                    System.out.println("your Age "+schlGrade +" is not valid for School Football Club");
                    System.out.println();
                    addFootballClub();
                }

            }else if (choice==3){//if choice 3 go back to main menu
                System.out.println("Back to Menu");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");

            } else{//if choice exceed from 1,2,3 throw error message
                System.out.println("invalid Input");
            }
        }else{
            System.out.println("SLOTS ARE not Available to ADD please TRY AGAIN LATER"+"\n");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }

    }


    //reading the scanner method to get integer values where its needed
    private int read(Scanner scanner) {

        while (!scanner.hasNextInt()){
            System.out.println("You have Entered  invalid input !! Please Enter the Number" +
                    "\n Re-Enter :");
            scanner.next();
        }
        return scanner.nextInt();
    }


    @Override
    public void deleteFootballClub(){//override the delete football club method from console menu and delete the club by taking the name
        System.out.println(details);
        System.out.println();
        System.out.println("Enter the Club Name : ");
        String deleteClub=scanner.next();

        for (FootballClub sportsClub:details) {//loop initialize the details of football club

            if (sportsClub.getNameOfTheClub().equals(deleteClub)){//check if entering club name is in the list
                //then alert message to delete or not
                System.out.println("Do You Want To Delete Club");
                System.out.println("Yes / No");
                String option = scanner.next();
                if (option.equals("yes")){//if choice yes club will delete from list
                    details.remove(sportsClub);
                    System.out.println(details);

                    available = matchCount - (details.size());//checking available number of count after deleting the club
                    System.out.println(" Currently the number of Clubs you can add In Premier League is || " + available + " || ");
                    System.out.println("______________________________________________________________________________________");
                    System.out.println(sportsClub.getNameOfTheClub() + " Successfully Deleted From The League");
                    System.out.println();
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    return;
                }
                else {
                    System.out.println("No club Deleted From League");
                }
            }
        }
        System.out.println("Entered club " + deleteClub + " is not in the Premier League ");

    }


    @Override
    public void displayStatistic(){//override the display statistic method from console menu and print the details by taking array list
        System.out.println("Enter a Specific Club Name to Display the Statistic : ");
        String clubName=scanner.next();

        for (FootballClub sportsClub:details){
            if (sportsClub.getNameOfTheClub().contains(clubName)){//checking whether the club is in the array list
                System.out.println(" Here We go with Your Club Statistic ");
                System.out.println();
                System.out.println("Club - "+sportsClub.getNameOfTheClub()+ " ||"+
                        " Location - "+sportsClub.getLocationOfTheClub()+ " || "+
                        " Registration Number - "+sportsClub.getRegistrationNumber() +" || "+
                        " Win - "+sportsClub.getNoOfWin()+" || "+ "Points - "+sportsClub.getNumberOfPoints()+" || "+" Goal Scored - "+sportsClub.getNumberOfGoalsScored());
                System.out.println();
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                return;
            }
        }

        System.out.println(" Entered Club "+ clubName + " Is not IN the League ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();

    }


    @Override
    public void displayPremierLeagueTable(){//override the display premier league table method from console menu and print the table of club details
        //https://stackoverflow.com/questions/4258700/collections-sort-with-multiple-fields
        details.sort(new PremierLeagueTableComparable());//sorting the table by comparable method points and goal difference descending order

        System.out.println("                                       - WELCOME TO THE POINTS TABLE OF PREMIER LEAGUE -");
        System.out.println();
            System.out.println("\tClub \t|\t\t Points \t|\t Goal Difference \t|\t Match \t|\t Defeat \t|\t Draw \t|\t Win \t|\t Recieve Goal \t|\t Scored Goal ");
            System.out.println("  _________________________________________________________________________________________________________________________________________________");
        for (FootballClub footballClub:details){

            System.out.println("\t"+footballClub.getNameOfTheClub()+"\t|\t\t\t"
                    +footballClub.getNumberOfPoints()+"\t\t|\t\t\t"
                    +(footballClub.getGoalDifference())+"\t\t\t|\t\t"
                    +footballClub.getNumberOFMatches()+"\t|\t\t"
                    +footballClub.getNoOfDefeat()+"\t\t|\t\t"
                    +footballClub.getNoOfDraw()+"\t|\t   "
                    +footballClub.getNoOfWin()+"\t|\t\t"
                    +footballClub.getNumberOfGoalsReceived()+"\t\t\t|\t\t"
                    +footballClub.getNumberOfGoalsScored()+"\t\t|");
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }


    @Override
    public void addPlayedMatch() {//overriding the add played match from console menu and add the match

        System.out.println("Enter date IN (format mm-dd-yyyy): ");
        String dateFormat = scanner.nextLine();
        System.out.println();
        Date date;
        try {
            //https://stackoverflow.com/questions/30454933/how-to-correctly-create-a-date-with-a-specific-format
            date = new SimpleDateFormat("MM-dd-yyyy").parse(dateFormat);//creating a date format
        } catch (ParseException ex) {
            System.out.println("You Have Entered Invalid Date \n" +
                    "You have to enter date in this format (mm-dd-yyyy)");
            System.out.println();
            return;
        }

        System.out.println("Enter Club A - ");
        String clubA = scanner.next();
        FootballClub teamA = null;
        for (FootballClub ClubMatch : details) {
            if (ClubMatch.getNameOfTheClub().equals(clubA)) {
                teamA = ClubMatch;
            }
        }

        if (teamA == null) {
            System.out.println(" Club is not in the League");
            return;
        }

        System.out.println("Enter Club B - ");
        String clubB = scanner.next();
        FootballClub teamB = null;
        for (FootballClub ClubMatch : details) {
            if (ClubMatch.getNameOfTheClub().equals(clubB)) {
                teamB = ClubMatch;
            }
        }

        if (teamB == null) {
            System.out.println("Club is not in the League");
            return;
        }


        System.out.println("Enter Club A Goals - ");
        int goalsOfClubA = scanner.nextInt();
        int AGoals = 0;
        try {
            AGoals = goalsOfClubA;
        } catch (Exception e) {
            System.out.println("Invalid Score number");
        }

        if (AGoals < 0) {//score should be above 0
            System.out.println("Score should be Above 0");
            return;
        }

        System.out.println("Enter Club B Goals - ");
        int goalsOfClubB = scanner.nextInt();
        int BGoals = 0;//initialize a variable for ClubB
        try {
            BGoals = goalsOfClubB;
        } catch (Exception e) {
            System.out.println("Invalid Score number");
        }
        if (BGoals < 0) {//score should be above 0
            System.out.println("Score should be Above 0");
            return;
        }

        PlayedMatch playedMatch = new PlayedMatch(teamA, teamB, AGoals, BGoals,date);

        //setting entered score number of goals to teamA and teamB
        teamA.setNumberOfGoalsScored(teamA.getNumberOfGoalsScored() + AGoals);
        teamB.setNumberOfGoalsScored(teamB.getNumberOfGoalsScored() + BGoals);
        //setting received goals for each team
        teamA.setNumberOfGoalsReceived(teamA.getNumberOfGoalsReceived() + BGoals);
        teamB.setNumberOfGoalsReceived(teamB.getNumberOfGoalsReceived() + AGoals);
        //adding the matches by the number of time playing team
        teamA.setNumberOFMatches(teamA.getNumberOFMatches() + 1);
        teamB.setNumberOFMatches(teamB.getNumberOFMatches() + 1);

        if (AGoals > BGoals){//if a goals higher than b goals initialize the details
            teamA.setNumberOfPoints(teamA.getNumberOfPoints() + 3);//points increase by 3
            teamA.setNoOfWin(teamA.getNoOfWin() + 1);//win increase by 1
            teamB.setNoOfDefeat(teamB.getNoOfDefeat() + 1);//defeat increase by 1 for opponent team
            System.out.println("Club A is Leading");
        } else if ((AGoals < BGoals)) {
            teamB.setNumberOfPoints(teamB.getNumberOfPoints() + 3);
            teamB.setNoOfWin(teamB.getNoOfWin() + 1);
            teamA.setNoOfDefeat(teamA.getNoOfDefeat() + 1);
            System.out.println("Club B is Leading");
        }

        else {//if the match between two teams get tie each team get 1 points and increase the draw count by 1
            teamA.setNumberOfPoints(teamA.getNumberOfPoints() + 1);
            teamA.setNoOfDraw(teamA.getNoOfDraw() + 1);
            teamB.setNumberOfPoints(teamB.getNumberOfPoints() + 1);
            teamB.setNoOfDraw(teamB.getNoOfDraw() + 1);
            //
            System.out.println("Match Draw");
        }
        playedMatches.add(playedMatch);//adding the data to array list
        System.out.println(playedMatches);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }

    @Override
    public void saveToFile(String ClubDetails) throws IOException {//using object serializable to save data to text file
        FileOutputStream fos=new FileOutputStream(ClubDetails);
        ObjectOutputStream oos=new ObjectOutputStream(fos);

        for (FootballClub saveClub:details){
            oos.writeObject(saveClub);
        }
        oos.flush();
        fos.close();
        oos.close();

        System.out.println(" All the Data has Saved Successfully ");
    }

    @Override
    public void saveMatch(String matchDetails) throws IOException {//using object serializable to save data to text file
        FileOutputStream fileOutputStream=new FileOutputStream(matchDetails);
        ObjectOutputStream outputStream=new ObjectOutputStream(fileOutputStream);

        for (PlayedMatch match:playedMatches){
            outputStream.writeObject(match);
        }
        outputStream.flush();
        fileOutputStream.close();
        outputStream.close();

        System.out.println("Match Saved");

    }

    @Override
    public void loadFile(String ClubDetails)throws IOException,ClassNotFoundException{
        FileInputStream fis=new FileInputStream(ClubDetails);
        ObjectInputStream ois=new ObjectInputStream(fis);

        for (;;){
            try{
                FootballClub LoadClub= (FootballClub) ois.readObject();
                details.add(LoadClub);
                System.out.println(LoadClub);

                }catch (EOFException e){
                break;
            }
        }
        fis.close();
        ois.close();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" Data Successfully Loaded ");
        System.out.println();
    }

    @Override
    public void loadMatch(String matchDetails) throws IOException {
        FileInputStream fileInputStream=new FileInputStream(matchDetails);
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);

        for (; ; ){
            try{
                PlayedMatch match=(PlayedMatch) objectInputStream.readObject();
                playedMatches.add(match);
                System.out.println(match);

            } catch (Exception e) {
//                e.printStackTrace();
                break;
            }
        }
        fileInputStream.close();
        objectInputStream.close();
        System.out.println("Match data Loaded");
    }

    @Override
    public void gui(){//overriding to display gui from console
        try {
            Desktop openDesktop=java.awt.Desktop.getDesktop();
            URI openUri=new URI("http://localhost:4200/home");//localhost link of angular
            openDesktop.browse(openUri);
        } catch (Exception e){
            System.out.println("Connection Error");
        }
    }
}
