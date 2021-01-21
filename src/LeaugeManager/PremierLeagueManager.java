package LeaugeManager;

import Clubs.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.List;

public class PremierLeagueManager implements LeagueManager {
    Stage stage;
    //Array list to save football club data.
    final List<FootballClub> footballClubList = new ArrayList<>();
    //Array list to save match details.
    final List<Match> matches = new ArrayList<>();
    TableView<FootballClub> table;
    //File to save data.
    File f1=new File("file.txt");
    private static int matchCount =0;

    @Override
    //Method to Adding members
    public void addFootBallClub(FootballClub footballClub) {



        boolean condition = false;
        //find the same clubs.
        for (FootballClub fbc : footballClubList) {
            if (footballClub.equals(fbc)) {
                condition = true;
                break;
            }
        }
        if (!condition) {
            footballClubList.add(footballClub);
            System.out.println("Added Successful...");
            System.out.println("["+footballClubList.size()+"]");
        } else {
            System.out.println("Already Taken.Please try again...");
        }
    }

    @Override
    // Method to delete members.
    public boolean deleteFootBallClub(String footBallClubName) {
        if (footballClubList.isEmpty()) {
            System.out.println("No clubs registered yet...");
        } else {
            boolean condition = false;
            for (FootballClub footballClub : footballClubList) {
                if (footballClub.getClubName().equals(footBallClubName)) {
                    condition = true;
                    footballClubList.remove(footballClub);
                    System.out.println("The Football club :" + footBallClubName + " is successfully removed...");
                    System.out.println(footballClubList.size());

                    if (footballClub instanceof UniversityFootballClub) {
                        System.out.println("Removed club type : UniversityClub(Under 23");
                    } else if (footballClub instanceof SchoolFootballClubs) {
                        System.out.println("Removed club type : SchoolClub(Under 18)");
                    }
                    break;
                }
            }
            if (!condition) {
                System.out.println("Your searching is not found");
            }
            return condition;
        }
        return false;
    }

    @Override
    //Method to show club statistics.
    public void clubStatistics(String clubName) {


        for (FootballClub fbc : footballClubList) {
            if (clubName.equals(fbc.getClubName())) {
                if (fbc instanceof SchoolFootballClubs) {
                    System.out.println("////////// SCHOOL FOOT BALL CLUB ///////////////");
                    System.out.println("School Name :" + ((SchoolFootballClubs) fbc).getSchoolName());
                } else if (fbc instanceof UniversityFootballClub) {
                    System.out.println("////////// UNIVERSITY FOOT BALL CLUB ///////////////");
                    System.out.println("University Name :" + ((UniversityFootballClub) fbc).getUniversityName());
                } else {
                    System.out.println("////////// FOOT BALL CLUB ///////////////");
                }
                System.out.println("Club name :" + fbc.getClubName());
                System.out.println("Club Location :" + fbc.getClubLocation());
                System.out.println("////////// Scored-->[" + fbc.getScoredGoals() + "/" + fbc.getReceivedGoals() + "]<--Received ///////////");
                System.out.println("////////// Wins :" + fbc.getNoOfWins());
                System.out.println("////////// Draw :" + fbc.getNoOfDraws());
                System.out.println("////////// Defeat :" + fbc.getNoOfDefeats());
                System.out.println("////////// Point :" + fbc.getNumberOfPoints());
                System.out.println("////////// Played Matches :" + fbc.getNumberOfPlayedMatches());
                System.out.println("////////////////////////////////////////////////");

                break;
            } else {
                System.out.println("No any record found...");
            }
        }
    }

