package lk.cw.oop;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class FootballClubRepository {
    String leagueFileName = "E:\\2ND Year\\OOP\\w1761076_CW\\CW_OOP_\\League Details.txt";
    String matchFileName = "E:\\2ND Year\\OOP\\w1761076_CW\\CW_OOP_\\Match Details.txt";

    public FootballClubRepository(){


        //
        try {
            this.loadFile(leagueFileName);
            this.loadMatch(matchFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ArrayList<FootballClub> details=new ArrayList<FootballClub>();
    ArrayList<PlayedMatch> playedMatches=new ArrayList<>();



    public void loadFile(String fileName)throws IOException,ClassNotFoundException{
        FileInputStream fis=new FileInputStream(fileName);
        ObjectInputStream ois=new ObjectInputStream(fis);

        for (;;){
            try{
                FootballClub LoadClub= (FootballClub) ois.readObject();
                details.add(LoadClub);

            }catch (EOFException e){
                break;
            }
        }
        fis.close();
        ois.close();

    }

    public void sortTable(){
        details.sort(new PremierLeagueTableComparable());
    }

    public void sortDetail(){
        Collections.sort(details, Comparator.comparing(FootballClub::getNumberOfGoalsScored).reversed());
    }

    public void sortWin(){
        Collections.sort(details, Comparator.comparing(FootballClub::getNoOfWin).reversed());
    }

    public void displayDateMatch(){
        Collections.sort(playedMatches,Comparator.comparing(PlayedMatch::getMatchDate));
    }

    public void loadMatch(String fileName) throws IOException {
        FileInputStream fileInputStream=new FileInputStream(fileName);
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);

        for (; ; ){
            try{
                PlayedMatch match=(PlayedMatch) objectInputStream.readObject();
                playedMatches.add(match);

            } catch (Exception e) {
//                e.printStackTrace();
                break;
            }
        }
        fileInputStream.close();
        objectInputStream.close();


    }

    public FootballClub findOne(String clubName){
        for (FootballClub footballClub:details){
            if (footballClub.getNameOfTheClub().contains(clubName)){
                return footballClub;
            }
        }
        return null;
    }


    public PlayedMatch addPlayedMatch(Date date, FootballClub teamA, FootballClub teamB, int AGoals, int BGoals ) {


        PlayedMatch playedMatch = new PlayedMatch(teamA, teamB, AGoals, BGoals,date);

        int teamAindex = details.indexOf(teamA);
        int teamBindex = details.indexOf(teamB);

        //
        details.get(teamAindex).setNumberOfGoalsScored(teamA.getNumberOfGoalsScored() + AGoals);
        details.get(teamBindex).setNumberOfGoalsScored(teamB.getNumberOfGoalsScored() + BGoals);

        details.get(teamAindex).setNumberOfGoalsReceived(teamA.getNumberOfGoalsReceived() + BGoals);
        details.get(teamBindex).setNumberOfGoalsReceived(teamB.getNumberOfGoalsReceived() + AGoals);

        details.get(teamAindex).setNumberOFMatches(teamA.getNumberOFMatches() + 1);
        details.get(teamBindex).setNumberOFMatches(teamB.getNumberOFMatches() + 1);

        //
        if (AGoals > BGoals) {
            details.get(teamAindex).setNumberOfPoints(teamA.getNumberOfPoints() + 3);
            details.get(teamAindex).setNoOfWin(teamA.getNoOfWin() + 1);
            details.get(teamBindex).setNoOfDefeat(teamB.getNoOfDefeat() + 1);
            //
        } else if ((AGoals < BGoals)) {
            details.get(teamBindex).setNumberOfPoints(teamB.getNumberOfPoints() + 3);
            details.get(teamBindex).setNoOfWin(teamB.getNoOfWin() + 1);
            details.get(teamAindex).setNoOfDefeat(teamA.getNoOfDefeat() + 1);
            //
        }
        //
        else {
            details.get(teamAindex).setNumberOfPoints(teamA.getNumberOfPoints() + 1);
            details.get(teamAindex).setNoOfDraw(teamA.getNoOfDraw() + 1);
            details.get(teamBindex).setNumberOfPoints(teamB.getNumberOfPoints() + 1);
            details.get(teamBindex).setNoOfDraw(teamB.getNoOfDraw() + 1);
            //
        }

        playedMatches.add(playedMatch);

        try {
            saveMatch();
            saveToFile();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return playedMatch;


    }

    public void saveMatch() throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream(matchFileName);
        ObjectOutputStream outputStream=new ObjectOutputStream(fileOutputStream);

        for (PlayedMatch match:playedMatches){
            outputStream.writeObject(match);
        }
        outputStream.flush();
        fileOutputStream.close();
        outputStream.close();


    }

    public void saveToFile() throws IOException {
        FileOutputStream fos=new FileOutputStream(leagueFileName);
        ObjectOutputStream oos=new ObjectOutputStream(fos);

        for (FootballClub saveClub:details){
            oos.writeObject(saveClub);
        }
        oos.flush();
        fos.close();
        oos.close();

    }

    public PlayedMatch generateRandom(){
        int total = details.size();

        Random rand = new Random();

        int random_num1 = rand.nextInt(total);

        FootballClub randomTeamA = details.get(random_num1);

        int random_num2 = rand.nextInt(total);

        while (random_num2 == random_num1){
            random_num2 = rand.nextInt(total);
        }

        FootballClub randomTeamB = details.get(random_num2);

        int randomTeamAGoals = rand.nextInt(10);
        int randomTeamBGoals = rand.nextInt(10);

        Date randomD=new Date();
        try {
            randomD=RandomDate.createRandomDate(2018,2020);
        }catch(ParseException e){
            e.printStackTrace();
        }

        PlayedMatch playedMatch = addPlayedMatch(randomD, randomTeamA, randomTeamB, randomTeamAGoals, randomTeamBGoals);

        playedMatches.add(playedMatch);
        return playedMatch;




    }





}
