package Clubs;

public class UniversityFootballClub extends FootballClub {
    private String universityName;
    private String uniLocation;

    //constructor
    public UniversityFootballClub(String clubName, String clubLocation,String team01,String team02,int noOfWins, int noOfDraws, int noOfDefeats,
                                  int recievedGoalas,int scoredGoals, int numberOfPoints, int numberOfPlayedMatches,String UniversityName,String UniLocation) {

        super(clubName, clubLocation,team01,team02,noOfWins,noOfDraws, noOfDefeats,recievedGoalas,scoredGoals, numberOfPoints, numberOfPlayedMatches);
        this.universityName=UniversityName;
        this.uniLocation=UniLocation;
    }
    //default constructor
    public UniversityFootballClub(){}

    //get method for university name
    public String getUniversityName() {
        return universityName;
    }
    //set method for university name
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
    //get method for university location
    public String getUniLocation() {
        return uniLocation;
    }

    //set method for university location
    public void setUniLocation(String uniLocation) {
        this.uniLocation = uniLocation;
    }

    @Override
    public String toString() {
        return "UniversityFootballClub -->(" + super.toString() + " UniversityName ='" + universityName + '\'' + ", UniLocation='" + uniLocation + '\'' +
                ')';
    }

}
