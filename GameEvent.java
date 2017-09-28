
public class GameEvent {
    GameGui gameGui;
    GameClock gameClock;
    GameBall gameBall;
    Team [] teamsInGame;
    EventProbability eventProbability;


    public GameEvent (Team [] tig, GameClock gc, GameBall gb, GameGui gg){
        teamsInGame = tig;
        gameGui = gg;
        gameClock = gc;
        gameBall = gb;
        eventProbability = new EventProbability(teamsInGame, gb);
    }

    public void runEvent() {
        if (gameBall.getState() == GameConstants.LIVE_GAME) {
            double decision = Math.random() * 100;

            if (teamsInGame[gameBall.getDefPoss()].getPointRun() > 8){
                substituteAi();
            }
            if (gameBall.getlocationOnCourt() < 10) {
                tryToScore();
            } else if (decision > 50 && decision < 53) {
                substituteAi();
            } else if (decision > 8 && decision < 28) {
                shoot();
            } else if (decision <= 2) {
                turnover();
                if (gameClock.getShotClock() == 0) {
                    turnover(1);
                }
            }
        }
        else if (gameBall.getState() == GameConstants.MISSED_SHOT) {
                rebound();
        }
        else if (gameBall.getState() == GameConstants.LOOSE_BALL) {
                obtainLooseBall();
        }
        else if (gameBall.getState() == GameConstants.JUMP_BALL) {
                jumpBall();
        }
    }


    public void tryToScore(){
        gameBall.advBallTowardsBasket();
    }

