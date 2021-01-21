package LeaugeManager;

import Clubs.FootballClub;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.IOException;

public interface LeagueManager {
    public void  addFootBallClub(FootballClub footballClub);
    public boolean deleteFootBallClub(String footBallClubName);
    public void  clubStatistics(String clubName);
    public void displayPremierLeagueTable() throws Exception;
    public void saveFile() throws IOException;
    public void loadFile() throws IOException, ClassNotFoundException;
    public void addPlayedMatch();
}

