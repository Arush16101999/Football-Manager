package lk.cw.oop;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface PremierLeague {//creating the interface of premier league manager
    void addFootballClub() throws FileNotFoundException;
    void deleteFootballClub();
    void displayStatistic();
    void displayPremierLeagueTable();
    void addPlayedMatch();
    void saveToFile(String ClubDetails) throws IOException;
    void saveMatch(String matchDetails) throws IOException;
    void loadFile(String ClubDetails) throws IOException,ClassNotFoundException;
    void loadMatch(String matchDetails) throws IOException;
    void gui();

}