    public void shoot(){
        int twoOrThreeAttempted = eventProbability.twoOrThreeAttempted();
        int player = eventProbability.whoShotTheBall(twoOrThreeAttempted);

        teamsInGame[gameBall.getPoss()].roster[player].updateBoxScore(GameConstants.BOXSCORE_FGA, 1);
        gameGui.colorRecentStatUpdate(gameBall.getPoss(),player,GameConstants.BOXSCORE_FGA);
        gameGui.updateBoxScores();

        String playByPlay = twoOrThreeAttempted + " point field goal attempted by " + teamsInGame[gameBall.getPoss()].roster[player].getName();
        gameGui.updatePlayByPlay(playByPlay);

        boolean didShotGoIn = eventProbability.didShotGoIn(twoOrThreeAttempted, player);

        if (didShotGoIn){

            teamsInGame[gameBall.getPoss()].pointsScored(twoOrThreeAttempted);
            gameGui.updateTotalPoints();
            teamsInGame[gameBall.getPoss()].setPointRun(twoOrThreeAttempted);
            teamsInGame[gameBall.getDefPoss()].setPointRun(GameConstants.ZERO_POINTS);
            teamsInGame[gameBall.getPoss()].roster[player].updateBoxScore(GameConstants.BOXSCORE_FG,1);
            teamsInGame[gameBall.getPoss()].roster[player].updateBoxScore(GameConstants.BOXSCORE_PTS,twoOrThreeAttempted);
            gameGui.colorRecentStatUpdate(gameBall.getPoss(),player,GameConstants.BOXSCORE_PTS);
            gameGui.updateShotChart(gameBall.getPoss(), twoOrThreeAttempted, true);
            //gamePage.updateBoxScores();
            playByPlay = twoOrThreeAttempted + " point field goal made by " + teamsInGame[gameBall.getPoss()].roster[player].getName();
            gameGui.updatePlayByPlay(playByPlay);
            gameClock.resetShotClock();

            boolean isAssisted = eventProbability.isAssisted(player);
            if (isAssisted){
                int whoAssisted = eventProbability.whoAssisted(player);
                teamsInGame[gameBall.getPoss()].roster[whoAssisted].updateBoxScore(GameConstants.BOXSCORE_AST,1);
                gameGui.colorRecentStatUpdate(gameBall.getPoss(),whoAssisted,GameConstants.BOXSCORE_AST);
                playByPlay = "Assisted by " + teamsInGame[gameBall.getPoss()].roster[whoAssisted].getName();
                gameGui.updatePlayByPlay(playByPlay);
            }

            boolean isFouledOnShot = eventProbability.isFouledOnShot(player);
            if (isFouledOnShot){
                int playerWhoFouled = eventProbability.whoFouled();
                teamsInGame[gameBall.getDefPoss()].roster[playerWhoFouled].updateBoxScore(GameConstants.BOXSCORE_PF,1);
                gameGui.colorRecentStatUpdate(gameBall.getDefPoss(),playerWhoFouled,GameConstants.BOXSCORE_PF);
                playByPlay = "Fouled by " + teamsInGame[gameBall.getDefPoss()].roster[playerWhoFouled].getName();
                gameGui.updatePlayByPlay(playByPlay);

                if( teamsInGame[gameBall.getDefPoss()].roster[playerWhoFouled].getBoxScoreStatInt(GameConstants.BOXSCORE_PF) >= GameConstants.MAX_PF){
                    playByPlay = teamsInGame[gameBall.getDefPoss()].roster[playerWhoFouled].getName() + " has fouled out of the game.";
                    gameGui.updatePlayByPlay(playByPlay);
                    teamsInGame[gameBall.getDefPoss()].playerOutRestOfGame(playerWhoFouled);
                }

                boolean didFtGoIn = eventProbability.didShotGoIn(GameConstants.ONE_POINT,player);
                if(didFtGoIn){
                    teamsInGame[gameBall.getPoss()].pointsScored(GameConstants.ONE_POINT);
                    gameGui.updateTotalPoints();
                    teamsInGame[gameBall.getPoss()].setPointRun(GameConstants.ONE_POINT);
                    teamsInGame[gameBall.getDefPoss()].setPointRun(GameConstants.ZERO_POINTS);
                    teamsInGame[gameBall.getPoss()].roster[player].updateBoxScore(GameConstants.BOXSCORE_FT,1);
                    teamsInGame[gameBall.getPoss()].roster[player].updateBoxScore(GameConstants.BOXSCORE_FTA,1);
                    teamsInGame[gameBall.getPoss()].roster[player].updateBoxScore(14,1);
                    gameGui.colorRecentStatUpdate(gameBall.getPoss(),player,GameConstants.BOXSCORE_FTA);
                    playByPlay = "Free throw made by " + teamsInGame[gameBall.getPoss()].roster[player].getName();
                    gameGui.updatePlayByPlay(playByPlay);
                    gameBall.changePoss();
                    gameClock.resetShotClock();
                }
                else{
                    teamsInGame[gameBall.getPoss()].roster[player].updateBoxScore(GameConstants.BOXSCORE_FTA,1);
                    gameGui.colorRecentStatUpdate(gameBall.getPoss(),player,GameConstants.BOXSCORE_FTA);
                    playByPlay = "Free throw missed by " + teamsInGame[gameBall.getPoss()].roster[player].getName();
                    gameGui.updatePlayByPlay(playByPlay);
                    gameBall.setState(GameConstants.MISSED_SHOT);
                }
            }
            else{
                gameBall.changePoss();
                gameClock.resetShotClock();
            }


        }
        else{
            boolean isFouledOnShot = eventProbability.isFouledOnShot(player);
            boolean isBlockedShot = eventProbability.isBlockedShot();
            gameGui.updateShotChart(gameBall.getPoss(), twoOrThreeAttempted, false);

                if (isFouledOnShot) {
                    int playerWhoFouled = eventProbability.whoFouled();
                    teamsInGame[gameBall.getDefPoss()].roster[playerWhoFouled].updateBoxScore(GameConstants.BOXSCORE_PF, 1);
                    gameGui.colorRecentStatUpdate(gameBall.getDefPoss(),playerWhoFouled,GameConstants.BOXSCORE_PF);
                    playByPlay = "Personal foul on " + teamsInGame[gameBall.getDefPoss()].roster[playerWhoFouled].getName();
                    gameGui.updatePlayByPlay(playByPlay);

                    if (teamsInGame[gameBall.getDefPoss()].roster[playerWhoFouled].getBoxScoreStatInt(GameConstants.BOXSCORE_PF) >= GameConstants.MAX_PF){
                        playByPlay = teamsInGame[gameBall.getDefPoss()].roster[playerWhoFouled].getName() + " has fouled out of the game.";
                        gameGui.updatePlayByPlay(playByPlay);
                        teamsInGame[gameBall.getDefPoss()].playerOutRestOfGame(playerWhoFouled);
                    }

                    boolean didFtGoIn = true;
                    while (twoOrThreeAttempted != 0) {
                        didFtGoIn = eventProbability.didShotGoIn(GameConstants.ONE_POINT, player);
                        if (didFtGoIn) {
                            teamsInGame[gameBall.getPoss()].pointsScored(GameConstants.ONE_POINT);
                            gameGui.updateTotalPoints();
                            teamsInGame[gameBall.getPoss()].setPointRun(GameConstants.ONE_POINT);
                            teamsInGame[gameBall.getDefPoss()].setPointRun(GameConstants.ZERO_POINTS);
                            teamsInGame[gameBall.getPoss()].roster[player].updateBoxScore(GameConstants.BOXSCORE_FT, 1);
                            teamsInGame[gameBall.getPoss()].roster[player].updateBoxScore(GameConstants.BOXSCORE_FTA, 1);
                            teamsInGame[gameBall.getPoss()].roster[player].updateBoxScore(GameConstants.BOXSCORE_PTS, 1);
                            gameGui.colorRecentStatUpdate(gameBall.getPoss(),player,GameConstants.BOXSCORE_PTS);
                            playByPlay = "Free throw made by " + teamsInGame[gameBall.getPoss()].roster[player].getName();
                            gameGui.updatePlayByPlay(playByPlay);
                        } else {
                            teamsInGame[gameBall.getPoss()].roster[player].updateBoxScore(GameConstants.BOXSCORE_FTA, 1);
                            gameGui.colorRecentStatUpdate(gameBall.getPoss(),player,GameConstants.BOXSCORE_FTA);
                            playByPlay = "Free throw missed by " + teamsInGame[gameBall.getPoss()].roster[player].getName();
                            gameGui.updatePlayByPlay(playByPlay);
                        }
                        twoOrThreeAttempted--;

                    }
                    if (!didFtGoIn){
                        gameBall.setState(GameConstants.MISSED_SHOT);
                    }
                    else{
                        gameBall.changePoss();

                    }
                    gameClock.resetShotClock();

            }
            else if(isBlockedShot && !isFouledOnShot){
                    int whoBlockedShot = eventProbability.whoBlockedShot();
                    teamsInGame[gameBall.getDefPoss()].roster[whoBlockedShot].updateBoxScore(GameConstants.BOXSCORE_BLK, 1);
                    gameGui.colorRecentStatUpdate(gameBall.getDefPoss(),whoBlockedShot,GameConstants.BOXSCORE_BLK);
                    playByPlay = "Blocked by " + teamsInGame[gameBall.getDefPoss()].roster[whoBlockedShot].getName();
                    gameGui.updatePlayByPlay(playByPlay);
                    gameBall.setState(GameConstants.LOOSE_BALL);
                }
                else{
                    gameBall.setState(GameConstants.MISSED_SHOT);
                    playByPlay = twoOrThreeAttempted + " point field goal missed by " + teamsInGame[gameBall.getPoss()].roster[player].getName();
                    gameGui.updatePlayByPlay(playByPlay);
                    gameClock.resetShotClock();
                }


        }
    }

