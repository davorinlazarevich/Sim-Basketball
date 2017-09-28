import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class GameGui {

    Team[] teamsInGame;    //Array that holds the two teams that compete against each other
    GameClock gameClock;    //The clock used in the game
    GameBall gameBall;      //The ball played with

    BorderPane layoutBorderPane;

    GridPane homeBoxScoresGrid;
    GridPane visitorBoxScoresGrid;
    GridPane inGameHomeBoxScoresGrid;
    GridPane inGameVisitorBoxScoresGrid;
    VBox boxScoresVBox;
    VBox inGameBoxScoresVBox;
    Pane shotChartpane;
    Scene scene;

    Text homeText;
    Text visitorText;

    Text minSec;
    Text period;
    Text homeTotalPoints;
    Text visitorTotalPoints;
    Button fastForwardButton;
    Button fastForwardToEnd;
    Button startButton;
    Button stopButton;
    Button shotChartButton;
    Button boxScoresButton;
    Button fullBoxScoresButton;
    Button restartGameButton;
    Label playByPlay;

    int totalHomeScore;
    int totalVisitorScore;
    ScrollPane scrollPane;
    String playByPlayLog;
    Text[][] homeBoxScores;
    Text[][] visitorBoxScores;
    Text[][] inGamehomeBoxScores;
    Text[][] inGamevisitorBoxScores;
    Text[] homeShots;
    Text[] visitorShots;
    boolean shotChart;
    int homeShotsIndex;
    int visitorShotsIndex;
    boolean fullBoxScores;
    int colorTeam;
    int colorStat;
    int colorPlayer;

    public GameGui() {
        fastForwardButton = new Button("Speed Up");
        fastForwardToEnd = new Button("Sim Game");

        startButton = new Button("Start");
        stopButton = new Button("Stop");
        shotChartButton = new Button("Shot Chart");
        boxScoresButton = new Button("Play by Play");
        fullBoxScoresButton = new Button("Full Box Scores");
        restartGameButton = new Button("Restart");
        colorTeam = 0;
        colorStat = 0;
        colorPlayer = 0;
    }

    public void setupGamePage(Team[] tig, GameClock gc, GameBall gb) {
        teamsInGame = tig;
        gameClock = gc;
        gameBall = gb;
        layoutBorderPane = new BorderPane();

        layoutBorderPane.setId("pane");
        shotChart = false;

        homeTotalPoints = new Text(teamsInGame[1].getTeamName());
        visitorTotalPoints = new Text(teamsInGame[2].getTeamName());

        totalHomeScore = 0;
        totalVisitorScore = 0;
        homeText = new Text("HOME");
        visitorText = new Text("VISITOR");
        homeTotalPoints = new Text("0");
        visitorTotalPoints = new Text("0");
        minSec = new Text("24  12:00");
        period = new Text("Period: 1");
        playByPlayLog = "";
        playByPlay = new Label(playByPlayLog);
        scrollPane = new ScrollPane();
        scrollPane.setContent(playByPlay);
        scrollPane.setMinHeight(200);
        scrollPane.setMaxHeight(200);

        homeBoxScoresGrid = new GridPane();
        visitorBoxScoresGrid = new GridPane();
        inGameHomeBoxScoresGrid = new GridPane();
        inGameVisitorBoxScoresGrid = new GridPane();

        homeBoxScoresGrid.getColumnConstraints().add(new ColumnConstraints(150));
        visitorBoxScoresGrid.getColumnConstraints().add(new ColumnConstraints(150));
        inGameHomeBoxScoresGrid.getColumnConstraints().add(new ColumnConstraints(200));
        inGameVisitorBoxScoresGrid.getColumnConstraints().add(new ColumnConstraints(200));
        homeBoxScoresGrid.setHgap(25);
        homeBoxScoresGrid.setVgap(3);
        visitorBoxScoresGrid.setHgap(25);
        visitorBoxScoresGrid.setVgap(3);
        inGameHomeBoxScoresGrid.setHgap(16);
        inGameHomeBoxScoresGrid.setVgap(12);
        inGameVisitorBoxScoresGrid.setHgap(16);
        inGameVisitorBoxScoresGrid.setVgap(12);


        homeBoxScores = new Text[30][16];
        visitorBoxScores = new Text[30][16];
        inGamehomeBoxScores = new Text[30][16];
        inGamevisitorBoxScores = new Text[30][16];

        fullBoxScores = false;
        initializeBoxScores();
        initializeInGameBoxScores();

        homeText.setFont(Font.font("Arial", FontWeight.BOLD, 45));
        visitorText.setFont(Font.font("Arial", FontWeight.BOLD, 45));
        homeTotalPoints.setFont(Font.font("Arial", FontWeight.BOLD, 45));
        visitorTotalPoints.setFont(Font.font("Arial", FontWeight.BOLD, 45));
        minSec.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        period.setFont(Font.font("Arial", FontWeight.BOLD, 25));


        playByPlay.setFont(Font.font("Arial", 18));
        HBox buttonsHbox = new HBox(startButton, stopButton, fastForwardButton, fastForwardToEnd, boxScoresButton, fullBoxScoresButton, shotChartButton, restartGameButton);


        startButton.setPadding(new Insets(30, 10, 30, 10));
        startButton.setStyle("-fx-font-size: 15pt;");
        stopButton.setPadding(new Insets(30, 10, 30, 10));
        stopButton.setStyle("-fx-font-size: 15pt;");
        fastForwardButton.setPadding(new Insets(30, 10, 30, 10));
        fastForwardButton.setStyle("-fx-font-size: 15pt;");
        fastForwardToEnd.setPadding(new Insets(30, 10, 30, 10));
        fastForwardToEnd.setStyle("-fx-font-size: 15pt;");
        shotChartButton.setPadding(new Insets(30, 10, 30, 10));
        shotChartButton.setStyle("-fx-font-size: 15pt;");
        fullBoxScoresButton.setPadding(new Insets(30, 10, 30, 10));
        fullBoxScoresButton.setStyle("-fx-font-size: 15pt;");
        boxScoresButton.setPadding(new Insets(30, 10, 30, 10));
        boxScoresButton.setStyle("-fx-font-size: 15pt;");
        restartGameButton.setPadding(new Insets(30, 10, 30, 10));
        restartGameButton.setStyle("-fx-font-size: 15pt;");

        VBox homeScoreVbox = new VBox(homeText, homeTotalPoints);
        VBox visitorScoreVbox = new VBox(visitorText, visitorTotalPoints);
        HBox topHbox = new HBox(homeScoreVbox, period, minSec, visitorScoreVbox);

        homeScoreVbox.setAlignment(Pos.CENTER);
        visitorScoreVbox.setAlignment(Pos.CENTER);

        boxScoresVBox = new VBox(homeBoxScoresGrid, visitorBoxScoresGrid);
        inGameBoxScoresVBox = new VBox(inGameHomeBoxScoresGrid, inGameVisitorBoxScoresGrid, scrollPane, playByPlay);
        boxScoresVBox.setSpacing(30);
        inGameBoxScoresVBox.setSpacing(30);
        topHbox.setSpacing(20);

        shotChartpane = new Pane();
        homeShotsIndex = 0;
        visitorShotsIndex = 0;

        homeShots = new Text[150];
        visitorShots = new Text[150];


        layoutBorderPane.setTop(topHbox);
        layoutBorderPane.setCenter(inGameBoxScoresVBox);
        layoutBorderPane.setBottom(buttonsHbox);


        topHbox.setAlignment(Pos.CENTER);
        buttonsHbox.setAlignment(Pos.CENTER);
        layoutBorderPane.setAlignment(topHbox, Pos.CENTER);
        layoutBorderPane.setAlignment(inGameBoxScoresVBox, Pos.CENTER);
        layoutBorderPane.setAlignment(buttonsHbox, Pos.CENTER);
        layoutBorderPane.setAlignment(shotChartpane, Pos.CENTER);

        scene = new Scene(layoutBorderPane, 900, 900);
        layoutBorderPane.setId("pane");
        shotChartpane.setId("shotchart");
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
    }


    public void setPeriod(int p) {
        period.setText("Period:" + String.valueOf(p));
    }

    public void setPeriod(String s) {
        period.setText(s);
    }

    public void updatePlayByPlay(String s) {
        updateBoxScores();
        playByPlayLog = "P:" + gameClock.getPeriod() + " " + gameClock.getTime() + " - " + s + '\n' + playByPlayLog;
        playByPlay.setText(playByPlayLog);
    }

    ;

    public void updateClock() {
        String time = "";
        if (gameClock.getShotClock() < 10){
            time = "0" + gameClock.getShotClock();
        }
        else{
            time = "" + gameClock.getShotClock();
        }
        if (gameClock.isTimeUp()) {
            time = "24";
        }
        if (gameClock.getMin() < 10) {
            time = time + "  0" + gameClock.getMin();
        } else {
            time = time + "  " + gameClock.getMin();
        }
        if (gameClock.getSec() < 10) {
            time = time + ":0" + gameClock.getSec();
        } else {
            time = time + ":" + gameClock.getSec();
        }
        minSec.setText(time);
    }

    public void updateTotalPoints() {
        homeTotalPoints.setText(String.valueOf(teamsInGame[GameConstants.HOME_TEAM].getPointsScored()));
        visitorTotalPoints.setText(String.valueOf(teamsInGame[GameConstants.VISITOR_TEAM].getPointsScored()));
    }

    public void colorRecentStatUpdate(int team, int player, int stat){
        if (colorTeam == GameConstants.HOME_TEAM){
            inGamehomeBoxScores[colorPlayer][colorStat].setFill(Color.BLACK);
        }
        else if (colorTeam == GameConstants.VISITOR_TEAM){
            inGamevisitorBoxScores[colorPlayer][colorStat].setFill(Color.BLACK);
        }

        if (team == GameConstants.HOME_TEAM){
            inGamehomeBoxScores[player][stat].setFill(Color.RED);
            colorTeam = GameConstants.HOME_TEAM;
            colorPlayer = player;
            colorStat = stat;
        }
        else if (team == GameConstants.VISITOR_TEAM){
            inGamevisitorBoxScores[player][stat].setFill(Color.RED);
            colorTeam = GameConstants.VISITOR_TEAM;
            colorPlayer = player;
            colorStat = stat;
        }
    }

    public void updateBoxScores() {

        for (int i = 1; i <= 12; i++) {
            for (int j = 0; j <= 14; j++) {
                if (i <= 5) {
                    homeBoxScores[i][j].setText(teamsInGame[GameConstants.HOME_TEAM].roster[i].getBoxScoreStat(j));
                    inGamehomeBoxScores[i][j].setText(teamsInGame[GameConstants.HOME_TEAM].roster[i].getBoxScoreStat(j));
                } else {
                    homeBoxScores[i + 2][j].setText(teamsInGame[1].roster[i].getBoxScoreStat(j));

                }

            }
        }

        for (int i = 1; i <= 12; i++) {
            for (int j = 0; j <= 14; j++) {
                if (i <= 5) {
                    visitorBoxScores[i][j].setText(teamsInGame[GameConstants.VISITOR_TEAM].roster[i].getBoxScoreStat(j));
                    inGamevisitorBoxScores[i][j].setText(teamsInGame[GameConstants.VISITOR_TEAM].roster[i].getBoxScoreStat(j));
                } else {
                    visitorBoxScores[i + 2][j].setText(teamsInGame[2].roster[i].getBoxScoreStat(j));

                }

            }
        }


    }

    public void initializeBoxScores() {

        homeBoxScores[0][1] = new Text("Min");
        homeBoxScoresGrid.add(homeBoxScores[0][1], 1, 0, 1, 1);
        homeBoxScores[0][2] = new Text("FG");
        homeBoxScoresGrid.add(homeBoxScores[0][2], 2, 0, 1, 1);
        homeBoxScores[0][3] = new Text("FGA");
        homeBoxScoresGrid.add(homeBoxScores[0][3], 3, 0, 1, 1);
        homeBoxScores[0][4] = new Text("FT");
        homeBoxScoresGrid.add(homeBoxScores[0][4], 4, 0, 1, 1);
        homeBoxScores[0][5] = new Text("FTA");
        homeBoxScoresGrid.add(homeBoxScores[0][5], 5, 0, 1, 1);
        homeBoxScores[0][6] = new Text("ORB");
        homeBoxScoresGrid.add(homeBoxScores[0][6], 6, 0, 1, 1);
        homeBoxScores[0][7] = new Text("DRB");
        homeBoxScoresGrid.add(homeBoxScores[0][7], 7, 0, 1, 1);
        homeBoxScores[0][8] = new Text("TRB");
        homeBoxScoresGrid.add(homeBoxScores[0][8], 8, 0, 1, 1);
        homeBoxScores[0][9] = new Text("AST");
        homeBoxScoresGrid.add(homeBoxScores[0][9], 9, 0, 1, 1);
        homeBoxScores[0][10] = new Text("STL");
        homeBoxScoresGrid.add(homeBoxScores[0][10], 10, 0, 1, 1);
        homeBoxScores[0][11] = new Text("BLK");
        homeBoxScoresGrid.add(homeBoxScores[0][11], 11, 0, 1, 1);
        homeBoxScores[0][12] = new Text("TOV");
        homeBoxScoresGrid.add(homeBoxScores[0][12], 12, 0, 1, 1);
        homeBoxScores[0][13] = new Text("PF");
        homeBoxScoresGrid.add(homeBoxScores[0][13], 13, 0, 1, 1);
        homeBoxScores[0][14] = new Text("PTS");
        homeBoxScoresGrid.add(homeBoxScores[0][14], 14, 0, 1, 1);

        visitorBoxScores[0][1] = new Text("Min");
        visitorBoxScoresGrid.add(visitorBoxScores[0][1], 1, 0, 1, 1);
        visitorBoxScores[0][2] = new Text("FG");
        visitorBoxScoresGrid.add(visitorBoxScores[0][2], 2, 0, 1, 1);
        visitorBoxScores[0][3] = new Text("FGA");
        visitorBoxScoresGrid.add(visitorBoxScores[0][3], 3, 0, 1, 1);
        visitorBoxScores[0][4] = new Text("FT");
        visitorBoxScoresGrid.add(visitorBoxScores[0][4], 4, 0, 1, 1);
        visitorBoxScores[0][5] = new Text("FTA");
        visitorBoxScoresGrid.add(visitorBoxScores[0][5], 5, 0, 1, 1);
        visitorBoxScores[0][6] = new Text("ORB");
        visitorBoxScoresGrid.add(visitorBoxScores[0][6], 6, 0, 1, 1);
        visitorBoxScores[0][7] = new Text("DRB");
        visitorBoxScoresGrid.add(visitorBoxScores[0][7], 7, 0, 1, 1);
        visitorBoxScores[0][8] = new Text("TRB");
        visitorBoxScoresGrid.add(visitorBoxScores[0][8], 8, 0, 1, 1);
        visitorBoxScores[0][9] = new Text("AST");
        visitorBoxScoresGrid.add(visitorBoxScores[0][9], 9, 0, 1, 1);
        visitorBoxScores[0][10] = new Text("STL");
        visitorBoxScoresGrid.add(visitorBoxScores[0][10], 10, 0, 1, 1);
        visitorBoxScores[0][11] = new Text("BLK");
        visitorBoxScoresGrid.add(visitorBoxScores[0][11], 11, 0, 1, 1);
        visitorBoxScores[0][12] = new Text("TOV");
        visitorBoxScoresGrid.add(visitorBoxScores[0][12], 12, 0, 1, 1);
        visitorBoxScores[0][13] = new Text("PF");
        visitorBoxScoresGrid.add(visitorBoxScores[0][13], 13, 0, 1, 1);
        visitorBoxScores[0][14] = new Text("PTS");
        visitorBoxScoresGrid.add(visitorBoxScores[0][14], 14, 0, 1, 1);

        for (int i = 1; i <= 14; i++) {
            homeBoxScores[0][i].setFont(Font.font(null, FontWeight.BOLD, 14));
            visitorBoxScores[0][i].setFont(Font.font(null, FontWeight.BOLD, 14));
        }


        for (int i = 1; i <= 12; i++) {
            for (int j = 0; j <= 14; j++) {
                if (i <= 5) {
                    homeBoxScores[i][j] = new Text(teamsInGame[1].roster[i].getBoxScoreStat(j));
                    homeBoxScoresGrid.add(homeBoxScores[i][j], j, i, 1, 1);
                    homeBoxScores[i][j].setFont(Font.font(null, FontWeight.BOLD, 13));
                } else {
                    homeBoxScores[i + 2][j] = new Text(teamsInGame[1].roster[i].getBoxScoreStat(j));
                    homeBoxScoresGrid.add(homeBoxScores[i + 2][j], j, i + 2, 1, 1);
                    homeBoxScores[i + 2][j].setFont(Font.font(null, FontWeight.BOLD, 13));
                }

            }
        }

        for (int i = 1; i <= 12; i++) {
            for (int j = 0; j <= 14; j++) {
                if (i <= 5) {
                    visitorBoxScores[i][j] = new Text(teamsInGame[2].roster[i].getBoxScoreStat(j));
                    visitorBoxScoresGrid.add(visitorBoxScores[i][j], j, i, 1, 1);
                    visitorBoxScores[i][j].setFont(Font.font(null, FontWeight.BOLD, 13));
                } else {
                    visitorBoxScores[i + 2][j] = new Text(teamsInGame[2].roster[i].getBoxScoreStat(j));
                    visitorBoxScoresGrid.add(visitorBoxScores[i + 2][j], j, i + 2, 1, 1);
                    visitorBoxScores[i + 2][j].setFont(Font.font(null, FontWeight.BOLD, 13));
                }

            }
        }

        for (int i = 6; i <= 7; i++) {
            for (int j = 0; j <= 14; j++) {
                homeBoxScores[i][j] = new Text("");
                homeBoxScoresGrid.add(homeBoxScores[i][j], j, i, 1, 1);

            }
        }
        for (int i = 6; i <= 7; i++) {
            for (int j = 0; j <= 14; j++) {
                visitorBoxScores[i][j] = new Text("");
                visitorBoxScoresGrid.add(visitorBoxScores[i][j], j, i, 1, 1);

            }
        }


    }

    public void initializeInGameBoxScores(){
        inGamehomeBoxScores[0][1] = new Text("Min");
        inGameHomeBoxScoresGrid.add(inGamehomeBoxScores[0][1], 1, 0, 1, 1);
        inGamehomeBoxScores[0][2] = new Text("FG");
        inGameHomeBoxScoresGrid.add(inGamehomeBoxScores[0][2], 2, 0, 1, 1);
        inGamehomeBoxScores[0][3] = new Text("FGA");
        inGameHomeBoxScoresGrid.add(inGamehomeBoxScores[0][3], 3, 0, 1, 1);
        inGamehomeBoxScores[0][4] = new Text("FT");
        inGameHomeBoxScoresGrid.add(inGamehomeBoxScores[0][4], 4, 0, 1, 1);
        inGamehomeBoxScores[0][5] = new Text("FTA");
        inGameHomeBoxScoresGrid.add(inGamehomeBoxScores[0][5], 5, 0, 1, 1);
        inGamehomeBoxScores[0][6] = new Text("ORB");
        inGameHomeBoxScoresGrid.add(inGamehomeBoxScores[0][6], 6, 0, 1, 1);
        inGamehomeBoxScores[0][7] = new Text("DRB");
        inGameHomeBoxScoresGrid.add(inGamehomeBoxScores[0][7], 7, 0, 1, 1);
        inGamehomeBoxScores[0][8] = new Text("TRB");
        inGameHomeBoxScoresGrid.add(inGamehomeBoxScores[0][8], 8, 0, 1, 1);
        inGamehomeBoxScores[0][9] = new Text("AST");
        inGameHomeBoxScoresGrid.add(inGamehomeBoxScores[0][9], 9, 0, 1, 1);
        inGamehomeBoxScores[0][10] = new Text("STL");
        inGameHomeBoxScoresGrid.add(inGamehomeBoxScores[0][10], 10, 0, 1, 1);
        inGamehomeBoxScores[0][11] = new Text("BLK");
        inGameHomeBoxScoresGrid.add(inGamehomeBoxScores[0][11], 11, 0, 1, 1);
        inGamehomeBoxScores[0][12] = new Text("TOV");
        inGameHomeBoxScoresGrid.add(inGamehomeBoxScores[0][12], 12, 0, 1, 1);
        inGamehomeBoxScores[0][13] = new Text("PF");
        inGameHomeBoxScoresGrid.add(inGamehomeBoxScores[0][13], 13, 0, 1, 1);
        inGamehomeBoxScores[0][14] = new Text("PTS");
        inGameHomeBoxScoresGrid.add(inGamehomeBoxScores[0][14], 14, 0, 1, 1);

        inGamevisitorBoxScores[0][1] = new Text("Min");
        inGameVisitorBoxScoresGrid.add(inGamevisitorBoxScores[0][1], 1, 0, 1, 1);
        inGamevisitorBoxScores[0][2] = new Text("FG");
        inGameVisitorBoxScoresGrid.add(inGamevisitorBoxScores[0][2], 2, 0, 1, 1);
        inGamevisitorBoxScores[0][3] = new Text("FGA");
        inGameVisitorBoxScoresGrid.add(inGamevisitorBoxScores[0][3], 3, 0, 1, 1);
        inGamevisitorBoxScores[0][4] = new Text("FT");
        inGameVisitorBoxScoresGrid.add(inGamevisitorBoxScores[0][4], 4, 0, 1, 1);
        inGamevisitorBoxScores[0][5] = new Text("FTA");
        inGameVisitorBoxScoresGrid.add(inGamevisitorBoxScores[0][5], 5, 0, 1, 1);
        inGamevisitorBoxScores[0][6] = new Text("ORB");
        inGameVisitorBoxScoresGrid.add(inGamevisitorBoxScores[0][6], 6, 0, 1, 1);
        inGamevisitorBoxScores[0][7] = new Text("DRB");
        inGameVisitorBoxScoresGrid.add(inGamevisitorBoxScores[0][7], 7, 0, 1, 1);
        inGamevisitorBoxScores[0][8] = new Text("TRB");
        inGameVisitorBoxScoresGrid.add(inGamevisitorBoxScores[0][8], 8, 0, 1, 1);
        inGamevisitorBoxScores[0][9] = new Text("AST");
        inGameVisitorBoxScoresGrid.add(inGamevisitorBoxScores[0][9], 9, 0, 1, 1);
        inGamevisitorBoxScores[0][10] = new Text("STL");
        inGameVisitorBoxScoresGrid.add(inGamevisitorBoxScores[0][10], 10, 0, 1, 1);
        inGamevisitorBoxScores[0][11] = new Text("BLK");
        inGameVisitorBoxScoresGrid.add(inGamevisitorBoxScores[0][11], 11, 0, 1, 1);
        inGamevisitorBoxScores[0][12] = new Text("TOV");
        inGameVisitorBoxScoresGrid.add(inGamevisitorBoxScores[0][12], 12, 0, 1, 1);
        inGamevisitorBoxScores[0][13] = new Text("PF");
        inGameVisitorBoxScoresGrid.add(inGamevisitorBoxScores[0][13], 13, 0, 1, 1);
        inGamevisitorBoxScores[0][14] = new Text("PTS");
        inGameVisitorBoxScoresGrid.add(inGamevisitorBoxScores[0][14], 14, 0, 1, 1);

        for (int i = 1; i <= 14; i++) {
            inGamehomeBoxScores[0][i].setFont(Font.font(null, FontWeight.BOLD, 18));
            inGamevisitorBoxScores[0][i].setFont(Font.font(null, FontWeight.BOLD, 18));
        }

        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j <= 14; j++) {
                inGamehomeBoxScores[i][j] = new Text(teamsInGame[GameConstants.HOME_TEAM].roster[i].getBoxScoreStat(j));
                inGameHomeBoxScoresGrid.add(inGamehomeBoxScores[i][j], j, i, 1, 1);
                inGamehomeBoxScores[i][j].setFont(Font.font(null, FontWeight.BOLD, 21));

                inGamevisitorBoxScores[i][j] = new Text(teamsInGame[GameConstants.VISITOR_TEAM].roster[i].getBoxScoreStat(j));
                inGameVisitorBoxScoresGrid.add(inGamevisitorBoxScores[i][j], j, i, 1, 1);
                inGamevisitorBoxScores[i][j].setFont(Font.font(null, FontWeight.BOLD, 21));
            }
        }
    }

    public void viewShotChart() {
        layoutBorderPane.setCenter(shotChartpane);
    }
    public void viewFullBoxScore() {
        layoutBorderPane.setCenter(boxScoresVBox);
        boxScoresButton.setText("Play by Play");
        fullBoxScores = true;
    }

    public void viewInGameBoxScore() {
        layoutBorderPane.setCenter(inGameBoxScoresVBox);
        fullBoxScores = false;
    }

    public void updateShotChart(int team, int twoOrThree, boolean shotMade) {
        if (team == GameConstants.HOME_TEAM) {
            if (twoOrThree == 2) {
                if (shotMade) {
                    homeShotsIndex++;
                    homeShots[homeShotsIndex] = new Text("O");

                    int y = getYLocation(twoOrThree);
                    int x = getXLocation(y, twoOrThree, team);
                    homeShots[homeShotsIndex].setFill(Color.GREEN);
                    homeShots[homeShotsIndex].setFont(Font.font("Arial", FontWeight.BOLD, 22));
                    homeShots[homeShotsIndex].setX(x);
                    homeShots[homeShotsIndex].setY(y);
                    shotChartpane.getChildren().add(homeShots[homeShotsIndex]);


                } else {
                    homeShotsIndex++;
                    homeShots[homeShotsIndex] = new Text("X");

                    int y = getYLocation(twoOrThree);
                    int x = getXLocation(y, twoOrThree, team);
                    homeShots[homeShotsIndex].setFill(Color.RED);
                    homeShots[homeShotsIndex].setFont(Font.font("Arial", FontWeight.BOLD, 22));
                    homeShots[homeShotsIndex].setX(x);
                    homeShots[homeShotsIndex].setY(y);
                    shotChartpane.getChildren().add(homeShots[homeShotsIndex]);

                }

            } else {
                if (shotMade) {
                    homeShotsIndex++;
                    homeShots[homeShotsIndex] = new Text("O");

                    int y = getYLocation(twoOrThree);
                    int x = getXLocation(y, twoOrThree, team);
                    homeShots[homeShotsIndex].setFill(Color.GREEN);
                    homeShots[homeShotsIndex].setFont(Font.font("Arial", FontWeight.BOLD, 22));
                    homeShots[homeShotsIndex].setX(x);
                    homeShots[homeShotsIndex].setY(y);
                    shotChartpane.getChildren().add(homeShots[homeShotsIndex]);


                } else {
                    homeShotsIndex++;
                    homeShots[homeShotsIndex] = new Text("X");

                    int y = getYLocation(twoOrThree);
                    int x = getXLocation(y, twoOrThree, team);
                    homeShots[homeShotsIndex].setFill(Color.RED);
                    homeShots[homeShotsIndex].setFont(Font.font("Arial", FontWeight.BOLD, 22));
                    homeShots[homeShotsIndex].setX(x);
                    homeShots[homeShotsIndex].setY(y);

                    shotChartpane.getChildren().add(homeShots[homeShotsIndex]);

                }

            }
        } else {
            if (twoOrThree == 2) {
                if (shotMade) {
                    visitorShotsIndex++;
                    visitorShots[visitorShotsIndex] = new Text("O");

                    int y = getYLocation(twoOrThree);
                    int x = getXLocation(y, twoOrThree, team);
                    visitorShots[visitorShotsIndex].setFill(Color.GREEN);
                    visitorShots[visitorShotsIndex].setFont(Font.font("Arial", FontWeight.BOLD, 22));
                    visitorShots[visitorShotsIndex].setX(x);
                    visitorShots[visitorShotsIndex].setY(y);
                    shotChartpane.getChildren().add(visitorShots[visitorShotsIndex]);


                } else {
                    visitorShotsIndex++;
                    visitorShots[visitorShotsIndex] = new Text("X");

                    int y = getYLocation(twoOrThree);
                    int x = getXLocation(y, twoOrThree, team);
                    if (x > 840)
                        x= 810;
                    visitorShots[visitorShotsIndex].setFill(Color.RED);
                    visitorShots[visitorShotsIndex].setFont(Font.font("Arial", FontWeight.BOLD, 22));
                    visitorShots[visitorShotsIndex].setY(y);
                    visitorShots[visitorShotsIndex].setX(x);
                    shotChartpane.getChildren().add(visitorShots[visitorShotsIndex]);

                }

            } else {
                if (shotMade) {
                    visitorShotsIndex++;
                    visitorShots[visitorShotsIndex] = new Text("O");

                    int y = getYLocation(twoOrThree);
                    int x = getXLocation(y, twoOrThree, team);
                    visitorShots[visitorShotsIndex].setFill(Color.GREEN);
                    visitorShots[visitorShotsIndex].setFont(Font.font("Arial", FontWeight.BOLD, 22));
                    visitorShots[visitorShotsIndex].setX(x);
                    visitorShots[visitorShotsIndex].setY(y);
                    shotChartpane.getChildren().add(visitorShots[visitorShotsIndex]);


                } else {
                    visitorShotsIndex++;
                    visitorShots[visitorShotsIndex] = new Text("X");

                    int y = getYLocation(twoOrThree);
                    int x = getXLocation(y, twoOrThree, team);
                    visitorShots[visitorShotsIndex].setFill(Color.RED);
                    visitorShots[visitorShotsIndex].setFont(Font.font("Arial", FontWeight.BOLD, 22));
                    visitorShots[visitorShotsIndex].setX(x);
                    visitorShots[visitorShotsIndex].setY(y);
                    shotChartpane.getChildren().add(visitorShots[visitorShotsIndex]);

                }

            }
        }
    }

    public int getYLocation(int twoOrThree) {
        int toReturn;

        if (twoOrThree == 2) {
            int min = 127;
            int max = 589;
            toReturn = min + (int) (Math.random() * ((max - min) + 1));

        } else {
            int min = 75;
            int max = 640;
            toReturn = min + (int) (Math.random() * ((max - min) + 1));

        }
        return toReturn;
    }

    public int getXLocation(int y, int twoOrThree, int team) {
        int toReturn;
        int min;
        int max;

        if (team == 1) {
            if (twoOrThree == 2) {
                min = 20;
                max = 235;
                if (y >= 255 && y <= 457) {
                    min = 60;
                    max = 234;
                    toReturn = min + (int) (Math.random() * ((max - min) + 1));
                    return toReturn;
                }
                else if (y <= 254){
                    min = 20;
                    max = max - (y - 127);
                    toReturn = min + (int) (Math.random() * ((max - min) + 1));
                    return toReturn;
                }
                else if (y >= 458){
                    min = 40;
                    max = max - (589 - y);
                    toReturn = min + (int) (Math.random() * ((max - min) + 1));
                    return toReturn;
                }
            }
            else {
                min = 20;
                max = 275;
                if (y >= 75 && y <= 126) {
                    toReturn = min + (int) (Math.random() * ((max - min) + 1));
                    return toReturn;
                } else if (y >= 590 && y <= 640) {
                    toReturn = min + (int) (Math.random() * ((max - min) + 1));
                    return toReturn;
                } else if (y >= 255 && y <= 457) {
                    min = 236;
                    toReturn = min + (int) (Math.random() * ((max - min) + 1));
                    return toReturn;
                } else if (y >= 127 && y <= 254) {
                    min = (y - 128) + min;
                    toReturn = min + (int) (Math.random() * ((max - min) + 1));
                    return toReturn;
                } else if (y >= 458 && y <= 589) {
                    min = min - (y - 458);
                    toReturn = min + (int) (Math.random() * ((max - min) + 1));
                    return toReturn;
                }

            }
        }
        else if (team == 2) {
            if (twoOrThree == 2) {
                min = 658;
                max = 860;
                if (y >= 255 && y <= 457) {
                    min = 657;
                    max = 810;
                    toReturn = min + (int) (Math.random() * ((max - min) + 1));
                    return toReturn;
                }
                else if (y <= 254){
                    max = 850;
                    min = min + (254 - y);
                    toReturn = min + (int) (Math.random() * ((max - min) + 1));
                    return toReturn;
                }
                else if (y >= 458){
                    max = 810;
                    min = min + (589 - y);
                    toReturn = min + (int) (Math.random() * ((max - min) + 1));
                    return toReturn;
                }
            } else {
                min = 600;
                max = 870;
                if (y >= 75 && y <= 126) {
                    toReturn = min + (int) (Math.random() * ((max - min) + 1));
                    return toReturn;
                } else if (y >= 590 && y <= 640) {
                    toReturn = min + (int) (Math.random() * ((max - min) + 1));
                    return toReturn;
                } else if (y >= 255 && y <= 457) {
                    max = 653;
                    toReturn = min + (int) (Math.random() * ((max - min) + 1));
                    return toReturn;
                } else if (y >= 127 && y <= 254) {
                    max = max - (y - 128);
                    toReturn = min + (int) (Math.random() * ((max - min) + 1));
                    return toReturn;
                } else if (y >= 458 && y <= 589) {
                    max = max + (y - 458);
                    toReturn = min + (int) (Math.random() * ((max - min) + 1));
                    return toReturn;
                }

            }

            return 1;
        }
        return 1;
    }


}