    @Override
    // Method to display all details of clubs.
    public void displayPremierLeagueTable() {

        //set stage for main page
        stage = new Stage();
        stage.setTitle("Premiere League - Point Table");
        //Add a table
        TableView<FootballClub> tableView = new TableView<>();
        //pane for adding table and buttons
        Pane pane=new Pane();
        //Random object for generate match
        Random random=new Random();


        //Text field to enter date
        TextField txtDate = new TextField();
        txtDate.setLayoutY(600);
        txtDate.setLayoutX(1010);
        txtDate.setPrefSize(155,15);

        //Button to generate random match.
        Button btnGenerate = new Button("GENERATE MATCH");
        btnGenerate.setStyle("-fx-cursor: hand;-fx-font-weight: bold;-fx-text-fill: white; -fx-background-color:#4cd137;-fx-background-radius: 30;");
        btnGenerate.setPrefSize(180,53);
        btnGenerate.setLayoutX(1000);
        btnGenerate.setLayoutY(350);
        btnGenerate.setOpacity(0.9);

        //Button to sort ascending order.
        Button btnSort = new Button("Date Sort ");
        btnSort.setStyle("-fx-cursor: hand;-fx-font-weight: bold;-fx-text-fill: white; -fx-background-color:#C40000;-fx-background-radius: 30;");
        btnSort.setPrefSize(180,53);
        btnSort.setLayoutX(1000);
        btnSort.setLayoutY(450);
        btnSort.setOpacity(0.9);

        //Button to find match.
        Button btnFind = new Button("Find Matches");
        btnFind.setStyle("-fx-cursor: hand;-fx-font-weight: bold;-fx-text-fill: white; -fx-background-color:#EC761D;-fx-background-radius: 30;");
        btnFind.setPrefSize(180,53);
        btnFind.setLayoutX(1000);
        btnFind.setLayoutY(650);
        btnFind.setOpacity(0.9);

        //Button to sort Clubs by Winning order
        Button btnWinOdr= new Button("Win Order");
        btnWinOdr.setStyle("-fx-cursor: hand;-fx-font-weight: bold;-fx-text-fill: black;-fx-background-color:yellow;-fx-background-radius: 100;");
        btnWinOdr.setPrefSize(110,110);
        btnWinOdr.setLayoutX(970);
        btnWinOdr.setLayoutY(200);
        btnWinOdr.setOpacity(0.9);

        //Button to sort Clubs by scored goals
        Button btnScored= new Button("Score Order");
        btnScored.setStyle("-fx-cursor: hand;-fx-font-weight: bold;-fx-text-fill: black; -fx-background-color:lime;-fx-background-radius: 100;");
        btnScored.setPrefSize(110,110);
        btnScored.setLayoutX(1100);
        btnScored.setLayoutY(200);
        btnScored.setOpacity(0.9);


        //BUTTON ACTIONS

        //Action event of generate button
        btnGenerate.setOnAction(event -> {
                    if(footballClubList.size()>1) {
                            //create a random team index
                            int ranTeam1 = random.nextInt(footballClubList.size());
                            int ranTeam2 = random.nextInt(footballClubList.size());
                            //create a random goal count
                            int rangoals1=random.nextInt(20);
                            int rangoals2=random.nextInt(20);

                            //Randomly chosen teams
                            FootballClub fb1=footballClubList.get(ranTeam1);
                            FootballClub fb2=footballClubList.get(ranTeam2);


                            if(fb1.getClubName().equals(fb2.getClubName())) {

                            }else {


                                //

                                Match match=new Match();
                                match.setFootballClub01(fb1);
                                match.setFootballClub02(fb2);
                                match.setScoreTeam01(rangoals1);
                                match.setScoreTeam02(rangoals2);
                                match.setDate(match.getDate());

                                fb1.setScoredGoals(fb1.getScoredGoals()+rangoals1);
                                fb2.setScoredGoals(fb2.getScoredGoals()+rangoals2);
                                fb1.setReceivedGoals(fb1.getReceivedGoals()+rangoals2);
                                fb2.setReceivedGoals(fb2.getReceivedGoals()+rangoals1);
                                fb1.setNumberOfPlayedMatches(fb1.getNumberOfPlayedMatches()+1);
                                fb2.setNumberOfPlayedMatches(fb2.getNumberOfPlayedMatches()+1);

                                if(rangoals1>rangoals2){
                                    fb1.setNumberOfPoints(fb1.getNumberOfPoints()+3);
                                    fb1.setNoOfWins(fb1.getNoOfWins()+1);
                                    fb2.setNoOfDefeats(fb2.getNoOfDefeats()+1);
                                    fb2.setNumberOfPoints(fb2.getNumberOfPoints()-1);
                                }else if(rangoals1<rangoals2){
                                    fb2.setNumberOfPoints(fb2.getNumberOfPoints()+3);
                                    fb2.setNoOfWins(fb2.getNoOfWins()+1);
                                    fb1.setNoOfDefeats(fb1.getNoOfDefeats()+1);
                                    fb1.setNumberOfPoints(fb1.getNumberOfPoints()-1);
                                }else {
                                    fb1.setNumberOfPoints(fb1.getNumberOfPoints()+1);
                                    fb2.setNumberOfPoints(fb2.getNumberOfPoints()+1);
                                    fb1.setNoOfDraws(fb1.getNoOfDefeats()+1);
                                    fb2.setNoOfDraws(fb2.getNoOfDefeats()+1);
                                }
                                matches.add(match);
                                matchCount++;

                                System.out.println(fb1);
                                System.out.println(fb2);
                                System.out.println(rangoals1);
                                System.out.println(rangoals2);
                            }

                            //GUI to generate
                        Stage generateStage = new Stage();
                        generateStage.setTitle("Played Match");
                        Pane pane2=new Pane();


                        //label team 01
                        Label team1Name = new Label();
                        team1Name.setText(fb1.getClubName());
                        team1Name.setStyle("-fx-font-weight: bold;-fx-font-size: 20;");
                        team1Name.setLayoutX(90);
                        team1Name.setPrefSize(200, 22);
                        team1Name.setLayoutY(320);
                        //label team 02
                        Label team2Name = new Label();
                        team2Name.setText(fb2.getClubName());
                        team2Name.setStyle("-fx-font-weight: bold;-fx-font-size: 20;");
                        team2Name.setLayoutX(660);
                        team2Name.setPrefSize(200, 22);
                        team2Name.setLayoutY(320);
                        //lable team 1 score
                        Label team1Score = new Label();
                        team1Score.setText(String.valueOf(rangoals1));
                        team1Score.setStyle("-fx-font-weight: bold;-fx-font-size: 38;");
                        team1Score.setLayoutX(250);
                        team1Score.setPrefSize(200, 22);
                        team1Score.setLayoutY(250);

                        Label team2Score = new Label();
                        team2Score.setText(String.valueOf(rangoals2));
                        team2Score.setStyle("-fx-font-weight: bold;-fx-font-size: 38;");
                        team2Score.setLayoutX(490);
                        team2Score.setPrefSize(200, 22);
                        team2Score.setLayoutY(250);


                        Image bgnd = new Image("new.png");
                        ImageView imageBackground = new ImageView(bgnd);
                        imageBackground.setFitHeight(200);
                        imageBackground.setFitWidth(800);

                        Image football = new Image("football.png");

                        ImageView ball = new ImageView(football);
                        ball.setFitHeight(110);
                        ball.setFitWidth(115);
                        ball.setLayoutY(210);
                        ball.setLayoutX(60);

                        ImageView ball2 = new ImageView(football);
                        ball2.setFitHeight(110);
                        ball2.setFitWidth(115);
                        ball2.setLayoutY(210);
                        ball2.setLayoutX(620);



                        pane2.getChildren().addAll(imageBackground,ball,ball2,team1Name,team2Name,team1Score,team2Score);
                        Scene scene1 = new Scene(pane2, 800, 400);
                        generateStage.setScene(scene1);
                        generateStage.showAndWait();

                    } else if(footballClubList.size()==1){
                        Alert errorMessage = new Alert(Alert.AlertType.ERROR, "Only one club is in the list..", ButtonType.OK);
                        errorMessage.show();
                    } else {
                    Alert errorMessage = new Alert(Alert.AlertType.ERROR, "No clubs registered yet.", ButtonType.OK);
                    errorMessage.show();
                }

        });

        //button for sorting points by descending order
        btnSort.setOnAction(event -> {
            String[] team = new String[matches.size()];
            for(int i=0;i<matches.size();i++) {
                try {
                    team[i] = String.valueOf(matches.get(i).getDate().getTime());
                }catch (Exception e){
                    System.out.println("");
                }
            }
            for(int i=0;i<matches.size();i++) {
                try {
                    for (int j = 0; j < matches.size() - 1 - i; j++) {
                        if (team[j].compareTo(team[j + 1]) < 0) {
                            String temp = team[j];
                            team[j] = team[j + 1];
                            team[j + 1] = temp;

                            Match match = matches.get(j);
                            matches.set(j, matches.get(j + 1));
                            matches.set(j + 1, match);
                        }
                    }
                }catch (Exception e){
                    System.out.println("try again");
                }

            }
            stage = new Stage();
            stage.setTitle("Match sort by date...");
            Pane p1 = new Pane();
            TableView<Match> tableStatus = new TableView<>();

            Image bgnd = new Image("new.png");
            ImageView imageBackground = new ImageView(bgnd);
            imageBackground.setFitHeight(200);
            imageBackground.setFitWidth(1100);


            TableColumn<Match, String> columnScore01 = new TableColumn<>("Team 01 Score");
            columnScore01.setCellValueFactory(new PropertyValueFactory<>("scoreTeam01"));
            columnScore01.setMinWidth(200);

            TableColumn<Match, String> columnScore02 = new TableColumn<>("Team 02 Score");
            columnScore02.setCellValueFactory(new PropertyValueFactory<>("scoreTeam02"));
            columnScore02.setMinWidth(200);

            TableColumn<Match, String> columndate = new TableColumn<>("Date");
            columndate.setCellValueFactory(new PropertyValueFactory<>("date"));
            columndate.setMinWidth(400);

            for(Match match:matches) {

                tableStatus.getItems().add(new Match(match.getFootballClub01(), match.getFootballClub02(),
                        match.getScoreTeam01(), match.getScoreTeam02(), match.getDate()));
            }

            tableStatus.getColumns().addAll(columnScore01, columnScore02,columndate);
            tableStatus.setLayoutY(280);
            tableStatus.setLayoutX(130);

            p1.getChildren().addAll(tableStatus,imageBackground);
            Scene scene1 = new Scene(p1, 1100, 700);
            stage.setScene(scene1);
            stage.showAndWait();



        });

        //Action event of find

        btnFind.setOnAction(event -> {

            //Date of generated

            for (Match match:matches) {

                Date date = match.getDate();
                System.out.println(date);

                String inputDate = txtDate.getText();
                //Date of inputted
                Date dateinput;
                try {
                    dateinput = new SimpleDateFormat("dd-MM-yyyy").parse(inputDate);
                } catch (ParseException e) {
                    Alert errorMessage = new Alert(Alert.AlertType.ERROR, "Wrong Format", ButtonType.OK);
                    errorMessage.show();
                    return;
                }

                if (dateinput.equals(date)) {

                    //GUI to show find match.
                    stage = new Stage();
                    stage.setTitle("Match status...");
                    Pane p1 = new Pane();
                    TableView<Match> tableStatus = new TableView<>();

                    Label status = new Label("Match Status...");
                    status.setStyle("-fx-background-color:white;-fx-font-weight: bold;-fx-font-size: 27;");
                    status.setLayoutX(90);
                    status.setPrefSize(200, 22);
                    status.setLayoutY(200);

                    Label lblDate = new Label();
                    lblDate.setText(inputDate);
                    lblDate.setStyle("-fx-background-color:white;-fx-font-weight: bold;-fx-font-size: 27;");
                    lblDate.setLayoutX(800);
                    lblDate.setPrefSize(200, 17);
                    lblDate.setLayoutY(200);

                    TableColumn<Match, String> columnTeam01 = new TableColumn<>("Team 01");
                    columnTeam01.setCellValueFactory(new PropertyValueFactory<>("footballClub01"));
                    columnTeam01.setMinWidth(200);

                    TableColumn<Match, String> columnTeam02 = new TableColumn<>("Team 02");
                    columnTeam02.setCellValueFactory(new PropertyValueFactory<>("footballClub02"));
                    columnTeam02.setMinWidth(200);

                    TableColumn<Match, String> columnScore01 = new TableColumn<>("Team 01 Score");
                    columnScore01.setCellValueFactory(new PropertyValueFactory<>("scoreTeam01"));
                    columnScore01.setMinWidth(200);

                    TableColumn<Match, String> columnScore02 = new TableColumn<>("Team 02 Score");
                    columnScore02.setCellValueFactory(new PropertyValueFactory<>("scoreTeam02"));
                    columnScore02.setMinWidth(200);


                    tableStatus.getItems().add(new Match(match.getFootballClub01(), match.getFootballClub02(),
                            match.getScoreTeam01(), match.getScoreTeam02(), match.getDate()));


                    tableStatus.getColumns().addAll(columnTeam01, columnTeam02, columnScore01, columnScore02);
                    tableStatus.setLayoutY(280);
                    tableStatus.setLayoutX(130);

                    Image bgnd = new Image("f1.jpg");
                    ImageView imageBackground = new ImageView(bgnd);
                    imageBackground.setFitHeight(700);
                    imageBackground.setFitWidth(1100);

                    Image logo = new Image("new.png");
                    ImageView imageView2 = new ImageView(logo);
                    imageView2.setFitHeight(180);
                    imageView2.setFitWidth(1100);

                    p1.getChildren().addAll(imageBackground, imageView2, status, tableStatus, lblDate);
                    Scene scene1 = new Scene(p1, 1100, 700);
                    stage.setScene(scene1);
                    stage.showAndWait();
                    return;
                } else {
                    Alert errorMessage = new Alert(Alert.AlertType.ERROR, "No matches in this date.", ButtonType.OK);
                    errorMessage.show();
                }

            }

        });

        //button for sorting win count by descending order
        btnWinOdr.setOnAction(event -> {
            String[] team = new String[footballClubList.size()];
            for(int i=0;i<footballClubList.size();i++)
            {
                team[i]=String.valueOf( footballClubList.get(i).getNoOfWins());
            }

            for(int i=0;i<footballClubList.size();i++) {
                for (int j = 0; j < footballClubList.size() - 1 - i; j++) {
                    if (team[j].compareTo(team[j + 1]) < 0) {
                        String temp = team[j];
                        team[j] = team[j + 1];
                        team[j + 1] = temp;

                        FootballClub footballClub = footballClubList.get(j);
                        footballClubList.set(j, footballClubList.get(j + 1));
                        footballClubList.set(j + 1, footballClub);
                    }
                }
            }
        });
        //button for sorting scored goals by descending order
        btnScored.setOnAction(event -> {
            String[] team = new String[footballClubList.size()];
            for(int i=0;i<footballClubList.size();i++)
            {
                team[i]=String.valueOf( footballClubList.get(i).getScoredGoals());
            }

            for(int i=0;i<footballClubList.size();i++) {
                for (int j = 0; j < footballClubList.size() - 1 - i; j++) {
                    if (team[j].compareTo(team[j + 1]) < 0) {
                        String temp = team[j];
                        team[j] = team[j + 1];
                        team[j + 1] = temp;

                        FootballClub footballClub = footballClubList.get(j);
                        footballClubList.set(j, footballClubList.get(j + 1));
                        footballClubList.set(j + 1, footballClub);
                    }
                }
            }
        });

        btnWinOdr.setOnMouseEntered(event -> {
            btnWinOdr.setOpacity(1);
        });
        btnScored.setOnMouseEntered(event -> {
            btnScored.setOpacity(1);
        });
        btnGenerate.setOnMouseEntered(event -> {
            btnGenerate.setOpacity(1);
        });
        btnSort.setOnMouseEntered(event -> {
            btnSort.setOpacity(1);
        });
        btnFind.setOnMouseEntered(event -> {
            btnFind.setOpacity(1);
        });
        btnWinOdr.setOnMouseExited(event -> {
            btnWinOdr.setOpacity(0.5);
        });
        btnGenerate.setOnMouseExited(event -> {
            btnGenerate.setOpacity(0.5);
        });
        btnSort.setOnMouseExited(event -> {
            btnSort.setOpacity(0.5);
        });
        btnFind.setOnMouseExited(event -> {
            btnFind.setOpacity(0.5);
        });
        btnScored.setOnMouseExited(event -> {
            btnScored.setOpacity(0.5);
        });



        //Point Table columns
        TableColumn<FootballClub, String>  columnClubName =new TableColumn<>("Club");
        columnClubName.setCellValueFactory(new PropertyValueFactory<>("clubName"));
        columnClubName.setMinWidth(200);

        TableColumn<FootballClub, Integer> columnPlayedMatch =new TableColumn<>("MP");
        columnPlayedMatch.setCellValueFactory(new PropertyValueFactory<>("numberOfPlayedMatches"));
        columnPlayedMatch.setMinWidth(20);

        TableColumn<FootballClub, String> columnWin =new TableColumn<>("W");
        columnWin.setCellValueFactory(new PropertyValueFactory<>("noOfWins"));
        columnWin.setMinWidth(20);

        TableColumn<FootballClub, String> columnDraw =new TableColumn<>("D");
        columnDraw.setCellValueFactory(new PropertyValueFactory<>("noOfDraws"));
        columnDraw.setMinWidth(20);

        TableColumn<FootballClub, String> columnLose =new TableColumn<>("L");
        columnLose.setCellValueFactory(new PropertyValueFactory<>("noOfDefeats"));
        columnLose.setMinWidth(20);

        TableColumn<FootballClub, String> columnScored =new TableColumn<>("GS");
        columnScored.setCellValueFactory(new PropertyValueFactory<>("scoredGoals"));
        columnScored.setMinWidth(20);

        TableColumn<FootballClub, String> columnReceived =new TableColumn<>("GR");
        columnReceived.setCellValueFactory(new PropertyValueFactory<>("receivedGoals"));
        columnReceived.setMinWidth(20);

        TableColumn<FootballClub, Integer> columnPoints =new TableColumn<>("PTS");
        columnPoints.setCellValueFactory(new PropertyValueFactory<>("numberOfPoints"));
        columnPoints.setMinWidth(20);


        Collections.sort(footballClubList);
        //adding details to table
        for(FootballClub fb:footballClubList){
            tableView.getItems().add(new FootballClub(fb.getClubName(),fb.getNumberOfPlayedMatches(),fb.getNoOfWins(),fb.getNoOfDraws(),fb.getNoOfDefeats(),
                    fb.getScoredGoals(),fb.getReceivedGoals(),fb.getNumberOfPoints()));
        }

        //adding above colmns in table
        tableView.getColumns().addAll(columnClubName,columnPlayedMatch,columnWin,columnDraw,columnLose,columnScored,columnReceived,columnPoints);
        tableView.setLayoutY(330);
        tableView.setLayoutX(50);
        //background Image
        Image homeBg = new Image("gnd.jpg");
        ImageView imageView1 = new ImageView(homeBg);
        imageView1.setFitHeight(800);
        imageView1.setFitWidth(1300);

        //Logo image
        Image logo = new Image("logo.png");
        ImageView imageView2 = new ImageView(logo);
        imageView2.setFitHeight(150);
        imageView2.setFitWidth(900);
        imageView2.setLayoutX(130);
        imageView2.setLayoutY(40);


        pane.getChildren().addAll(imageView1,imageView2,tableView,btnGenerate,btnWinOdr,btnScored,btnSort,txtDate,btnFind);
        Scene scene = new Scene(pane,1300,800);
        stage.setScene(scene);
        stage.showAndWait();

    }

