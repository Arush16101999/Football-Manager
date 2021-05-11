package lk.cw.oop;
import java.io.Serializable;
import java.util.Date;

public class PlayedMatch implements Serializable {
    private FootballClub ClubA;
    private FootballClub ClubB;
    private int ClubAScore;
    private int ClubBScore;
    private Date matchDate;


    public PlayedMatch(FootballClub clubA, FootballClub clubB, int clubAScore, int clubBScore, Date matchDate) {
        this.ClubA = clubA;
        this.ClubB = clubB;
        this.ClubAScore = clubAScore;
        this.ClubBScore = clubBScore;
        this.matchDate=matchDate;

    }
    public PlayedMatch(){

    }


    public FootballClub getClubA() {
        return ClubA;
    }

    public FootballClub getClubB() {
        return ClubB;
    }

    public int getClubAScore() {
        return ClubAScore;
    }

    public int getClubBScore() {
        return ClubBScore;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setClubA(FootballClub clubA) {
        ClubA = clubA;
    }

    public void setClubB(FootballClub clubB) {
        ClubB = clubB;
    }

    public void setClubAScore(int clubAScore) {
        ClubAScore = clubAScore;
    }

    public void setClubBScore(int clubBScore) {
        ClubBScore = clubBScore;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    @Override
    public String toString() {
        return "            Played Match \n" +
                "____________________________________ \n"+
                " Club A -> " + ClubA +" Club A Score = " + ClubAScore +"\n"+
                " Club B -> " + ClubB +" Club B Score = " + ClubBScore +"\n"+
                " Match Date = " + matchDate +"\n";
    }
}
