package Clubs;


public class SchoolFootballClubs extends FootballClub {
    private String schoolName;
    private String schoolLocation;

    public SchoolFootballClubs(String clubName, String clubLocation,String team01,String team02, int noOfWins, int noOfDraws, int noOfDefeats,
                               int recievedGoalas,int scoredGoals, int numberOfPoints, int numberOfPlayedMatches,String schoolName,String schoolLocation) {
        super(clubName, clubLocation,team01,team02,noOfWins,noOfDraws, noOfDefeats,recievedGoalas,scoredGoals, numberOfPoints, numberOfPlayedMatches);
        this.schoolName=schoolName;
        this.schoolLocation=schoolLocation;
    }

    public SchoolFootballClubs() {

    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolLocation() {
        return schoolLocation;
    }

    public void setSchoolLocation(String schoolLocation) {
        this.schoolLocation = schoolLocation;
    }

    @Override
    public String toString() {
        return "SchoolFootballClubs -->( "+ super.toString() +" schoolName='" + schoolName + '\'' + ", schoolLocation='" + schoolLocation + '\'' +
                ')';
    }


}