    @Override
    // Method to save statistics in text file.
    public void saveFile() throws IOException {

        FileOutputStream fis=new FileOutputStream(f1);
        ObjectOutputStream oos = new ObjectOutputStream(fis);

        for (FootballClub fc : footballClubList) {
            oos.writeObject(fc);
        }
        for (Match match : matches) {
            oos.writeObject(match);
        }
        oos.close();
        fis.close();
        System.out.println("******* DATA SAVED SUCCESSFULLY **************");
    }

    @Override
    // Method to load details from saved file.
    public void loadFile() throws IOException, ClassNotFoundException{

        try {

            FileInputStream fis=new FileInputStream(f1);
            ObjectInputStream ois=new ObjectInputStream(fis);

            for (;;) {
                try {
                    FootballClub fbc = (FootballClub) ois.readObject();
                    footballClubList.add((fbc));
                } catch (EOFException | ClassNotFoundException e) {
                    break;
                }
            }
            for (;;) {
                try {
                    Match match = (Match) ois.readObject();
                    matches.add((match));
                } catch (EOFException | ClassNotFoundException e) {
                    break;
                }
            }
            ois.close();
            fis.close();
        }catch (Exception e){
        }
        System.out.println("************** DATA SUCCESSFULLY LOADED **************");
    }

