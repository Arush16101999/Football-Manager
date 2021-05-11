package lk.cw.oop;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException,ClassNotFoundException { //create a main method to run the console menu

        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        try {
            //calling the method to load the file data
            premierLeagueManager.loadFile("League Details.txt");
            premierLeagueManager.loadMatch("Match Details.txt");
        } catch (FileNotFoundException ignored) {
            System.out.println(" No Details ");
        }


        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("                        **** Welcome to the FootBall Premier League Manager ***** ");
            System.out.println();
            System.out.println("             A - to add a new football club in the Premier league \n" +
                    "            D - to Delete s existing club from the premier league \n" +
                    "            V - to Display the various statics of a select club \n" +
                    "            T - to Display premier league table  \n" +
                    "            M - to add team to played match \n" +
                    "            G - to view GUI \n" +
                    "            Q - to Quite the program \n" +
                    "Enter Input : ");
            String menu = sc.next();

            switch (menu) {

                case "a"://runs the method inside League manager to add club
                    premierLeagueManager.addFootballClub();
                    break;

                case "d"://runs the method inside League manager to delete club
                    premierLeagueManager.deleteFootballClub();
                    break;

                case "v"://runs the method inside League manager to display club
                    premierLeagueManager.displayStatistic();
                    break;

                case "t"://runs the method inside League manager to view table
                    premierLeagueManager.displayPremierLeagueTable();
                    break;

                case "m"://runs the method inside League manager to add matches
                    premierLeagueManager.addPlayedMatch();
                    break;

                case "g":////runs the method inside League manager to open GUI
                    premierLeagueManager.gui();
                    break;

                case "q":
                    //Quits the program with saving the details
                    premierLeagueManager.saveToFile("League Details.txt");
                    premierLeagueManager.saveMatch("Match Details.txt");
                    System.out.println("             THANK YOU");
                    System.exit(0);
                    break;

                default: //default to get the re-enter option if it exceeds from a,d,v,t,s,q
                    System.out.println(" YOUR INPUT INVALID ");
                    System.out.println("ENTER a,d,v,t,s,q");
                    continue;

            }
        }
    }

}
