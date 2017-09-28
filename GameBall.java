public class GameBall {

    Team [] teamsInGame;
    private int state;
    private int poss;
    private int defPoss;
    private int locationOnCourt;

    public int getState(){return state;}
    public void setState(int s){state = s;}
    public int getPoss(){
        return poss;
    }
    public int getDefPoss(){return defPoss;};

    public void changePoss(){
        if (poss == GameConstants.HOME_TEAM){
            poss = GameConstants.VISITOR_TEAM;
            defPoss = GameConstants.HOME_TEAM;
            locationOnCourt = 0;

        }
        else if (poss == GameConstants.VISITOR_TEAM){
            poss = GameConstants.HOME_TEAM;
            defPoss = GameConstants.VISITOR_TEAM;
            locationOnCourt = 0;

        }
    };

    public void setPoss(int p){
        poss = p;
    }
    public void setDefPoss(int dp){defPoss = dp;}
    public int getlocationOnCourt(){
        return locationOnCourt;
    }
    public void setlocationOnCourt(int loc){
        locationOnCourt = loc;
    }
    public void advBallTowardsBasket(){
        locationOnCourt++;
    }

    public GameBall(Team [] tig){
        teamsInGame = tig;
        poss = 0;
        defPoss = 0;
        locationOnCourt = 0;
        state = 1;

    }

    public void resetGameball(Team [] tig){
        teamsInGame = tig;
        poss = 0;
        defPoss = 0;
        locationOnCourt = 0;
        state = 1;
    }

}
