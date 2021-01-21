package LeaugeManager;


import Clubs.FootballClub;
import Clubs.SchoolFootballClubs;
import Clubs.UniversityFootballClub;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class Main extends Application {

    private static PremierLeagueManager plm=new PremierLeagueManager();
    private static int count =0;

    //Main
    public static void main(String[] args)  {
             launch(args);
    }


    //Method to add played match
    private static void addPlayedMatch() {
        System.out.println("*********************************************");
        System.out.println("*********** P L A Y  M A T C H **************");
        System.out.println("*********************************************");
        System.out.println("");
        if(plm.footballClubList.size()<20) {

            plm.addPlayedMatch();
        }else {
            System.out.println("No result.....");
        }
    }

    //Method to show the all club detail
    private static void printClubTable() {
        plm.displayPremierLeagueTable();

    }

    private void saveFile() throws IOException {
        if(plm.footballClubList.size()==0) {
            System.out.println("No any clubs registered yet.");
        }else {
            plm.saveFile();
        }
    }


    //Method to show club statistics
    private static void printClubStatistic() {
        System.out.println("*********************************************");
        System.out.println("***** C L U B  I N F O M A T I O N **********");
        System.out.println("*********************************************");
        System.out.println("");
        if(plm.footballClubList.size()<20) {
            Scanner inputValues = new Scanner(System.in);
            System.out.println("Enter the club name you want to Display :");
            String clubName = inputValues.next();
            plm.clubStatistics(clubName);
        }else {
            System.out.println("No clubs registered yet...");
        }
    }

    //Method to delete existing club in the club list
    private static void deletingClub() {  //ok
        System.out.println("*************************************+++");
        System.out.println("***** D E L E T E   C L U B S **********");
        System.out.println("*************************************+++");
        System.out.println("");
        Scanner inputValues = new Scanner(System.in);
        System.out.println("Enter the club name you want to delete :");
        String clubName=inputValues.next();
        boolean result = plm.deleteFootBallClub(clubName);
        if (result) {
           count --;
        }
    }

    //Method to add club to premier league
    private static void  insertingClub() {
        Scanner sc=new Scanner(System.in);
        System.out.println("*************************************");
        System.out.println("******** A D D  C L U B S ***********");
        System.out.println("*************************************");
        System.out.println("");
        FootballClub club=null;
        // Input the club type
        System.out.println("Enter Football club type -'D' for Default football club, 'U' for UniversityFootBall club, 'S' for SchoolFootballclub ");
        String input=sc.nextLine();

        switch (input){
            //Default club
                case "D":
                case "d":
                    if(plm.footballClubList.size()<20) {
                        club=new FootballClub();
                        System.out.println("Insert club name :");
                        String name=sc.nextLine();
                        if(name==null){
                            System.out.println("Please enter club name;");
                            return;
                        }else {
                            club.setClubName(name);
                            System.out.println("Insert club location :");
                            String location = sc.nextLine();
                            club.setClubLocation(location);
                        }
                    }else {
                        System.out.println("No spaces free.");
                    }
                    break;
            //university club
            case "U":
            case "u":
                if(plm.footballClubList.size()<20) {

                    club=new UniversityFootballClub();
                    System.out.println("Insert club name :");
                    String name=sc.nextLine();
                    club.setClubName(name);

                    System.out.println("Insert club location :");
                    String location=sc.nextLine();
                    club.setClubLocation(location);

                    System.out.println("Insert University name:");
                    String uName=sc.nextLine();
                    ((UniversityFootballClub) club).setUniversityName(uName);

                    System.out.println("Insert University location:");
                    String uLocation=sc.nextLine();
                    ((UniversityFootballClub) club).setUniLocation(uLocation);

                }else {
                    System.out.println("No spaces free.");
                }
                break;
            //school club
            case "S":
            case "s":
                if(plm.footballClubList.size()<20) {

                    club=new SchoolFootballClubs();
                    System.out.println("Insert club name :");
                    String name=sc.nextLine();
                    club.setClubName(name);

                    System.out.println("Insert club location :");
                    String location=sc.nextLine();
                    club.setClubLocation(location);

                    System.out.println("Insert School name:");
                    String sName=sc.nextLine();
                    ((SchoolFootballClubs) club).setSchoolName(sName);

                    System.out.println("Insert School location:");
                    String sLocation=sc.nextLine();
                    ((SchoolFootballClubs) club).setSchoolLocation(sLocation);

                }else {
                    System.out.println("No spaces free.");
                }
               break;
            default:
                throw new IllegalStateException("Unexpected value: " + input);
        }
        //add to club list
        plm.addFootBallClub(club);
        count++;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //calling the load data method
        plm.loadFile();
        System.out.println("******************************************************");
        System.out.println("************* W  E  L  C  O  M  E ********************");
        System.out.println("******************************************************");
        System.out.println("********************** TO ****************************");
        System.out.println("******************************************************");
        System.out.println("*** P  R  E  M  I  E  R *** L  E  A  G  U  E ******** ");
        System.out.println("******************************************************");
        System.out.println("******************************************************");
        menuLoop:
        //Menu
        while (true) {
            Scanner inputValues = new Scanner(System.in);
            System.out.println("********* M E N U *************");
            System.out.println("*** 1 for inserting the clubs");
            System.out.println("*** 2 for deleting the clubs ");
            System.out.println("*** 3 for club GUI");
            System.out.println("*** 4 for printing club statistic ");
            System.out.println("*** 5 for add played match ");
            System.out.println("*** 6 for save matches ");
            System.out.println("*** 7 for Quit ");
            System.out.println();
            System.out.println("----------Enter the number---------");
            try {
                int selection = inputValues.nextInt();

                switch (selection) {
                    case 1:
                        insertingClub();
                        break;
                    case 2:
                        deletingClub();
                        break;
                    case 3:
                        printClubTable();
                        break;
                    case 4:
                        printClubStatistic();
                        break;
                    case 5:
                        addPlayedMatch();
                        break;
                    case 6:
                        saveFile();
                        break;
                    case 7:
                        saveFile();
                        System.out.println("***********************************************************");
                        System.out.println("**** T H A N K  Y O U !  H A V E  A  G O O D  D A Y !  ****");
                        System.out.println("***********************************************************");
                        break menuLoop;
                    default:
                        System.out.println("Invalid input Reenter:");
                }
            } catch (Exception e){
                System.out.println("Please enter the type.\n" );
            }
        }
    }



}
