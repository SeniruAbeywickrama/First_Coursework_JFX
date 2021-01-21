package Clubs;

import javax.jnlp.ServiceManagerStub;
import java.io.Serializable;
import java.util.Objects;

public class SportsClub implements Serializable {

    private String clubName;
    private String clubLocation;


    public SportsClub(String clubName, String clubLocation){
        this.clubName=clubName;
        this.clubLocation=clubLocation;

    }
    //Default constructor
    public SportsClub() {

    }

    public SportsClub(String clubName) {
        this.clubName=clubName;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }


    @Override
    public String toString() {
        return "clubName='" + getClubName() + '\'' + ", clubLocation='" + getClubLocation() + '\'';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub sportsClub = (SportsClub) o;
        return Objects.equals(clubName, sportsClub.clubName);
    }


   @Override
    public int hashCode() {
        return Objects.hash(clubName, clubLocation);
    }

}
