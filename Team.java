
public class Team {
    String teamName;
    Player[] roster;
    String [][] boxScores;
    int rosterSize;
    int pointsScored;
    int pointRun;

    public int getRosterSize() {
        return rosterSize;
    }
    public String getTeamName(){return teamName;};
    public int getPointsScored(){
        return pointsScored;
    }

    public Team(String teamName) {
        this.teamName = teamName;
        Player[] roster = new Player[GameConstants.MAX_ROSTER_SIZE];
        this.roster = roster;
        rosterSize = GameConstants.INITIAL_ROSTERSIZE;
        boxScores = new String[GameConstants.MAX_BOXSCORE_ROWS][GameConstants.MAX_BOXSCORE_COLUMNS];
        pointsScored = 0;
        pointRun = 0;

    }
    public void addPlayer(Player p) {
        roster[rosterSize + 1] = p;
        rosterSize++;
    }

    public String toString() {
        String toReturn = teamName + "\n\n";
        for (int i = 1; i <= rosterSize; i++)
            toReturn = toReturn + i + ": " + roster[i].getName() + "\n\n";
        return toReturn;
    }

    public String lineupString(){
        String toReturn = "Current Lineup\n";
        toReturn = toReturn + "C - " + roster[5].getName() + "\n";
        toReturn = toReturn + "F - " + roster[4].getName() + "\n";
        toReturn = toReturn + "F - " + roster[3].getName() + "\n";
        toReturn = toReturn + "G - " + roster[2].getName() + "\n";
        toReturn = toReturn + "G - " + roster[1].getName() + "\n";
        toReturn = toReturn + "\nBench\n";

        for (int i = 6; i <= rosterSize; i++){
            toReturn = toReturn + roster[i].getName() + "\n";
        }

        return toReturn;
    }

    public void setLineup() {

        for (int i = 1; i <= 2; i++) {
                if (roster[i].pos != 1){
                    for (int j = i + 1; j <= rosterSize; j++) {
                        if (roster[j].pos == 1){
                            roster[13] = roster[j];
                            roster[j] = roster[i];
                            roster[i] = roster[13];
                            roster[13] = null;
                        }
                    }
                }
        }

        for (int i = 3; i <= 4; i++) {
            if (roster[i].pos != 3){
                for (int j = i + 1; j <= rosterSize; j++) {
                    if (roster[j].pos == 3){
                        roster[13] = roster[j];
                        roster[j] = roster[i];
                        roster[i] = roster[13];
                        roster[13] = null;
                    }
                }
            }
        }


            if (roster[5].pos != 5){
                for (int j = 5 + 1; j <= rosterSize; j++) {
                    if (roster[5].pos == 5){
                        roster[13] = roster[j];
                        roster[j] = roster[5];
                        roster[5] = roster[13];
                        roster[13] = null;
                    }
                }
            }


        for (int i = 1; i <= 5; i++) {
            for (int j = i + 1; j <= rosterSize; j++) {
                if (roster[i].pos == roster[j].pos && roster[i].getEffpg() < roster[j].getEffpg()){
                    roster[13] = roster[j];
                    roster[j] = roster[i];
                    roster[i] = roster[13];
                    roster[13] = null;
                }
            }
        }

        //bench
        for (int k = 1; k <= 7; k++) {
            for (int i = 6; i <= rosterSize - 1; i++) {
                if (roster[i].getEffpg() < roster[i + 1].getEffpg()) {
                    roster[13] = roster[i];
                    roster[i] = roster[i + 1];
                    roster[i + 1] = roster[13];
                    roster[13] = null;
                }
            }
        }
    }

    public void substitute(int subIndexA, int subIndexB){
            if(roster[subIndexA].eligibileToPlay == true && roster[subIndexB].eligibileToPlay == true){
                roster[13] = roster[subIndexA];
                roster[subIndexA] = roster[subIndexB];
                roster[subIndexB] = roster[13];
                roster[13] = null;
            }

    }



    //If player fouls out or gets injured.
    public void playerOutRestOfGame(int player){
        roster[player].setEligibilityToPlay(false);


        for (int i = 6; i <= rosterSize; i++){
            if (roster[i].eligibileToPlay == true){
                roster[13] = roster[player];
                roster[player] = roster[i];
                roster[i] = roster[13];
                roster[13] = null;
            }
        }



    }

    public void pointsScored(int pts){
        pointsScored = pointsScored + pts;
    }

    public int getPointRun (){return pointRun;}
    public void setPointRun (int ptsRun){
        if (ptsRun == 0)
            pointRun = 0;
        else
            pointRun = pointRun + ptsRun;
    }
    public void resetPointsRun(){
        pointRun = 0;
    }

}
