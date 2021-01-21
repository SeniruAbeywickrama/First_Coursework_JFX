package Clubs;


import java.util.Date;
import java.util.Objects;

public class FootballClub extends SportsClub implements Comparable<FootballClub> {
    private String team01;
    private String team02;
    private int noOfWins=0;
    private int noOfDraws=0;
    private int noOfDefeats=0;
    private int receivedGoals=0;
    private int scoredGoals=0;
    private int numberOfPoints=0;
    private int numberOfPlayedMatches=0;


    //constructor for Footballclub
    public FootballClub(String clubName, String clubLocation, String team01, String team02, int noOfWins, int noOfDraws,
                        int noOfDefeats, int receivedGoals, int scoredGoals, int numberOfPoints, int numberOfPlayedMatches) {

        super(clubName, clubLocation);
        this.team01 = team01;
        this.team02 = team02;
        this.noOfWins = noOfWins;
        this.noOfDraws = noOfDraws;
        this.noOfDefeats = noOfDefeats;
        this.receivedGoals = receivedGoals;
        this.scoredGoals = scoredGoals;
        this.numberOfPoints = numberOfPoints;
        this.numberOfPlayedMatches = numberOfPlayedMatches;
    }

    //constructor for point table
    public FootballClub(String clubName,int numberOfPlayedMatches, int noOfWins, int noOfDraws,
                        int noOfDefeats,int scoredGoals,int receivedGoals,int numberOfPoints){
        super(clubName);
        this.numberOfPlayedMatches = numberOfPlayedMatches;
        this.noOfWins = noOfWins;
        this.noOfDraws = noOfDraws;
        this.noOfDefeats = noOfDefeats;
        this.scoredGoals = scoredGoals;
        this.receivedGoals = receivedGoals;
        this.numberOfPoints = numberOfPoints;

    }

    public FootballClub() {
        super();
    }


    //getter for team01
    public String getTeam01() {
        return team01;
    }

    //setter for team01
    public void setTeam01(String team01) {
        this.team01 = team01;
    }

    public String getTeam02() {
        return team02;
    }

    public void setTeam02(String team02) {
        this.team02 = team02;
    }

    public int getNoOfWins() {
        return noOfWins;
    }

    public void setNoOfWins(int noOfWins) {
        this.noOfWins = noOfWins;
    }

    public int getNoOfDraws() {
        return noOfDraws;
    }

    public void setNoOfDraws(int noOfDraws) {
        this.noOfDraws = noOfDraws;
    }

    public int getNoOfDefeats() {
        return noOfDefeats;
    }

    public void setNoOfDefeats(int noOfDefeats) {
        this.noOfDefeats = noOfDefeats;
    }


    public int getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    public int getReceivedGoals() {
        return receivedGoals;
    }

    public void setReceivedGoals(int recivedGoals) {
        this.receivedGoals = recivedGoals;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public int getNumberOfPlayedMatches() {
        return numberOfPlayedMatches;
    }

    public void setNumberOfPlayedMatches(int numberOfPlayedMatches) {
        this.numberOfPlayedMatches = numberOfPlayedMatches;
    }


    @Override
    public String toString() {
        return "FootBall Club-->("+super.toString()+" NoOfWins =" + noOfWins + ", NoOfDraws =" + noOfDraws + ", NoOfDefeats=" + noOfDefeats + ", Team 01 =" + team01 + ", Team 02 =" + team02 +
                ",Scored Goals=" + scoredGoals + ",RecivedGoals=" + receivedGoals + ", NumberOfPoints=" + numberOfPoints +
                ", NumberOfPlayedMatches=" + numberOfPlayedMatches+")";
    }



    @Override
    public int compareTo(FootballClub o) {
        if (this.numberOfPoints == o.numberOfPoints) {
            if (o.scoredGoals - this.receivedGoals > this.scoredGoals - receivedGoals) {
                return 1;
            } else {
                return -1;
            }
        } else if (o.numberOfPoints > this.numberOfPoints) {
            return 1;
        } else {
            return -1;
        }
    }



    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTeam01(), getTeam02(), getNoOfWins(),
                getNoOfDraws(), getNoOfDefeats(), getReceivedGoals(), getScoredGoals(),getNumberOfPoints(), getNumberOfPlayedMatches());
    }




}
