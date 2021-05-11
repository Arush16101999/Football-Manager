package lk.cw.oop;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge =5000 )
@RestController
@RequestMapping("/footballclubs")
public class FootballClubController {

    private FootballClubRepository footballClubRepository = new FootballClubRepository();


    @GetMapping
    public List<FootballClub> getAllClubs() {

        return footballClubRepository.details;


    }

    @GetMapping("/sort")
    public List<FootballClub> getAllClubsSorted() {
        footballClubRepository.sortTable();
        return footballClubRepository.details;

    }

    @GetMapping("/goal")
    public List<FootballClub> getGoalSort(){
        footballClubRepository.sortDetail();
        return footballClubRepository.details;
    }

    @GetMapping("/win")
    public List<FootballClub> getWinSort(){
        footballClubRepository.sortWin();
        return footballClubRepository.details;
    }

    @GetMapping("/random")
    public PlayedMatch generateRandomMatch() {

        return footballClubRepository.generateRandom();


    }

    //
    @GetMapping(value = "/{name}")
    public FootballClub getOne(@PathVariable String name) {

        return footballClubRepository.findOne(name);

    }

    @GetMapping("/matches")
    public List<PlayedMatch> getAllPlayedMatches(){
        footballClubRepository.displayDateMatch();

        return footballClubRepository.playedMatches;
    }







}
