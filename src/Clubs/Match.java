package Clubs;
import java.io.Serializable;
import java.util.Date;


public class Match implements Serializable {
    FootballClub footballClub01;
    FootballClub footballClub02;
    private int scoreTeam01;
    private int scoreTeam02;
    private Date date;

    public Match(FootballClub footballClub01, FootballClub footballClub02, int scoreTeam01, int scoreTeam02, Date date) {
        this.footballClub01=footballClub01;
        this.footballClub02=footballClub02;
        this.scoreTeam01=scoreTeam01;
        this.scoreTeam02=scoreTeam02;
        this.date=date;

    }

    public Match() {

    }


    public FootballClub getFootballClub01(){
                return footballClub01;
    }

    public void setFootballClub01(FootballClub footballClub01) {
        this.footballClub01 = footballClub01;
    }

    public FootballClub getFootballClub02() {
        return footballClub02;
    }

    public void setFootballClub02(FootballClub footballClub02) {
        this.footballClub02 = footballClub02;
    }

    public int getScoreTeam01() {
        return scoreTeam01;
    }

    public void setScoreTeam01(int scoreTeam01) {
        this.scoreTeam01 = scoreTeam01;
    }

    public int getScoreTeam02() {
        return scoreTeam02;
    }

    public void setScoreTeam02(int scoreTeam02) {
        this.scoreTeam02 = scoreTeam02;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Match{" +
                "footballClub01=" + footballClub01 +
                ", footballClub02=" + footballClub02 +
                ", scoreTeam01=" + scoreTeam01 +
                ", scoreTeam02=" + scoreTeam02 +
                ", date=" + date +
                '}';
    }
}