    @Override
    //Method to add played match.
    public void addPlayedMatch() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter Date( dd-mm-yyyy) :");
        String input=sc.nextLine();
        Date date;
        try{
            date=new SimpleDateFormat("dd-MM-yyyy").parse(input);
        } catch (ParseException e) {
            System.out.println("Wrong format...Try again.");
            return;
        }
        System.out.println("Enter the Team 01 :");
        input=sc.nextLine();
        FootballClub team01=null;
            for (FootballClub fbc:footballClubList){
                if(fbc.getClubName().equals(input)) {
                    team01 = fbc;
                }
            }
            if(team01==null){
                System.out.println("Club isn't in the league.");
             //   return;
            }
        System.out.println("Enter the Team 02 :");
        input=sc.nextLine();
        FootballClub team02=null;
        for (FootballClub fbc:footballClubList){
            if(fbc.getClubName().equals(input)){
                team02=fbc;
            }
        }
        if(team02==null){
            System.out.println("Club isn't in the league.");
            return;
        }

        System.out.println("Enter team 01 goals :");
        input=sc.nextLine();
        int team01Goals= 0;
            try {
                team01Goals=Integer.parseInt(input);
            }catch (Exception e){}

        if(team01Goals == 0){
            System.out.println("Please enter the number of goals.");
            return;
        }

