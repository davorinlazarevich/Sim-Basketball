import javafx.application.Platform;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameSimulation implements Runnable{
    GameGui gameGui;
    GameClock gameClock;
    GameBall gameBall;
    Team [] teamsInGame;
    boolean gameRunning;
    boolean gameOver;
    boolean endOfPeriod;
    GameEvent gameEvent;
    int gamespeed;
    TimeUnit gs;
    boolean fastmode;
    boolean slowermode;
    boolean startButtonPressed;

    public GameSimulation() {
        gamespeed = 1000;
        fastmode = false;
        slowermode = false;
        startButtonPressed = false;
    }

    public void run(){
        gameRunning = false;
        gameOver = false;
        endOfPeriod = false;

    }

    public void initializeGame(Team[] tig, GameClock gc, GameBall gb, GameGui gg) {
        teamsInGame = tig;
        gameGui = gg;
        gameClock = gc;
        gameBall = gb;
        gameEvent = new GameEvent(teamsInGame, gameClock, gameBall, gameGui);
    }

    public void runGame() {
        gameRunning = true;
        endOfPeriod = false;

        if (gameRunning)
        {
            gameEvent.runEvent();

            if (gameClock.getSec() == 1) {
                updateMinutes();

            }
            endOfPeriod = gameClock.tick();
            gameGui.updateClock();
            if (endOfPeriod){
                gameBall.changePoss();
            }


            if (teamsInGame[1].pointsScored != teamsInGame[2].pointsScored && gameClock.getPeriod() >= 4) {
                gameOver = true;
            } else if (endOfPeriod == true) {
                gameClock.setPeriod();
                gameClock.resetShotClock();
                gameGui.setPeriod(gameClock.getPeriod());
                gameGui.updateClock();
                gameBall.changePoss();
                startButtonPressed = false;
                fastmode = false;
            }
            if (gameOver){
                String playByPlay = "GAME OVER";
                gameClock.resetShotClock();
                gameGui.setPeriod("FINAL");
                gameGui.updatePlayByPlay(playByPlay);
            }
        }

    }

    public void runGameToEnd() {

        while (!gameOver)
        {
            gameEvent.runEvent();

            if (gameClock.getSec() == 1) {
                updateMinutes();

            }
            endOfPeriod = gameClock.tick();
            gameGui.updateClock();
            if (endOfPeriod){
                gameBall.changePoss();
            }


            if (teamsInGame[1].pointsScored != teamsInGame[2].pointsScored && endOfPeriod && gameClock.getPeriod() >= 4) {
                gameOver = true;
            } else if (endOfPeriod == true) {
                gameClock.setPeriod();
                gameGui.setPeriod(gameClock.getPeriod());
                gameGui.updateClock();
            }
            if (gameOver){
                String playByPlay = "GAME OVER";
                gameClock.resetShotClock();
                gameGui.setPeriod("FINAL");
                gameGui.updatePlayByPlay(playByPlay);
            }
        }

    }


    public void pauseGame(){
        gameRunning = false;
    }

    public void updateMinutes(){
        for (int i = 1; i <= 5; i++){
            teamsInGame[1].roster[i].updateBoxScore(1,1);
            teamsInGame[2].roster[i].updateBoxScore(1,1);
        }
    }

    public void setGameRunning(){
        gameRunning = true;
        endOfPeriod = false;
    }

    public void speedUpGame(){
        gamespeed = 50;
    }

    public void slowDownGame(){
        gamespeed = 1000;
    }

    public void startScheduledExecutorService(){

        final ScheduledExecutorService scheduler
                = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(
                new Runnable(){

                    @Override
                    public void run() {

                        if(gameRunning && endOfPeriod == false){

                            Platform.runLater(new Runnable(){
                                @Override
                                public void run() {
                                    runGame();
                                }
                            });

                        }else{
                            scheduler.shutdown();

                        }

                    }
                },
                1,
                gamespeed,
                TimeUnit.MILLISECONDS);
    }

    public void reset(){

    }
}