    public void rebound(){
        int whatTeamRebounded = eventProbability.whatTeamRebounded();   //If 1 defense recovered, 2 offense recovered
        int whoRebounded = eventProbability.whoRebounded(whatTeamRebounded);
        if (whatTeamRebounded == GameConstants.HOME_TEAM){  //Defensive Rebound occured
            teamsInGame[gameBall.getDefPoss()].roster[whoRebounded].updateBoxScore(GameConstants.BOXSCORE_TRB, 1);
            teamsInGame[gameBall.getDefPoss()].roster[whoRebounded].updateBoxScore(GameConstants.BOXSCORE_DRB, 1);
            gameGui.colorRecentStatUpdate(gameBall.getDefPoss(),whoRebounded,GameConstants.BOXSCORE_DRB);
            String playByPlay = "Defensive rebound by " + teamsInGame[gameBall.getDefPoss()].roster[whoRebounded].getName();
            gameGui.updatePlayByPlay(playByPlay);
            gameBall.setState(GameConstants.LIVE_GAME);
            gameBall.changePoss();
            gameClock.resetShotClock();
        }
        else{   //Offensive Rebound occured
            teamsInGame[gameBall.getPoss()].roster[whoRebounded].updateBoxScore(GameConstants.BOXSCORE_TRB, 1);
            teamsInGame[gameBall.getPoss()].roster[whoRebounded].updateBoxScore(GameConstants.BOXSCORE_ORB, 1);
            gameGui.colorRecentStatUpdate(gameBall.getPoss(),whoRebounded,GameConstants.BOXSCORE_ORB);
            String playByPlay = "Offensive rebound by " + teamsInGame[gameBall.getPoss()].roster[whoRebounded].getName();
            gameGui.updatePlayByPlay(playByPlay);
            gameBall.setState(GameConstants.LIVE_GAME);
            gameClock.resetShotClock();
        }

    }

    public void turnover(){
        int whoTurnedItOver = eventProbability.whoTurnedItOver();
        teamsInGame[gameBall.getPoss()].roster[whoTurnedItOver].updateBoxScore(GameConstants.BOXSCORE_TO, 1);
        gameGui.colorRecentStatUpdate(gameBall.getPoss(),whoTurnedItOver,GameConstants.BOXSCORE_TO);

        int whoStoleTheBall = eventProbability.whoStoleTheBall();
        teamsInGame[gameBall.getDefPoss()].roster[whoStoleTheBall].updateBoxScore(GameConstants.BOXSCORE_STL, 1);
        gameGui.colorRecentStatUpdate(gameBall.getDefPoss(),whoStoleTheBall,GameConstants.BOXSCORE_STL);
        String playByPlay = teamsInGame[gameBall.getPoss()].roster[whoTurnedItOver].getName() + " turns the ball over. Stolen by " + teamsInGame[gameBall.getDefPoss()].roster[whoStoleTheBall].getName();
        gameGui.updatePlayByPlay(playByPlay);

        gameBall.changePoss();
        gameClock.resetShotClock();
    }

