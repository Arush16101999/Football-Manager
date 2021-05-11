package lk.cw.oop;
import java.util.Comparator;

public class PremierLeagueTableComparable implements Comparator<FootballClub> {//create comparator to sort points in descending

    @Override
    public int compare(FootballClub team1, FootballClub team2) {
        //comparing both scores
        if (team1.getNumberOfPoints() >team2.getNumberOfPoints()) {
            return -1;
        } else if (team1.getNumberOfPoints() <team2.getNumberOfPoints()){
            return 1;
        }else {
            //if points equal then check the goals different
            if (team1.getGoalDifference() > team2.getGoalDifference()){
                return -1;
            }else if (team1.getGoalDifference()<team2.getGoalDifference()){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
