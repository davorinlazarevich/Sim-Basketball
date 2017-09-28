import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class App extends Application {
    DraftFile draftFile;
    DraftGui draftGui;
    SetLineupGui setLineupGui;
    GameGui gameGui;
    GameSimulation gameSimulation;
    Thread thread;

    Team homeTeam;
    Team visitorTeam;
    Team [] teamsInGame;

    GameClock gameClock;
    GameBall gameBall;

    Text simBasketballText;
    Button userVsCpuButton;
    Button userVsUser;

    VBox firstSceneCenterVBox;
    BorderPane firstLayoutBorderPane;
    Scene firstScene;

    public void start(Stage primaryStage) throws Exception {
        draftGui = new DraftGui();
        draftFile = new DraftFile();
        setLineupGui = new SetLineupGui();
        gameGui = new GameGui();
        gameSimulation = new GameSimulation();
        thread = new Thread(gameSimulation);

        homeTeam = new Team("Home Team");
        visitorTeam = new Team("Visitor Team");
        teamsInGame = new Team[GameConstants.MAX_TEAMS];
        teamsInGame[GameConstants.HOME_TEAM] = homeTeam;
        teamsInGame[GameConstants.VISITOR_TEAM] = visitorTeam;
        gameClock = new GameClock();
        gameBall = new GameBall(teamsInGame);

        thread.start();
        draftGui.initializeDraftGui(teamsInGame, draftFile);

        int teamDrafting = 1;
        int gameDifficulty = 10;
        boolean userVsCpu = true;

        simBasketballText = new Text("SIM BASKETBALL");
        simBasketballText.setFont(Font.font("Arial", 25));

        userVsCpuButton = new Button("P1 vs CPU");
        userVsUser = new Button("P1 vs P2");

        userVsCpuButton.setPadding(new Insets(30, 20, 30, 20));
        userVsCpuButton.setStyle("-fx-font-size: 15pt;");
        //userVsCpuButton.setStyle("-fx-background-color: #eaecef");

        userVsUser.setPadding(new Insets(30, 20, 30, 20));
        userVsUser.setStyle("-fx-font-size: 15pt;");
        firstSceneCenterVBox = new VBox(simBasketballText,userVsCpuButton, userVsUser);
        firstSceneCenterVBox.setSpacing(20);
        firstLayoutBorderPane = new BorderPane();
        firstLayoutBorderPane.setCenter(firstSceneCenterVBox);
        firstSceneCenterVBox.setAlignment(Pos.CENTER);

        firstLayoutBorderPane.setId("firstScene");

        firstScene = new Scene(firstLayoutBorderPane ,900, 900);
        firstScene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());


        primaryStage.setTitle("Sim Basketball");
        //primaryStage.setResizable(false);
        primaryStage.setScene(firstScene);
        primaryStage.show();

        userVsCpuButton.setOnAction( ( ActionEvent event ) ->
        {
            draftGui.setUserVScpuDifficulty(true, gameDifficulty);
            primaryStage.setScene(draftGui.draftScene);

        } );

        userVsUser.setOnAction( ( ActionEvent event ) ->
        {
            draftGui.setUserVScpuDifficulty(false, gameDifficulty);
            primaryStage.setScene(draftGui.draftScene);

        } );

        draftGui.goToSetupLineupGui.setOnAction( ( ActionEvent event ) ->
        {
            if (teamsInGame[GameConstants.HOME_TEAM].getRosterSize() == 12 && teamsInGame[GameConstants.VISITOR_TEAM].getRosterSize() == 12) {
                teamsInGame[GameConstants.HOME_TEAM].setLineup();
                teamsInGame[GameConstants.VISITOR_TEAM].setLineup();

                setLineupGui.setupTeams(teamsInGame, userVsCpu);
                if (draftGui.userVsCpu){
                    setLineupGui.visitorButtonInvisible();
                }
                primaryStage.setScene(setLineupGui.scene);

            }
        } );

        setLineupGui.startGameButton2.setOnAction((ActionEvent event) ->
        {
            gameGui.setupGamePage(teamsInGame, gameClock, gameBall);
            primaryStage.setScene(gameGui.scene);
            gameSimulation.initializeGame(teamsInGame, gameClock, gameBall, gameGui);

        });

        gameGui.fastForwardToEnd.setOnAction((ActionEvent event) ->
        {
            gameSimulation.fastmode = false;
            if (gameSimulation.gameOver == false && !gameSimulation.fastmode) {
                gameSimulation.startButtonPressed = true;
                gameSimulation.fastmode = true;
                gameSimulation.slowermode = false;
                gameSimulation.pauseGame();
                gameSimulation.setGameRunning();
                gameSimulation.runGameToEnd();
            }
        });
        gameGui.fastForwardButton.setOnAction((ActionEvent event) ->
        {
            if (gameSimulation.gameOver == false && !gameSimulation.fastmode) {
                gameSimulation.startButtonPressed = true;
                gameSimulation.fastmode = true;
                gameSimulation.slowermode = false;
                gameSimulation.pauseGame();
                gameSimulation.speedUpGame();
                gameSimulation.setGameRunning();
                gameSimulation.startScheduledExecutorService();
            }
        });


        gameGui.startButton.setOnAction((ActionEvent event) ->
        {
            if (gameSimulation.gameOver == false && !gameSimulation.startButtonPressed) {
                gameSimulation.slowDownGame();
                gameSimulation.pauseGame();
                gameSimulation.startButtonPressed = true;
                gameSimulation.setGameRunning();
                gameSimulation.startScheduledExecutorService();
            }



        });
        gameGui.stopButton.setOnAction((ActionEvent event) ->
        {
            gameSimulation.pauseGame();
            gameSimulation.startButtonPressed = false;
            gameSimulation.fastmode = false;
            gameSimulation.slowermode = false;
        });

        gameGui.shotChartButton.setOnAction((ActionEvent event) ->
        {
            gameGui.viewShotChart();
        });
        gameGui.boxScoresButton.setOnAction((ActionEvent event) ->
        {
            gameGui.viewInGameBoxScore();

        });

        gameGui.fullBoxScoresButton.setOnAction((ActionEvent event) ->
        {
            gameGui.viewFullBoxScore();
        });
        gameGui.restartGameButton.setOnAction((ActionEvent event) ->
        {
            restart();
            primaryStage.setScene(firstScene);

        });


    }
    public void restart(){
        DraftFile df = new DraftFile();
        draftFile = df;

        GameSimulation gs = new GameSimulation();
        gameSimulation = gs;

        Thread t = new Thread(gameSimulation);
        thread = t;
        thread.start();

        Team h1 = new Team("Home Team");
        homeTeam = h1;

        Team v2 = new Team("Visitor Team");
        visitorTeam = v2;

        Team [] tig = new Team[3];
        teamsInGame = tig;

        teamsInGame[1] = h1;
        teamsInGame[2] = v2;

        GameClock gc = new GameClock();
        gameClock = gc;

        GameBall gb = new GameBall(teamsInGame);
        gameBall = gb;

        draftGui.initializeDraftGui(teamsInGame, draftFile);

        VBox fscvb = new VBox(simBasketballText,userVsCpuButton, userVsUser);
        firstSceneCenterVBox = fscvb;
        firstSceneCenterVBox.setSpacing(20);
        BorderPane flbp = new BorderPane();
        firstLayoutBorderPane = flbp;
        firstLayoutBorderPane.setCenter(firstSceneCenterVBox);
        firstSceneCenterVBox.setAlignment(Pos.CENTER);

        firstLayoutBorderPane.setId("firstScene");

        Scene s = new Scene(firstLayoutBorderPane ,900, 900);
        firstScene = s;
        firstScene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());


    }




    public static void main(String [] args){
        launch(args);



    }

}