    public void turnover(int to){
        if (to == 1){
            if (gameBall.getPoss() == 1){
                String playByPlay = "Shot clock violation. Visitor team now gets possession.";
                gameGui.updatePlayByPlay(playByPlay);
            }
            else{
                String playByPlay = "Shot clock violation. Home team now gets possession.";
                gameGui.updatePlayByPlay(playByPlay);
            }
        }
        gameBall.changePoss();
        gameClock.resetShotClock();
        gameBall.setState(GameConstants.LIVE_GAME);
        System.out.println("Shot clock violation");
    }

    public void personalFoul(){
        int playerWhoFouled = eventProbability.whoFouled();
        teamsInGame[gameBall.getDefPoss()].roster[playerWhoFouled].updateBoxScore(GameConstants.BOXSCORE_PF, 1);
        gameGui.colorRecentStatUpdate(gameBall.getDefPoss(),playerWhoFouled,GameConstants.BOXSCORE_PF);
        String playByPlay = "Personal foul on " + teamsInGame[gameBall.getDefPoss()].roster[playerWhoFouled].getName();
        gameGui.updatePlayByPlay(playByPlay);

        if(teamsInGame[gameBall.getDefPoss()].roster[playerWhoFouled].getBoxScoreStatInt(13) >= 6){
            playByPlay = teamsInGame[gameBall.getDefPoss()].roster[playerWhoFouled].getName() + " has fouled out of the game.";
            gameGui.updatePlayByPlay(playByPlay);
            teamsInGame[gameBall.getDefPoss()].playerOutRestOfGame(playerWhoFouled);
        }
    }

    public void obtainLooseBall(){
        double whoRecovered = Math.random() * 10;
        if (whoRecovered > 5){
            gameBall.changePoss();
            gameClock.resetShotClock();
        }
        else {
            gameBall.setState(GameConstants.LIVE_GAME);
        }
    }

    public void substituteAi() {
        if (teamsInGame[gameBall.getDefPoss()].getPointsScored() - teamsInGame[gameBall.getDefPoss()].getPointsScored() > 10) {
            int whoToSubOut = eventProbability.whoToSubOut(gameBall.getPoss());
            int whoToSubOut2 = eventProbability.whoToSubOut(gameBall.getPoss());
            int whoToSubIn = eventProbability.whoToSubIn(gameBall.getPoss());
            int whoToSubIn2 = eventProbability.whoToSubIn(gameBall.getPoss());

            teamsInGame[gameBall.getPoss()].substitute(whoToSubOut, whoToSubIn);
            teamsInGame[gameBall.getPoss()].substitute(whoToSubOut2, whoToSubIn2);
            teamsInGame[gameBall.getDefPoss()].resetPointsRun();
            teamsInGame[gameBall.getPoss()].resetPointsRun();
        }
        else
        {
            int whoToSubOut = eventProbability.whoToSubOut(gameBall.getPoss());
            int whoToSubIn = eventProbability.whoToSubIn(gameBall.getPoss());
            teamsInGame[gameBall.getPoss()].substitute(whoToSubOut, whoToSubIn);
        }


    }


    public void jumpBall(){
        int whoWonJumpBall = eventProbability.whoWonJumpBall();
        if (whoWonJumpBall == GameConstants.HOME_TEAM){
            gameBall.setState(GameConstants.LIVE_GAME);
            gameBall.setPoss(GameConstants.HOME_TEAM);
            gameBall.setDefPoss(GameConstants.VISITOR_TEAM);
            gameBall.setlocationOnCourt(1);
            gameClock.resetShotClock();
            String playByPlay = teamsInGame[gameBall.getPoss()].roster[GameConstants.CENTER].getName() + " wins the jump ball.";
            gameGui.updatePlayByPlay(playByPlay);
        }
        else {
            gameBall.setState(GameConstants.LIVE_GAME);
            gameBall.setPoss(GameConstants.VISITOR_TEAM);
            gameBall.setDefPoss(GameConstants.HOME_TEAM);
            gameBall.setlocationOnCourt(1);
            gameClock.resetShotClock();
            String playByPlay = teamsInGame[gameBall.getPoss()].roster[GameConstants.CENTER].getName() + " wins the jump ball.";
            gameGui.updatePlayByPlay(playByPlay);
        }
    }

}