        System.out.println("Enter team 02 goals :");
        input=sc.nextLine();
        int team02Goals= 0;
            try{
                 team02Goals=Integer.parseInt(input);
            }catch (Exception e) {}
        if(team02Goals == 0){
            System.out.println("Please enter the number of goals.");
            return;
        }
        System.out.println(date);

        //add the values to setters
        Match match=new Match(team01,team02,team01Goals,team02Goals,date);
        match.setDate(date);
        match.setFootballClub01(team01);
        match.setFootballClub02(team02);
        match.setScoreTeam01(team01Goals);
        match.setScoreTeam02(team02Goals);

        // add match data to matches arraylist
        matches.add(match);
        matchCount++;



        //adding goals

        team01.setScoredGoals(team01.getScoredGoals()+team01Goals);
        team02.setScoredGoals(team02.getScoredGoals()+team02Goals);
        team01.setReceivedGoals(team01.getReceivedGoals()+team02Goals);
        team02.setReceivedGoals(team02.getReceivedGoals()+team01Goals);
        team01.setNumberOfPlayedMatches(team01.getNumberOfPlayedMatches()+1);
        team02.setNumberOfPlayedMatches(team02.getNumberOfPlayedMatches()+1);

        // adding points,win count to team 01 and team 02

        if(team01Goals>team02Goals){
            team01.setNumberOfPoints(team01.getNumberOfPoints()+3);
            team01.setNoOfWins(team01.getNoOfWins()+1);
            team02.setNoOfDefeats(team02.getNoOfDefeats()+1);
            team02.setNumberOfPoints(team02.getNumberOfPoints()-1);
        }else if(team01Goals<team02Goals){
            team02.setNumberOfPoints(team02.getNumberOfPoints()+3);
            team02.setNoOfWins(team02.getNoOfWins()+1);
            team01.setNoOfDefeats(team01.getNoOfDefeats()+1);
            team01.setNumberOfPoints(team01.getNumberOfPoints()-1);
        }else {
            team01.setNumberOfPoints(team01.getNumberOfPoints()+1);
            team02.setNumberOfPoints(team02.getNumberOfPoints()+1);
            team01.setNoOfDraws(team01.getNoOfDefeats()+1);
            team02.setNoOfDraws(team02.getNoOfDefeats()+1);
        }
    }



}
